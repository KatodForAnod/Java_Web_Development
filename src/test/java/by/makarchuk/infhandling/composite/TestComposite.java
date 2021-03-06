package by.makarchuk.infhandling.composite;

import org.testng.annotations.Test;

public class TestComposite {
    @Test
    public void test_1() {
        TextComposite textComposite = new TextComposite(TypeComponent.TEXT);
        Symbol symbol1 = new Symbol('H',TypeComponent.SYMBOL);
        Symbol symbol2 = new Symbol('e',TypeComponent.SYMBOL);
        Symbol symbol3 = new Symbol('y',TypeComponent.SYMBOL);
        Symbol symbol4 = new Symbol('y',TypeComponent.SYMBOL);
        Symbol symbol5 = new Symbol('a',TypeComponent.SYMBOL);
        Symbol symbol6 = new Symbol('!',TypeComponent.SYMBOL);
        Symbol symbol7 = new Symbol('O',TypeComponent.SYMBOL);
        Symbol symbol8 = new Symbol('F',TypeComponent.SYMBOL);
        Symbol symbol9 = new Symbol('C',TypeComponent.SYMBOL);
        Symbol symbol10 = new Symbol('.',TypeComponent.SYMBOL);
        Symbol symbol11 = new Symbol('H',TypeComponent.SYMBOL);
        Symbol symbol12 = new Symbol('e',TypeComponent.SYMBOL);
        Symbol symbol13 = new Symbol('l',TypeComponent.SYMBOL);
        Symbol symbol14 = new Symbol('l',TypeComponent.SYMBOL);
        Symbol symbol15 = new Symbol('o',TypeComponent.SYMBOL);

        TextComposite textComposite1 = new TextComposite(TypeComponent.WORD);
        textComposite1.addComponent(symbol1);
        textComposite1.addComponent(symbol2);
        textComposite1.addComponent(symbol3);


        TextComposite textComposite2 = new TextComposite(TypeComponent.WORD);
        textComposite2.addComponent(symbol4);
        textComposite2.addComponent(symbol5);
        textComposite2.addComponent(symbol6);

        TextComposite textComposite3 = new TextComposite(TypeComponent.WORD);
        textComposite3.addComponent(symbol7);
        textComposite3.addComponent(symbol8);
        textComposite3.addComponent(symbol9);
        textComposite3.addComponent(symbol10);



        TextComposite textComposite4 = new TextComposite(TypeComponent.SENTENCE);
        textComposite4.addComponent(textComposite1);
        textComposite4.addComponent(textComposite2);
        TextComposite textComposite5 = new TextComposite(TypeComponent.SENTENCE);
        textComposite5.addComponent(textComposite3);
        TextComposite textComposite6 = new TextComposite(TypeComponent.PARAGRAPH);
        textComposite6.addComponent(textComposite4);
        textComposite6.addComponent(textComposite5);



        textComposite.addComponent(textComposite6);
        System.out.println(textComposite.toString());
    }

    @Test
    public void test_2(){
        String str = "      hey us ofc.";
        for(String i:str.split("(?<=[a-zA-Z])(\\s)")){
            System.out.println(i);
        }
    }
}
