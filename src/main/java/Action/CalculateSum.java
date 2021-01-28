package Action;

import org.apache.log4j.Logger;

import java.util.Arrays;

public class CalculateSum {
    private static final Logger logger = Logger.getLogger(CalculateSum.class);

    public Integer calculateSum(int[] array) {
        logger.info("started method calculateSum");

        if (array.length < 1) {
            logger.error("wrong size of mass");
            return null;
        }

        int sum = 0;
        for (int i : array) {
            sum += i;
        }

        return sum;
    }

    public Integer calculateSumUseIntStream(int[] array) {
        logger.info("started method calculateSumUseIntStream");

        if (array.length < 1) {
            logger.error("wrong size of mass");
            return null;
        }

        return Arrays.stream(array).sum();
    }
}
