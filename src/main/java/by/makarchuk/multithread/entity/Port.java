package by.makarchuk.multithread.entity;

import by.makarchuk.multithread.action.GenerateID;
import by.makarchuk.multithread.exception.WrongInputParam;
import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Port {
    private static final Logger logger = Logger.getLogger(Port.class);
    private static final int BERTH_CAPACITY = 2;
    private static Port instance = new Port();
    private Queue<Berth> freeBerths = new LinkedList<>();
    private Queue<Berth> busyBirths = new LinkedList<>();
    private final Lock lock = new ReentrantLock(true);
    private final Condition berthIsFree = lock.newCondition();

    public static Port getInstance() {
        return instance;
    }

    private Port() {
        initBerths();
    }

    public void freeBerth(Berth berth){
        try{
            lock.lock();
            freeBerths.offer(berth);
            busyBirths.remove();
            berthIsFree.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public Berth getFreeBerth() throws WrongInputParam {
        lock.lock();
        try {
            while (freeBerths.isEmpty()) {
                System.out.println("Ожидание свободного причала");
                berthIsFree.await();
            }
            Berth berth = freeBerths.poll();
            busyBirths.offer(berth);
            System.out.println("Причал "+ berth.getId() + " свободен");
            return berth;
        } catch (InterruptedException e) {
            logger.error("getFreeBerth", e);
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

        throw new WrongInputParam();
    }

    private void initBerths() {
        for (int i = 0; i < BERTH_CAPACITY; i++) {
            int id = GenerateID.getUniqBerthID();
            freeBerths.add(new Berth(id));
        }
    }
}
