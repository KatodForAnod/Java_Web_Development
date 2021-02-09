package by.makarchuk.diamondfund.handler;

import by.makarchuk.diamondfund.entity.Color;
import by.makarchuk.diamondfund.entity.DiamondStone;
import by.makarchuk.diamondfund.entity.Preciousness;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class GemHandler extends DefaultHandler {
    private Set<DiamondStone> gems;
    private DiamondStone current;
    private GemXmlTag currentXmlTag;
    private EnumSet<GemXmlTag> withText;
    private static final String ELEMENT_DIAMOND_GEM = "diamond_gem";
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    public GemHandler() {
        gems = new HashSet<DiamondStone>();
        withText = EnumSet.range(GemXmlTag.NAME, GemXmlTag.TRANSPARENCY);
    }

    public Set<DiamondStone> getStones() {
        return gems;
    }

    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        if (ELEMENT_DIAMOND_GEM.equals(qName)) {
            current = new DiamondStone();
        } else {
            GemXmlTag temp = GemXmlTag.valueOf(qName.toUpperCase());
            if (withText.contains(temp)) {
                currentXmlTag = temp;
            }
        }
    }

    public void endElement(String uri, String localName, String qName) {
        if (ELEMENT_DIAMOND_GEM.equals(qName)) {
            gems.add(current);
        }
    }

    public void characters(char[] ch, int start, int length) {
        String data = new String(ch, start, length).trim();
        if (currentXmlTag != null) {
            switch (currentXmlTag) {
                case NAME: {
                    current.setName(data);
                    break;
                }
                case ORIGIN: {
                    current.setOrigin(data);
                    break;
                }
                case DATE: {
                    current.setDateDiscovery(LocalDateTime.parse(data, DATE_TIME_FORMATTER));
                    break;
                }
                case COLOR: {
                    String color = data.toUpperCase();
                    current.setColor(Color.valueOf(color));
                    break;
                }
                case WEIGHTGRM: {
                    current.setWeightGrm(Double.parseDouble(data));
                    break;
                }
                case PRECIOUSNESS: {
                    String preciousness = data.toUpperCase();
                    current.setPreciousness(Preciousness.valueOf(preciousness));
                    break;
                }
                case TRANSPARENCY: {
                    current.setTransparency(Double.parseDouble(data));
                    break;
                }
                case CARATS: {
                    current.setCarats(Double.parseDouble(data));
                    break;
                }
                /*default : {throw new EnumConstantNotPresentException(
                        currentXmlTag.getDeclaringClass(), currentXmlTag.name());}*/
            }
        }
        currentXmlTag = null;
    }
}
