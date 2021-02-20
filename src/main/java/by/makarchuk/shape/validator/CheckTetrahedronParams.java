package by.makarchuk.shape.validator;

import by.makarchuk.shape.entity.Point;

public class CheckTetrahedronParams {
    public static boolean tetrahedronIsValid(Point a, Point b, Point c, Point d) {
        boolean isValid = false;
        if (CheckTriangleParams.isValid1dCheck(a, b, c) &&
                CheckTriangleParams.isValid1dCheck(c, d, b) &&
                CheckTriangleParams.isValid1dCheck(b, d, a) &&
                CheckTriangleParams.isValid1dCheck(a, c, d)) {
            isValid = true;
        }

        return isValid;
    }
}
