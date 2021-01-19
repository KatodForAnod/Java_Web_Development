package Action;

public class CalculateAverage {
    public static Double calculateAverage(int[] array) {
        if (array.length < 1) {
            return null;
        }

        double average = 0;
        for (int i : array) {
            average += i;
        }

        return average / array.length;
    }
}
