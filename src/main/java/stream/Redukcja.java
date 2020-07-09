package stream;

import java.util.ArrayList;
import java.util.List;

/**
 * Redukcja łączy elementy strumienia w jedną wartość.
 * Wynik może być wartością typu pierwotnego lub nawet złożonym obiektem.
 * Głównym argumentem operacji redukcji jest funkcja dwóch argumentów służąca do kumulacji wyniku.
 *
 * stream().reduce(a, (b, c) -> d);
 * , gdzie:
 *   a - wartość początkowa, dla której //reduce// zaczyna działanie. Jeśli strumień jest pusty, to ta wartość jest zwracana, jako wynik
 *   b - suma wszystkich operacji (np. sumowane liczby, połączone String'i)
 *   c - jest do kolejna wartość ze strumienia, jaką należy obsłużyć
 *   d - funkcja redukcji do spełnienia, jeśli strumień zawiera elementy, czyli np.  sumowanie, dzielenie, łączenie
 *
 * Źródło: https://hyperskill.org/learn/step/3569
 */
public class Redukcja {

    public static void main(String[] args) {
        // Lista do redukcji
        List<String> lisaSamochodow = new ArrayList<>();
        lisaSamochodow.add("Syrena 105L");
        lisaSamochodow.add("Fiat 125P");
        lisaSamochodow.add("Warszawa M20");

        // Sumowanie długości nazw i modeli samochodów
        int sumaDlugosciZnakow = lisaSamochodow.stream()
                .map(String::length)
                .reduce(0, (acc, next) -> acc + next);
        System.out.println(sumaDlugosciZnakow); // 32

        // Laczenie String'ów
        String nowaListaSamochodow = lisaSamochodow.stream()
                .reduce("", (acc, next) -> acc + " " + next
                );
        System.out.println(nowaListaSamochodow); //  Syrena 105L Fiat 125P Warszawa M20
    }
}
