package by.makarchuk.diamondfund.parser;

import by.makarchuk.diamondfund.entity.DiamondStone;
import by.makarchuk.diamondfund.handler.GemErrorHandler;
import by.makarchuk.diamondfund.handler.GemHandler;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.Set;

public class GemsSaxBuilder {
    private static final Logger logger = Logger.getLogger(GemsSaxBuilder.class);
    private GemHandler handler = new GemHandler();
    private XMLReader reader;
    private Set<DiamondStone> gems;

    public GemsSaxBuilder() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            reader = saxParser.getXMLReader();
        } catch (ParserConfigurationException | SAXException e) {
            logger.error("GemSaxBuilder(): ", e);
            e.printStackTrace(); // log
        }
        reader.setErrorHandler(new GemErrorHandler());
        reader.setContentHandler(handler);
    }

    public Set<DiamondStone> getStones() {
        return gems;
    }

    public void buildSetGems(String filename) {
        try {
            reader.parse(filename);
        } catch (SAXException | IOException e) {
            logger.error("buildSetGems: ", e);
            e.printStackTrace(); // log
        }
        gems = handler.getStones();
    }
}
