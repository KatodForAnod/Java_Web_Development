package by.makarchuk.diamondfund.parser;

import by.makarchuk.diamondfund.entity.DiamondStone;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractGemsBuilder {
    protected Set<DiamondStone> gems;

    public AbstractGemsBuilder() {
        gems = new HashSet<DiamondStone>();
    }

    public AbstractGemsBuilder(Set<DiamondStone> gems) {
        this.gems = gems;
    }

    public Set<DiamondStone> getGems() {
        return gems;
    }

    public abstract void buildSetGems(String filename);
}
