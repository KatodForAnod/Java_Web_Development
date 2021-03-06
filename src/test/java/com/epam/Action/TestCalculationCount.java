package com.epam.Action;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCalculationCount {
    private CalculateCountOfDiffNumbers calculateCountOfDiffNumbers = new CalculateCountOfDiffNumbers();

    @Test
    void test_1() {
        int[] array = {1, -2, 3};

        Integer count = calculateCountOfDiffNumbers.countOfNegativeNumbers(array);
        Assert.assertEquals(count, (Integer) 1, "Wrong answer!");

    }

    @Test
    void test_2() {
        int[] array = new int[0];

        Assert.assertNull(calculateCountOfDiffNumbers.countOfNegativeNumbers(array), "Wrong answer!");
    }

    @Test
    void test_3() {
        int[] array = {1, 2, 3};

        Integer count = calculateCountOfDiffNumbers.countOfNegativeNumbers(array);
        Assert.assertEquals(count, (Integer) 0, "Wrong answer!");
    }

    @Test
    void test_4() {
        int[] array = {1, 2, 3};

        Integer count = calculateCountOfDiffNumbers.countOfPositiveNumbers(array);
        Assert.assertEquals(count, (Integer) 3, "Wrong answer!");
    }

    @Test
    void test_5() {
        int[] array = new int[0];

        Assert.assertNull(calculateCountOfDiffNumbers.countOfPositiveNumbers(array), "Wrong answer!");
    }

    @Test
    void test_6() {
        int[] array = {-1, -2, -3};

        Integer count = calculateCountOfDiffNumbers.countOfPositiveNumbers(array);
        Assert.assertEquals(count, (Integer) 0, "Wrong answer!");
    }

    @Test
    void test_7() {
        int[] array = {1, -2, 3};

        Integer count = calculateCountOfDiffNumbers.countOfNegativeNumbersUseIntStream(array);
        Assert.assertEquals(count, (Integer) 1, "Wrong answer!");

    }

    @Test
    void test_8() {
        int[] array = new int[0];

        Assert.assertNull(calculateCountOfDiffNumbers.countOfNegativeNumbersUseIntStream(array), "Wrong answer!");
    }

    @Test
    void test_9() {
        int[] array = {1, -2, 3};

        Integer count = calculateCountOfDiffNumbers.countOfPositiveNumbersUseIntStream(array);
        Assert.assertEquals(count, (Integer) 2, "Wrong answer!");

    }

    @Test
    void test_10() {
        int[] array = new int[0];

        Assert.assertNull(calculateCountOfDiffNumbers.countOfPositiveNumbersUseIntStream(array), "Wrong answer!");
    }
}