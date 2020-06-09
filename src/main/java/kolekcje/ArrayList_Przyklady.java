package kolekcje;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toCollection;

/**
 * ArrayList - jest to dynamiczna tablica. Jej ilość elementów może
 * wzrastać lub zmniejszać się.
 *
 * Nie może przechowywać typów pierwotnych
 *
 * Wymaga importu biblioteki java.util.ArrayList
 */
public class ArrayList_Przyklady {

    /**
     * Przykłady inicjalizacji ArrayList
     */
    class InicjalizacjaArrayList {

        // Inicjalizacja pustej tablicy
        ArrayList<String> tablica1 = new ArrayList<>();

        // Inicjalizacja z określoną początkową pojemnością
        ArrayList<String> tablica2 = new ArrayList<>(50);

        // Inicjalizacja tablicy z dodaniem elementów innej tablicy
        ArrayList<String> tablica3 = new ArrayList<>(tablica2);
    }

    /**
     * Podstawowe metody ArrayList
     * Indeks tablicy ArrayList zaczyna się od 0
     */
    class PodstawoweMetodyArrayList {
        /*
        int size() zwraca liczbę elementów listy;
        Object get(int index) zwraca obiekt listy, który jest obecny pod określonym indeksem;
        add(Object o) dodaje przekazany element do ostatniej pozycji kolekcji;
        add(int index, Object o) dodaje przekazany element do określonej pozycji kolekcji;
        set(int index, Object o) zamienia element obecny pod określonym indeksem na obiekt;
        remove(Object o) usuwa obiekt z tablicy;
        remove(int index) usuwa element z danego indeksu;
        clear() usuwa wszystkie elementy z kolekcji.
         */
    }
}

/**
 * https://hyperskill.org/learn/step/2322
 */
class Zadanie1 {

    public static void main(String[] args) {
        ArrayList<String> nameList = new ArrayList<>(Arrays.asList("Mr.Green", "Mr.Yellow", "Mr.Red"));
        for (String s : nameList) {
            System.out.println(s);
        }
    }
}

/**
 * https://hyperskill.org/learn/step/3482
 */
class ConcatPositiveNumbersProblem {
    public static ArrayList<Integer> concatPositiveNumbers(ArrayList<Integer> l1, ArrayList<Integer> l2) {
        l1.addAll(l2);
        return l1.stream().filter(e -> e > 0 ).collect(Collectors.toCollection(ArrayList::new));
    }

    /* Do not modify this method */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> list1 = readArrayList(scanner);
        ArrayList<Integer> list2 = readArrayList(scanner);

        ArrayList<Integer> result = concatPositiveNumbers(list1, list2);

        result.forEach((n) -> System.out.print(n + " "));
    }

    /* Do not modify this method */
    private static ArrayList<Integer> readArrayList(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}

