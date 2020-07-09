package stream;

import dataForExamples.PrzykladoweSamochody;
import dataForExamples.Samochod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Mapowanie {
    /**
     * Mapowanie danych odbywa się poprzez interfejs Function i jego pochodnych za pomocą metody .map()
     * Ilość mapowań jest doowolna
     */
    public static void prosteMapowania() {
        // Lista do filtrowania
        String[] jakiesLiczbyTablica = {"2", "4", "6", "8"};
        List<String> jakiesLiczbyLista = new ArrayList<>(Arrays.asList(jakiesLiczbyTablica));

        List<Integer> nowaListaLiczb = jakiesLiczbyLista.stream()
                .mapToInt(Integer::parseInt) // zmiana wszystkich wartości z String na Integer
                .map(e -> e / 2) // podzielenie każdego elementu przez 2
                .boxed()
                .collect(Collectors.toList());
        System.out.println(nowaListaLiczb);  // [1, 2, 3, 4]
    }

    /**
     * Wyciąganie naz pojazdów z listy obiektów.
     */
    public static void mapowanieObjektow() {
        List<String> lista = PrzykladoweSamochody.listaSamochodow().stream()
                .map(Samochod::getMarka)
                .collect(Collectors.toList());
        System.out.println(lista); // [Syrena, Fiat, Warszawa]
    }

    /**
     * FlatMap to "spłaszczanie" tablic wielowymiarowych do jednowymiarowej.
     */
    public static void flatMapListLists() {
        // Przykład tablicy wielowymiarowej
        List<String> l1 = new ArrayList<>();
        l1.add("Syrena");
        List<String> l2 = new ArrayList<>();
        l2.add("Fiat");
        l2.add("Ford");
        List<String> l3 = new ArrayList<>();
        l3.add("Warszawa");

        List<List<String>> sumList = new ArrayList<>();
        sumList.add(l1);
        sumList.add(l2);
        sumList.add(l3);

        // Spłaszczenie tablicy
        List<String> lista = sumList.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        System.out.println(lista); // [Syrena, Fiat, Ford, Warszawa]
    }
}