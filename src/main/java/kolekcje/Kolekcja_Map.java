package kolekcje;

import java.util.HashMap;
import java.util.Map;

/**
 * Mapa jest kolekcją par klucz-wartość, gdzie klucze są unikalne.
 */
public class Kolekcja_Map {


    /**
     * Wyświetlenie danych mapy z for
     */
    public static void main(String[] args) {
        Map<String, String> listaSamochodow = new HashMap<>();
        listaSamochodow.put("Syrena", "105L");
        listaSamochodow.putIfAbsent("Fiat", "125P");
        listaSamochodow.putIfAbsent("Warszawa", "M20");

        for (Map.Entry<String, String> entry : listaSamochodow.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    /**
     * Wyświetlenie danych mapy za pomocą .forEach
     */
    public static void wyswietlMapeForEach(String[] args) {
        Map<String, String> listaSamochodow = new HashMap<>();
        listaSamochodow.put("Syrena", "105L");
        listaSamochodow.putIfAbsent("Fiat", "125P");
        listaSamochodow.putIfAbsent("Warszawa", "M20");

        listaSamochodow.forEach((k, v) -> System.out.println((k + ":" + v)));

    }

    /**
     * Wyświetlenie danych mapy za pomocą Stream
     */
    public static void wyswietlMapeStream(String[] args) {
        Map<String, String> listaSamochodow = new HashMap<>();
        listaSamochodow.put("Syrena", "105L");
        listaSamochodow.putIfAbsent("Fiat", "125P");
        listaSamochodow.putIfAbsent("Warszawa", "M20");

        listaSamochodow.entrySet().stream()
                .forEach(e -> System.out.println(e.getKey() +":" + e.getValue()));
    }
}
