package tablice_kolekcje;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Implementacja interfejsu Iterable pozwala, aby obiekty klasy były celami dla każdej pętli.
 * Umożliwa przechodzenie do kolejnych lub poprzednich elementów kolekcji bez użycia pętli
 * oraz zmiany na nich.
 *
 * Interfejs Collection<E> rozszerza Iterable<E>, lecz nie rozszerza Map<K, V>
 */
public class Iterowanie {

    public static void main(String[] args) {

        // Kolekcja do przykładów
        List<String> apteczka = new ArrayList<>();
        apteczka.add("instrukcja");
        apteczka.add("kompresy");
        apteczka.add("plastry");
        apteczka.add("nożyczki");

        // Iterowanie po kolekcji
        // Definiowanie iteratoratora dla kolekcji apteczka
        ListIterator<String> iterator = apteczka.listIterator();

        // .hasPrevious() - sprawdza, czy istnieje poprzedni element. Zwraca false, gdyż jeszcze nie zaczął iterować
        System.out.println(iterator.hasPrevious()); // false

        // .previous() - przechodzi do poprzedniego elementu i zwraca go. Wywala błąd, gdyż nie ma wcześiejszego elementu
        // System.out.println(iterator.previous());

        // .hasNext() - sprawdza, czy istnieje kolejny element. Zwraca true, gdyż jeszcze nie zaczął iterować
        System.out.println(iterator.hasNext()); // true

        // .next() - przechodzi do pierwszego elementu i go zwraca
        System.out.println(iterator.next()); // instrukcja

        // .hasNext() - sprawdza, czy istnieje kolejny element. Zwraca true, gdyż istnieje kolejny element po instrukcja
        System.out.println(iterator.hasNext()); // true

        // .next() - przechodzi do pierwszego elementu i go zwraca
        System.out.println(iterator.next()); // kompresory

        // .hasPrevious() - sprawsza ponownie czy istnieje element 'kompresory'
        System.out.println(iterator.hasPrevious()); // true

        // .previous() - zwraca ponownie 'kompresory', gdyż indeks jest na bieżącym elemencie
        System.out.println(iterator.previous()); // kompresory

        // .hasPrevious() - sprawsza ponownie czy istnieje element 'instrukcja'
        System.out.println(iterator.hasPrevious()); // true

        // .previous() - zwraca ponownie 'kompresory', gdyż indeks jest przesunięty spowrotem
        System.out.println(iterator.previous()); // instrukcja

        // .remove() - usuwa aktualnie iterowany element, czyli 'instrukcja'
        iterator.remove(); //kompresory, plastry, nożyczki

        // .add() - wstawia element przed aktualną iteracją
        iterator.add("agrafki"); // agrafki, kompresory, plastry, nożyczki

        // .set() - zmienia wartość aktualnie iterowanej wartości
        iterator.next();
        iterator.set("opaska"); // agrafki, opaska, plastry, nożyczki
    }
}
