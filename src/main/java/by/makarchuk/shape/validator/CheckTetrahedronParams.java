package by.makarchuk.shape.validator;

import by.makarchuk.shape.entity.Point;
import by.makarchuk.shape.entity.Tetrahedron;
import by.makarchuk.shape.entity.Triangle;

public class CheckTetrahedronParams {
    public static boolean allTrianglesIsValid(
            Triangle triangleABC, Triangle triangleCDB,
            Triangle triangleBDA, Triangle triangleACD) {

        boolean trianglesIsValid = (CheckTriangleParams.isValid1dCheck(triangleABC) &&
                CheckTriangleParams.isValid1dCheck(triangleCDB) &&
                CheckTriangleParams.isValid1dCheck(triangleBDA) &&
                CheckTriangleParams.isValid1dCheck(triangleACD));

        return trianglesIsValid;
    }

    public static boolean tetrahedronIsValid(Point a, Point b, Point c, Point d) {
        boolean isValid = false;
        Triangle triangleABC = new Triangle(a, b, c);
        Triangle triangleCDB = new Triangle(c, d, b);
        Triangle triangleBDA = new Triangle(b, d, a);
        Triangle triangleACD = new Triangle(a, c, d);

        if (allTrianglesIsValid(triangleABC, triangleCDB, triangleBDA, triangleACD)) {
            isValid = true;
        }

        return isValid;
    }
}
