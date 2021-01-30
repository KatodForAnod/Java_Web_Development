package com.epam.ReadFile;

import org.apache.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseInputData {
    private static final Logger logger = Logger.getLogger(ParseInputData.class);
    private static final String patternString = "[a-zA-Z]";

    public static boolean onlyIntCheck(String inputData) {
        logger.info("started method onlyIntCheck");
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(inputData);

        return !matcher.find();
    }
}
