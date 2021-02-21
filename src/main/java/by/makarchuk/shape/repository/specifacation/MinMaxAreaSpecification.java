package by.makarchuk.shape.repository.specifacation;

import by.makarchuk.shape.entity.AbstractShape;
import by.makarchuk.shape.exception.WrongInputParam;
import by.makarchuk.shape.repository.Warehouse;

public class MinMaxAreaSpecification implements Specification {
    private Double minArea;
    private Double maxArea;

    public MinMaxAreaSpecification(Double minArea, Double maxArea) throws WrongInputParam {
        if (minArea <= 0 || maxArea <= 0) {
            throw new WrongInputParam("params must be > 0");
        }
        this.minArea = minArea;
        this.maxArea = maxArea;
    }

    public boolean specify(AbstractShape abstractShape) {
        //вынести в свойтсва класса??
        Warehouse warehouse = Warehouse.getInstance();
        Double area = warehouse.getArea(abstractShape.getId());
        boolean result = (area >= minArea) && (area <= maxArea);

        return result;
    }
}
