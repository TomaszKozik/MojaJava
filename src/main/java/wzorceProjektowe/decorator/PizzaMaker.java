package wzorceProjektowe.decorator;

/**
 * Decorator pozwala na budowanie wieloskładnikowych obiektów np. pizza. Np. zamiast tworzenia gotowej klasy
 * stanowiącej gotowy rodzaj pizzy wraz z jej ceną, dekorator umożliwia budowanie tej pizzy. Każda klasa dekoratora
 * to składnik pizzy wraz z jego ceną. Dzięki czemu jest zwiększona możliwość dokonywania zmian i konfiguracji.
 * <p>
 * Źródło wiedzy: https://www.youtube.com/watch?v=j40kRwSm4VE - ang., czas oglądania 12:57
 */
public class PizzaMaker {

    public static void main(String[] args) {
        Pizza pizza = new Mozzarella(new TomatoSauce(new Dough()));

        System.out.println("---------");
        System.out.println("Ready pizza:");
        System.out.println("  Ingredients: " + pizza.getDescription());
        System.out.println("  Price: " + pizza.getCost() + "$");
    }
}

interface Pizza {

    String getDescription();

    Double getCost();
}

/**
 * Podstawowa klasa, którą będziemy dekorować
 * Jest nią ciasto na pizze
 */
class Dough implements Pizza {

    public Dough() {
        System.out.println("Prepare dough");
    }

    @Override
    public String getDescription() {
        return "Thin dough";
    }

    @Override
    public Double getCost() {
        return 10.00;
    }
}

/**
 * Klasa abstrakcyjna przyjmująca klasę do dekorowania i pobierająca
 * podstawowe elementy do dopisywania
 */
abstract class PizzaDecorator implements Pizza {

    protected Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription();
    }

    @Override
    public Double getCost() {
        return pizza.getCost();
    }
}

/**
 * Deokoracja 1: mozzarella
 */
class Mozzarella extends PizzaDecorator {

    public Mozzarella(Pizza tempPizza) {
        super(tempPizza);
        System.out.println("Adding mozarella");
    }

    public String getDescription() {
        return pizza.getDescription() + ", mozarella";
    }

    public Double getCost() {
        return pizza.getCost() + 0.50;
    }
}

/**
 * Dekoracja 2: sos pomidorowy
 */
class TomatoSauce extends PizzaDecorator {

    public TomatoSauce(Pizza tempPizza) {
        super(tempPizza);
        System.out.println("Adding tomato sauce");
    }

    public String getDescription() {
        return pizza.getDescription() + ", tomato souce";
    }

    public Double getCost() {
        return pizza.getCost() + 0.20;
    }
}
