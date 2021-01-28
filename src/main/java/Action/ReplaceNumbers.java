package Action;

import org.apache.log4j.Logger;

public class ReplaceNumbers {
    private static final Logger logger = Logger.getLogger(ReplaceNumbers.class);

    public int[] replaceNumber(int[] array, int prevSi, int newSi) {
        logger.info("started method replaceNumber");
        if (array.length < 1) {
            logger.error("wrong size of mass");
            return null;
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == prevSi) {
                array[i] = newSi;
            }
        }

        return array;
    }
}
