package by.makarchuk.diamondfund.validation;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class TestXmlIsValid {
    @Test
    public void test_1() {
        String xmlPath =
                getClass().getClassLoader().getResource("XmlAndXsdForTest//gemsTest.xml").getFile();
        String xsdPath =
                getClass().getClassLoader().getResource("XmlAndXsdForTest//gemsSchemaTest.xsd").getFile();

        boolean isValid = XmlIsValid.isValid(xmlPath, xsdPath);
        Assert.assertTrue(isValid);
    }
}
