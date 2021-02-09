package by.makarchuk.diamondfund.entity;

import org.apache.log4j.Logger;

import java.time.LocalDateTime;

public class DiamondStone extends Stone {
    private static final Logger logger = Logger.getLogger(DiamondStone.class);
    protected Double carats;
    protected Double transparency;
    protected Preciousness preciousness;

    public DiamondStone() {
    }

    public DiamondStone(LocalDateTime dateDiscovery, String name, String origin, Color color,
                        Double carats, Double transparency, Preciousness preciousness) {
        super(dateDiscovery, name, carats / 5, origin, color);

        this.carats = carats;
        this.transparency = transparency;
        this.preciousness = preciousness;
    }

    @Override
    public void setWeightGrm(Double weightGrm) {
        setCarats(weightGrm * 5);
    }

    public void setCarats(Double carats) {
        logger.info("setCarats input: " + carats);
        weightGrm = carats / 5;
        this.carats = carats;
    }

    public void setTransparency(Double transparency) {
        logger.info("setTransparency input: " + transparency);
        this.transparency = transparency;
    }

    public void setPreciousness(Preciousness preciousness) {
        this.preciousness = preciousness;
    }

    @Override
    public String toString() {
        StringBuilder infAboutStone = new StringBuilder("stone {");
        infAboutStone
                .append("name: ")
                .append(name)
                .append(", discovery: ")
                .append(dateDiscovery)
                .append(", carats: ")
                .append(carats)
                .append(", origin: ")
                .append(origin)
                .append(", color: ")
                .append(color)
                .append(", transparency: ")
                .append(transparency)
                .append(", preciousness: ")
                .append(preciousness)
                .append("}");

        return infAboutStone.toString();
    }
}
