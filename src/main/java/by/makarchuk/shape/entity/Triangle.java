package by.makarchuk.shape.entity;

import by.makarchuk.shape.exception.WrongInputParam;
import by.makarchuk.shape.validator.CheckTriangleParams;

public class Triangle extends AbstractShape {
    private final Point pointA;
    private final Point pointB;
    private final Point pointC;

    public Triangle(Point pointA, Point pointB, Point pointC) throws WrongInputParam {
        super();
        if (CheckTriangleParams.isValid1dCheck(pointA, pointB, pointC)) {
            throw new WrongInputParam("it is not triangle");
        }
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
    }

    public Point getPointA() {
        return pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public Point getPointC() {
        return pointC;
    }
}
