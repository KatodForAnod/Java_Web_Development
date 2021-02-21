package by.makarchuk.shape.entity;

import by.makarchuk.shape.exception.WrongInputParam;
import by.makarchuk.shape.validator.CheckTriangleParams;
import org.apache.log4j.Logger;

public class Triangle extends AbstractShape {
    private static final Logger logger = Logger.getLogger(Triangle.class);
    private final Point pointA;
    private final Point pointB;
    private final Point pointC;

    public Triangle(Point pointA, Point pointB, Point pointC) throws WrongInputParam {
        super();
        if (!CheckTriangleParams.isValid1dCheck(pointA, pointB, pointC)) {
            logger.error("wrong inputData: " + pointA.toString() +
                    pointB.toString() + pointC.toString());
            throw new WrongInputParam("it is not triangle");
        }
        logger.info("create triangle with inputData: " + pointA.toString() +
                pointB.toString() + pointC.toString());
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
