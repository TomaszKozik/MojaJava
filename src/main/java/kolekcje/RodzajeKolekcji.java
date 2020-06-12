package kolekcje;

import java.util.*;
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

            // Dodanie innej kolekcji do już istniejącej
            apteczka.addAll(Arrays.asList("agrafki", "koc")); // [nożyczki, kompresy, bandaze, plastry, ustnik, agrafki, koc]

            // Zamiania wartości dla danego indeksu
            apteczka.set(2, "opaska");  // [nożyczki, kompresy, opaska, plastry, ustnik, agrafki, koc]

            // Usuniecie elementu z tablicy według wartości
            apteczka.remove("ustnik"); // [nożyczki, kompresy, opaska, plastry, agrafki, koc]

            // Usunięcie elementu z tablicy według indeksu
            apteczka.remove(2); // [nożyczki, kompresy, plastry, agrafki, koc]

            // Usuwa elementy z kolekcji głównej niewspólne z inną kolekcją
            apteczka.retainAll(Arrays.asList("nożyczki", "kompresy", "plastry", "agrafki")); // [nożyczki, kompresy, plastry, agrafki] - usuwa koc

            // Usunięcie elementów według zgodnych z inną tablicą
            apteczka.retainAll(Arrays.asList("nożyczki", "kompresy")); // [plastry, agrafki]]

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

            // stream - tworzy nową mutowalną listę
            List<String> sortowanieStream = listaSamochodow.stream().sorted().collect(Collectors.toList());
            sortowanieStream.forEach(System.out::println);

            // Collections - pozostawia niemutowalną listę
            Collections.sort(listaSamochodow);
            listaSamochodow.forEach(System.out::println);
        }
    }

    /**
     * Kolekcja Set to zbiór unikatowych elementów.
     * W stosunku do ArrayList lub List Set nie posiada indeksu.
     * Kolekcje Set są zmienne i niezmienne.
     * Dziedziczy elementy po Collection<E>
     * .add() i .addAll() dodają element o ile nie istnieje w tablicy
     *
     * Set ma trzy odmiany mutowalne:
     * new HashSet<>() - podstawowy Set z unikalnymi elementami
     * new TreesSet<>() - posortowany Set
     * new LinkedHashSet<>() -
     */
    static class Kolekcja_Set {

        public static void main(String[] args) {

            // niezmienna tablica dla Java9
            // Set<String> niezmiennaTablica = Set.of("Syerana", "Fiat", "Syrena"); // Syrena, Fiat

            // HashSet - zmienny Set
            Set<String> uniklanaListaSamochodow = new HashSet<>();
            uniklanaListaSamochodow.add("Syrena");
            uniklanaListaSamochodow.add("Warszawa");
            uniklanaListaSamochodow.add("Fiat");
            uniklanaListaSamochodow.add("Syrena");
            uniklanaListaSamochodow.forEach(System.out::println); // Warszawa, Fiat, Syrena

            // TreeSet - zmienny sortowany Set
            // Set zamiennie z SortedSet, przy czym SortedSet dodaje kilka opcji
            Set<String> uniklanaListaSamochodow2 = new TreeSet<>();
            uniklanaListaSamochodow2.add("Syrena");
            uniklanaListaSamochodow2.add("Warszawa");
            uniklanaListaSamochodow2.add("Fiat");
            uniklanaListaSamochodow2.add("Syrena");
            uniklanaListaSamochodow2.forEach(System.out::println); // Fiat, Syrena, Warszawa

            // TreeSet - z SortedSet
            SortedSet<String> uniklanaListaSamochodow3 = new TreeSet<>();
            uniklanaListaSamochodow3.add("Syrena");
            uniklanaListaSamochodow3.add("Warszawa");
            uniklanaListaSamochodow3.add("Fiat");
            uniklanaListaSamochodow3.add("Syrena");
            uniklanaListaSamochodow3.forEach(System.out::println); // Fiat, Syrena, Warszawa

            // Opcje dodatkowe dla SortedSet
            // Zwraca pierwszy element
            uniklanaListaSamochodow3.first(); // Fiat
            // Zwraca ostatni element
            uniklanaListaSamochodow3.last(); // Warszawa
            // Zwraca listę elementów z przed danego elementu
            uniklanaListaSamochodow3.headSet("Warszawa"); // Fiat, Syrena

            // LinedHashSet - zmienny Set
            // LinkedSet gwarantuje, że kolejność elementów jest taka sama, jak kolejność ich wstawienia do zestawu
            // Wynik LinkedHashSet to "Syrena, Warszawa, Fiat", dla samego HashSet "Syrena" była na końcu
            // pomimo identycznego wprowadzania danych
            Set<String> uniklanaListaSamochodow4 = new LinkedHashSet<>();
            uniklanaListaSamochodow4.add("Syrena");
            uniklanaListaSamochodow4.add("Warszawa");
            uniklanaListaSamochodow4.add("Fiat");
            uniklanaListaSamochodow4.add("Syrena");
            uniklanaListaSamochodow4.forEach(System.out::println); // Syrena, Warszawa, Fiat
        }
    }
}
