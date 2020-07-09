package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Konwertowanie {
    /**
     * Konwertowanie list
     */
    public static void int2IntStream() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        int sum = numbers
                .stream()
                .mapToInt(i -> i)
                .sum();
        System.out.println(sum); // 6
    }

    public static void intStream2Stream() {
        Stream<Integer> streamOfNumbers = IntStream
                .range(1, 4)
                .boxed();
        streamOfNumbers.forEach(System.out::println); // 1, 2, 3
    }

    public static void intStream2DobuleStream() {
        IntStream.of(1, 2, 3, 4)
                .asDoubleStream()
                .forEach(System.out::println); // 1.0, 2.0, 3.0, 4.0
    }
}
