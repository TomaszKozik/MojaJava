package tablice_kolekcje;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Collections - to klasa, która pozwala nam na modyfikacje list
 *
 * https://hyperskill.org/learn/step/3573
 * https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/util/Collections.html
 */
public class CollectionsExamples {

    public static void main(String[] args) {
        // Lista do poniższych przykładów
        List<String> listaSamochodow = Arrays.asList("Syrena", "Fiat", "Warszawa");

        // Tworzenie kolekcji niemodyfikowalnych
        List<String> pustaLista = Collections.emptyList();
        Set<Integer> pustySet = Collections.emptySet();
        List<String> listaJednoElementowa = Collections.singletonList("Warszawa");
        Set<String> setJednoElementowy = Collections.singleton("Syrena");

        // Przeksztalcenie listy modyfikowalnej w niemodyfikowalną
        List<String> niezmiennaListaSamochodow = Collections.unmodifiableList(listaJednoElementowa);

        // Szybkie operacje na listach
        Collections.sort(listaSamochodow); // Fiat, Syrena, Warszawa
        Collections.reverse(listaJednoElementowa); // Warszawa, Syrena, Fiat
        Collections.min(listaSamochodow); // Fiat
    }
}
