package by.makarchuk.shape.validator;

import by.makarchuk.shape.entity.Point;
import by.makarchuk.shape.entity.Triangle;

public class CheckTriangleParams {
    /*private static boolean isValid(double sideAB, double sideBC, double sideCA) {
        boolean isValid = false;
        if ((sideAB + sideBC) > sideCA) {
            isValid = true;
        }

        return isValid;
    }

    private static boolean isValid(Point a, Point b, Point c) {
        boolean isValid;
        double sideAB = Math.sqrt(Math.pow(b.getX() - a.getX(), 2) +
                Math.pow(b.getY() - a.getY(), 2) +
                Math.pow(b.getZ() - a.getZ(), 2));
        double sideBC = Math.sqrt(Math.pow(b.getX() - c.getX(), 2) +
                Math.pow(b.getY() - c.getY(), 2) +
                Math.pow(b.getZ() - c.getZ(), 2));
        double sideCA = Math.sqrt(Math.pow(c.getX() - a.getX(), 2) +
                Math.pow(c.getY() - a.getY(), 2) +
                Math.pow(c.getZ() - a.getZ(), 2));
        isValid = isValid(sideAB, sideBC, sideCA);

        return isValid;
    }*/

    //проверка на одномерное представление фигуры
    public static boolean isValid1dCheck(Point a, Point b, Point c) {
        //XYZ кол-во плоскостей
        int amountOfPlanes = 3;
        boolean isValid = false;
        if ((a.getZ() == b.getZ()) && (c.getZ() == a.getZ())) {
            amountOfPlanes--;
        }
        if ((a.getY() == b.getY()) && (c.getY() == a.getY())) {
            amountOfPlanes--;
        }
        if ((a.getX() == b.getX()) && (c.getX() == a.getX())) {
            amountOfPlanes--;
        }
        if (amountOfPlanes >= 2) {
            isValid = true;
        }

        return isValid;
    }

    public static boolean isValid1dCheck(Triangle triangle) {
        return isValid1dCheck(triangle.getPointA(), triangle.getPointB(),
                triangle.getPointC());
    }
}
