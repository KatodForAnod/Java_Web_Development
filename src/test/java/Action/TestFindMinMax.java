package Action;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestFindMinMax {
    private FindMinMax findMinMax = new FindMinMax();

    @Test
    void test_1() {
        int[] array = {1, -2, 3};

        Integer min = findMinMax.findMin(array);
        Assert.assertEquals(min, (Integer) (-2), "Wrong answer!");
    }

    @Test
    void test_2() {
        int[] array = new int[0];

        Assert.assertNull(findMinMax.findMin(array), "Wrong answer!");
    }

    @Test
    void test_3() {
        int[] array = {1, -2, 3};

        Integer max = findMinMax.findMax(array);
        Assert.assertEquals(max, (Integer) 3, "Wrong answer!");
    }

    @Test
    void test_4() {
        int[] array = new int[0];

        Assert.assertNull(findMinMax.findMax(array), "Wrong answer!");
    }
}