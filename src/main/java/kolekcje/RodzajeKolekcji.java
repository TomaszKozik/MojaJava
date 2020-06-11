package kolekcje;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// todo wrzucić do qahelper.kozik.ovh
public class RodzajeKolekcji {
    /**
     * ArrayList - jest to dynamiczna tablica. Jej ilość elementów może
     * wzrastać lub zmniejszać się.
     *
     * Nie może przechowywać typów pierwotnych
     *
     * Wymaga importu biblioteki java.util.ArrayList
     */

    public static class Kolekcja_ArrayList {

        public static void main(String[] args) {
            // Inicjalizacja pustej tablicy
            ArrayList<String> tablica1 = new ArrayList<>();

            // Inicjalizacja z określoną początkową pojemnością
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

            // Zamiania wartości dla danego indeksu
            apteczka.set(2, "opaska");  // [nożyczki, kompresy, opaska, plastry, ustnik]

            // Usuniecie elementu z tablicy według wartości
            apteczka.remove("ustnik"); // [nożyczki, kompresy, opaska, plastry]

            // Usunięcie elementu z tablicy według indeksu
            apteczka.remove(2); // [nożyczki, kompresy, plastry]

            // Czyszczenie całej tablicy
            apteczka.clear();

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

    /**
     * Lista to uporządkowana kolekcja elementów. Oznacza to, że każdy element ma pozycję
     * na liście określoną indeksem całkowitym, tak jak w zwykłych tablicach.
     *
     * List<E> tworzy się na bazie interfesju Collection<E>
     *
     * Nie można utworzyć bezpośredniej instancji List<E>. Tworzy się ją na podstawie
     * ArrayList<E> lub LinkedList<E>
     *
     * Są dwa rodzaje list: niezmienne (immutable) i zmienne (mutable)
     * Niezmienną tworzy się na podstawie nieinstacyjnych kolekcji,
     * a zmienne na podstawie instacyjnych
     */
    static class Kolekcja_List {

        public static void main(String[] args) {
            /*
              Rodzaje list
              Są dwa rodzaje list: niezmienne (immutable) i zmienne (mutable)
              Niezmienną tworzy się na podstawie nieinstacyjnych kolekcji,
              a zmienne na podstawie instacyjnych.
              Na listach niezmiennych nie możemy edytować, dodawać, usuwać rekordów.
              Na listach zmiennych działają wszystkie operacje, jak dla ArrayList<E>
             */
            // Lista niezmienna na podstawie listy elementów
            List<String> niezmiennaLista = Arrays.asList("Syrena", "Fiat", "Warszawa");

            // Lista niezmienna na podstawie listy elementów od Javy 9
            // List<String> niezmiennaListaOdJava9 = List.of("Syrena", "Fiat", "Warszawa");

            // Lista niezmienna na podstawie klasy Collections
            List<String> niezminnaCollectionsPusta = Collections.emptyList();
            List<Integer> niezminnaCollectionsZParametrem = Collections.singletonList(100);

            // Lista zmienna na podstawie instacji ArrayList
            List<String> zmiennaLista = new ArrayList<>();

            // Przekształce listy zmiennej w niezmienną
            List<String> niezmiennaListaZZmiennejListy = Collections.unmodifiableList(zmiennaLista);

            /**
             * Sortowanie listy
             * Znam dwa proste sposoby sortowania list przez strem i Collections
             */
            List<String> listaSamochodow = Arrays.asList("Syrena", "Fiat", "Warszawa");

            // stream
            List<String> sortowanieStream = listaSamochodow.stream().sorted().collect(Collectors.toList());
            sortowanieStream.forEach(System.out::println);

            // Collections
            Collections.sort(listaSamochodow);
            listaSamochodow.forEach(System.out::println);
        }
     }
}
