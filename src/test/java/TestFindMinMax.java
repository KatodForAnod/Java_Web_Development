import Action.FindMinMax;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestFindMinMax {
    @Test
    void test_1() {
        int[] array = {1, -2, 3};

        Integer min = FindMinMax.findMin(array);
        Assert.assertEquals(min, (Integer) (-2), "Wrong answer!");
    }

    @Test
    void test_2() {
        int[] array = new int[0];

        Assert.assertEquals(FindMinMax.findMin(array), null, "Wrong answer!");
    }

    @Test
    void test_3() {
        int[] array = {1, -2, 3};

        Integer max = FindMinMax.findMax(array);
        Assert.assertEquals(max, (Integer) 3, "Wrong answer!");
    }

    @Test
    void test_4() {
        int[] array = new int[0];

        Assert.assertEquals(FindMinMax.findMax(array), null, "Wrong answer!");
    }
}