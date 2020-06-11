package kolekcje;

import java.util.*;
import java.util.stream.Collectors;

class Collections_Przyklady {
    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        List<Integer> table = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            Arrays.asList(scanner.nextLine().split("\\s+")).stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toCollection(() -> table));
        }




//        List<Integer> numbers = Arrays.asList(scanner.nextLine().split("\\s+")).stream()
//                .map(Integer::parseInt)
//                .collect(Collectors.toList());
//
//        int count = scanner.nextInt();
//        for (int i = 0; i < count; i++) {
//            Collections.swap(numbers, scanner.nextInt(), scanner.nextInt());
//        }
//
//        System.out.println(String.join(" ", numbers));
    }

    public static List<Integer> stringToList() {
        return Arrays.asList(scanner.nextLine().split("\\s+")).stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}


public class List_PrzykladyUzycia {

    public static <T> List<List<T>> splitListIntoSubLists(List<T> list, int subListSize) {
        List<List<T>> sublists = new ArrayList<>();
        Collection<List<T>> sublists2;

        sublists2 = list.stream()
                .collect(Collectors.groupingBy(it -> list.size() / (double) subListSize))
                .values();
        for (List<T> sublist : sublists2) {
            sublists.add(sublist);
        }
        return sublists;
    } //1 2 3 4 5 6 7


    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final String[] values = scanner.nextLine().split("\\s+");

        final List<Integer> list = Arrays.asList(values).stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        final int subListSize = Integer.parseInt(scanner.nextLine());

        final List<List<Integer>> subLists = splitListIntoSubLists(list, subListSize);

        subLists.forEach(subList -> {
            final String representation = subList.stream().map(Object::toString).collect(Collectors.joining(" "));
            System.out.println(representation);
        });
    }

}
