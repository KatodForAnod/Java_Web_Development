import Action.ReplaceNumbers;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestReplaceNumbers {
    @Test
    void test_1() {
        int[] arrayPrev = {1, -2, 3};
        int[] arrayNew = {1, 4, 3};

        Assert.assertEquals(ReplaceNumbers.replaceNumber(arrayPrev, -2, 4), arrayNew,
                "Wrong answer!");
    }

    @Test
    void test_2() {
        int[] array = new int[0];

        Assert.assertEquals(ReplaceNumbers.replaceNumber(array, -2, 4), null,
                "Wrong answer!");
    }
}