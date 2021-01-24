package Action;

public class ReplaceNumbers {
    public int[] replaceNumber(int[] array, int prevSi, int newSi) {
        if (array.length < 1) {
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
