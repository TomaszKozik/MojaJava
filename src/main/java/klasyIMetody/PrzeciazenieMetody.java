package klasyIMetody;

/**
 * Przeciążenie metod dotyczy metod znajdujących się w tej samej klasie o tej samej nazwie.
 * Przeciążyć metodę można na postawie zmiany typów i/lub ilości przekazywanych argumentów do metod,
 * jak i sposobem zwracania elementu.
 */
public class PrzeciazenieMetody {

    public static void main(String args[]) {
        // Przeciążenie ze względu na ilość parametrów
        metoda1();
        metoda1("jakisString");

        // Przeciążenie ze względu na rodzaj parametru
        System.out.println(metoda1(5));
        System.out.println(metoda1(5L));
    }

    public static void metoda1() {
        System.out.println("Wywołanie metody1");
    }

    public static void metoda1(String string) {
        System.out.println("Wywołanie metody1" + string);
    }

    public static int metoda1(int parametr) {
        return parametr;
    }

    public static double metoda1(double parametr) {
        return parametr;
    }
}
