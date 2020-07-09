package stream;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

/**
 * Java umożliwia pracę strumieni na typach pierwotnych,
 * dzięki czemu działanie strumieni może być szybsze
 * pomijając mapowanie danych na inne typy danych
 *
 * Streamy na typach pierwotnych mają również kilka dodatkowych funkcji.
 */
public class StreamyNaPrymitywnychWartosciach {

    // Pobieranie min, max, avg, sum, count i danych statytycznych
    public static void minMaxAvgSum() {
        int[] numbers = { 10, 11, 25, 14, 22, 21, 18 };

        int max = IntStream.of(numbers).max().getAsInt();
        System.out.println(max); // 25

        int min = IntStream.of(numbers).min().getAsInt();
        System.out.println(min); // 10

        double avg = IntStream.of(numbers).average().orElse(0.0);
        System.out.println(avg); // 17.2857...

        int sum = IntStream.of(numbers).sum();
        System.out.println(sum); // 121

        // Dla count nie działa .getAsInt()
        double count = IntStream.of(numbers).count();
        System.out.println(count);

        // Statystyki
        IntSummaryStatistics stat = IntStream.rangeClosed(1, 55_555).summaryStatistics();
        System.out.println(String.format("Count: %d, Min: %d, Max: %d, Avg: %.1f",
                stat.getCount(), stat.getMin(), stat.getMax(), stat.getAverage()));
    }

    public static void gereracjaLiczb() {
        // Generowanie 10 liczb
        DoubleStream.generate(Math::random)
                .limit(10)
                .forEach(System.out::println);
    }

    public static void iteracja() {
        // seed - numer początkowy iteracji
        // przykład i -> i + 5 działa na podobnej zasadzie do pętli for
        // limit - określa ilość wyiterowanych elementów
        IntStream.iterate (10, i -> i + 5)
                .limit (5)
                .forEach(System.out::println);
    }

    public static void charsToIntStream() {
        // Zkolekcjonowanie wartości int znaków ze String'a 'Syrana'
        List<Integer> charsInInt = "Syrena"
                .chars()
                .boxed()
                .collect(Collectors.toList());
        charsInInt.forEach(System.out::println); // 83, 121, 114, 101, 110, 97
    }

    public static void laczenieStrumieni() {
        IntStream stream1 = IntStream.of(2, 4, 6);
        IntStream stream2 = IntStream.of(1, 3, 5);

        IntStream.concat(stream1, stream2)
                .forEach(System.out::println); // 2, 4, 6, 1, 3, 5
    }
}