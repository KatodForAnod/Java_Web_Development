package by.makarchuk.infhandling.specification;

import by.makarchuk.infhandling.composite.TextComponent;

public class MinWordCount implements Specification{
    private int minWords;

    public MinWordCount(int minWords){
        this.minWords = minWords;
    }

    public boolean specify(TextComponent textComponent) {
        boolean result = textComponent.countComponents() >= minWords;

        return result;
    }
}
