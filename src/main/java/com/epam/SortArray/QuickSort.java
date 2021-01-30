package com.epam.SortArray;

import org.apache.log4j.Logger;

public class QuickSort {
    private static final Logger logger = Logger.getLogger(QuickSort.class);

    public int[] sortMinToMax(int[] source, int leftBorder, int rightBorder) {
        logger.info("started method sortMinToMax");

        if (source.length < 2) {
            if (source.length == 0) {
                logger.error("wrong size of mass");
                return null;
            }

            return source;
        }

        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = source[(leftMarker + rightMarker) / 2];
        do {

            while (source[leftMarker] < pivot) {
                leftMarker++;
            }

            while (source[rightMarker] > pivot) {
                rightMarker--;
            }

            if (leftMarker <= rightMarker) {

                if (leftMarker < rightMarker) {
                    int tmp = source[leftMarker];
                    source[leftMarker] = source[rightMarker];
                    source[rightMarker] = tmp;
                }

                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);


        if (leftMarker < rightBorder) {
            sortMinToMax(source, leftMarker, rightBorder);
        }
        if (leftBorder < rightMarker) {
            sortMinToMax(source, leftBorder, rightMarker);
        }

        return source;
    }
}
