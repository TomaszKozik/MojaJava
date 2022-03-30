package tablice_kolekcje;

import java.util.*;

import static java.util.Arrays.asList;

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
public class QueueExamples {
    public static void main(String[] args) {

        // Tworzenie pystych kolekcji Queue i Deque
        Queue<String> instQueue = new ArrayDeque<>();
        Deque<String> instDeque = new ArrayDeque<>();

        // Tworzenie kolekcji z innych kolekcji
        // Kolekcje do przykładów
        String[] tablicaString = {"a", "b", "c", "d"};
        List<String> listaZTablicaString = asList(tablicaString);
        Set<String> setZListaZTablicaString = new HashSet<>(listaZTablicaString);
        // Tworzenie kolekcji z przykładów
        Queue<String> queueFromList = new ArrayDeque<>(listaZTablicaString);	// Kolekcja Queue z tablicy
        Queue<String> queueFromSet = new ArrayDeque<>(setZListaZTablicaString);	// Kolekcja Queue z kolekcji Set
        Deque<String> dequeFromList = new ArrayDeque<>(listaZTablicaString);	// Kolekcja Deque z kolekcji List
        Deque<String> dequeFromSet = new ArrayDeque<>(setZListaZTablicaString);	// Kolekcja Deque z kolekcji Set

        // Queue - obsługa elementów
        Queue<String> samochodyQueue = new ArrayDeque<>();
        samochodyQueue.offer("Syrena"); // Wstawia na koniec listy
        samochodyQueue.offer("Fiat"); // Wstawia na koniec listy
        samochodyQueue.offer("Warszawa"); // Wstawia na koniec listy
        samochodyQueue.peek();  // Pobiera pierwszy element
        samochodyQueue.poll();  // Pobiera i usuwa pierwszy element

        // Deque - obsługa elementów
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
