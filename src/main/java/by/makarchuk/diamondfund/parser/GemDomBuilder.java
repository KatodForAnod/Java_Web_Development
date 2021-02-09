package by.makarchuk.diamondfund.parser;

import by.makarchuk.diamondfund.entity.Color;
import by.makarchuk.diamondfund.entity.DiamondStone;
import by.makarchuk.diamondfund.entity.Preciousness;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

public class GemDomBuilder {
    private Set<DiamondStone> gems;
    private DocumentBuilder docBuilder;
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
    private static final Logger logger = Logger.getLogger(GemDomBuilder.class);

    public GemDomBuilder() {
        gems = new HashSet<DiamondStone>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            logger.error("GemDomBuilder(): ", e);
            e.printStackTrace(); // log
        }
    }

    public Set<DiamondStone> getGems() {
        return gems;
    }

    public void buildSetGems(String filename) {
        Document doc;
        try {
            doc = docBuilder.parse(filename);
            Element root = doc.getDocumentElement();
            NodeList studentsList = root.getElementsByTagName("diamond_gem");
            for (int i = 0; i < studentsList.getLength(); i++) {
                Element studentElement = (Element) studentsList.item(i);
                DiamondStone diamondStone = buildGem(studentElement);
                gems.add(diamondStone);
            }
        } catch (IOException | SAXException e) {
            logger.error("buildSetGems: ", e);
            e.printStackTrace(); // log
        }
    }

    private DiamondStone buildGem(Element gemElement) {
        DiamondStone diamondStone = new DiamondStone();
        diamondStone.setName(getElementTextContent(gemElement, "name"));
        diamondStone.setOrigin(getElementTextContent(gemElement, "origin"));

        LocalDateTime localDateTime =
                LocalDateTime.parse(getElementTextContent(gemElement, "date"), DATE_TIME_FORMATTER);
        diamondStone.setDateDiscovery(localDateTime);

        String color = getElementTextContent(gemElement, "color").toUpperCase();
        diamondStone.setColor(Color.valueOf(color));

        Double weight = Double.parseDouble(getElementTextContent(gemElement, "weightGrm"));
        diamondStone.setWeightGrm(weight);

        String precious = getElementTextContent(gemElement, "preciousness").toUpperCase();
        diamondStone.setPreciousness(Preciousness.valueOf(precious));

        //tag carats has minOccurs="0"
        String caratsStr = getElementTextContent(gemElement, "carats");
        if (caratsStr.equals("null")) {
            logger.warn("tag <carats> not found");
        } else {
            Double carats = Double.parseDouble(caratsStr);
            diamondStone.setWeightGrm(carats);
        }

        Double transparency = Double.parseDouble(getElementTextContent(gemElement, "transparency"));
        diamondStone.setTransparency(transparency);
        return diamondStone;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        if (node == null) {
            return "null";
        }
        String text = node.getTextContent();
        return text;
    }
}
