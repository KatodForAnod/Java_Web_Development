package by.makarchuk.diamondfund.handler;

public enum GemXmlTag {
    GEMS("gems"),
    DIAMOND_GEM("diamond_gem"),
    ID("id"),
    LANG("lang"),
    NAME("name"),
    ORIGIN("origin"),
    DATE("date"),
    COLOR("color"),
    WEIGHTGRM("weightGrm"),
    PRECIOUSNESS("preciousness"),
    CARATS("carats"),
    TRANSPARENCY("transparency");

    private String value;

    GemXmlTag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
