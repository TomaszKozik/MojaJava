package wzorceProjektowe.strategy;
/**
 * Wzorzec strategy jest wzorcem behawioralnym.
 * Pozwala na implementowanie podobnych zachowań z listy poprzez deklarację interfejsu,
 * przy czym:
 * - w skład listy wchodzi wiele klas implementujących interfejs
 * - każda klasa ma podobne zachowanie - podobny warunek do spełnienia lub inną funkcję
 *   np. wydrukowanie zbliżonej treści (coś może latać, coś nie może latać).
 *
 * Przydatny szczególnie, gdy mamy wiele obiektów, na których pracujemy,
 * a które mają podobne warunki do spełnienia.
 *
 * Pomoga w:
 * - ograniczeniu ilości kodu poprzez ograniczenie ilości np. warunków do spełnienia w klasach tego wymagających
 * - duplikacji kodu
 * - chroni przed koniecznymi zmianami w innych klasach
 * Minusem jest duża ilość klas
 *
 * Źródło wiedzy: https://www.youtube.com/watch?v=-NCgRD9-C6o&list=PLF206E906175C7E07&index=3
 */

/**
 * Interfejs dla wzorca
 */
interface TypeOfBuilding {
    Boolean check(Integer numberOfFlats, Integer numberOfFloors);
}

/**
 * Pierwszy warunek - sprawdza, czy budynek to dom jednorodzinny
 */
class HouseChecker implements TypeOfBuilding {

    @Override
    public Boolean check(Integer numberOfFlats, Integer numberOfFloors) {
        return numberOfFlats == 1;
    }
}

/**
 * Drugi warunek - sprawdza, czy budynek jest budynkiem szeregowym
 */
class TerracedBuildingChecker implements TypeOfBuilding {

    @Override
    public Boolean check(Integer numberOfFlats, Integer numberOfFloors) {
        return numberOfFlats > 1 && numberOfFlats == 1;
    }
}


/**
 * Pierwszy warunek - sprawdza, czy budynek to blok mieszkalny
 */
class BlockOfFlatsChecker implements TypeOfBuilding {

    @Override
    public Boolean check(Integer numberOfFlats, Integer numberOfFloors) {
        return numberOfFlats > 1 && numberOfFlats > 1;
    }
}

/**
 * Klasa wykorzystująca podany powyżej interfejs,
 * umożliwiająca sprawdzenie rodzaju budynku poprzez `check`
 * oraz zmianę rodzaju budynku poprzez `setBuildingType`
 */
abstract class Building {
    public TypeOfBuilding typeOfBuilding;

    public boolean check(Integer numberOfFlats, Integer numberOfFloors) {
        return typeOfBuilding.check(numberOfFlats, numberOfFloors);
    }

    public void setBuildingType(TypeOfBuilding typeOfBuilding) {
        this.typeOfBuilding = typeOfBuilding;
    }
}

/**
 * Nasz budynek
 */
class House extends Building {

    public House() {
        typeOfBuilding = new HouseChecker();
    }
}

public class RunExample {
    public static void main(String[] args) {
        Building house = new House();
        System.out.println("Is it a real house? " + house.check(1, 5));
        System.out.println("Change house to the terrace building");
        house.setBuildingType(new TerracedBuildingChecker());
        System.out.println("Is it still a house? " + house.check(1, 5));
    }
}
