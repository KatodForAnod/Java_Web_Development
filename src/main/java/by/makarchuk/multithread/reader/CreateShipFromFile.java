package by.makarchuk.multithread.reader;

import by.makarchuk.multithread.action.GenerateID;
import by.makarchuk.multithread.entity.Ship;
import by.makarchuk.multithread.exception.WrongInputParam;

import java.util.LinkedList;
import java.util.List;

public class CreateShipFromFile {
    public static List<Ship> createShips(String filePath) throws WrongInputParam {
        ReadFile readFile = new ReadFile();
        List<Ship> shipList = new LinkedList<>();
        List<String> data = readFile.read(filePath);

        for (int i =0;i<data.size(); i+=2){
            int currentCapacity = Integer.parseInt(data.get(i));
            int maxCapacity = Integer.parseInt(data.get(i+1));
            shipList.add(new Ship(GenerateID.getUniqShipID(), maxCapacity, currentCapacity));
        }

        return shipList;
    }
}
