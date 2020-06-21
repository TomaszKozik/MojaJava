package kolekcje;

import java.util.*;

/**
 * Kolekcja Set to zbiór unikatowych elementów.
 * W stosunku do ArrayList lub List Set nie posiada indeksu.
 * Kolekcje Set są zmienne i niezmienne.
 * Dziedziczy elementy po Collection<E>
 * .add() i .addAll() dodają element o ile nie istnieje w tablicy
 *
 * Set ma trzy odmiany mutowalne:
 * new HashSet<>() - podstawowy Set z unikalnymi elementami
 * new TreesSet<>() - posortowany Set
 * new LinkedHashSet<>() - Set z unikalnymi elementami przechowujący kolejność dodania elementów
 */
public class SetsExample {
    public static void main(String[] args) {

        // Set niemodyfikowalny dla Java9
        // Set<String> setNiemodyfikowalny = Set.of("Syerana", "Fiat", "Syrena"); // Syrena, Fiat

        // HashSet - modyfikowalny  Set - wynik wywołania Set za każdym razem może być inny (chodzi o kolejność)
        Set<String> uniklanaListaSamochodow = new HashSet<>();
        uniklanaListaSamochodow.add("Syrena");
        uniklanaListaSamochodow.add("Warszawa");
        uniklanaListaSamochodow.add("Fiat");
        uniklanaListaSamochodow.add("Syrena");
        uniklanaListaSamochodow.forEach(System.out::println); // Warszawa, Fiat, Syrena

        // TreeSet - modyfikowalny sortowany Set
        // Set zamiennie z SortedSet, przy czym SortedSet dodaje kilka opcji
        Set<String> uniklanaListaSamochodow2 = new TreeSet<>();
        uniklanaListaSamochodow2.add("Syrena");
        uniklanaListaSamochodow2.add("Warszawa");
        uniklanaListaSamochodow2.add("Fiat");
        uniklanaListaSamochodow2.add("Syrena");
        uniklanaListaSamochodow2.forEach(System.out::println); // Fiat, Syrena, Warszawa

        // TreeSet - z SortedSet
        SortedSet<String> uniklanaListaSamochodow3 = new TreeSet<>();
        uniklanaListaSamochodow3.add("Syrena");
        uniklanaListaSamochodow3.add("Warszawa");
        uniklanaListaSamochodow3.add("Fiat");
        uniklanaListaSamochodow3.add("Syrena");
        uniklanaListaSamochodow3.forEach(System.out::println); // Fiat, Syrena, Warszawa

        // Opcje dodatkowe dla SortedSet
        // Zwraca pierwszy element
        uniklanaListaSamochodow3.first(); // Fiat
        // Zwraca ostatni element
        uniklanaListaSamochodow3.last(); // Warszawa
        // Zwraca listę elementów z przed danego elementu
        uniklanaListaSamochodow3.headSet("Warszawa"); // Fiat, Syrena

        // LinedHashSet - modyfikowalny Set
        // LinkedSet gwarantuje, że kolejność elementów jest taka sama, jak kolejność ich wstawienia do zestawu
        // Wynik LinkedHashSet to "Syrena, Warszawa, Fiat", dla samego HashSet "Syrena" była na końcu
        // pomimo identycznego wprowadzania danych
        Set<String> uniklanaListaSamochodow4 = new LinkedHashSet<>();
        uniklanaListaSamochodow4.add("Syrena");
        uniklanaListaSamochodow4.add("Warszawa");
        uniklanaListaSamochodow4.add("Fiat");
        uniklanaListaSamochodow4.add("Syrena");
        uniklanaListaSamochodow4.forEach(System.out::println); // Syrena, Warszawa, Fiat
    }
}
