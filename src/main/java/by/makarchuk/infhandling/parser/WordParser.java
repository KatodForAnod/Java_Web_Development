package by.makarchuk.infhandling.parser;

import by.makarchuk.infhandling.composite.Symbol;
import by.makarchuk.infhandling.composite.TextComposite;
import by.makarchuk.infhandling.composite.TypeComponent;
import org.apache.log4j.Logger;

public class WordParser extends AbstractTextParser{
    private static final Logger logger = Logger.getLogger(SentenceParse.class);
    @Override
    public TextComposite parse(String text) {
        logger.info("parse text: " + text);
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
