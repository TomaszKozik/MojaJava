package kolekcje;

import java.util.*;

import static java.util.Arrays.*;

// todo wrzucić do qahelper.kozik.ovh
public class RodzajeKolekcji {


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
