package klasyIMetody;

/**
 * Konstruktory można tylko przeciążyć.
 */
public class PrzeciazenieKonstruktora {

    public static void main(String args[]) {
        new Samochod();					// Syrena 105L
        new Samochod("Fiat", "125P");	// Fiat 125P
    }

    static class Samochod {
        String marka;
        String model;

        public Samochod() {
            this.marka = "Syrena";
            this.model = "105L";
            System.out.println(marka + " " + model);
        }

        public Samochod(String name, String model) {
            this.marka = name;
            this.model = model;
            System.out.println(marka + " " + model);
        }
    }
}
