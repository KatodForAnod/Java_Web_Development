package by.makarchuk.multithread.entity;

import org.apache.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class Berth{
    private static final Logger logger = Logger.getLogger(Berth.class);
    private final int id;
    private final int maxCapacity = 2000;
    private int currentCapacity = 1500;
    private final Port port = Port.getInstance();

    public void loadShip(Ship ship){
        int cargoLoad = (int)(Math.random()*500) + 1;
        if(cargoLoad > currentCapacity){
            System.out.println("Корбаль " + ship.getShipId() + " хочет получить грузов " + cargoLoad
                    + " на складе " + currentCapacity + " корабль получает " + currentCapacity);
            cargoLoad = currentCapacity;
        }
        System.out.println("Идет загрузка: "+ cargoLoad+" пакетов в корабль " + ship.getShipId());
        cargoLoad =  ship.loadCargo(cargoLoad);

        try {
            TimeUnit.SECONDS.sleep((int) (Math.random() * 20) + 1);
        }catch (InterruptedException e){
            logger.error("loadShip", e);
            e.printStackTrace();
        }

        System.out.println("Было загруженно: "+ cargoLoad+" пакетов в корабль " + ship.getShipId()
                + ", нынешние кол-во грузов "+ ship.getCurrentCapacity());
        currentCapacity -= cargoLoad;
        System.out.println("Склад у причала " + id + " заполнен на " + currentCapacity);
    }

    public void unloadShip(Ship ship){
        int cargoUnload = (int)(Math.random()*100) + 1;
        if(currentCapacity + cargoUnload > maxCapacity){
            System.out.println("Корбаль " + ship.getShipId() + " хочет выгрузить грузов " + cargoUnload
                    + " на складе " + currentCapacity + " корабль выгружает " + (maxCapacity- currentCapacity));
            cargoUnload = maxCapacity - currentCapacity;
        }
        System.out.println("Идет выгрузка: "+ cargoUnload+" пакетов из корабля " + ship.getShipId());
        cargoUnload = ship.unloadCargo(cargoUnload);

        try {
            TimeUnit.SECONDS.sleep((int) (Math.random() * 20) + 1);
        }catch (InterruptedException e){
            logger.error("unloadShip", e);
            e.printStackTrace();
        }

        System.out.println("Было выгруженно: "+ cargoUnload+" пакетов из корабля " + ship.getShipId()
                + ", нынешние кол-во грузов "+ ship.getCurrentCapacity());
        currentCapacity += cargoUnload;
        System.out.println("Склад у причала " + id + " заполнен на " + currentCapacity);
    }

    public Berth(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
