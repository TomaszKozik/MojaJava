package stream;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Wyrażenia lambda
 * <p>
 * Lambdy zastępują klasy anonimowe, dzięki czemu dają możliwość ograniczenia ilości pisanego kodu.
 * Tworzy się je na podstawie ówcześnie zdefiniowanych interfejsów,
 * które z kolei mogą zawierać dowolną ilość metod statycznych, domyślnych i stałych,
 * lecz wyłącznie jedną metodę abstrakcyjną.
 * <p>
 * <p>
 * https://hyperskill.org/learn/step/3601
 */
public class Lambda {

    /**
     * Porównanie klasy anonimowej i lambdy
     * na podstawie intrefejsu Func z powyższego przykładu
     */
    static class PorownanieLambdaIKlasyAnonimowej {
        public static void main(String[] args) {

            // Klasa anonimowa
            InterfejsFunkcjonalny.Func<Long, Long> square = new InterfejsFunkcjonalny.Func<Long, Long>() {
                @Override
                public Long apply(Long val) {
                    return val * val;
                }
            };
            long val = square.apply(10L); // 100L

            // Wyrażenie lambda
            InterfejsFunkcjonalny.Func<Long, Long> square2 = val2 -> val2 * val2;
            long val2 = square2.apply(10L); // 100L
        }
    }

    /**
     * Przykłady zapisu wyrażeń lambda w oparciu o standardowy
     * interfejs Function i BiFunction
     */
    static class PrzykladyZapisuLambd {
        public static void main(String[] args) {
            // Wyrażenie przyjmujące jeden element i zwracające również jeden element
            Function<Integer, Integer> jedenElement = (x) -> x;

            // Wyrażenie przyjmujące jeden element i zwracające również jeden element - można w nim pomijać nawiasy
            Function<Integer, Integer> jedenElement2 = x -> x;

            // Wyrażanie z określeniem typu
            Function<Integer, Integer> mult = (Integer x) -> x * 2;

            // Wyrażenie przyjmujące dwa elementy i zwracające jeden element
            BiFunction<Integer, Integer, Integer> sum = (x, y) -> x + y;

            // Wyrażenie z wieloma instrukcjami
            Function<Integer, Integer> adder = (x) -> {
                x += 5;
                x += 10;
                return x;
            };
        }
    }

    /**
     * Przekazywanie wyrażeń lambda do metod, jako argumentów
     */
    static class LambdaJakoArgumentMetody {

        /**
         * Przykładowa metoda przyjmująca wyrażenie lambda
         */
        public static void obliczSpalanie(Function<Integer, Double> f) {
            System.out.println(f.apply(7));
        }

        /**
         * Przykłady wywołania metody z wyrażeniem lambda
         */
        public static void main(String[] args) {
            // Sposób pierwszy
            Function<Integer, Double> f = (x) -> Double.valueOf(x % 100); // 7.0
            obliczSpalanie(f); // 11

            // Sposób drugi
            obliczSpalanie(x -> Double.valueOf(x % 100)); // 7.0
        }
    }

    /**
     * Przekazywanie argumentów dodatkowych do lambd
     */
    static class PrzekazywanieArgumentowDodatkowych {
        public static void main(String[] args) {
            final String marka = "Syrena ";
            Function<String, String> Syreny = (name) -> marka + name;

            System.out.println(Syreny.apply("105L")); // Syrena 105L
            System.out.println(Syreny.apply("Bosto")); // Syrena Bosto
        }
    }
}
