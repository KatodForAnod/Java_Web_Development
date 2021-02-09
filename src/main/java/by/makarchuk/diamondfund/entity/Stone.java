package by.makarchuk.diamondfund.entity;

import java.time.LocalDateTime;


public abstract class Stone {
    protected LocalDateTime dateDiscovery;
    protected String name;
    protected Double weightGrm;
    protected String origin;
    protected Color color;

    public Stone() {
    }

    public Stone(LocalDateTime dateDiscovery, String name, Double weightGrm, String origin, Color color) {
        this.dateDiscovery = dateDiscovery;
        this.name = name;
        this.weightGrm = weightGrm;
        this.origin = origin;
        this.color = color;
    }

    public void setDateDiscovery(LocalDateTime dateDiscovery) {
        this.dateDiscovery = dateDiscovery;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeightGrm(Double weightGrm) {
        this.weightGrm = weightGrm;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        StringBuilder infAboutStone = new StringBuilder("stone {");
        infAboutStone
                .append("name: ").append(name)
                .append(", discovery: ").append(dateDiscovery)
                .append(", origin: ").append(origin)
                .append(", weightGrm: ").append(weightGrm)
                .append(", color: ").append(color)
                .append("}");

        return infAboutStone.toString();
    }
}
