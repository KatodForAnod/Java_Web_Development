package by.makarchuk.diamondfund.parser;

public class GemBuilderFactory {
    private enum TypeParser {
        SAX, STAX, DOM
    }

    private GemBuilderFactory() {
    }

    public static AbstractGemsBuilder createGemBuilder(String typeParser) {
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        switch (type) {
            case DOM: {
                return new GemsDomBuilder();
            }
            case STAX: {
                return new GemsStaxBuilder();
            }
            case SAX: {
                return new GemsSaxBuilder();
            }
            default: {
                throw new EnumConstantNotPresentException(
                        type.getDeclaringClass(), type.name());
            }
        }
    }
}
