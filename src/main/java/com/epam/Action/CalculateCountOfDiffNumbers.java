package com.epam.Action;

import org.apache.log4j.Logger;

import java.util.Arrays;

public class CalculateCountOfDiffNumbers {
    private static final Logger logger = Logger.getLogger(CalculateCountOfDiffNumbers.class);

    public Integer countOfPositiveNumbers(int[] array) {
        logger.info("started method countOfPositiveNumbers");
        if (array.length < 1) {
            logger.error("wrong size of mass");
            return null;
        }

        int count = 0;
        for (int i : array) {
            if (i > 0) {
                count++;
            }
        }

        return count;
    }

    public Integer countOfNegativeNumbers(int[] array) {
        logger.info("started method countOfNegativeNumbers");
        if (array.length < 1) {
            logger.error("wrong size of mass");
            return null;
        }

        int count = 0;
        for (int i : array) {
            if (i < 0) {
                count++;
            }
        }

        return count;
    }

    public Integer countOfPositiveNumbersUseIntStream(int[] array) {
        logger.info("started method countOfPositiveNumbersUseIntStream");
        if (array.length < 1) {
            logger.error("wrong size of mass");
            return null;
        }

        return Math.toIntExact(Arrays.stream(array).filter(x -> x > 0).count());
    }

    public Integer countOfNegativeNumbersUseIntStream(int[] array) {
        logger.info("started method countOfPositiveNumbersUseIntStream");
        if (array.length < 1) {
            logger.error("wrong size of mass");
            return null;
        }

        return Math.toIntExact(Arrays.stream(array).filter(x -> x < 0).count());
    }
}
