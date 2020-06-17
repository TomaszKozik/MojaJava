package stream;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Interfejsy funkcjonalne i wyrażenia lambda
 *
 * Intefejsy funkcjonalne to interfejsy zbudowane z jednej metody abstrakcyjnej.
 * Dozwolone jest stosowanie w nich metod domyślnych i statycznych
 * Oznacza się je adnotacją @FunctionalInterface
 *
 *
 * https://hyperskill.org/learn/step/3601
 */
public class Lambda {

    /**
     * Przykłady intefejsów dunkcjonalnych
     */
    @FunctionalInterface
    interface Nothing {
        void nothing ();
    }

    @FunctionalInterface
    interface Greeting {
        void saySomething (String string);
    }

    @FunctionalInterface
    interface MyMath {
        int twoInt (int i, int j);
    }

    @FunctionalInterface
    interface Func<T, R> {
        R apply(T val);

        static void doNothingStatic() { }

        default void doNothingByDefault() { }
    }

    /**
     * Przykłady wywołania intefejsów
     */
    public static void main(String args[]) {
        // Bez parametrów
        Nothing doNothing = () -> System.out.println("aa");
        doNothing.nothing();

        // Jeden parametr na wejściu
        Greeting sayHello = text -> System.out.println("Say " + text);
        sayHello.saySomething("Tomek");

        // Dwa paremetry na wejściu, wyjście obliczeniowe
        MyMath multiply = (i, j) -> i * j;
        int b = multiply.twoInt(5,5);
        System.out.println(b);

        // Dwa paremetry na wejściu, wyjście obliczeniowe z klamrami
        MyMath added = (i, j) -> {int aInternal = i * 100;
            int bInternal = j * 100;
            return aInternal + bInternal;};
        int c = added.twoInt(5,5);
        System.out.println(c);
    }

    /**
     * Przykłady wykorzystania interfesjów funkcjonalnych
     */
    static class PrzykladWykorzystania {
        public static void main(String[] args) {

            // Klasa anonimowa
            Func<Long, Long> square = new Func<Long, Long>() {
                @Override
                public Long apply(Long val) {
                    return val * val;
                }
            };
            long val = square.apply(10L); // 100L

            // Wyrażenie lambda
            Func<Long, Long> square2 = val2 -> val2 * val2;
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

            // Wyrażenie z wieloma instrukcjami
            Function<Integer, Integer> adder = (x) -> {
                x += 5;
                x += 10;
                return x;
            };

            // Wyrażenie przyjmujące dwa elementy i zwracające jeden element
            BiFunction<Integer, Integer, Integer> sum = (x, y) -> x + y;
        }
    }

    /**
     * Przekazywanie wyrażeń lambda do metod, jako argumentów
     */
    static class PrzekazywanieLambdaDoMetodJakoArgumentow {

        /**
         * Przykładowa metoda przyjmująca wyrażenie lambda
         */
        public static void obliczSpalanie(Function<Integer, Double> f) {
            System.out.println(f.apply(7));
        }

        /**
         * Przykłady wywołania metody z wyrażeniem lamda
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
     * Przekazywanie argumentów dodatkowych
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
