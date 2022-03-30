package tablice_kolekcje;

import java.util.*;

/**
 * Mapa jest kolekcją par klucz-wartość, gdzie klucze są unikalne.
 */
public class MapExamples {


    /**
     * Inicjowanie map
     */
    public static void inicjacjaMap() {
        // Mapa podstawowa
        Map<String, String> mapaHash = new HashMap<>();

            // Mapa zapamiętująca kolejność dodawania elementów
        Map<String, String> mapaLinked = new LinkedHashMap<>();

        // Mapa z sortowaniem elementów po kluczu
        SortedMap<String, String> mapaSorted = new TreeMap<>();
    }

    /**
     * Podstawowe metody dla Map
     */
    public static void podstawoweMetody(String[] args) {
        Map<String, String> listaSamochodow = new HashMap<>();
        listaSamochodow.put("Syrena", "105L");    // Dodaj klucz i wartość. Mapa zawiera: 'Syrena:105L'
        listaSamochodow.putIfAbsent("Fiat", "125P");    // Dodaj klucz i wartość jeśli nie istnieje. Mapa zawiera: 'Fiat:125P' i 'Syrena:105L'
        listaSamochodow.putIfAbsent("Syrena", "105L");  // Dodaj klucz i wartość jeśli nie istnieje. Mapa zawiera: 'Fiat:125P' i 'Syrena:105L'

        String modelFiata = listaSamochodow.get("Fiat");    // Pobierz wartość względem klucza. Pobierze '125P'
        String modelForda = listaSamochodow.getOrDefault("Ford", "brak klucza");   // Pobierz wartość względem klucza. Pobierze 'brak klucza', jako wartość domyślną, gdy nie ma danego klucza

        listaSamochodow.remove("Fiat"); // Usuń klucz i wartość według klucza. Mapa zawiera: 'Syrena:105L'

        listaSamochodow.containsKey("Syrena");  // Zwraca 'true' jeśli lista zawiera dany klucz
        listaSamochodow.containsValue("105L");  // Zwraca 'true' jeśli lista zawiera daną wartość
    }

    /**
     * Metody dla TreeMap
     */
    public static void metodyDlaTreeMap() {
        SortedMap<String, String> listaSamochodow = new TreeMap<>();
        listaSamochodow.put("Syrena", "105L");    // Dodaj klucz i wartość. Mapa zawiera: 'Syrena:105L'
        listaSamochodow.putIfAbsent("Fiat", "125P");    // Dodaj klucz i wartość jeśli nie istnieje. Mapa zawiera: 'Fiat:125P' i 'Syrena:105L'
        listaSamochodow.putIfAbsent("Syrena", "105L");  // Dodaj klucz i wartość jeśli nie istnieje. Mapa zawiera: 'Fiat:125P' i 'Syrena:105L'

        listaSamochodow.firstKey();    // Zwraca pierwszy element mapy
        listaSamochodow.lastKey();      // Zwraca ostatni element mapy

        listaSamochodow.subMap("Fiat", "Syrena");   // Zwraca nową mapę dla kluczy z wybranego zakresu
    }


    /**
     * Wyświetlenie danych mapy z for
     */
    public static void wyswietlMapeFor() {
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
    public static void wyswietlMapeForEach() {
        Map<String, String> listaSamochodow = new HashMap<>();
        listaSamochodow.put("Syrena", "105L");
        listaSamochodow.putIfAbsent("Fiat", "125P");
        listaSamochodow.putIfAbsent("Warszawa", "M20");

        listaSamochodow.forEach((k, v) -> System.out.println((k + ":" + v)));
    }

    /**
     * Wyświetlenie danych mapy za pomocą Stream
     */
    public static void wyswietlMapeStream() {
        Map<String, String> listaSamochodow = new HashMap<>();
        listaSamochodow.put("Syrena", "105L");
        listaSamochodow.putIfAbsent("Fiat", "125P");
        listaSamochodow.putIfAbsent("Warszawa", "M20");

        listaSamochodow.entrySet().stream()
                .forEach(e -> System.out.println(e.getKey() +":" + e.getValue()));
    }
}
