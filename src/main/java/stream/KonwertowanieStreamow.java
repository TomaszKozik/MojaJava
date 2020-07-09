package stream;

import dataForExamples.PrzykladoweSamochody;
import dataForExamples.Samochod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class KonwertowanieStreamow {

    /**
     * Stream do tablicy
     * .toArray()
     */
    public static void stream2Array() {
        List<String> listaSamochodow = new ArrayList<>();
        listaSamochodow.add("Syrena 105L");
        listaSamochodow.add("Fiat 125P");
        listaSamochodow.add("Warszawa M20");

        String[] nowaListaSamochodow = listaSamochodow.stream()
                .toArray(String[]::new);
    }

    /**
     * Stream do listy
     * .collect(Collectors.toList())
     */
    public static void stream2List() {
        List<String> listaSamochodow = new ArrayList<>();
        listaSamochodow.add("Syrena 105L");
        listaSamochodow.add("Fiat 125P");
        listaSamochodow.add("Warszawa M20");

        List<String> nowaListaSamochodow = listaSamochodow.stream()
                .collect(Collectors.toList());
    }

    /**
     * Stream do mapy
     * .collect(Collectors.toMap(<key>,<value>)
     */
    public static void steam2Map() {
        Map<String, String> nowaListaSamochodow = PrzykladoweSamochody.listaSamochodow().stream()
                .collect(Collectors.toMap(Samochod::getMarka, Samochod::getModel));
    }


    /**
     * Lista Integer do IntStream
     */
    public static void int2IntStream() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        int sum = numbers
                .stream()
                .mapToInt(i -> i)
                .sum();
        System.out.println(sum); // 6
    }

    /**
     * IntStream do Stream
     */
    public static void intStream2Stream() {
        Stream<Integer> streamOfNumbers = IntStream
                .range(1, 4)
                .boxed();
        streamOfNumbers.forEach(System.out::println); // 1, 2, 3
    }

    /**
     * IntStream do DoubleStream
     */
    public static void intStream2DoubleStream() {
        IntStream.of(1, 2, 3, 4)
                .asDoubleStream()
                .forEach(System.out::println); // 1.0, 2.0, 3.0, 4.0
    }
}
