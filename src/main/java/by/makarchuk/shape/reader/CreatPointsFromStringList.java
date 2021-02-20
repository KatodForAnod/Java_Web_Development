package by.makarchuk.shape.reader;

import by.makarchuk.shape.entity.Point;

import java.util.ArrayList;
import java.util.List;

public class CreatPointsFromStringList {
    private static final String stringSplit = " ";
    private static final int countOfPointParams = 3;

    public List<List<Point>> getPoints(List<String> inputList) {
        List<List<Point>> arrayOfPoints = new ArrayList<>();
        for (String string : inputList) {
            if (!InputStringIsValid.noLettersCheck(string)) {
                //здесь должен быть лог в файл
                continue;
            }
            String[] pointParams = string.split(stringSplit);
            if ((pointParams.length % countOfPointParams) != 0 ||
                    pointParams.length == 0) {
                //здесь должен быть лог в файл
                continue;
            }

            List<Point> oneLinePoints = new ArrayList<>();
            double x;
            double y;
            double z;
            for (int i = 0; i < pointParams.length; i += countOfPointParams) {
                try {
                    x = Double.parseDouble(pointParams[i]);
                    y = Double.parseDouble(pointParams[i + 1]);
                    z = Double.parseDouble(pointParams[i + 2]);
                    oneLinePoints.add(new Point(x, y, z));
                } catch (NumberFormatException e) {
                    //здесь должен быть лог в файл
                }
            }
            arrayOfPoints.add(oneLinePoints);
        }

        return arrayOfPoints;
    }
}
