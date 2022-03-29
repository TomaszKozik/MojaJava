package wzorceProjektowe.abstractFactory;

/**
 * Abstract Factory, to wzorzec do składania wielu obiektów w jeden.
 * Jest rozszerzeniem wzorca Factory.
 */
class EnemyShipTesting {
    public static void main(String[] args) {
        ShipBuilding buildShip = new ShipOrdering();

        Ship theGrunt = buildShip.orderTheShip("Little ship");
        System.out.println(theGrunt + "\n");

        Ship theBoss = buildShip.orderTheShip("Large ship");
        System.out.println(theBoss + "\n");
    }
}

abstract class ShipBuilding {
    protected abstract Ship buildShip(String typeOfShip);

    public Ship orderTheShip(String typeOfShip) {
        Ship theShip = buildShip(typeOfShip);
        theShip.makeShip();
        theShip.displayEnemyShip();
        theShip.followHeroShip();
        theShip.enemyShipShoots();
        return theShip;
    }
}

class ShipOrdering extends ShipBuilding {
    protected Ship buildShip(String typeOfShip) {
        Ship theShip = null;

        if (typeOfShip.equals("Little ship")) {
            ShipPartsFactory littleShipPartsFactory = new LittleShipPartsFactory();
            theShip = new LittleShip(littleShipPartsFactory);
            theShip.setName("Little sheep");
        } else if (typeOfShip.equals("Large ship")) {
            ShipPartsFactory largeShipPartsFactory = new LargeShipPartsFactory();
            theShip = new LargeShip(largeShipPartsFactory);
            theShip.setName("Large sheep");
        }
        return theShip;
    }
}

abstract class Ship {
    private String name;
    protected Weapon weapon;
    protected Engine engine;

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    abstract void makeShip();

    public void followHeroShip() {
        System.out.println(getName() + " is following the hero at " + engine);
    }

    public void displayEnemyShip() {
        System.out.println(getName() + " is on the screen");
    }

    public void enemyShipShoots() {
        System.out.println(getName() + " attacks and does " + weapon);
    }

    public String toString() {
        return "The " + name + " has a top speed of " + engine +
                " and an attack power of " + weapon;
    }
}

interface ShipPartsFactory {
    public Weapon addWeapon();

    public Engine addEngine();
}

class LittleShipPartsFactory implements ShipPartsFactory {
    public Weapon addWeapon() {
        return new LittleShipWeapon();
    }

    public Engine addEngine() {
        return new LittleShipEngine();
    }
}

class LargeShipPartsFactory implements ShipPartsFactory {
    public Weapon addWeapon() {
        return new LargeShipWeapon();
    }

    public Engine addEngine() {
        return new LargeShipEngine();
    }
}

class LittleShip extends Ship {
    protected ShipPartsFactory shipPartsFactory;

    public LittleShip(ShipPartsFactory shipPartsFactory) {
        this.shipPartsFactory = shipPartsFactory;
    }

    void makeShip() {
        System.out.println("Making enemy ship " + getName());
        weapon = shipPartsFactory.addWeapon();
        engine = shipPartsFactory.addEngine();
    }
}

class LargeShip extends Ship {
    protected ShipPartsFactory shipPartsFactory;

    public LargeShip(ShipPartsFactory shipPartsFactory) {
        this.shipPartsFactory = shipPartsFactory;
    }

    void makeShip() {
        System.out.println("Making enemy ship " + getName());
        weapon = shipPartsFactory.addWeapon();
        engine = shipPartsFactory.addEngine();
    }
}


/**
 * Części do statków
 */
interface Engine {
    public String toString();
}

class LittleShipEngine implements Engine {
    @Override
    public String toString() {
        return "1000 mph";
    }
}

class LargeShipEngine implements Engine {
    @Override
    public String toString() {
        return "2000 mph";
    }
}

interface Weapon {
    public String toString();
}

class LittleShipWeapon implements Weapon {
    @Override
    public String toString() {
        return "20 damage";
    }
}

class LargeShipWeapon implements Weapon {
    @Override
    public String toString() {
        return "40 damage";
    }
}
