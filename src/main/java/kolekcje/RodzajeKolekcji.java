package kolekcje;

import java.util.*;

import static java.util.Arrays.*;

// todo wrzucić do qahelper.kozik.ovh
public class RodzajeKolekcji {

    /**
     * Konwertowanie pomiędzy tablicami
     */
    static class KonwertoWanieKolekcji {
        public static void main(String[] args) {

            // Przykłady tablic
            String[] tablicaString = {"a", "b", "c", "d"};
            int[] tablicaInt = {1, 2, 3, 4};
            Integer[] tablicaInteger = {5, 6, 7, 8};

            // Kolekcje niezmienny
            List<String> listNiezmienny = Arrays.asList(tablicaString);
            listNiezmienny.add("e");
            listNiezmienny.forEach(System.out::println);

            /*
              List
              Kolekcji List i innych kolekcji nie da się wykonać z tablic z typami pierwotnymi.
              Muszą one być zrealizowane poprzez klasy opakowujące np. Integer.
             */
            List<String> listaZTablicaString = asList(tablicaString);
            List<Integer> listaZTablicyInteger = Arrays.asList(tablicaInteger);

            /*
              Set, TreeSet, LinkedHashSet
              Kolekcji Set nie da się zrobić bezpośrednio z zwykłej tablicy.
              Można to zrealizować poprzez Listę
             */
            Set<String> setZTablicaString = new HashSet<>(Arrays.asList(tablicaString));
            Set<String> setZListaZTablicaString = new HashSet<>(listaZTablicaString);
            TreeSet<String> treeSetZTablicaString = new TreeSet<>(Arrays.asList(tablicaString));
            LinkedHashSet<String> linkedHashSetZListaZTablicaString = new LinkedHashSet<>(listaZTablicaString);
            List<String> listFromSet = new ArrayList<>(setZTablicaString);

            /*
              Queue i Deque
             */
            Queue<String> queueFromList = new ArrayDeque<>(listaZTablicaString);
            Queue<String> queueFromSet = new ArrayDeque<>(setZListaZTablicaString);
            Deque<String> dequeFromList = new ArrayDeque<>(listaZTablicaString);
            Deque<String> dequeFromSet = new ArrayDeque<>(setZListaZTablicaString);
            List<String> listFromQueue = new ArrayList<>(queueFromList);
            List<String> listFromDeque = new ArrayList<>(dequeFromList);


        }
    }
}
