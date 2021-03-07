package by.makarchuk.infhandling.composite;

import org.apache.log4j.Logger;

import java.util.Collections;
import java.util.List;

public class Symbol implements TextComponent{
    private static final Logger logger = Logger.getLogger(Symbol.class);
    private static final int LENGTH_SYMBOL = 1;
    private char value;
    private TypeComponent typeComponent;

    @Override
    public int countComponents() {
        return LENGTH_SYMBOL;
    }

    @Override
    public void query() {

    }

    @Override
    public List<TextComponent> getComponents() {
        //logger
        return Collections.emptyList();
    }

    public Symbol(char value, TypeComponent typeComponent) {
        logger.info("create symbol: " + value);
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
