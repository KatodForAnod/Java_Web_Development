package by.makarchuk.shape.entity;

import by.makarchuk.shape.exception.WrongInputParam;
import by.makarchuk.shape.validator.CheckTetrahedronParams;
import org.apache.log4j.Logger;

public class Tetrahedron extends AbstractShape {
    private static final Logger logger = Logger.getLogger(Tetrahedron.class);
    private final Point pointA;
    private final Point pointB;
    private final Point pointC;
    private final Point pointD;

    public Tetrahedron(Point pointA, Point pointB, Point pointC, Point pointD) throws WrongInputParam {
        super();
        if (!CheckTetrahedronParams.tetrahedronIsValid(pointA, pointB, pointC, pointD)) {
            logger.error("wrong inputData: " + pointA.toString() +
                    pointB.toString() + pointC.toString() + pointD.toString());
            throw new WrongInputParam("this is not tetrahedron");
        }
        logger.info("create tetrahedron with inputData: " + pointA.toString() +
                pointB.toString() + pointC.toString() + pointD.toString());
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
