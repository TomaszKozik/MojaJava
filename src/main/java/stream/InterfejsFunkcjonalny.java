package stream;

/**
 * Interfejsy funkcjonalne
 */
public class InterfejsFunkcjonalny {
    /**
     * Przykłady intefejsów dunkcjonalnych
     * <p>
     * Intefejsy funkcjonalne to interfejsy zbudowane z jednej metody abstrakcyjnej.
     * Dozwolone jest stosowanie w nich metod domyślnych i statycznych
     * Oznacza się je adnotacją @FunctionalInterface
     */
    @FunctionalInterface
    interface Nothing {
        void nothing();
    }

    @FunctionalInterface
    interface Greeting {
        void saySomething(String string);
    }

    @FunctionalInterface
    interface MyMath {
        int twoInt(int i, int j);
    }

    @FunctionalInterface
    interface Func<T, R> {
        R apply(T val);

        static void doNothingStatic() {
        }

        default void doNothingByDefault() {
        }
    }

    /**
     * Przykłady wywołania intefejsów
     */
    public static void main(String args[]) {
        // Bez parametrów
        Nothing doNothing = () -> System.out.println("aa");
        doNothing.nothing(); // aa

        // Jeden parametr na wejściu
        Greeting sayHello = text -> System.out.println("Say " + text);
        sayHello.saySomething("Tomek"); // Say Tomek

        // Dwa paremetry na wejściu, wyjście obliczeniowe
        MyMath multiply = (i, j) -> i * j;
        int b = multiply.twoInt(5, 5);
        System.out.println(b); // 25

        // Dwa paremetry na wejściu, wyjście obliczeniowe z klamrami
        MyMath added = (i, j) -> {
            int aInternal = i * 100;
            int bInternal = j * 100;
            return aInternal + bInternal;
        };
        int c = added.twoInt(5, 5);
        System.out.println(c); // 100
    }
}
