package by.makarchuk.diamondfund.parser;

import by.makarchuk.diamondfund.entity.Color;
import by.makarchuk.diamondfund.entity.DiamondStone;
import by.makarchuk.diamondfund.entity.Preciousness;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestSaxBuilder {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    @Test
    public void test_1() {
        DiamondStone diamondStone = new DiamondStone();
        diamondStone.setName("diamond");
        diamondStone.setOrigin("russia");
        diamondStone.setDateDiscovery(LocalDateTime.parse("2000-11-11T12:30:40", DATE_TIME_FORMATTER));
        diamondStone.setColor(Color.RED);
        diamondStone.setWeightGrm(23.0);
        diamondStone.setPreciousness(Preciousness.PRECIOUS);
        diamondStone.setTransparency(95.0);

        String type = "sax";
        AbstractGemsBuilder builder = GemBuilderFactory.createGemBuilder(type);
        builder.buildSetGems(getClass().getClassLoader().getResource("XmlAndXsdForTest//gemsTest.xml").getFile());

        Assert.assertEquals(builder.getGems().toArray()[0], diamondStone);
    }
}
