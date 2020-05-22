package lambdaSuplierConsumerPredicate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Supplier;

/**
 * Supplier
 * Reprezentuje "dostawcę" wyników.
 * Nie ma wymogu zwracania każdego nowego lub odrębnego wyniku
 * Nie pobiera żadnego argumentu.
 * Możemy go użyć do dostarczania różnych instancji obiektów lub wykonania różnych metod,
 * z których oczekujemy na otrzymanie wyniku.
 *
 * Wykonywanie supplieka jest dopiero wtedy, gdy użyjemy metoda get()  - jest to tak zwany mechanizm Lazy Loading,
 * dzięki temu określamy dokładnie momenty wykonania funkcji. Nie musi być ona zrealizowana, jak to jest normalnie
 * przy starcie klasy.
 *
 * Jest intefejsem funkcjonalnym, dzięki czemu używamy do tworzenia dla niego funkcji
 * w oparciu o lambdy.
 *
 * Wywołujemy napisany kod poprzez .get()
 *
 * @Od wesji Java 1.8
 *
 * @see https://programuj.pl/blog/java8-lambdy-praktyczne-przyklady
 * @see https://nullpointerexception.pl/kurs-java-dla-poczatkujacych-8-streamy-i-lambdy/
 */
public class SupplierExample {

    /**
     * Przykład najprostszego użycia
     */
    public static class Supplier_NajprostszyPrzyklad {
        private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        public static void main(String[] args) {

            Supplier<LocalDateTime> s = () -> LocalDateTime.now();
            LocalDateTime time = s.get();

            System.out.println("--- WYNIK SUPPLIERA ---");
            System.out.println(time);

            Supplier<String> s1 = () -> dtf.format(LocalDateTime.now());
            String time2 = s1.get();

            System.out.println("--- WYNIK SUPPLIERA ---");
            System.out.println(time2);

        }

    }

}
