package by.makarchuk.shape.reader;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestParseInputString {
    @Test
    public void test_1() {
        boolean isValid = ParseInputString.onlyDoubleCheck("2.0 3.2 3.5");
        Assert.assertTrue(isValid);
    }

    @Test
    public void test_2() {
        boolean isValid = ParseInputString.onlyDoubleCheck("2.0z 3.2 3.5");
        Assert.assertFalse(isValid);
    }

    @Test
    public void test_3() {
        boolean isValid = ParseInputString.onlyDoubleCheck("2.0 3.2");
        Assert.assertFalse(isValid);
    }
}
