package Action;

public class CalculateSum {
    public Integer calculateSum(int[] array) {
        if (array.length < 1) {
            return null;
        }

        int sum = 0;
        for (int i : array) {
            sum += i;
        }

        return sum;
    }
}
