package by.makarchuk.infhandling.composite;

public class Symbol implements TextComponent{
    private static final int LENGTH_SYMBOL = 1;
    private char value;
    private TypeComponent typeComponent;

    @Override
    public int countComponents() {
        return LENGTH_SYMBOL;
    }

    public Symbol(char value, TypeComponent typeComponent) {
        this.value = value;
        this.typeComponent = typeComponent;
    }

    @Override
    public void addComponent(TextComponent componentText) {

    }

    @Override
    public void deleteComponent(TextComponent componentText) {

    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
