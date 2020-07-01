package stream;

import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Odniesienia, to inaczej sposoby zapisu metod lambd, aby je wywołać
 */
public class Odniesienia {

    // Metoda do przykładów
    public static int square(Integer x) {
        return x * x;
    }

    public static void main(String[] args) {

        // Odniesienie do metody statycznej - przykład dla własnej metody*
        Function<Integer, Integer> sqr = Odniesienia::square;
        sqr.apply(10); // 100

        // Odniesienie do metody statycznej - przykład drugi dla własnej metody
        Function<Integer, Integer> sqr2 = x -> square(x);
        sqr2.apply(10); // 100

        // Odniesienie do metody statycznej - przykład dla metod z bibliotek
        Function<Double, Double> sqrt = Math::sqrt;
        sqrt.apply(10d); // 100d

        // Odniesienie do niestatycznej metody, do jej instancji
        Scanner scanner = new Scanner(System.in);
        Supplier<String> string = scanner::nextLine;
        String pierwszyString = string.get();
        String drugiString = string.get();

        // Odniesienie do niestatycznej metody, do jej instancji
        Supplier<String> string2 = () -> scanner.nextLine();
        String trzeciString = string2.get();

        // Odniesienie do metody instancji obiektu określonego typu
        Function<Long, Integer> konwerter = Long::intValue;
        konwerter.apply(100L); // 100

        // Odniesienie do metody instancji obiektu określonego typu - drugi przykład
        Function<Long, Integer> konwerter2 = val -> val.intValue();
        konwerter2.apply(100L); // 100

        // Odniesienie do konstruktora
        Supplier<String> newString = String::new;
        Supplier<String> newString2 = () -> new String(); // less readable than the method reference
    }
}