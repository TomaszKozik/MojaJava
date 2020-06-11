package kolekcje.arrayList_Zadania;

import java.util.ArrayList;
import java.util.Arrays;

public class WypisanieDanych {

    /**
     * https://hyperskill.org/learn/step/2322
     */
    public static void main(String[] args) {
        ArrayList<String> listaSamochodow = new ArrayList<>(Arrays.asList("Syrena", "Fiat", "Warszawa"));

        System.out.println("---- foreach standardowe");
        for (String s : listaSamochodow) {
            System.out.println(s);
        }

        System.out.println("---- foreach z Consumerem - 1 sposób----");
        listaSamochodow.forEach(elem -> System.out.println(elem));

        System.out.println("---- foreach z Consumerem - 2 sposób ----");
        listaSamochodow.forEach(System.out::println);

        System.out.println("---- String.join ----");
        System.out.println(String.join("\n", listaSamochodow));
    }
}
