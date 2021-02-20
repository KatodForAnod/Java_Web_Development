package by.makarchuk.shape.reader;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputStringIsValid {
    //private static final String patternString = "(\\d+\\.\\d)\\s(\\d+\\.\\d)\\s(\\d+\\.\\d)";
    private static final String patternString = "[a-zA-z]";

    public static boolean noLettersCheck(String inputData) {
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(inputData);

        return !matcher.find();
    }
}
