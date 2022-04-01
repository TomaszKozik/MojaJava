package wzorceProjektowe.prototype;

/**
 * Wzorzec prototype służy do tworzenia nowych instacji obiektów poprzez klonowanie innych obiektów.
 * Pozwala na dodawanie nowych instancji pod czas działania aplikacji.
 * Ogranicza tworzenie przepisywanych podklas, a tym samym ilość kodu.
 * <p>
 * Źródło wiedzy: https://www.youtube.com/watch?v=AFbZhRL0Uz8&list=PLF206E906175C7E07&index=9
 */

/**
 * Interfejs narzucający możliwość klonowania
 */
interface Animal extends Cloneable {

    Animal makeCopy();
}

class Sheep implements Animal {

    public Sheep() {
        System.out.println("Sheep is made");
    }

    /**
     * Metoda do klonowania
     * @return
     */
    @Override
    public Animal makeCopy() {
        System.out.println("Sheep is being made");
        Sheep sheepObject = null;

        try {
            sheepObject = (Sheep) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return sheepObject;
    }

    public String toString() {
        return "Dolly is my hero";
    }
}

/**
 * Fabryka do klonowania obiektów
 */
class CloneFactory {
    public Animal getClone(Animal animalSimple) {
        return animalSimple.makeCopy();
    }
}

public class RunExample {
    public static void main(String[] args) {
        CloneFactory cloneFactory = new CloneFactory();
        Sheep sally = new Sheep();
        Sheep clonedSheep = (Sheep) cloneFactory.getClone(sally);
        // Potwierdzenie, że obiekt clonedSheep jest sklonowany i jest nowym obiektem
        System.out.println(sally);
        System.out.println(clonedSheep);
        System.out.println("Sally hashcode" + System.identityHashCode(sally));
        System.out.println("CloneSheep hashcode" + System.identityHashCode(clonedSheep));
    }
}