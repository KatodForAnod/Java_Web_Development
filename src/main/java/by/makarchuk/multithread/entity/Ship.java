package by.makarchuk.multithread.entity;

import by.makarchuk.multithread.exception.WrongInputParam;

import java.util.concurrent.TimeUnit;

public class Ship implements Runnable {
    private int id;
    private final int maxCapacity;
    private int currentCapacity;

    public Ship(int id, int maxCapacity, int currentCapacity) {
        this.id = id;
        this.maxCapacity = maxCapacity;
        this.currentCapacity = currentCapacity;
    }

    public void run() {
        Port port = Port.getInstance();
        try {

            Berth berth = port.getFreeBerth();
            switch ((int) (Math.random() * 2) + 1) {
                case 1: {
                    berth.unloadShip(this);
                    break;
                }
                case 2: {
                    berth.loadShip(this);
                    break;
                }
            }
            port.freeBerth(berth);
        } catch (WrongInputParam | InterruptedException wrongInputParam) {
            wrongInputParam.printStackTrace();
        }
    }

    public int getShipId() {
        return id;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public int loadCargo(int cargo){
        System.out.println("В корабль " + id + " загружается: " + cargo + " грузов, текущее кол-во грузов "+ getCurrentCapacity());
        if (currentCapacity + cargo > maxCapacity) {
            int cargoLoad = maxCapacity - currentCapacity;
            currentCapacity = maxCapacity;

            return cargoLoad;
        }
        currentCapacity += cargo;
        return cargo;
    }

    public int unloadCargo(int cargo){
        System.out.println("Из корабля " + id + " выгружается: " + cargo + " грузов, текущее кол-во грузов "+ getCurrentCapacity());
        if (cargo > currentCapacity) {
            cargo = currentCapacity;
            currentCapacity = 0;
            return cargo;
        }

        currentCapacity -= cargo;
        return cargo;
    }
}
