package by.makarchuk.shape.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseInputString {
    private static final String patternString = "(\\d+\\.\\d)\\s(\\d+\\.\\d)\\s(\\d+\\.\\d){1}";

    public static boolean onlyDoubleCheck(String inputData) {
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(inputData);

        return matcher.find();
    }
}
