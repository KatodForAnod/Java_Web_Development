package by.makarchuk.diamondfund.handler;

import org.apache.log4j.Logger;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXParseException;

public class GemErrorHandler implements ErrorHandler {
    private static final Logger logger = Logger.getLogger(GemErrorHandler.class);

    public void warning(SAXParseException e) {
        logger.warn(getLineColumnNumber(e) + "-" + e.getMessage());
    }

    public void error(SAXParseException e) {
        logger.error(getLineColumnNumber(e) + " - " + e.getMessage());
    }

    public void fatalError(SAXParseException e) {
        logger.fatal(getLineColumnNumber(e) + " - " + e.getMessage());
    }

    private String getLineColumnNumber(SAXParseException e) {
        return e.getLineNumber() + " : " + e.getColumnNumber();
    }

}
