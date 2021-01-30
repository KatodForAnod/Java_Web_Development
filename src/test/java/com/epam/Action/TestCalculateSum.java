package com.epam.Action;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCalculateSum {
    private CalculateSum calculateSum = new CalculateSum();

    @Test
    void test_1() {
        int[] array = {1, 2, 3};

        Integer sum = calculateSum.calculateSum(array);
        Assert.assertEquals(sum, (Integer) 6, "Wrong answer!");
    }

    @Test
    void test_2() {
        int[] array = new int[0];

        Integer sum = calculateSum.calculateSum(array);
        Assert.assertNull(sum, "Wrong answer!");
    }

    @Test
    void test_3() {
        int[] array = {1, 2, 3};

        Integer sum = calculateSum.calculateSumUseIntStream(array);
        Assert.assertEquals(sum, (Integer) 6, "Wrong answer!");
    }

    @Test
    void test_4() {
        int[] array = new int[0];

        Integer sum = calculateSum.calculateSumUseIntStream(array);
        Assert.assertNull(sum, "Wrong answer!");
    }
}