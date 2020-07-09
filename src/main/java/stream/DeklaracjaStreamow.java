package stream;

import dataForExamples.PrzykladoweSamochody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class DeklaracjaStreamow {

    /**
     * Deklaracja strumieni poprzez metodę '.stream()' na podstawie listy samochodów, która zlicza ich ilość.
     */
    public static void deklaracjaPoprzezMetode() {
        double iloscSamochodow = PrzykladoweSamochody.listaSamochodow().stream()
                .count();
        System.out.println(iloscSamochodow); // 3
    }

    /**
     * Deklaracja strumieni poprzez klasę 'Stream' na podstawie listy samochodów, która zlicza ich ilość.
     */
    public static void deklaracjaPoprzezKlase() {
        double iloscSamochodow = Stream.of(PrzykladoweSamochody.listaSamochodow())
                .count();
        System.out.println(iloscSamochodow); // 3
    }

    /**
     * Strumienie można łączyć i deklarować je jako jeden strumień.
     * Stream.concat()
     */
    public static void laczenieStrumieni2() {
        String[] jakiesLiczbyTablica = {"2", "4", "6", "8"};
        List<String> jakiesLiczbyLista = new ArrayList<>(Arrays.asList(jakiesLiczbyTablica));
        List<String> jakiesLiczbyLista2 = new ArrayList<>(Arrays.asList(jakiesLiczbyTablica));

        Stream.concat(Stream.of(jakiesLiczbyLista), jakiesLiczbyLista2.stream())
                .forEach(System.out::println); // [2, 4, 6, 8] [2, 4, 6, 8]
    }
}
