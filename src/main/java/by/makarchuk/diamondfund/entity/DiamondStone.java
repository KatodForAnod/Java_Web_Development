package by.makarchuk.diamondfund.entity;

import java.time.LocalDateTime;

public class DiamondStone extends Stone {
    protected Double carats;
    protected Double transparency;

    public DiamondStone(LocalDateTime dateDiscovery, String name, String origin, Color color, Double carats, Double transparency) {
        super(dateDiscovery, name, carats / 5, origin, color);
        this.carats = carats;
        this.transparency = transparency;
    }

    @Override
    public void setWeightGrm(Double weightGrm) {
        setCarats(weightGrm * 5);
    }

    public void setCarats(Double carats) {
        weightGrm = carats / 5;
        this.carats = carats;
    }

    public void setTransparency(Double transparency) {

        this.transparency = transparency;
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
                .append("}");

        return infAboutStone.toString();
    }
}
