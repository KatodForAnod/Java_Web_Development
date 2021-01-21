package ReadFiles;

import MyExeptions.ArrayException;

import java.io.*;
import java.util.Scanner;


public class ReadTxt {
    public static int[] createArrayFromFile(String path) throws IOException {
        File file = new File(path);
        Scanner scanner = new Scanner(file);

        String inputData = scanner.nextLine();
        while (!ParseInputData.onlyIntCheck(inputData)) {
            inputData = scanner.nextLine();
        }

        String[] param = inputData.split(" ");

        int[] array;
        try {
            array = createNewIntArray(param);
        } catch (ArrayException e) {
            e.printStackTrace();
            return new int[0];
        }

        try {
            array = fillIntArray(param, array);
        } catch (ArrayException e) {
            e.printStackTrace();
            return new int[0];
        }

        return array;
    }

    public static int[] createNewIntArray(String[] param) throws ArrayException {
        int defaultSize;
        int[] array;

        try {
            if (param.length < 2) {
                throw new ArrayException();
            }

            defaultSize = Integer.parseInt(param[0]);
            array = new int[defaultSize];
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return new int[0];
        }

        return array;
    }

    public static int[] fillIntArray(String[] param, int[] array) throws ArrayException {
        try {
            //example
            //param = {2, -4, 5}
            //array = {-4, 5}
            if (param.length - 1 != array.length) {
                throw new ArrayException();
            }

            for (int i = 0; i < array.length; i++) {
                array[i] = Integer.parseInt(param[i + 1]);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return new int[0];
        }

        return array;
    }
}
