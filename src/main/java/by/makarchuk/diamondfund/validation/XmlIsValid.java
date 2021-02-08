package by.makarchuk.diamondfund.validation;


import by.makarchuk.diamondfund.handler.GemErrorHandler;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XmlIsValid {
    private static final Logger logger = Logger.getLogger(GemErrorHandler.class);

    public static boolean isValid(String xmlPath, String xsdPath) {
        if (xmlPath == null || xsdPath == null) {
            logger.error("method isValid: wrong input data");
            return false;
        }
        boolean isValid = false;

        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(language);
        File schemaLocation = new File(xsdPath);
        try {
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(xmlPath);
            validator.setErrorHandler(new GemErrorHandler());
            validator.validate(source);
            isValid = true;
        } catch (IOException e) {
            System.err.println(xmlPath + " is not correct path");
        } catch (SAXException e) {
            System.err.println(xmlPath + " is not valid");
        }

        return isValid;
    }
}
