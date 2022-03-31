package wzorceProjektowe.abstractFactory;

/**
 * Abstract Factory służy do budowania obiektu z wykorzystaniem innych obiektów,
 * czyli np. budujemy obiekt Samochód, który jest zbudowany z obiketów różnych częśći
 * np. silnik, nadwozie
 *
 * Na podstawie: https://www.youtube.com/watch?v=xbjAsdAK4xQ&list=PLF206E906175C7E07&index=6
 */

/**
 * Sekcja obiektów części
 */
//Interface dla części Silnik
interface Engine {
    Integer getPower();
}

//Interface dla częśći Nadwozie
interface Body {
    String getColour();
}

// Silnik do Forda
class FordEngine implements Engine {
    @Override
    public Integer getPower() {
        return 100;
    }
}

//  Nadwozie do Forda
class FordBody implements Body {
    private final String colour;

    public FordBody(String colour) {
        this.colour = colour;
    }

    @Override
    public String getColour() {
        return colour;
    }
}

// Silnik do Syreny
class SyrenaEngine implements Engine {
    @Override
    public Integer getPower() {
        return 35;
    }
}

// Nadwozie do Syreny
class SyrenaBody implements Body {
    private final String colour;

    public SyrenaBody(String colour) {
        this.colour = colour;
    }

    @Override
    public String getColour() {
        return colour;
    }
}

/**
 * Sekcja do budowy części dla konkrentego pojazdu.
 * Jest pewną formą listy części potrzebnych kompletujących samochód.
 */
// Interfejs wyznaczający części współne każdego pojazdu
interface CarFactoryInterface {
    Engine addEngine();

    Body addBody(String colour);
}

// Fabryka Forda
class FordFactory implements CarFactoryInterface {

    @Override
    public Engine addEngine() {
        return new FordEngine();
    }

    @Override
    public Body addBody(String colour) {
        return new FordBody(colour);
    }
}

// Fabryka Syreny
class SyrenaFactory implements CarFactoryInterface {

    @Override
    public Engine addEngine() {
        return new SyrenaEngine();
    }

    @Override
    public Body addBody(String colour) {
        return new SyrenaBody(colour);
    }
}

/**
 * Sekcja, zbierania wyprodukowanych części w cały samochód
 * Taka dokumentacja dla pracownika
 */
abstract class Car {
    private String name;
    protected Engine engine;
    protected Body body;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printPowerOfEngine() {
        System.out.println("The power of " + getName() + " is " + engine.getPower() + " KM");
    }

    public void printColourOfBody() {
        System.out.println("The colour of " + getName() + " is " + body.getColour());
    }

    abstract public void makeCar(String colour);
}

// Jak złożyć Forda?
class Ford extends Car {
    private final CarFactoryInterface carFactoryInterface;

    public Ford(CarFactoryInterface carFactoryInterface) {
        this.carFactoryInterface = carFactoryInterface;
    }

    @Override
    public void makeCar(String colour) {
        System.out.println("Making a car" + getName());
        body = carFactoryInterface.addBody(colour);
        engine = carFactoryInterface.addEngine();
    }
}

// Jak złożyć Syrenę?
class Syrena extends Car {
    private final CarFactoryInterface carFactoryInterface;

    public Syrena(CarFactoryInterface carFactoryInterface) {
        this.carFactoryInterface = carFactoryInterface;
    }

    @Override
    public void makeCar(String colour) {
        System.out.println("Making a car" + getName());
        body = carFactoryInterface.addBody(colour);
        engine = carFactoryInterface.addEngine();
    }
}

/**
 * Sekcja zamówienia samochodu i jego zbudowania pod klienta
 */
// Zbuduj samochód według zamówienia
abstract class BuildCar {
    // Składasz zamówienie na samochód poprzez wymuszenie zbudowania klasy do składania zamówień
    abstract protected Car orderCar(String nameOfCar);

    // Budujesz samochód na podstawie złożonego zamówienia.
    public void build(String nameOfCar, String colour) {
        Car car = orderCar(nameOfCar);      // Klasa do zamówień zwraca Ci obiek samochód do zbudowania.
        car.makeCar(colour);
        car.printColourOfBody();
        car.printPowerOfEngine();
    }
}

// Zamów samochód według wytycznych
class OrderCar extends BuildCar {

    @Override
    protected Car orderCar(String nameOfCar) {
        Car car = null;

        if (nameOfCar.equals("Ford")) {
            CarFactoryInterface fordFactory = new FordFactory();
            car = new Ford(fordFactory);
            car.setName("Ford");
        } else if (nameOfCar.equals("Syrena")) {
            CarFactoryInterface syrenaFactory = new SyrenaFactory();
            car = new Syrena(syrenaFactory);
            car.setName("Syrena");
        }
        return car;
    }
}

/**
 * Wykonanie całości
 */
public class Example {
    public static void main(String[] args) {
        BuildCar orderCar = new OrderCar();
        orderCar.build("Ford", "niebieski");
        System.out.println("----------------");
        orderCar.build("Syrena", "kość słoniowa");
    }
}
