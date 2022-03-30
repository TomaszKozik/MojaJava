package tablice_kolekcje;

import java.util.ArrayList;

import static java.util.Arrays.asList;

/**
 * ArrayList - jest to dynamiczna tablica. Jej ilość elementów może
 * wzrastać lub zmniejszać się.
 *
 * Nie może przechowywać typów pierwotnych
 *
 * Wymaga importu biblioteki java.util.ArrayList
 */
public class ArrayListExample {


    public static void main(String[] args) {
        // Inicjalizacja pustej tablicy
        ArrayList<String> tablica1 = new ArrayList<>();

        // Inicjalizacja tablicy z określoną początkową pojemnością
        ArrayList<String> tablica2 = new ArrayList<>(50);

        // Inicjalizacja tablicy z dodaniem elementów innej tablicy
        ArrayList<String> tablica3 = new ArrayList<>(tablica2);

        // Przykladowa kolekcja
        ArrayList<String> apteczka = new ArrayList<>();         // pusta kolekcja String'ów
        apteczka.add("nożyczki");           // dodanie nowego elementu
        apteczka.add("kompresy");           // dodanie nowego elementu
        apteczka.add("plastry");            // dodanie nowego elementu

        // Podstawowe operacje na ArrayList

        // Zmiana tablicy na String
        apteczka.toString();    // [nożyczki, kompresy, plastry]

        // Pobranie ilości elementów:
        apteczka.size();        // 3

        // Pobranie elementu według indeksu
        apteczka.get(2);        // plastry

        // Dodanie nowego elementu
        apteczka.add("ustnik"); // [nożyczki, kompresy, plastry, ustnik]

        // Dodanie nowego elementu pod wskazany indeks. Wszystki elementy od tego indeksu są przesuwane w dalsze pozycje
        apteczka.add(2, "bandaże"); // [nożyczki, kompresy, bandaze, plastry, ustnik]

        // Dodanie innej kolekcji do już istniejącej
        apteczka.addAll(asList("agrafki", "koc")); // [nożyczki, kompresy, bandaze, plastry, ustnik, agrafki, koc]

        // Zamiania wartości dla danego indeksu
        apteczka.set(2, "opaska");  // [nożyczki, kompresy, opaska, plastry, ustnik, agrafki, koc]

        // Usuniecie elementu z tablicy według wartości
        apteczka.remove("ustnik"); // [nożyczki, kompresy, opaska, plastry, agrafki, koc]

        // Usunięcie elementu z tablicy według indeksu
        apteczka.remove(2); // [nożyczki, kompresy, plastry, agrafki, koc]

        // Usuwa elementy z kolekcji głównej niewspólne z inną kolekcją
        apteczka.retainAll(asList("nożyczki", "kompresy", "plastry", "agrafki")); // [nożyczki, kompresy, plastry, agrafki] - usuwa koc

        // Usunięcie elementów według zgodnych z inną tablicą
        apteczka.retainAll(asList("nożyczki", "kompresy")); // [plastry, agrafki]]

        // Sprawdzenie, czy element istnieje w tablicy
        apteczka.contains("nożyczki"); // true

        // Czyszczenie całej tablicy
        apteczka.clear();

        // Sprawdzenie, czy tablica jest pusta
        apteczka.isEmpty();

        // Sposoby wypisywania elementów tablic
        // foreach standardowe"
        for (String s : apteczka) {
            System.out.println(s);
        }

        // foreach z Consumerem - 1 sposób
        apteczka.forEach(elem -> System.out.println(elem));

        // foreach z Consumerem - 2 sposób
        apteczka.forEach(System.out::println);

        // String.join
        System.out.println(String.join("\n", apteczka));
    }
}
