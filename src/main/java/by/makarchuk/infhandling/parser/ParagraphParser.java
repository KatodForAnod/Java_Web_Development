package by.makarchuk.infhandling.parser;

import by.makarchuk.infhandling.composite.TextComposite;
import by.makarchuk.infhandling.composite.TypeComponent;

public class ParagraphParser extends AbstractTextParser{
    private static final String SENTENCE_SPLIT = "(?<=((\\.)|(!)))(\\s)";
    private AbstractTextParser sentenceParser = new SentenceParse();
    @Override
    public TextComposite parse(String text) {
        TextComposite paragraphComposite = new TextComposite(TypeComponent.PARAGRAPH);
        for(String paragraphText : text.split(SENTENCE_SPLIT)) {
            TextComposite sentence = sentenceParser.parse(paragraphText);
            paragraphComposite.addComponent(sentence);
        }

        return paragraphComposite;
    }
}
