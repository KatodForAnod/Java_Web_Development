package by.makarchuk.shape.action;

import by.makarchuk.shape.entity.Point;
import by.makarchuk.shape.exception.WrongInputParam;
import by.makarchuk.shape.validator.CheckTriangleParams;

public class CalculateFigureArea {
    private static double calculateTriangleArea(double sideAB, double sideBC, double sideCA) {
        double p = (sideAB + sideBC + sideCA) / 2.0;
        double area = Math.sqrt(p * (p - sideAB) * (p - sideBC) * (p - sideCA));

        return area;
    }

    public static double calculateTriangleArea(Point a, Point b, Point c) throws WrongInputParam {
        if (!CheckTriangleParams.isValid1dCheck(a, b, c)) {
            throw new WrongInputParam("wrong input params");
        }
        double sideAB = Math.sqrt(Math.pow(b.getX() - a.getX(), 2) +
                Math.pow(b.getY() - a.getY(), 2) +
                Math.pow(b.getZ() - a.getZ(), 2));
        double sideBC = Math.sqrt(Math.pow(b.getX() - c.getX(), 2) +
                Math.pow(b.getY() - c.getY(), 2) +
                Math.pow(b.getZ() - c.getZ(), 2));
        double sideCA = Math.sqrt(Math.pow(c.getX() - a.getX(), 2) +
                Math.pow(c.getY() - a.getY(), 2) +
                Math.pow(c.getZ() - a.getZ(), 2));
        double area = calculateTriangleArea(sideAB, sideBC, sideCA);

        return area;
    }

    public static double calculateTetrahedronArea(Point a, Point b, Point c, Point d) throws WrongInputParam {
        double area = calculateTriangleArea(a, b, c) +
                calculateTriangleArea(c, d, b) +
                calculateTriangleArea(b, d, a) +
                calculateTriangleArea(a, c, d);

        return area;
    }
}
