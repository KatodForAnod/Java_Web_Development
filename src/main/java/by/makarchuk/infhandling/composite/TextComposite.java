package by.makarchuk.infhandling.composite;

import java.util.LinkedList;
import java.util.List;

public class TextComposite implements TextComponent {
    private TypeComponent typeComponent;
    private List<TypeComponent> components = new LinkedList<>();

    @Override
    public int countComponents() {
        return components.size();
    }

    @Override
    public void addComponent(TextComponent componentText) {

    }

    @Override
    public void deleteComponent(TextComponent componentText) {

    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        switch (typeComponent) {
            case TEXT: {
                for (TypeComponent block : components) {
                    stringBuilder.append(block.toString()).append("\n");
                }
                break;
            }
            case PARAGRAPH: {
                stringBuilder.append("    ");
            }
            case SENTENCE: {
                for (TypeComponent block : components) {
                    stringBuilder.append(block.toString()).append(" ");
                }
                break;
            }
            default: {
                for (TypeComponent block : components) {
                    stringBuilder.append(block.toString());
                }
                break;
            }
        }

        return stringBuilder.toString();
    }
}
