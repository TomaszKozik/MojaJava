package doPosprzatania.kolekcje;

import java.util.*;





public class MapClass {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String index = scan.nextLine();

        int indexStart = Integer.parseInt(divideBySpace(index)[0]);
        int indexEnd = Integer.parseInt(divideBySpace(index)[1]);

        int maxKeys = scan.nextInt();

        HashSet<String> set = new HashSet<>();
        for (int i = 1; i < maxKeys; i++) {
            set.add(scan.nextLine());
        }

        SortedMap<Integer, String> map = new TreeMap<>();
        set.forEach(elem -> {
            System.out.println(elem);
//            String[] elem2 = divideBySpace(elem);
//            System.out.println(elem2[0]);
//            System.out.println(elem2[1]);
//            map.put(Integer.parseInt(elem2[0]), elem2[1]);
        });

        map.forEach((k, v) -> System.out.println(k + ": " + v));



//
//        Map<Integer, String> map2 = map.subMap(Integer.parseInt(indexInNumbers[0]),Integer.parseInt(indexInNumbers[1] + 1));
//        map.forEach((k, v) -> System.out.println(k + " " + v));


    }


    public static String[] divideBySpace(String string) {
        return string.trim().split("\\s+");
    }

    public static void main2(String[] args) {
        Map<String, Integer> map = new TreeMap<>();
        map.put("Gamma", 3);
        map.put("Omega", 24);
        map.put("Alpha", 1);
        System.out.println("Sposób wyświetlenia mapy za pomocą lambda");
        map.forEach((key, value) -> System.out.println(key + "=" + value));
    }
}