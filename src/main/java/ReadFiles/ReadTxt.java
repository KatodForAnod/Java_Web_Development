package ReadFiles;

import java.io.*;
import java.util.Scanner;

/*
    TODO
    Сделать собственные классы исключений
    Сделать парсер проверяющий правильные данные
 */
public class ReadTxt {
    public static int[] createArrayFromFile(String path) throws IOException {
        File file = new File(path);
        Scanner scanner = new Scanner(file);

        String size = scanner.next();

        int defaultSize;
        int[] array;

        try {
            defaultSize = Integer.parseInt(size);
            array = new int[defaultSize];
        } catch (NumberFormatException e) {
            return new int[0];
        }

        try {
            int i = 0;
            while (scanner.hasNext()) {
                String value = scanner.next();
                array[i] = Integer.parseInt(value);
                i++;
            }
        } catch (NumberFormatException e) {
            System.out.println("Wrong input data");
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Wrong array size");
            e.printStackTrace();
        }


        return array;
    }
}
