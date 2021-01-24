package Action;

public class CalculateCountOfDiffNumbers {
    public Integer countOfPositiveNumbers(int[] array) {
        if (array.length < 1) {
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
        if (array.length < 1) {
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
}
