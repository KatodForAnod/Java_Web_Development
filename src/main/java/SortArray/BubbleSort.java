package SortArray;

public class BubbleSort {
    public int[] sortMinToMax(int[] array) {
        if (array.length < 2) {
            if (array.length == 0) {
                return null;
            }

            return array;
        }

        int tmp;
        int sizeOfMass = array.length;

        while (sizeOfMass > 1) {
            for (int i = 1; i < sizeOfMass; i++) {
                if (array[i - 1] > array[i]) {
                    tmp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = tmp;
                }
            }

            sizeOfMass--;
        }


        return array;
    }
}
