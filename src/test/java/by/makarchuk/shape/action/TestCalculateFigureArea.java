package by.makarchuk.shape.action;

import by.makarchuk.shape.entity.Point;
import by.makarchuk.shape.exception.WrongInputParam;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCalculateFigureArea {
    @Test
    public void test_1() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(4, 0, 0);
        Point c = new Point(0, 5, 0);
        try {
            double area = CalculateFigureArea.calculateTriangleArea(a, b, c);
            Assert.assertEquals(area, 10.0);
        } catch (WrongInputParam e) {
            e.printStackTrace();
        }
    }
}
