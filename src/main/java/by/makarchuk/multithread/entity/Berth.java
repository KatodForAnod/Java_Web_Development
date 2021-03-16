package by.makarchuk.multithread.entity;

import java.util.concurrent.TimeUnit;

public class Berth{
    private final int id;
    private final int maxCapacity = 2000;
    private int currentCapacity = 1500;
    private final Port port = Port.getInstance();

    public void loadShip(Ship ship) throws InterruptedException {
        int cargoLoad = (int)(Math.random()*500) + 1;
        if(cargoLoad > currentCapacity){
            System.out.println("Корбаль " + ship.getShipId() + " хочет получить грузов " + cargoLoad + " на складе " + currentCapacity + " корабль получает " + currentCapacity);
            cargoLoad = currentCapacity;
        }
        System.out.println("Идет загрузка: "+ cargoLoad+" пакетов в корабль " + ship.getShipId());
        cargoLoad =  ship.loadCargo(cargoLoad);
        TimeUnit.SECONDS.sleep((int)(Math.random()*20) + 1);
        System.out.println("Было загруженно: "+ cargoLoad+" пакетов в корабль " + ship.getShipId() + ", нынешние кол-во грузов "+ ship.getCurrentCapacity());
        currentCapacity -= cargoLoad;
        System.out.println("Склад у причала " + id + " заполнен на " + currentCapacity);
    }

    public void unloadShip(Ship ship) throws InterruptedException {
        int cargoUnload = (int)(Math.random()*100) + 1;
        if(currentCapacity + cargoUnload > maxCapacity){
            System.out.println("Корбаль " + ship.getShipId() + " хочет выгрузить грузов " + cargoUnload + " на складе " + currentCapacity + " корабль выгружает " + (maxCapacity- currentCapacity));
            cargoUnload = maxCapacity - currentCapacity;
        }
        System.out.println("Идет выгрузка: "+ cargoUnload+" пакетов из корабля " + ship.getShipId());
        cargoUnload = ship.unloadCargo(cargoUnload);
        TimeUnit.SECONDS.sleep((int)(Math.random()*20) + 1);
        System.out.println("Было выгруженно: "+ cargoUnload+" пакетов из корабля " + ship.getShipId() + ", нынешние кол-во грузов "+ ship.getCurrentCapacity());
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
