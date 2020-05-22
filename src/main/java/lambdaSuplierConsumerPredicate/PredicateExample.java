package lambdaSuplierConsumerPredicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


/**
 * Reprezentuje predykat (funkcja o wartości logicznej) dla jednego argumentu.
 * Jest wykorzystywany, jako funkcja sprawdzająca warunki logiczne.
 * Można go wykorzystywać np. przy filtrowaniu w Stream Api.
 *
 * Jest intefejsem funkcjonalnym, dzięki czemu używamy do tworzenia dla niego funkcji
 * w oparciu o lambdy.
 *
 * Wywołujemy napisany kod poprzez .test(<argument>)
 *
 *
 * @Od wesji Java 1.8
 *
 * @see https://programuj.pl/blog/java8-lambdy-praktyczne-przyklady
 * @see https://nullpointerexception.pl/kurs-java-dla-poczatkujacych-8-streamy-i-lambdy/
 */
public class PredicateExample {

    /**
     * Przykład najprostszego użycia
     */
    public static class Predicate_NajprostszyPrzyklad {
        public static void main(String[] args) {
            Predicate<String> filterNonEmpty = s -> s != null && !s.isEmpty();
            System.out.println("--- WYNIK PREDICATE ---");
            System.out.println("Czy string nie jest pusty? " + filterNonEmpty.test("To jest string"));
        }
    }

    /**
     *
     */
    public static void main(String[] args) {

        Predicate<Integer> noGreaterThan5 =  x -> x > 5;

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> collect = list.stream()
                .filter(noGreaterThan5)
                .collect(Collectors.toList());

        System.out.println(collect); // [6, 7, 8, 9, 10]

    }
}
