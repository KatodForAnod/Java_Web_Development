package by.makarchuk.shape.reader;

import by.makarchuk.shape.entity.Point;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestCreatePointsFromStringList {
    @Test
    public void test_1() {
        CreatPointsFromStringList creatPointsFromStringList = new CreatPointsFromStringList();
        List<String> inputData = new ArrayList<>();
        inputData.add("2.0z 3.0 ");
        inputData.add("2.0 3.0 4.0");

        List<List<Point>> data = creatPointsFromStringList.getPoints(inputData);
        System.out.println(data.size());
        System.out.println(data.get(0).get(0).getX());
        System.out.println(data.get(0).get(0).getY());
        System.out.println(data.get(0).get(0).getZ());
    }
}
