package kolekcje;

import java.util.*;

import static java.util.Arrays.*;

// todo wrzucić do qahelper.kozik.ovh
public class RodzajeKolekcji {


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

            // HashSet - zmienny Set - wynik wywołania Set za każdym razem może być inny (chodzi o kolejność)
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

    /**
     * Queue to kolekcja z ograniczonym dostępem do elementów:
     * elementy są wstawiane na końcu i usuwane od początku
     *
     * Interfejs kolejkii to Queue<E> dla kolejek FIFO i rozszerza Collection<E>
     * Interfejs kolejkii to Deque<E> dla kolejek FIFO i LIFO i rozszerza Collection<E>
     * Instacjami dla obu jest new ArrayDeque<>()
     *
     * https://hyperskill.org/learn/step/3576
     */
    static class Kolekcja_Queue {
        public static void main(String[] args) {


            // Instancje Queue i Deque
            Queue<String> instQueue = new ArrayDeque<>();
            Deque<String> instDeque = new ArrayDeque<>();

            /*
              Queue - wstawieanie i usuwanie elementów
             */
            Queue<String> samochodyQueue = new ArrayDeque<>();
            samochodyQueue.offer("Syrena"); // Wstawia na koniec listy
            samochodyQueue.offer("Fiat"); // Wstawia na koniec listy
            samochodyQueue.offer("Warszawa"); // Wstawia na koniec listy
            samochodyQueue.peek();  // Pobiera pierwszy element
            samochodyQueue.poll();  // Pobiera i usuwa pierwszy element

            /*
              Deque - wstawieanie i usuwanie elementów
             */
            Deque<String> samochodyDeque = new ArrayDeque<>();
            samochodyDeque.offerFirst("Syrena"); // Wstawienie na początek listy
            samochodyDeque.offerLast("Fiat"); // Wstawienie na koniec listy
            samochodyDeque.offer("Warszawa"); // Wstawienie na początek listy
            samochodyDeque.peekFirst();  // Pobiera pierwszy element
            samochodyDeque.pollFirst();  // Pobiera i usuwa pierwszy element
            samochodyDeque.peekLast();  // Pobiera ostatni element
            samochodyDeque.pollLast();  // Pobiera i usuwa ostatni element
        }
    }

    /**
     * Konwertowanie pomiędzy tablicami
     */
    static class KonwertoWanieKolekcji {
        public static void main(String[] args) {

            // Przykłady tablic
            String[] tablicaString = {"a", "b", "c", "d"};
            int[] tablicaInt = {1, 2, 3, 4};
            Integer[] tablicaInteger = {5, 6, 7, 8};

            // Kolekcje niezmienny
            List<String> listNiezmienny = Arrays.asList(tablicaString);
            listNiezmienny.add("e");
            listNiezmienny.forEach(System.out::println);

            /*
              List
              Kolekcji List i innych kolekcji nie da się wykonać z tablic z typami pierwotnymi.
              Muszą one być zrealizowane poprzez klasy opakowujące np. Integer.
             */
            List<String> listaZTablicaString = asList(tablicaString);
            List<Integer> listaZTablicyInteger = Arrays.asList(tablicaInteger);

            /*
              Set, TreeSet, LinkedHashSet
              Kolekcji Set nie da się zrobić bezpośrednio z zwykłej tablicy.
              Można to zrealizować poprzez Listę
             */
            Set<String> setZTablicaString = new HashSet<>(Arrays.asList(tablicaString));
            Set<String> setZListaZTablicaString = new HashSet<>(listaZTablicaString);
            TreeSet<String> treeSetZTablicaString = new TreeSet<>(Arrays.asList(tablicaString));
            LinkedHashSet<String> linkedHashSetZListaZTablicaString = new LinkedHashSet<>(listaZTablicaString);
            List<String> listFromSet = new ArrayList<>(setZTablicaString);

            /*
              Queue i Deque
             */
            Queue<String> queueFromList = new ArrayDeque<>(listaZTablicaString);
            Queue<String> queueFromSet = new ArrayDeque<>(setZListaZTablicaString);
            Deque<String> dequeFromList = new ArrayDeque<>(listaZTablicaString);
            Deque<String> dequeFromSet = new ArrayDeque<>(setZListaZTablicaString);
            List<String> listFromQueue = new ArrayList<>(queueFromList);
            List<String> listFromDeque = new ArrayList<>(dequeFromList);


        }
    }
}
