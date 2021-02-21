package by.makarchuk.shape.reader;

import by.makarchuk.shape.entity.Point;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CreatPointsFromStringList {
    private static final Logger logger = Logger.getLogger(CreatPointsFromStringList.class);
    private static final String stringSplit = " ";
    private static final int countOfPointParams = 3;

    public List<List<Point>> getPoints(List<String> inputList) {
        List<List<Point>> arrayOfPoints = new ArrayList<>();
        for (String string : inputList) {
            if (!InputStringIsValid.noLettersCheck(string)) {
                logger.warn("warn: stroke " + string + " has letters");
                continue;
            }
            String[] pointParams = string.split(stringSplit);
            if ((pointParams.length % countOfPointParams) != 0 ||
                    pointParams.length == 0) {
                logger.warn("warn: stroke " + string + " has not %3 = 0, for 1 point ned x y z");
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
                    logger.info("created new point with input data " + x + " " + y + " " + z);
                } catch (NumberFormatException e) {
                    logger.warn("warn stroke " + string + " must have only double numbers");
                }
            }
            arrayOfPoints.add(oneLinePoints);
        }

        return arrayOfPoints;
    }
}
