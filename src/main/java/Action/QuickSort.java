package Action;

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

// Двигаем левый маркер слева направо пока элемент меньше, чем pivot

            while (source[leftMarker] < pivot) {
                leftMarker++;
            }

// Двигаем правый маркер, пока элемент больше, чем pivot

            while (source[rightMarker] > pivot) {
                rightMarker--;
            }

// Проверим, не нужно обменять местами элементы, на которые указывают маркеры

            if (leftMarker <= rightMarker) {

// Левый маркер будет меньше правого только если мы должны выполнить swap

                if (leftMarker < rightMarker) {
                    int tmp = source[leftMarker];
                    source[leftMarker] = source[rightMarker];
                    source[rightMarker] = tmp;
                }

// Сдвигаем маркеры, чтобы получить новые границы

                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);


// Выполняем рекурсивно для частей

        if (leftMarker < rightBorder) {
            sortMinToMax(source, leftMarker, rightBorder);
        }
        if (leftBorder < rightMarker) {
            sortMinToMax(source, leftBorder, rightMarker);
        }

        return source;
    }
}
