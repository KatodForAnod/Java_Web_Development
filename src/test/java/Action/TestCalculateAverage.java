package Action;

import Action.CalculateAverage;
import org.testng.Assert;
import org.testng.annotations.*;


public class TestCalculateAverage {
    @Test
    void test_1() {
        int[] array = {1, 2, 3};

        Double average = CalculateAverage.calculateAverage(array);
        Assert.assertEquals(average, (Double) 2.0, "Wrong answer!");

    }

    @Test
    void test_2() {
        int[] array = new int[0];

        Assert.assertNull(CalculateAverage.calculateAverage(array), "Wrong answer!");
    }
}
