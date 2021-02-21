package by.makarchuk.shape.factory;

import by.makarchuk.shape.entity.Point;
import by.makarchuk.shape.entity.Tetrahedron;
import by.makarchuk.shape.exception.WrongInputParam;
import org.apache.log4j.Logger;

public class TetrahedronFactory implements ShapeFactory {
    private static final Logger logger = Logger.getLogger(TetrahedronFactory.class);
    private static final int amountOfPointsInTetrahedron = 4;

    @Override
    public Tetrahedron createShape(Point[] points) throws WrongInputParam {
        if (points == null) {
            logger.error("null input");
            throw new WrongInputParam("null input");
        }
        if (points.length != amountOfPointsInTetrahedron) {
            logger.error("invalid amount of points");
            throw new WrongInputParam("need " + amountOfPointsInTetrahedron +
                    " points not a " + points.length);
        }
        Tetrahedron tetrahedron = new Tetrahedron(points[0], points[1], points[2], points[3]);

        return tetrahedron;
    }
}
