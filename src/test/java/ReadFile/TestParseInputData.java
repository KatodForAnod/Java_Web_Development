package ReadFile;

import ReadFile.ParseInputData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestParseInputData {
    @Test
    public void test_1() {
        String input = "1z 2 4 55";
        Assert.assertFalse(ParseInputData.onlyIntCheck(input), "Wrong!");
    }

    @Test
    public void test_2() {
        String input = "1 2 4 55";
        Assert.assertTrue(ParseInputData.onlyIntCheck(input), "Wrong!");
    }
}
