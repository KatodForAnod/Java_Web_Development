package Action;

public class FindMinMax {
    public static Integer findMin(int[] array) {
        if (array.length < 1) {
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

    public static Integer findMax(int[] array) {
        if (array.length < 1) {
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
