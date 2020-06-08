package klasyIMetody;

/**
 * Weryfikacja instancji
 * Dzięki refleksji i zamiennie metodzie instanceof możemy w łatwy
 * sposób zweryfikować, czy instancja danej klasy została zdeklarona,
 * a tym samym sprawdzić ile razy.
 */
public class WeryfikacjaInstancji
{
    static class Przyklady {
        public static void main(String[] args) {
            // Instancje na potrzeby przykładów
            Samochod samochod = new Samochod("Syrena", "kosc sloniowa", 4, "sedan", 4);
            Rower rower = new Rower("Giant", "niebieski", 2, 21, "tarczowe");

            // instaceof zwraca nam informację, czy dana instancja dla danej klasy została utworzona
            // W przypadku instance of brane są pod uwagę również klasy nadrzędne
            boolean rowerToRower = rower instanceof Rower; // true
            // Błąd kompatybilności typu:
            // boolean rowerToSamochod = rower instanceof Samochod; // false
            boolean rowerToPojazd = rower instanceof Pojazd; // true

            // Refleksja zwraca nam informację, czy dana instancja dla danej klasy została utworzona
            // W przypadku refleksji mamy informację dotyczącą wyłącznie konrektnej klasy
            boolean rowneRower = rower.getClass() == Rower.class; // true
            // Błąd kompatybilności typu:
            // boolean rownePojazd = rower.getClass() == Pojazd.class;   // false
            // Błąd kompatybilności typu:
            // boolean rowneSamochod = rower.getClass() == Samochod.class; // false
        }
    }


    /**
     * Zadanie 1
     * Sprawdź instancje
     */
    static class Zadanie1 {
        public static void main(String[] args) {
            Pojazd pojazd1 = new Pojazd("EMP", "w", 23);
            Pojazd pojazd2 = new Pojazd("EMP2", "w2", 2);
            Pojazd pojazd3 = new Samochod("EMP3", "w3", 44, "asf", 5);
            Pojazd[] pojazdy = {pojazd1, pojazd2, pojazd3};
            determineWhoIsWho(pojazdy);
        }

        public static void determineWhoIsWho(Pojazd[] pojazdy) {
            for (Pojazd pojazd : pojazdy) {
                if (pojazd.getClass() == Samochod.class)
                    System.out.println("Samochod");
                else if (pojazd.getClass() == Rower.class)
                    System.out.println("Rower");
                else
                    System.out.println("Pojazd");
            }
        }
    }
}

// Klasy do przykładów
class Pojazd {

    protected String marka;
    protected String kolor;
    protected int iloscKol;

    public Pojazd(String marka, String kolor, int iloscKol) {
        this.marka = marka;
        this.kolor = kolor;
        this.iloscKol = iloscKol;
    }

    public String getMarka() {
        return marka;
    }

    public String getKolor() {
        return kolor;
    }

    public int getIloscKol() {
        return iloscKol;
    }
}

class Samochod extends Pojazd {

    private String typNadwozia;
    private int iloscOsob;

    public Samochod(String name, String email, int experience, String typNadwozia, int iloscOsob) {
        super(name, email, experience);
        this.typNadwozia = typNadwozia;
        this.iloscOsob = iloscOsob;
    }

    public String getTypNadwozia() {
        return typNadwozia;
    }

    public int getIloscOsob() {
        return iloscOsob;
    }
}

class Rower extends Pojazd {

    private int iloscPrzezutek;
    private String rodzajHamulca;

    public Rower(String name, String email, int experience, int iloscPrzezutek, String rodzajHamulca) {
        super(name, email, experience);
        this.iloscPrzezutek = iloscPrzezutek;
        this.rodzajHamulca = rodzajHamulca;
    }

    public int IloscPrzezutek() {
        return iloscPrzezutek;
    }

    public String getRodzajHamulca() {
        return rodzajHamulca;
    }
}