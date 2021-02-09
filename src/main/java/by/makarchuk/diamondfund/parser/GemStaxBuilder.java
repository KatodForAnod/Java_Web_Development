package by.makarchuk.diamondfund.parser;

import by.makarchuk.diamondfund.entity.Color;
import by.makarchuk.diamondfund.entity.DiamondStone;
import by.makarchuk.diamondfund.entity.Preciousness;
import by.makarchuk.diamondfund.handler.GemXmlTag;
import org.apache.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

public class GemStaxBuilder {
    private static final Logger logger = Logger.getLogger(GemStaxBuilder.class);
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
    private Set<DiamondStone> gems;
    private XMLInputFactory inputFactory;

    public GemStaxBuilder() {
        inputFactory = XMLInputFactory.newInstance();
        gems = new HashSet<DiamondStone>();
    }

    public Set<DiamondStone> getGems() {
        return gems;
    }

    public void buildSetGems(String filename) {
        XMLStreamReader reader;
        String name;
        try (FileInputStream inputStream = new FileInputStream(new File(filename))) {
            reader = inputFactory.createXMLStreamReader(inputStream);
            // StAX parsing
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (name.equals(GemXmlTag.DIAMOND_GEM.getValue())) {
                        DiamondStone gem = buildGem(reader);
                        gems.add(gem);
                    }
                }
            }
        } catch (XMLStreamException | IOException e) {
            logger.error("buildSetGems: ", e);
            e.printStackTrace();
        }
    }

    private DiamondStone buildGem(XMLStreamReader reader) throws XMLStreamException {
        DiamondStone gem = new DiamondStone();

        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (GemXmlTag.valueOf(name.toUpperCase())) {
                        case NAME: {
                            gem.setName(getXMLText(reader));
                            break;
                        }
                        case ORIGIN: {
                            gem.setOrigin(getXMLText(reader));
                            break;
                        }
                        case DATE: {
                            gem.setDateDiscovery(LocalDateTime.parse(getXMLText(reader), DATE_TIME_FORMATTER));
                            break;
                        }
                        case COLOR: {
                            String color = getXMLText(reader).toUpperCase();
                            gem.setColor(Color.valueOf(color));
                            break;
                        }
                        case WEIGHTGRM: {
                            gem.setWeightGrm(Double.parseDouble(getXMLText(reader)));
                            break;
                        }
                        case PRECIOUSNESS: {
                            String preciousness = getXMLText(reader).toUpperCase();
                            gem.setPreciousness(Preciousness.valueOf(preciousness));
                            break;
                        }
                        case TRANSPARENCY: {
                            gem.setTransparency(Double.parseDouble(getXMLText(reader)));
                            break;
                        }
                        case CARATS: {
                            gem.setCarats(Double.parseDouble(getXMLText(reader)));
                            break;
                        }

                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (GemXmlTag.valueOf(name.toUpperCase()) == GemXmlTag.DIAMOND_GEM) {
                        return gem;
                    }
            }
        }
        logger.error("buildGem: Unknown element in tag <gem>");
        throw new XMLStreamException("Unknown element in tag <gem>");
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}
