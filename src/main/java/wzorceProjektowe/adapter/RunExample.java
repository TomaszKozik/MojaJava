package wzorceProjektowe.adapter;

/**
 * Wzorzec Adapter
 * Pozwala na pracę dwóch interfejsów niekompatybilnych ze sobą
 * Adapter pracuje, jak fizyczny adapter, przejściówka. Np. umożliwia Ci podłącznie
 * przewodu microUSB pod złącznie miniUSB.
 * Pozwala na używanie dostępnego interfejsu i adaptowanego interfejsu.
 * <p>
 * Źródło wiedzy: https://www.youtube.com/watch?v=qG286LQM6BU&list=PLF206E906175C7E07&index=13
 */


/**
 * Przykładowy interfejs pojazdu elektrycznego
 */
interface ElectricVehicle {
    void honk();

    void drive();

    void assignDriver(String driverName);
}

/**
 * Hulajnoga elektryczna implementująca funkcje pojazdu elektrycznego
 */
class ElectricScooter implements ElectricVehicle {

    @Override
    public void honk() {
        System.out.println("Electric scooter is horned");
    }

    @Override
    public void drive() {
        System.out.println("Electric scooter is driven");
    }

    @Override
    public void assignDriver(String driverName) {
        System.out.println("Driver is " + driverName);
    }
}

/**
 * Przykładowy interfejs pojazdu mechanicznego
 */
interface MechanicalVehicle {
    void ring();

    void ride();

    void assignCyclist(String driverName);
}

/**
 * Hulajnoga mechaniczna implementująca funkcje pojazdu mechanicznego
 */
class MechanicalScooter implements MechanicalVehicle {

    public void ring() {
        System.out.println("Mechanic scooter is rung");
    }

    public void ride() {
        System.out.println("Mechanic scooter is ridden");
    }

    public void assignCyclist(String driverName) {
        System.out.println("Cyclist is " + driverName);
    }
}

/**
 * Adapter, przejściówka umożliwiająca realizację zadań hulajnogi elektrycznej przez hulajnogę mechaniczną
 */
class MechanicalScooterAdapter implements ElectricVehicle {
    MechanicalScooter mechanicalScooter;

    // Konstrukor przyjmuje klasę adaptowaną
    public MechanicalScooterAdapter(MechanicalScooter mechanicalScooter) {
        this.mechanicalScooter = mechanicalScooter;
    }

    @Override
    public void honk() {
        mechanicalScooter.ring();
    }

    @Override
    public void drive() {
        mechanicalScooter.ride();
    }

    @Override
    public void assignDriver(String driverName) {
        mechanicalScooter.assignCyclist(driverName);
    }
}

public class RunExample {
    public static void main(String[] args) {
        ElectricScooter electricScooter = new ElectricScooter();
        MechanicalScooter mechanicalScooter = new MechanicalScooter();
        ElectricVehicle mechanicalScooterAdapter = new MechanicalScooterAdapter(mechanicalScooter);

        System.out.println("Mechanical scooter");
        mechanicalScooter.assignCyclist("Paul");
        mechanicalScooter.ride();
        mechanicalScooter.ring();

        System.out.println("---------");
        System.out.println("Electric scooter");
        electricScooter.assignDriver("Frank");
        electricScooter.drive();
        electricScooter.honk();

        // Wynik jest podobny do mechanicalScooter, lecz funkcje są wykonywane przez adapter
        System.out.println("---------");
        System.out.println("Mechanical scooter adapter");
        mechanicalScooterAdapter.assignDriver("Mark");
        mechanicalScooterAdapter.drive();
        mechanicalScooterAdapter.honk();
    }
}