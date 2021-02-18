package by.makarchuk.shape.action;

public class CalculateFigureVolume {
    public static double calculateTetrahedronVolume(double sideA) {
        double area = (Math.pow(sideA, 3) * Math.sqrt(3)) / 12.0;
        return area;
    }
}
