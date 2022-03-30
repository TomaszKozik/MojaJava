package tablice_kolekcje;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

/**
 * Lista to uporządkowana kolekcja elementów. Oznacza to, że każdy element ma pozycję
 * na liście określoną indeksem całkowitym, tak jak w zwykłych tablicach.
 *
 * List<E> tworzy się na bazie interfejsu Collection<E>
 *
 * Są dwa rodzaje list:
 * - niemodyfikowalne (immutable) - tworzy się na podstawie nieinstancyjnych kolekcji,
 *   nie możemy ich edytować, dodawać do nich lub usuwać z nich rekordów
 * - modyfikowalne (mutable) - tworzy się na podstawie instancyjnych kolekcji,
 *   na listach modyfikowalnych działają wszystkie operacje, jak dla ArrayList<E>
 */
public class ListExample {
    public static void main(String[] args) {

        // Lista niemodyfikowalna na podstawie listy elementów
        List<String> listaNiemodyfikowalna1 = asList("Syrena", "Fiat", "Warszawa");

        // Lista niemodyfikowalna na podstawie tablicy
        String[] tablicaSamochodow = {"Syrena", "Fiat", "Warszawa"};
        List<String> listaNiemodyfikowalna2 = Arrays.asList(tablicaSamochodow);

        // Lista niemodyfikowalna na podstawie listy elementów (od Java 9)
        // List<String> listaNiemodyfikowalna3 = List.of("Syrena", "Fiat", "Warszawa");

        // Lista niemodyfikowalna na podstawie klasy Collections
        List<String> listaNiemodyfikowalna4 = Collections.emptyList();
        List<Integer> listaNiemodyfikowalna5 = Collections.singletonList(100);

        // Przekształce listy modyfikowalnej w niemodyfikowalną
        List<String> listaModyfikowalna1 = new ArrayList<>(Arrays.asList(tablicaSamochodow));
        List<String> listaNiemodyfikowalna6 = Collections.unmodifiableList(listaModyfikowalna1);


        // Lista modyfikowalna na podstawie new ArrayList
        List<String> listaModyfikowalna2 = new ArrayList<>(); // pusta lista modyfikowalna

        // Przekształce listy niemodyfikowalnej w modyfikowalną
        String[] listaNiemodyfikowalna7 = {"Syrena", "Fiat", "Warszawa"};
        List<String> listaModyfikowalna3 = new ArrayList<>(Arrays.asList(listaNiemodyfikowalna7));


        //  Sortowanie listy

        //Lista do poniższych przykładów:
        List<String> listaSamochodow = asList("Syrena", "Fiat", "Warszawa");

        // stream - tworzy nową mutowalną listę
        List<String> sortowanieStream = listaSamochodow.stream().sorted().collect(Collectors.toList());
        sortowanieStream.forEach(System.out::println);

        // Collections - nie zmienia rodzaju listy
        Collections.sort(listaSamochodow);
        listaSamochodow.forEach(System.out::println);

        // SubLista - wyodrębnienie listy po numerze indeksu
        List<String> listaSamochodow2 = asList("Syrena", "Fiat", "Warszawa");
        List<String> wyselekcjonowaneSamochody = listaSamochodow2.subList(1, 2);
    }
}
