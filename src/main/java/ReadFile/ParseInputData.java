package ReadFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseInputData {
    public static boolean onlyIntCheck(String inputData) {
        Pattern pattern = Pattern.compile("[a-zA-Z]");
        Matcher matcher = pattern.matcher(inputData);

        return !matcher.find();
    }
}
