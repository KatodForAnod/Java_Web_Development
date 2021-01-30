package com.epam.Action;


import org.testng.Assert;
import org.testng.annotations.*;


public class TestCalculateAverage {
    private CalculateAverage calculateAverage = new CalculateAverage();

    @Test
    void test_1() {
        int[] array = {1, 2, 3};

        Double average = calculateAverage.calculateAverage(array);
        Assert.assertEquals(average, (Double) 2.0, "Wrong answer!");

    }

    @Test
    void test_2() {
        int[] array = new int[0];

        Assert.assertNull(calculateAverage.calculateAverage(array), "Wrong answer!");
    }

    @Test
    void test_3() {
        int[] array = {1, 2, 3};

        Double average = calculateAverage.calculateAverageUseIntStream(array);
        Assert.assertEquals(average, (Double) 2.0, "Wrong answer!");

    }

    @Test
    void test_4() {
        int[] array = new int[0];

        Assert.assertNull(calculateAverage.calculateAverageUseIntStream(array), "Wrong answer!");
    }
}
