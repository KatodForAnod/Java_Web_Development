package by.makarchuk.diamondfund.entity;

import java.time.LocalDateTime;
import java.util.Objects;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stone stone = (Stone) o;
        return Objects.equals(dateDiscovery, stone.dateDiscovery) &&
                Objects.equals(name, stone.name) &&
                Objects.equals(weightGrm, stone.weightGrm) &&
                Objects.equals(origin, stone.origin) &&
                color == stone.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateDiscovery, name, weightGrm, origin, color);
    }
}
