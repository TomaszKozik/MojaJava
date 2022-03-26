package wzorceProjektowe.factory;

import java.util.Scanner;

/**
 * Klasa wzorzca projektowego Factory dostarcza opcji wyboru z grupy klas podobnych
 * mających jeden główny wzór. Dzięki czemu ograniczona jest if'ologia w obszarze klasy
 * wykonywalnej.
 *
 * Kiedy używać tego wzorca:
 *    Gdy posiadasz wiele podobnych klas znajdujących się w tej samej hierarchii podklas
 *    Gdy chcesz ułatwić wybór jednej z nich z scentralizowanego miejsca
 *    Masz zhermetyzowane tworzenie obiektów
 *
 * Źródło: https://www.youtube.com/watch?v=ub0DXaeV6hA
 */

abstract class EnemyShip {
    private String name;
    private double amtDamage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmtDamage() {
        return amtDamage;
    }

    public void setAmtDamage(double amtDamage) {
        this.amtDamage = amtDamage;
    }

    public void followHeroShip() {
        System.out.println(getName() + " is following the hero");
    }

    public void displayEnemyShip() {
        System.out.println(getName() + " is on the screen");
    }

    public void enemyShipShoots() {
        System.out.println(getName() + " attacks and does" + getAmtDamage());
    }
}

class UfoEnemyShip extends EnemyShip {

    public UfoEnemyShip() {
        setName("UFO enemy ship");
        setAmtDamage(20.0);
    }
}

class BigUfoEnemyShip extends UfoEnemyShip{

    public BigUfoEnemyShip() {
        setName("Big UFO enemy ship");
        setAmtDamage(100.0);
    }
}

class RocketEnemyShip extends EnemyShip {

    public RocketEnemyShip() {
        setName("Rocket enemy ship");
        setAmtDamage(20.0);
    }
}

/**
 * Jak tego nie robić
 */
class EnemyShipTestWrongExample {
    public static void main(String[] args) {
        EnemyShip theEnemy = null;

        Scanner scanner = new Scanner(System.in);
        String enemyShipOption = "";
        System.out.println("What type of ship? U/R");
        if (scanner.hasNextLine()) {
            enemyShipOption = scanner.nextLine();
        }

        if (enemyShipOption.equals("U")) {
            theEnemy = new UfoEnemyShip();
        }
        else {
            theEnemy = new RocketEnemyShip();
        }

        doStuffEnemy(theEnemy);
    }

    private static void doStuffEnemy(EnemyShip anEnemyShip) {
        anEnemyShip.displayEnemyShip();
        anEnemyShip.followHeroShip();
        anEnemyShip.enemyShipShoots();
    }
}

class EnemyShipFactory {
    public EnemyShip makeEnemyShip(String newEnemyShip) {
        EnemyShip enemyShip = null;

        if (newEnemyShip.equals("U")) {
            return new UfoEnemyShip();
        }
        else if (newEnemyShip.equals("R")) {
            return new RocketEnemyShip();
        }
        else if (enemyShip.equals("B")) {
            return new BigUfoEnemyShip();
        }
        else {
            return null;
        }

    }
}

/**
 * Jak to robić dobrze
 */
class EnemyShipTestGoodExample {
    public static void main(String[] args) {
        EnemyShipFactory shipFactory = new EnemyShipFactory();
        EnemyShip enemyShip = null;

        Scanner scanner = new Scanner(System.in);
        String enemyShipOption = "";
        System.out.println("What type of ship? U/R");
        if (scanner.hasNextLine()) {
            enemyShipOption = scanner.nextLine();
            enemyShip = shipFactory.makeEnemyShip(enemyShipOption);
        }

        doStuffEnemy(enemyShip);
    }

    private static void doStuffEnemy(EnemyShip anEnemyShip) {
        anEnemyShip.displayEnemyShip();
        anEnemyShip.followHeroShip();
        anEnemyShip.enemyShipShoots();
    }
}
