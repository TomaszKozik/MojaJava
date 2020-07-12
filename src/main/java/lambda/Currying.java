package lambda;

import dataForExamples.Samochod;
import dataForExamples.enums.Kolory;
import dataForExamples.enums.RodzajNadwozia;
import dataForExamples.enums.RodzajPaliwa;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Currying {

    /**
     * Przykłady dla funkcji dodawania dwóch liczb.
     * Przedstawione są sposoby na realizację funkcji dodawania dwóch liczb począwszy od Supplier'a,
     * aż po funkcje złożone, umożliwiające wprowadzanie parametrów i rodzaju operacji.
     */
    public static void dodawanie() {

        // Pobieranie wyniku dodawania 2 + 5
        // Funkcja '()', w tym przypadku Suplier nie przyjmuje parametrów, więc ma puste nawiasy;
        // Ma wprowadzone na sztywno parametry;
        // Daje wynik w zdeklarowanym typie Integer.
        Supplier<Integer> sum1 =
                () -> 2 + 5;
        int wynik1 = sum1.get();  // 7
        System.out.println("Suplier: " + wynik1); // 7

        // Przekazanie jednego parametru
        // Funkcja '()', w tym przypadku Function przyjmuje jeden parametr;
        // Pobiera parametr 'a' i ma na szytwono wprowadzony parametr '5';
        // Daje wynik w zdeklarowanym typie Integer.
        Function<Integer, Integer> sum2 =
                (a) -> a + 5;
        int wynik2 = sum2.apply(2);  // 7
        System.out.println("UnaryOperator: " + wynik2);  // 7

        // Przekazanie dwóch parametrów
        // Funkcja '()', w tym przypadku BiFunction przyjmuje dwa parametry;
        // Pobiera parametr 'a' i 'b';
        // Daje wynik w zdeklarowanym typie Integer.
        BiFunction<Integer, Integer, Integer> sum3 =
                (a, b) -> a + b;
        int wynik3 = sum3.apply(2, 5); // 7
        System.out.println("BiFunction: " + wynik3);  // 7

        // Currying: Przekazanie funkcji dodawania
        // Funkcja '()', w tym przypadku Function przyjmuje jeden parametr;
        // Pobiera parametr 'a' będący funkcją BiFunction ma na sztywno wprowadzone parametry '2' i '5';
        // Parametr 'a' jest BiFunction, więc wewnątrz głównej funkcji musimy zastosować .apply();
        // Daje wynik w zdeklarowanym typie Integer.
        Function<BiFunction<Integer, Integer, Integer>, Integer> sum4 =
                (a) -> a.apply(2, 5);
        int wynik4 = sum4.apply((x, y) -> x + y);  // 7
        System.out.println("Currying1: " + wynik4);  // 7

        // Currying: Przekazanie funkcji dodawania i jednego parametru z wynikiem jako funkcja
        // Funkcja '()', w tym przypadku Function przyjmuje jeden parametr;
        // Pobiera parametr 'a' jest funkcją '()', w tym przypadku BiFunction i
        //         Pobiera parametr 'b' i na sztywno wprowadzony parametr '5'
        //         Zwracaja integer;
        //         Jest wewnątrz głównej funkcji musimy zastosować .apply();
        // Daje wynik w postacji nowej funkcji 'Function'
        Function<BiFunction<Integer, Integer, Integer>, Function<Integer, Integer>> preSum5 =
                (a) -> (b) -> a.apply(b, 5);
        Function sum5 = preSum5.apply((x, y) -> x + y);
        int wynik5 = (int) sum5.apply(2);  // 7
        System.out.println("Currying2: " + wynik5);  // 7

        // Currying: Przekazanie funkcji dodawania i jednego parametru z wynikiem jako Integer
        // Funkcja '()', w tym przypadku Function przyjmuje jeden parametr;
        // Pobiera parametr 'a', który jest funkcją '()', w tym przypadku BiFunction i
        //         Pobiera parametr 'b' i na sztywno wprowadzony parametr '5'
        //         Zwracaja integer;
        //         Jest wewnątrz głównej funkcji musimy zastosować .apply();
        // Daje wynik w postacji nowej funkcji 'Function',
        // przyczym dzięki zastosowanie drugiego .apply() realizujemy całą główną funkcję.
        Function<BiFunction<Integer, Integer, Integer>, Function<Integer, Integer>> sum6 =
                (a) -> (b) -> a.apply(b, 5);
        int wynik6 = sum6.apply((x, y) -> x + y).apply(2);  // 7
        System.out.println("Currying3: " + wynik6);  // 7

        // Currying: Przekazanie funkcji dodawania i dwóch parametrów
        // Funkcja '()', w tym przypadku Function przyjmuje jeden parametr;
        // Pobiera parametr 'a', który jest funkcją '()', w tym przypadku BiFunction i
        //         Pobiera parametr 'b' i 'c'
        //         Zwracaja integer;
        //         Jest wewnątrz głównej funkcji musimy zastosować .apply();
        // Zewzględu, iż wewnętrzna funkcja oczekuje na parametr, jako wyjście należy
        // zdeklarować funckję przekazującą ten potrzebny parametr
        // z ustawionym oczekiwanym typem.
        Function<BiFunction<Integer, Integer, Integer>, BiFunction<Integer, Integer, Integer>> sum7 =
                (a) -> (b, c) -> a.apply(b, c);
        int wynik7 = sum7.apply((x, y) -> x + y).apply(2, 5);  // 7
        System.out.println("Currying4: " + wynik7);  // 7
    }

    /**
     * Wykorzystanie Consumera do wypisywania listy elementów
     */
    public static void consumerJakoWynik() {
        // Funkcja '()', w tym przypadku Function przyjmuje jeden parametr;
        // Pobiera parametr 'f', który jest String'iem
        // Zwraca Consumer z String'iem, który obsługujemy w pętli for
        // dla każdego elementu z listy samochody
        List<String> samochody = Arrays.asList("Syrena", "Fiat", "Warszawa");
        Function<String, Consumer<String>> mojeSamochody =
                f -> samochod -> System.out.println(f + samochod);
        Consumer<String> tense = mojeSamochody.apply("Mój samochód to: ");
        samochody.forEach(tense);
        // Wynik:
        // Mój samochód to: Syrena
        // Mój samochód to: Fiat
        // Mój samochód to: Warszawa
    }

    /**
     * Funkcja builder() na podstawie Currying
     * Tworzymy obiekt 'Samochod' na bazie klasy 'Samochod'
     *
     * https://www.baeldung.com/java-currying
     */
    class Test {

        public void main(String[] args) {
            Samochod samochod = builder()
                    .apply("Żuk")
                    .apply("A11")
                    .apply(Kolory.ZIELONY.getKolor())
                    .apply(36000)
                    .apply(14.0)
                    .apply(RodzajNadwozia.PICKUP.getKategoria())
                    .apply(RodzajNadwozia.PICKUP.getRodzajNadwozia())
                    .apply(2)
                    .apply(2)
                    .apply(RodzajPaliwa.BENZYNA.getRodzajPaliwa())
                    .apply(2120);

            System.out.println(samochod.getMarka() + " " + samochod.getModel()); // Żuk A11
        }

        public Function<String,
                Function<String,
                        Function<String,
                                Function<Integer,
                                        Function<Double,
                                                Function<String,
                                                        Function<String,
                                                                Function<Integer,
                                                                        Function<Integer,
                                                                                Function<String,
                                                                                        Function<Integer, Samochod>>>>>>>>>>> builder() {
            return marka
                    -> model
                    -> kolor
                    -> przebieg
                    -> spalanie
                    -> kategoria
                    -> rodzaj
                    -> iloscDrzwi
                    -> iloscMiejsc
                    -> rodzajPaliwa
                    -> pojemnoscSkokowa
                    -> new Samochod(marka, model, kolor, przebieg, spalanie, kategoria, rodzaj, iloscDrzwi, iloscMiejsc, rodzajPaliwa, pojemnoscSkokowa);
        }
    }
}


