package typyZmiennych.string;

import java.util.Locale;

/**
 * Zastosowanie: Tworzenie stringów sparametryzowanych ze zmiennych
 * <p>
 * system.out.printf() - drukowanie formatowanego String'a
 * String.format() - formwatowanie nowego String'a
 * <p>
 * %c - umożliwia podstawienie pojedynczego znaku char
 * %d - umożliwia podstawienie liczb całkowitych int, short, long, byte.
 * Dodatkowo możliwe jest wstawianie zer przed cyframi np. %02d,
 * czyli dwie cyfry z jednym zerem z przodu
 * %f - umożliwia podstawienie liczb dziesiętnych float, double.
 * Dodatkowo mają możliwość ograniczenia do ilości cyfr po przecinku
 * z zastosowaniem zaokrąglenia w górę np. %.5f , czyli 5 cyfr po przecinku
 * %s - umożliwia podstawienie innego String’a
 * %n - umożliwia wstawienie znaku nowej linii
 * <p>
 * Source: 'JetBrains Academy: https://hyperskill.org/learn/step/7046
 */
public class FormatExamples {

    // Przykładowe parametry i argumenty, na których będą wykonane poniższe operacje
    private static final String toFormat = "%s ma %.2f długości i spala %f litrów na %d km\n";
    private static final String car = "Syrena";
    private static final float length = 4.040f;
    private static final float fuelUsage = 8.1f;
    private static final int distance = 100;
    private static final float latitude = 50.102985f;
    private static final float longitude = -1.111111f;

    // Wywołanie przykładów
    public static void main(String[] args) {
        System.out.println("---- Bezpośrednie drugkowanie sformatowanego String'a - printf() ----");
        formatAndPrint();
        // Syrena ma 4,04 długości i spala 8,100000 litrów na 100 km

        System.out.println("---- Tworzenie nowego String'a w oparciu o formatowanie ciągu ----");
        System.out.println(getFormattedStringForEasiestExample());
        // Syrena ma 4,04 długości i spala 8,100000 litrów na 100 km

        System.out.println("---- Tworzenie nowego String'a w oparciu o formatowanie ciągu - przykład rozbudowany ----");
        System.out.println(getFormattedStringForExtensiveExample());
        /*
        Mój samochód to FSM Syrena.
        Wyprodukowany w 1980r. Jego długość to 4,04m.
        Włączyłem go dziś o 01:05.
         */

        System.out.println("----- Formatowanie współrzędnych geograficznych dla ustawień angielskich -----");
        System.out.println(getCoordinatesWithEnglishLocale());      // 50.10299, -1.11111

        System.out.println("----- Formatowanie współrzędnych geograficznych dla ustawień francuskich (w tym polskich) -----");
        System.out.println(getCoordinatesWithFrenchLocale());       // 50,10299, -1,11111

    }

    /**
     * Bezpośrednie drugkowanie sformatowanego String'a
     * .printf(String format, Object... args)
     */
    private static void formatAndPrint() {
        System.out.printf(toFormat, car, length, fuelUsage, distance);
    }

    /**
     * Tworzenie nowego String'a w oparciu o formatowanie ciągu
     * Przykład najprostszy
     * .format(String format, Object... args)
     *
     * @return String Sformatowany String
     */
    private static String getFormattedStringForEasiestExample() {
        String formattedString = String.format(toFormat, car, length, fuelUsage, distance);
        return formattedString;
    }

    /**
     * Tworzenie nowego String'a w oparciu o formatowanie ciągu
     * Przykład rozbudowany. Formatujemy String w opaciu o zmienne Character, Integer,
     * Double, zaokrąglone Double oraz znak nowej linii.
     * .format(String format, Object... args)
     *
     * @return String Sformatowany String
     */
    public static String getFormattedStringForExtensiveExample() {
        String useCharsAndBreakLine = "Mój samochód to %c%c%c Syrena.%n";
        String useInteger = "Wyprodukowany w %dr. ";
        String useDouble = "Jego długość to %.2fm.%n";
        int year = 1980;
        String useRoundedDouble = "Włączyłem go dziś o %02d:%02d.";

        String formattedString = String.format(useCharsAndBreakLine + useInteger + useDouble + useRoundedDouble, 'F', 'S', 'M', year, 4.04d, 1, 5);
        return formattedString;
        /*
        Mój samochód to FSM Syrena.
        Wyprodukowany w 1980r. Jego długość to 4,04m.
        Włączyłem go dziś o 01:05.
         */
    }

    /**
     * Formatowanie String'ów z ustawieniami regionalnymi, angielskimi
     * Zwracane są kropki dla zmiennych float lub double zamiast przecinków
     *
     * @return String Współrzędne geograficzne z użyciem kropek
     */

    private static String getCoordinatesWithEnglishLocale() {
        return String.format(Locale.ENGLISH, "%.5f, %.5f", latitude, longitude);
    }

    /**
     * Formatowanie String'ów z ustawieniami regionalnymi, francuskimi (w tym polskie)
     * Zwracane są przecinki dla zmiennych float lub double zamiast kropek
     *
     * @return String Współrzędne geograficzne z użyciem przecinków
     */

    private static String getCoordinatesWithFrenchLocale() {
        return String.format(Locale.FRANCE, "%.5f, %.5f", latitude, longitude);
    }
}
