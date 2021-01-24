package SortArray;

public class InsertSort {
    public int[] sortMinToMax(int[] array) {
        if (array.length < 2) {
            if (array.length == 0) {
                return null;
            }

            return array;
        }

        for (int left = 0; left < array.length; left++) {

            int value = array[left];
            int i = left - 1;

            for (; i >= 0; i--) {
                if (value < array[i]) {
                    array[i + 1] = array[i];
                } else {
                    break;
                }
            }

            array[i + 1] = value;
        }

        return array;
    }
}
