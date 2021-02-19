package by.makarchuk.shape.validator;

import by.makarchuk.shape.entity.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCheckTetrahedronParams {
    @Test
    public void test_1() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(4, 0, 0);
        Point c = new Point(3, 0, 4);
        Point d = new Point(2, 6, 1);
        boolean isValid = CheckTetrahedronParams.tetrahedronIsValid(a, b, c, d);
        Assert.assertTrue(isValid, "must be true");
    }

    @Test
    public void test_2() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(4, 0, 0);
        Point c = new Point(3, 0, 0);
        Point d = new Point(2, 6, 1);
        boolean isValid = CheckTetrahedronParams.tetrahedronIsValid(a, b, c, d);
        Assert.assertFalse(isValid, "must be false");
    }
}
