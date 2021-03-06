package by.makarchuk.infhandling.parser;

import by.makarchuk.infhandling.composite.Symbol;
import by.makarchuk.infhandling.composite.TextComposite;
import by.makarchuk.infhandling.composite.TypeComponent;

public class WordParser extends AbstractTextParser{
    @Override
    public TextComposite parse(String text) {
        TextComposite wordComposite = new TextComposite(TypeComponent.WORD);
        for(char symbolValue : text.toCharArray()) {
            if(symbolValue == ' '){
                continue;
            }
            Symbol symbol = new Symbol(symbolValue,TypeComponent.SYMBOL);
            wordComposite.addComponent(symbol);
        }

        return wordComposite;
    }
}
