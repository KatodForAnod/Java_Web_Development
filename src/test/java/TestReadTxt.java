import MyExeptions.ArrayException;
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

    @Test
    public void test_2() {
        try {
            Assert.assertEquals(
                    ReadTxt.createNewIntArray(new String[]{"1", "3"}), new int[1], "Wrong!");
        } catch (ArrayException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_3() {
        int[] array = {-2, 3};

        try {
            Assert.assertEquals(
                    ReadTxt.fillIntArray(new String[]{"2", "-2", "3"}, new int[2]), array, "Wrong!");
        } catch (ArrayException e) {
            e.printStackTrace();
        }
    }
}
