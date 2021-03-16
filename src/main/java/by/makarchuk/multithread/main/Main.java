package by.makarchuk.multithread.main;

import by.makarchuk.multithread.action.GenerateID;
import by.makarchuk.multithread.entity.Ship;

public class Main {
    public static void main(String[] args) {

        Thread myThread = new Thread(new Ship(GenerateID.getUniqShipID(), 200, 50),"MyThread");
        myThread.start();
    }
}
