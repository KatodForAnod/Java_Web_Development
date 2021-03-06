package by.makarchuk.infhandling.parser;

import by.makarchuk.infhandling.composite.TextComposite;
import by.makarchuk.infhandling.composite.TypeComponent;

public class SentenceParse extends AbstractTextParser {
    private static final String WORD_SPLIT = "(?<=([^\\s])(\\s))";
    private AbstractTextParser wordParser = new WordParser();

    @Override
    public TextComposite parse(String text) {
        TextComposite sentenceComposite = new TextComposite(TypeComponent.SENTENCE);
        for (String sentenceText : text.split(WORD_SPLIT)) {
            TextComposite word = wordParser.parse(sentenceText);
            sentenceComposite.addComponent(word);
        }

        return sentenceComposite;
    }
}
