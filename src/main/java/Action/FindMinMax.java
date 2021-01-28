package Action;

import org.apache.log4j.Logger;

public class FindMinMax {
    private static final Logger logger = Logger.getLogger(FindMinMax.class);

    public Integer findMin(int[] array) {
        logger.info("started method findMin");
        if (array.length < 1) {
            logger.error("wrong size of mass");
            return null;
        }

        int min = array[0];
        for (int i : array) {
            if (min > i) {
                min = i;
            }
        }

        return min;
    }

    public Integer findMax(int[] array) {
        logger.info("started method findMax");
        if (array.length < 1) {
            logger.error("wrong size of mass");
            return null;
        }

        int max = array[0];
        for (int i : array) {
            if (max < i) {
                max = i;
            }
        }

        return max;
    }
}
