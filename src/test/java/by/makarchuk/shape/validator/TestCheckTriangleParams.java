package by.makarchuk.shape.validator;

import by.makarchuk.shape.entity.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCheckTriangleParams {
    @Test
    public void test_1() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(4, 0, 0);
        Point c = new Point(0, 5, 0);
        boolean isValid = CheckTriangleParams.isValid1dCheck(a, b, c);
        Assert.assertTrue(isValid, "must be true");
    }

    @Test
    public void test_2() {
        Point a = new Point(0, 0, 1);
        Point b = new Point(3, 0, 1);
        Point c = new Point(5, 0, 1);
        boolean isValid = CheckTriangleParams.isValid1dCheck(a, b, c);
        Assert.assertFalse(isValid, "must be false");
    }
}
