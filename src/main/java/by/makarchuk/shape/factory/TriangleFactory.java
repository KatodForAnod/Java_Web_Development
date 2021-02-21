package by.makarchuk.shape.factory;

import by.makarchuk.shape.entity.Point;
import by.makarchuk.shape.entity.Triangle;
import by.makarchuk.shape.exception.WrongInputParam;

public class TriangleFactory implements ShapeFactory {
    private static final int amountOfPointsInTriangle = 3;

    @Override
    public Triangle createShape(Point[] points) throws WrongInputParam {
        if (points == null) {
            throw new WrongInputParam("null input");
        }
        if (points.length != amountOfPointsInTriangle) {
            throw new WrongInputParam("need " + amountOfPointsInTriangle +
                    " points not a " + points.length);
        }
        Triangle triangle = new Triangle(points[0], points[1], points[2]);

        return triangle;
    }
}
