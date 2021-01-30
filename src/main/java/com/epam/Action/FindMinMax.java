package com.epam.Action;

import org.apache.log4j.Logger;

import java.util.Arrays;

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

    public Integer findMinUseIntStream(int[] array) {
        logger.info("started method findMinUseIntStream");
        if (array.length < 1) {
            logger.error("wrong size of mass");
            return null;
        }

        return Arrays.stream(array).min().getAsInt();
    }

    public Integer findMaxUseIntStream(int[] array) {
        logger.info("started method findMaxUseIntStream");
        if (array.length < 1) {
            logger.error("wrong size of mass");
            return null;
        }

        return Arrays.stream(array).max().getAsInt();
    }
}
