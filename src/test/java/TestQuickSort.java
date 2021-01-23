import SortArray.QuickSort;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestQuickSort {
    @Test
    void test_1() {
        int[] arrayPrev = {1, -2, 3};
        int[] arrayNew = {-2, 1, 3};

        Assert.assertEquals(QuickSort.sortMinToMax(arrayPrev, 0,
                arrayPrev.length - 1), arrayNew, "Wrong!");
    }

    @Test
    void test_2() {
        int[] arrayPrev = {1};
        int[] arrayNew = {1};

        Assert.assertEquals(QuickSort.sortMinToMax(arrayPrev, 0,
                arrayPrev.length - 1), arrayNew, "Wrong!");
    }

    @Test
    void test_3() {
        int[] array = new int[0];

        Assert.assertNull(QuickSort.sortMinToMax(array, 0,
                array.length - 1), "Wrong!");
    }
}
