import Action.CalculateSum;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCalculateSum {
    @Test
    void test_1() {
        int[] array = {1, 2, 3};

        Integer sum = CalculateSum.calculateSum(array);
        Assert.assertEquals(sum, (Integer) 6, "Wrong answer!");
    }

    @Test
    void test_2() {
        int[] array = new int[0];

        Integer sum = CalculateSum.calculateSum(array);
        Assert.assertNull(sum, "Wrong answer!");
    }
}