package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Filtrowanie {

    /**
     * Filtrowanie danych odbywa się poprzez interfejs Predicate i jego pochodnych za pomocą metody .filter()
     * Ilość filtrów jest dowolna.
     * Można je ich ilość zmniejszać poprzez łączenie predykatów dla poszczególnego filtra za pomocą &&.
     */
    public static void filtrowanie() {
        // Lista do filtrowania
        List<String> lisaSamochodow = new ArrayList<>();
        lisaSamochodow.add("Syrena 105L");
        lisaSamochodow.add("Fiat 125P");
        lisaSamochodow.add("Warszawa M20");

        // Filtrowanie samochodów, które w nazwie lub modelu mają cyfrę 1 i 5.
        List<String> nowaListaSamochodow = lisaSamochodow.stream()
                .filter(e -> e.contains("1"))
                .filter(e -> e.contains("5"))
                .collect(Collectors.toList());
        System.out.println(nowaListaSamochodow.toString()); // [Syrena 105L, Fiat 125P]
    }
}
