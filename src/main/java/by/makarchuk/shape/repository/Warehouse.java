package by.makarchuk.shape.repository;

import java.util.HashMap;

public class Warehouse {
    private HashMap<Integer, Double> areasOfShapes;
    private static Warehouse instance; //#1

    private Warehouse() {
        areasOfShapes = new HashMap<>();
    }

    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
        }

        return instance;
    }

    public void addArea(Integer id, Double value) {
        areasOfShapes.put(id, value);
    }

    public Double getArea(Integer id) {
        return areasOfShapes.get(id);
    }

    public boolean removeArea(Integer id) {
        areasOfShapes.remove(id);
        boolean isValidKey = areasOfShapes.containsKey(id);

        return isValidKey;
    }
}
