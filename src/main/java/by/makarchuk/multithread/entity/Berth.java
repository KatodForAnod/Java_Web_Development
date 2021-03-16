package by.makarchuk.multithread.entity;

import java.util.concurrent.TimeUnit;

public class Berth{
    private final int id;
    private final int maxCapacity = 2000;
    private int currentCapacity;
    private final Port port = Port.getInstance();

    public void loadShip(Ship ship) throws InterruptedException {
        int cargoLoad = ship.loadCargo((int)(Math.random()*100) + 1);
        System.out.println("Идет загрузка: "+ cargoLoad+" стольких пакетов в корабль " + ship.getShipId());
        TimeUnit.SECONDS.sleep(5);
        currentCapacity -= cargoLoad;
        System.out.println("Склад у причала " + id + " заполнен на " + currentCapacity);
    }

    public void unloadShip(Ship ship) throws InterruptedException {
        int cargoUnload = ship.unloadCargo((int)(Math.random()*100) + 1);
        System.out.println("Идет выгрузка: "+ cargoUnload+" стольких пакетов в корабль " + ship.getShipId());
        TimeUnit.SECONDS.sleep(5);
        currentCapacity += cargoUnload;
        System.out.println("Склад у причала " + id + " заполнен на " + currentCapacity);
    }

    public Berth(int id) {
        this.id = id;
    }
}
