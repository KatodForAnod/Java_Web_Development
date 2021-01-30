package com.epam.SortArray;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestQuickSort {
    private QuickSort quickSort = new QuickSort();

    @Test
    void test_1() {
        int[] arrayPrev = {1, -2, 3};
        int[] arrayNew = {-2, 1, 3};

        Assert.assertEquals(quickSort.sortMinToMax(arrayPrev, 0,
                arrayPrev.length - 1), arrayNew, "Wrong!");
    }

    @Test
    void test_2() {
        int[] arrayPrev = {1};
        int[] arrayNew = {1};

        Assert.assertEquals(quickSort.sortMinToMax(arrayPrev, 0,
                arrayPrev.length - 1), arrayNew, "Wrong!");
    }

    @Test
    void test_3() {
        int[] array = new int[0];

        Assert.assertNull(quickSort.sortMinToMax(array, 0,
                array.length - 1), "Wrong!");
    }
}
