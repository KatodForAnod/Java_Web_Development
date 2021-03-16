package by.makarchuk.multithread.action;

public class GenerateID {
    private static int SHIP_ID = 0;
    private static int BERTH_ID = 0;

    public static int getUniqShipID(){
        return SHIP_ID++;
    }

    public static int getUniqBerthID(){
        return BERTH_ID++;
    }

}
