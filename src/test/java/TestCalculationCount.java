import Action.CalculateCountOfDiffNumbers;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCalculationCount {
    @Test
    void test_1() {
        int[] array = {1, -2, 3};

        Integer count = CalculateCountOfDiffNumbers.countOfNegativeNumbers(array);
        Assert.assertEquals(count, (Integer) 1, "Wrong answer!");

    }

    @Test
    void test_2() {
        int[] array = new int[0];

        Assert.assertNull(CalculateCountOfDiffNumbers.countOfNegativeNumbers(array), "Wrong answer!");
    }

    @Test
    void test_3() {
        int[] array = {1, 2, 3};

        Integer count = CalculateCountOfDiffNumbers.countOfNegativeNumbers(array);
        Assert.assertEquals(count, (Integer) 0, "Wrong answer!");
    }

    @Test
    void test_4() {
        int[] array = {1, 2, 3};

        Integer count = CalculateCountOfDiffNumbers.countOfPositiveNumbers(array);
        Assert.assertEquals(count, (Integer) 3, "Wrong answer!");
    }

    @Test
    void test_5() {
        int[] array = new int[0];

        Assert.assertNull(CalculateCountOfDiffNumbers.countOfPositiveNumbers(array), "Wrong answer!");
    }

    @Test
    void test_6() {
        int[] array = {-1, -2, -3};

        Integer count = CalculateCountOfDiffNumbers.countOfPositiveNumbers(array);
        Assert.assertEquals(count, (Integer) 0, "Wrong answer!");
    }
}