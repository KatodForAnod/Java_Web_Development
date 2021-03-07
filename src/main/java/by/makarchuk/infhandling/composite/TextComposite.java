package by.makarchuk.infhandling.composite;

import by.makarchuk.infhandling.specification.Specification;
import org.apache.log4j.Logger;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class TextComposite implements TextComponent {
    private static final Logger logger = Logger.getLogger(TextComposite.class);
    private static final String tab = "    ";
    private TypeComponent typeComponent;
    private List<TextComponent> components = new LinkedList<>();

    @Override
    public int countComponents() {
        return components.size();
    }

    @Override
    public void query() {

    }

    @Override
    public List<TextComponent> getComponents() {
        return components;
    }

    public TextComposite(TypeComponent typeComponent) {
        logger.info("create " + typeComponent);
        this.typeComponent = typeComponent;
    }

    @Override
    public void addComponent(TextComponent componentText) {
        components.add(componentText);
    }

    @Override
    public void deleteComponent(TextComponent componentText) {

    }

    public void query(Comparator<TextComponent> comparator) {
        List<TextComponent> list = components.stream().sorted(comparator).collect(Collectors.toList());
        components = list;
    }

    public void query(Specification specification) {
        List<TextComponent> list = components.stream().filter(o -> specification.specify(o)).collect(Collectors.toList());
        components = list;
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
