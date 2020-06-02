package doPosprzatania.kolekcje;

import java.util.ArrayList;
import java.util.List;

public class List_WyswietlenieZawartosci {

    public static void main(String[] args) {

        List<String> lista = new ArrayList<String>();
        lista.add("Filipiny");
        lista.add("Chile");
        lista.add("Argentyna");


        System.out.println("Pierwsza możliwość wyswietlenia listy:");
        for (String item : lista) {
            System.out.println(item);
        }

        System.out.println("Druga możliwość wyswietlenia listy:");
        lista.forEach(System.out::println);

        System.out.println("Trzecia możliwość wyswietlenia listy:");
        lista.forEach(elem -> System.out.println(elem));


    }
}
