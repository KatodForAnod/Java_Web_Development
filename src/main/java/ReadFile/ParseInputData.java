package ReadFile;

import org.apache.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseInputData {
    private static final Logger logger = Logger.getLogger(ParseInputData.class);

    public static boolean onlyIntCheck(String inputData) {
        logger.info("started method onlyIntCheck");
        Pattern pattern = Pattern.compile("[a-zA-Z]");
        Matcher matcher = pattern.matcher(inputData);

        return !matcher.find();
    }
}
