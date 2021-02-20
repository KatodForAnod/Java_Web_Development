package by.makarchuk.shape.entity;

import by.makarchuk.shape.exception.WrongInputParam;
import by.makarchuk.shape.validator.CheckTetrahedronParams;

public class Tetrahedron extends AbstractShape {
    private final Point pointA;
    private final Point pointB;
    private final Point pointC;
    private final Point pointD;

    public Tetrahedron(Point pointA, Point pointB, Point pointC, Point pointD) throws WrongInputParam {
        super();
        if (!CheckTetrahedronParams.tetrahedronIsValid(pointA, pointB, pointC, pointD)) {
            throw new WrongInputParam("this is not tetrahedron");
        }
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        this.pointD = pointD;
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

    public Point getPointD() {
        return pointD;
    }
}
