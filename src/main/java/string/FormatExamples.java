package string;

import java.util.Locale;

/**
 * Zastosowanie: Tworzenie stringów sparametryzowanych ze zmiennych
 *
 * system.out.printf() - drukowanie bezpośrednie z formatoweniem
 * String.format() - samo formwatowanie stringów
 *
 * %c - char
 * %d - int, short, long, byte
 * %f - float, double
 *      float i double mają możliwość ograniczenia do ilości cyfr po przecinku np. %.5f
 * %s - stringi
 * %n - znak nowej linii
 *
 * @see https://hyperskill.org/learn/step/7046
 */
public class FormatExamples {

    /**
     * Przykład najprostszy dla printf()
     */
    static class Printf {
        public static void main(String[] args) {
            System.out.printf("%s ma %.2f długości i spala %f litrów na %d km", "Syrena", 4.040, 8.1, 100);
        }
    }

    /**
     * Przykład najprostszy dla format();
     */
    static class FormatString {
        public static void main(String[] args) {
            String syrena = String.format("%s ma %.2f długości i spala %f litrów na %d km", "Syrena", 4.040, 8.1, 100);
            System.out.println(syrena);
        }
    }

    /**
     * Przykład ze zmiennymi
     */
    static class Zmienne {
        public static void main(String[] args){
            String name = "Mój samochód to %c%c%c %s.%n";
            String produced ="Wyprodukowany w %dr.%n";
            String length = "Jego długość to %.2fm.";
            int year = 1980;
            System.out.println(String.format(name + produced + length, 'F', 'S', 'M', "Syrena", year, 4.04d));

            System.out.println("---- wstawianie zer z przodu ----");
            System.out.println(String.format("%02d:%02d:%02d", 1, 20, 5));
        }
    }

    /**
     * Ustawienia regionalne
     */
    static class UstawieniaRegionalne {
        public static void main(String[] args) {
            float expectedLat = 50.102985f;
            float expectedLng = -1.111111f;
            String englishCords = String.format(Locale.ENGLISH, "%.5f, %.5f", expectedLat, expectedLng);
            System.out.println(englishCords);
            String frenchCords = String.format(Locale.FRANCE, "%.5f, %.5f", expectedLat, expectedLng);
            System.out.println(frenchCords);

        }
    }
}
