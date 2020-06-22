package doPosprzatania.kolekcje;

import java.util.*;

/**
 * Map jest to kolekcja zawierająca parę klucz-wartość.
 * Oznacza to, iż każdy element ma swój indywidualny (uniklany) klucz np. jakiś numer ewidencyjny.
 * Najlepszym tego przykładem może być książka telefoniczna, gdzie kluczem jest osoba,
 * a wartością numer telefonu.
 *
 * Klucze tworzą kolekcję Set. Są podobne do indeksów, lecz mogą mieć dowolny typ.
 *
 * Mapy są modyfikowalne, a od Java 9 również niemodyfikowalne.
 *
 * Interfejs Map<k,v> nie jest podtypem interfejsu Collection<E>.
 */

public class MapExamples {

    public static void main(String[] args) {

        // Tworzenie mapy niemodyfikowalnej (od Java 9)
        /*
        Map<String, String> emptyMap = Map.of();
        Map<String, String> friendPhones = Map.of(
                "Bob", "+1-202-555-0118",
                "James", "+1-202-555-0220",
                "Katy", "+1-202-555-0175"
        );
        */

        // Tworzenie modyfikowalnej niesortowanej mapy
        Map<Integer, String> mapLikeSet = new HashMap<>();

        // Tworzenie modyfikowalnej niesortowanej mapy
        Map<Integer, String> mapLikeLinkedSet = new LinkedHashMap<>();

        // Tworzenie modyfikowalnej niesortowanej mapy
        SortedMap<String, String> mapLikeTreeSet = new TreeMap<>();





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