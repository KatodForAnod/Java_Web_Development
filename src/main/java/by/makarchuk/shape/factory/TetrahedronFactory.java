package by.makarchuk.shape.factory;

import by.makarchuk.shape.entity.Point;
import by.makarchuk.shape.entity.Tetrahedron;
import by.makarchuk.shape.exception.WrongInputParam;

public class TetrahedronFactory implements ShapeFactory {
    private static final int amountOfPointsInTetrahedron = 4;

    @Override
    public Tetrahedron createShape(Point[] points) throws WrongInputParam {
        if (points == null) {
            throw new WrongInputParam("null input");
        }
        if (points.length != amountOfPointsInTetrahedron) {
            throw new WrongInputParam("need " + amountOfPointsInTetrahedron +
                    " points not a " + points.length);
        }
        Tetrahedron tetrahedron = new Tetrahedron(points[0], points[1], points[2], points[3]);

        return tetrahedron;
    }
}
