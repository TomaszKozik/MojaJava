package stream;

import java.util.function.*;

/**
 * Java od wersji 8 ma wiele funkcjonalnych interfejsów do reprezentowania funkcji. Te interfejsy funkcjonalne znajdują się w pakiecie //java.util.function// .
 *
 * Pakiet zawiera ponad 40 funkcjonalnych interfejsów pięciu grup: funkcji , operatorów , predykatów , dostawców i konsumentów .
 *
 * Grupy:
 * * funkcje (Function<T, R>, BiFunction<T, U, R>) akceptują argumenty i generują wyniki.
 * * operatory (UnaryOperator<T>) generują wyniki tego samego typu co ich argumenty (specjalny przypadek funkcji).
 * * predykaty (Predicate<T>, BiPredicate<T, U>) zwracają wartości boolowskie i akceptują wszelkie argumenty (funkcja o wartości boolowskiej).
 * * dostawcy (Supplier<T>) zwracają wartości i niczego nie akceptują.
 * * konsumenci (Consumer<T>, BiConsumer<T, U>) akceptują argumenty i nie zwracają wyników.
 *
 * Główne różnice między interfejsami funkcjonalnymi w tej samej grupie to liczba argumentów i ogólna lub nie.
 */
public class StandardoweInterfejsy {
    public static void main(String[] args) {

        // Function<T, R>
        // String to Integer function
        Function<String, Integer> converter = Integer::parseInt;
        converter.apply("1000"); // 1000

        // BiFunction<T, U, R>
        BiFunction<Integer, Integer, Integer> sumFunction = (a, b) -> a + b;
        sumFunction.apply(2, 3); // 5

        // UnaryOperator<T>
        UnaryOperator<Long> longMultiplier = val -> 100_000 * val;
        longMultiplier.apply(2L); // 200_000L

        // Predicate<T>
        Predicate<Character> isDigit = Character::isDigit;
        isDigit.test('h'); // false

        // BiPredicate<T, U>
        BiPredicate<String, String> isEqual = (a, b) -> a.equals(b);
        isEqual.test("syrena", "fiat"); // false

        // Supplier<T>
        Supplier<String> stringSupplier = () -> "Syrena";
        stringSupplier.get(); // Syrena

        // Consumer<T>
        Consumer<String> printer = System.out::println;
        printer.accept("Syrena"); // Syrena

        // BiConsumer<T, U>
        BiConsumer<String, String> printer2 = (a, b) -> System.out.println(a + " " + b);
        printer2.accept("Syrena","105L"); // Syrena 105L
    }
}
