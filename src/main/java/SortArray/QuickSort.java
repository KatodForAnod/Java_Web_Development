package SortArray;

public class QuickSort {
    public static int[] sortMinToMax(int[] source, int leftBorder, int rightBorder) {
        if (source.length < 2) {
            if (source.length == 0) {
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
