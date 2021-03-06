package by.makarchuk.infhandling.comparator;

import by.makarchuk.infhandling.composite.TextComponent;

import java.util.Comparator;

public class SortCountParagraphs implements Comparator<TextComponent> {
    @Override
    public int compare(TextComponent o1, TextComponent o2) {
        return o1.countComponents() - o2.countComponents();
    }
}
