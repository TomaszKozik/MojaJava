package wzorceProjektowe.strategy;

/**
 * Interfejs dający pewną możliwość, którą można implementować na wiele różnych sposobów
 * np. opisów, funkcji, warunków do spełnienia.
 * Gotowy interfejs można użyć w klasie wykorzystującej różne klasy implementujące ten interfejs.
 * Dzięki temu unika się
 * - duplikacji kodu
 * - redukuje się ilość kodu
 * - chroni przed wymuszaniem zmian w innych klasach
 * Minusem jest zwiększona ilości klas i metod
 */
interface Fly {
    String fly();
}

class CanFlies implements Fly {

    @Override
    public String fly() {
        return "Umie latać";
    }
}

class CannotFlies implements Fly {

    @Override
    public String fly() {
        return "Nie umie latać";
    }
}

/**
 * Klasa abstrakcyjna umożliwiająca klasą dziedziczącym ustawianie funkcji, warunków,
 * czyli klas implementujących interfejs.
 */
abstract class Animal {
    public Fly theAbilityToFly;

    public String isFlies() {
        return theAbilityToFly.fly();
    }

    public void setTheAbilityToFly(Fly theAbilityToFly) {
        this.theAbilityToFly = theAbilityToFly;
    }
}

class Dog extends Animal {
    public Dog() {
        theAbilityToFly = new CannotFlies();
    }
}

class Stork extends Animal {
    public Stork() {
        theAbilityToFly = new CanFlies();
    }
}

/**
 * Przykład obrazuje deklaracje klas zwierząt oraz sprawdzenie na podstawie wzorca
 * strategy, czy wykonują odpowiednie dla nich funkcje, warunki
 */
public class RunExample {
    public static void main(String[] args) {
        Animal azor = new Dog();
        Animal klekotek = new Stork();

        System.out.println("Czy Klekotek lata? " + klekotek.isFlies());
        System.out.println("Czy Azor lata? " + azor.isFlies());
        azor.setTheAbilityToFly(new CanFlies());
        System.out.println("Czy Azor lata? " + azor.isFlies());

    }
}