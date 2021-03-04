package by.makarchuk.infhandling.composite;

public interface TextComponent {
    int countComponents();
    void addComponent(TextComponent componentText);
    void deleteComponent(TextComponent componentText);
}
