package by.makarchuk.shape.factory;

import by.makarchuk.shape.entity.Point;
import by.makarchuk.shape.entity.Triangle;
import by.makarchuk.shape.exception.WrongInputParam;
import org.apache.log4j.Logger;

public class TriangleFactory implements ShapeFactory {
    private static final Logger logger = Logger.getLogger(TriangleFactory.class);
    private static final int amountOfPointsInTriangle = 3;

    @Override
    public Triangle createShape(Point[] points) throws WrongInputParam {
        if (points == null) {
            logger.error("null input");
            throw new WrongInputParam("null input");
        }
        if (points.length != amountOfPointsInTriangle) {
            logger.error("invalid amount of points");
            throw new WrongInputParam("need " + amountOfPointsInTriangle +
                    " points not a " + points.length);
        }
        Triangle triangle = new Triangle(points[0], points[1], points[2]);

        return triangle;
    }
}
