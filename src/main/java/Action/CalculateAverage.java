package Action;

import org.apache.log4j.Logger;

import java.util.Arrays;

public class CalculateAverage {
    private static final Logger logger = Logger.getLogger(CalculateAverage.class);

    public Double calculateAverage(int[] array) {
        logger.info("started method calculateAverage");
        if (array.length < 1) {
            logger.error("wrong size of mass");
            return null;
        }

        double average = 0;
        for (int i : array) {
            average += i;
        }

        return average / array.length;
    }

    public Double calculateAverageUseIntStream(int[] array) {
        logger.info("started method calculateAverageUseIntStream");
        if (array.length < 1) {
            logger.error("wrong size of mass");
            return null;
        }


        return Arrays.stream(array).average().getAsDouble();
    }
}
