package by.makarchuk.shape.reader;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestInputStringIsValid {
    @Test
    public void test_1() {
        boolean isValid = InputStringIsValid.noLettersCheck("2.0 3.0 4.0");
        Assert.assertTrue(isValid);
    }

    @Test
    public void test_2() {
        boolean isValid = InputStringIsValid.noLettersCheck("2.0z 3.2 3.5");
        Assert.assertFalse(isValid);
    }

}
