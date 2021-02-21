package by.makarchuk.shape.factory;

import by.makarchuk.shape.entity.AbstractShape;
import by.makarchuk.shape.entity.Point;
import by.makarchuk.shape.exception.WrongInputParam;

public interface ShapeFactory {
    AbstractShape createShape(Point[] points) throws WrongInputParam;
}
