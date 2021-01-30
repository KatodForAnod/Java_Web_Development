package com.epam.Action;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestReplaceNumbers {
    private ReplaceNumbers replaceNumbers = new ReplaceNumbers();
    @Test
    void test_1() {
        int[] arrayPrev = {1, -2, 3};
        int[] arrayNew = {1, 4, 3};

        Assert.assertEquals(replaceNumbers.replaceNumber(arrayPrev, -2, 4), arrayNew,
                "Wrong answer!");
    }

    @Test
    void test_2() {
        int[] array = new int[0];

        Assert.assertNull(replaceNumbers.replaceNumber(array, -2, 4), "Wrong answer!");
    }

    @Test
    void test_3() {
        int[] arrayPrev = {1, -2, 3};
        int[] arrayNew = {1, 4, 3};

        Assert.assertEquals(replaceNumbers.replaceNumberUseIntStream(arrayPrev, -2, 4), arrayNew,
                "Wrong answer!");
    }

    @Test
    void test_4() {
        int[] array = new int[0];

        Assert.assertNull(replaceNumbers.replaceNumberUseIntStream(array, -2, 4), "Wrong answer!");
    }
}