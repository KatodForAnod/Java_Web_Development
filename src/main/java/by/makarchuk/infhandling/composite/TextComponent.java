package by.makarchuk.infhandling.composite;

import java.util.List;

public interface TextComponent {
    int countComponents();
    void query();
    List<TextComponent> getComponents();
    void addComponent(TextComponent componentText);
    void deleteComponent(TextComponent componentText);
}
