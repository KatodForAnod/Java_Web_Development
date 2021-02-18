package by.makarchuk.shape.action;

import by.makarchuk.shape.entity.Triangle;

public class CalculateFigureArea {
    public static double calculateTriangleArea(double sideAB, double sideBC, double sideCA) {
        double p = (sideAB + sideBC + sideCA) / 2.0;
        double area = Math.sqrt(p * (p - sideAB) * (p - sideBC) * (p - sideCA));

        return area;
    }

}
