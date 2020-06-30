package klasyIMetody;

/**
 * enum - jest to tzw. typ wyliczeniowy.
 * Pozwala na zdefiniowanie zbioru możliwych wartości.
 * Jest rozszerzeniem zmiennych statycznych finalnych (final static)
 *
 * Definiuje się go jak klasę. Tylko zamiast class używany enum.
 */
public class EnumExamples {

    /**
     * Lista wyliczeniowa dla MojeSamochody
     */
    public enum MojeSamochody {

        /**
         * Lista moich samochodów.
         * Enum daje możliwość zwiększenia ilości parametrów niż zwykła zmienna final static
         * o dodatkowe właściwości.
         * Wpisywanie ilości i kolejności danych ma duże znaczenie, tak samo wielkość liter.
         *
         * Przykład dla final static:
         * public static final String SYRENA = "Syrena 105L";
         */
        SYRENA("Syrena 105L", "kość słoniowa"),
        FIAT("Fiat 125P", "kość słoniowa"),
        SYRENA2("Syrena Bosto", "wiśniowa"),
        POLONEZ("Polonez Atu", "czerwony");

        /**
         * enum zachowuje się, jak klasa przy czym operuje na stałych.
         * Dzięki takiemu zachowaniu tworzymy zmienne obiektu, konstruktor i gettery.
         * Dzięki nim właśnie mamy możliwość zwiększenia ilości właściwości danej stałej.
         */
        String markaModel;
        String kolor;

        MojeSamochody(String markaModel, String kolor) {
            this.markaModel = markaModel;
            this.kolor = kolor;
        }

        public String getMarkaModel() {
            return markaModel;
        }

        public String getKolor() {
            return kolor;
        }

        /**
         * Możliwe jest rozszerzenie enum poprzez dodanie niestandardowych metod statycznych.
         * Na przykład dodajmy metodę, która znajdzie instancję według podanego koloru
         */
        public static MojeSamochody findByColor(String kolor) {
            for (MojeSamochody value: values()) {
                if (kolor.equals(value.kolor)) {
                    return value;
                }
            }
            return null;
        }
    }

    /**
     * Tutaj wywołamy nasze enum i zobaczymy, co nam daje.
     */
    public static void main(String[] args) {

        // Pobranie nazwy stałej dla POLONEZ
        System.out.println("---- Pobranie nazwy stałej dla POLONEZ ----");
        String namePolonez = MojeSamochody.POLONEZ.name(); // POLONEZ
        System.out.println(namePolonez);

        // Pobranie marki i modelu dla POLONEZ
        System.out.println("---- Pobranie marki i modelu dla POLONEZ ----");
        String modelIMarkaPoloneza = MojeSamochody.POLONEZ.getMarkaModel(); // Polonez Atu
        System.out.println(modelIMarkaPoloneza);

        // Pobranie  koloru dla SYRENA2
        System.out.println("---- Pobrenie koloru dla SYRENA2 ----");
        String kolorSyrenaBosto = MojeSamochody.SYRENA2.getKolor(); // wiśniowa
        System.out.println(kolorSyrenaBosto);

        // Pobranie wszystkich stałych do listy
        System.out.println("---- Pobranie wszystkich stałych do listy ----");
        MojeSamochody[] wszystkieStale = MojeSamochody.values();
        for (MojeSamochody mojeSamochody : wszystkieStale) {
            System.out.println(mojeSamochody);
        }

        // Pobranie ilości wszystkich stałych
        System.out.println("---- Pobranie ilości wszystkich stałych ----");
        int iloscSamochodow = MojeSamochody.values().length; // 4
        System.out.println(iloscSamochodow);

        // Pobranie kolejności (indeksu liczonego od 0) dla FIAT
        System.out.println("---- Pobranie kolejności (indeksu liczonego od 0) dla FIAT ----");
        int ktoryToFiat = MojeSamochody.FIAT.ordinal(); // 1
        System.out.println(ktoryToFiat);

        // Pobranie instancji dla FIAT
        System.out.println("---- Pobranie instancji dla FIAT ----");
        MojeSamochody fiat = MojeSamochody.valueOf("FIAT"); // tutaj pobieramy instancję
        System.out.println(fiat.getKolor()); // tutaj operujemy na instancji

        // Pobranie instancji poprzez niestandardową metodę statyczną w enum
        System.out.println("---- Pobranie instancji poprzez niestandardową metodę statyczną w enum ----");
        MojeSamochody list = MojeSamochody.findByColor("kość słoniowa");
        System.out.println(list);
    }
}
