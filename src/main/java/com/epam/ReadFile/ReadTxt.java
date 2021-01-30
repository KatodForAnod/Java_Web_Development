package com.epam.ReadFile;

import com.epam.NewExeption.ArrayException;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.Scanner;


public class ReadTxt {
    private static final Logger logger = Logger.getLogger(ReadTxt.class);

    //TODO rebuild function, remove IOException
    public static int[] createArrayFromFile(String path) {
        logger.info("started method createArrayFromFile");
        Scanner scanner;

        try {
            File file = new File(path);
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            return new int[0];
        }

        String inputData = scanner.nextLine();
        while (!ParseInputData.onlyIntCheck(inputData)) {
            inputData = scanner.nextLine();
        }

        String[] param = inputData.split(" ");

        int[] array;
        try {
            array = createNewIntArray(param);
        } catch (ArrayException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            return new int[0];
        }

        try {
            array = fillIntArray(param, array);
        } catch (ArrayException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            return new int[0];
        }

        return array;
    }

    public static int[] createNewIntArray(String[] param) throws ArrayException {
        logger.info("started method createNewIntArray");

        int defaultSize;
        int[] array;

        try {
            if (param.length < 2) {
                throw new ArrayException();
            }

            defaultSize = Integer.parseInt(param[0]);
            array = new int[defaultSize];
        } catch (NumberFormatException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            return new int[0];
        }

        return array;
    }

    public static int[] fillIntArray(String[] param, int[] array) throws ArrayException {
        logger.info("started method fillIntArray");
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
            logger.error(e.getMessage());
            e.printStackTrace();
            return new int[0];
        }

        return array;
    }
}
