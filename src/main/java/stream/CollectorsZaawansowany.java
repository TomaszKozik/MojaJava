package stream;

import dataForExamples.Samochod;

import java.util.*;
import java.util.stream.Collectors;

import static dataForExamples.PrzykladoweSamochody.listaSamochodow;
import static java.util.Map.Entry.comparingByValue;

/**
 * Collectros posiada wiele funkcji.
 * Pobieranie danych statystycznych, mapowanie wyników do list, redukcje,
 * partycjonowanie i grupowanie.
 */
public class CollectorsZaawansowany {

    /**
     * Pobieranie danych statystycznych
     */
    public static void pobieranieDanychStatystycznych_1przyklad() {
        DoubleSummaryStatistics nowaListaSamochodow = listaSamochodow().stream()
                .collect(Collectors.summarizingDouble(Samochod::getSpalanie));
        nowaListaSamochodow.getAverage(); // średnia z spalania
        nowaListaSamochodow.getCount(); // ilość
        nowaListaSamochodow.getMax(); // maksymalne spalanie
        nowaListaSamochodow.getMin(); // minimalne spalanie
        nowaListaSamochodow.getSum(); // suma spalań
    }

    public static void pobieranieDanychStatystycznyhc_2przyklad() {
        // Srednie spalanie:
        Double srednieSpalanie = listaSamochodow().stream()
                .collect(Collectors.averagingDouble(Samochod::getSpalanie));
        // Ilość
        Long count = listaSamochodow().stream()
                .collect(Collectors.counting());
        // Maksymalne spalanie
        Optional<Double> maxSpalanie = listaSamochodow().stream()
                .map(Samochod::getSpalanie)
                .collect(Collectors.maxBy(Comparator.naturalOrder()));
        System.out.println(maxSpalanie.get());
        // Minimalne spalanie
        Optional<Double> minSpalanie = listaSamochodow().stream()
                .map(Samochod::getSpalanie)
                .collect(Collectors.minBy(Comparator.naturalOrder()));
        System.out.println(minSpalanie.get());
        // Suma spalań
        Double sumaSpalan = listaSamochodow().stream()
                .collect(Collectors.summingDouble(Samochod::getSpalanie)); // suma spalan
    }

    /**
     * Redukcja
     */
    public static void redukcja() {
        String redukcja = listaSamochodow().stream()
                .collect(Collectors.reducing("", Samochod::getMarka, String::concat)); //SyrenaFiatWarszawaNysa
    }

    /**
     * Mapowanie
     */
    public static void mapowanie() {
        List<String> markaModel = listaSamochodow().stream()
                .collect(Collectors.mapping(a -> a.getMarka().concat(" ").concat(a.getModel()), Collectors.toList())); // [Syrena 105L, Fiat 125P, Warszawa M20, Nysa 522]
    }

    /**
     * Partycjonowanie to operacja dzieląca dane według predykatu na mapę (kolekcję) dwóch list.
     * Klucz mapy ma typ boolowski.
     */
    public static void partycjonowanie() {
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        Map<Boolean, List<Integer>> groups =
                intList.stream().collect(Collectors.partitioningBy(s -> s > 6));
        groups.forEach((k, v) -> System.out.println(k + ":" + v));

        List<List<Integer>> subSets = new ArrayList<List<Integer>>(groups.values()); // [[1, 2, 3, 4, 5, 6], [7, 8]]
    }

    public static void partycjonowanie_2przyklad() {
        Map<Boolean, List<Samochod>> partPrzeb = listaSamochodow().stream()
                .collect(Collectors.partitioningBy(a -> a.getPrzebieg() > 100000));
        // Wynik przykladowy:
        // false:[dataForExamples.Samochod@52cc8049, dataForExamples.Samochod@5b6f7412, dataForExamples.Samochod@27973e9b]
        // true:[dataForExamples.Samochod@312b1dae]
    }

    /**
     * Grupowanie zamiast dzielić dane na dwie grupy (prawda i fałsz),
     * może stworzyć grupy dowolnej liczby i typów.
     */
    public static void grupowanie() {
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        Map<Integer, List<Integer>> groups =
                intList.stream().collect(Collectors.groupingBy(s -> (s - 1) / 4));
        groups.forEach((k, v) -> System.out.println(k + ":" + v)); // [[1, 2, 3, 4], [5, 6, 7, 8], [9]]
    }

    public static void grupowanie_2przyklad() {
        // Grupowanie obiektów Samochod po kolorze
        Map<String, List<Samochod>> partSpalanie = listaSamochodow().stream()
                .collect(Collectors.groupingBy(a -> a.getKolor()));
        // Wynik przykladowy:
        // beżowy:[dataForExamples.Samochod@52cc8049]
        // czerwony:[dataForExamples.Samochod@27973e9b]
        // niebieski:[dataForExamples.Samochod@5b6f7412, dataForExamples.Samochod@312b1dae]
    }

    /**
     * Lączenie Collectors
     */
    public static void grupowanieIMapowanie_1Przyklad() {
        Map<String, List<String>> lista = listaSamochodow().stream()
                .collect(Collectors.groupingBy(a -> a.getKolor(), Collectors.mapping(a -> a.getMarka().concat(" ").concat(a.getModel()), Collectors.toList())));
        // Wynik przykładowy:
        // beżowy:[Syrena 105L]
        // czerwony:[Warszawa M20]
        // niebieski:[Fiat 125P, Nysa 522]
    }

    public static void grupowanieIMapowanie_2Przyklad() {
    Map<String, Double> result = listaSamochodow().stream()
            .collect(Collectors.groupingBy(a -> a.getNadwozie().getKategoria(), Collectors.averagingDouble(Samochod::getSpalanie)));
        // Wynik przykładowy:
        // dostawcze:14.0
        // osobowe:9.866666666666667
    }

    public static void array2Map2List() {
        // Przykład pobiera całe zdania i wydziela z nichh poszczególe wyrazy, a następnie sortuje je
        // i wyświetla 10 najczęściej występujących
        Scanner scanner = new Scanner(System.in);

        Arrays.stream(scanner.nextLine().split("\\W+"))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(a -> a, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .map(Map.Entry::getKey)
                .forEach(System.out::println);
    }
}
