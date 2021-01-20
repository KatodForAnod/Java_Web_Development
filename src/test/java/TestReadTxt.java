import ReadFiles.ReadTxt;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestReadTxt {
    @Test
    public void test_1() {
        int[] arrayNew = {3, -1, 4, 2};

        try {
            Assert.assertEquals(
                    ReadTxt.createArrayFromFile("src/main/resources/ArrayProp.txt"),
                    arrayNew, "Wrong!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
