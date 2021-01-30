package com.epam.SortArray;


import org.testng.Assert;
import org.testng.annotations.Test;

public class TestInsertSort {
    private InsertSort insertSort = new InsertSort();
    @Test
    void test_1() {
        int[] arrayPrev = {1, -2, 3};
        int[] arrayNew = {-2, 1, 3};

        Assert.assertEquals(insertSort.sortMinToMax(arrayPrev), arrayNew, "Wrong!");
    }

    @Test
    void test_2() {
        int[] arrayPrev = {1};
        int[] arrayNew = {1};

        Assert.assertEquals(insertSort.sortMinToMax(arrayPrev), arrayNew, "Wrong!");
    }

    @Test
    void test_3() {
        int[] array = new int[0];

        Assert.assertNull(insertSort.sortMinToMax(array), "Wrong!");
    }
}
