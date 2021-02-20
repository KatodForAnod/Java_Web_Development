package by.makarchuk.shape.validator;

import by.makarchuk.shape.entity.Point;

public class CheckTriangleParams {

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

}
