package by.makarchuk.infhandling.parser;

import by.makarchuk.infhandling.composite.TextComposite;
import by.makarchuk.infhandling.composite.TypeComponent;
import org.apache.log4j.Logger;

public class SentenceParse extends AbstractTextParser {
    private static final Logger logger = Logger.getLogger(SentenceParse.class);
    private static final String WORD_SPLIT = "(?<=([^\\s])(\\s))";
    private AbstractTextParser wordParser = new WordParser();

    @Override
    public TextComposite parse(String text) {
        logger.info("parse text: " + text);
        TextComposite sentenceComposite = new TextComposite(TypeComponent.SENTENCE);
        for (String sentenceText : text.split(WORD_SPLIT)) {
            TextComposite word = wordParser.parse(sentenceText);
            sentenceComposite.addComponent(word);
        }

        return sentenceComposite;
    }
}
