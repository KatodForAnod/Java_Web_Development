package by.makarchuk.infhandling.composite;

import java.util.LinkedList;
import java.util.List;

public class TextComposite implements TextComponent {
    private static final String tab = "    ";
    private TypeComponent typeComponent;
    private List<TextComponent> components = new LinkedList<>();

    @Override
    public int countComponents() {
        return components.size();
    }

    public TextComposite(TypeComponent typeComponent) {
        this.typeComponent = typeComponent;
    }

    @Override
    public void addComponent(TextComponent componentText) {
        components.add(componentText);
    }

    @Override
    public void deleteComponent(TextComponent componentText) {

    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String specSymbol = "";

        switch (typeComponent) {
            case TEXT: {
                specSymbol = "\n";
                break;
            }
            case PARAGRAPH: {
                stringBuilder.append(tab);
                break;
            }
            case SENTENCE: {
                specSymbol = " ";
                break;
            }
            default: {
                specSymbol = "";
                break;
            }
        }
        for (TextComponent block : components) {
            stringBuilder.append(block.toString()).append(specSymbol);
        }

        return stringBuilder.toString();
    }
}
