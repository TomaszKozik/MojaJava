package klasyIMetody;

/**
 * Źródło wiedzy: https://hyperskill.org/learn/step/3585
 */
public class Dziedziczenie {

    public static void main(String args[]) {

        // nowy obiekt Osoba jest referencją klasy Osoba
        Osoba osoba = new Osoba();
        // nowy obiekt Pasazer jest referencją klasy Pasazer
        Pasazer pasazer = new Pasazer();
        // nowy obiekt Kierowca jest referencją klasy Kierowca
        Kierowca kierowca = new Kierowca();

        // nowy obiekt Pasazer jest referencją klasy Osoba
        Osoba pasazer2 = new Pasazer();
        // nowy obiekt Kierowca jest referencją klasy Osoba
        Osoba kierowca2 = new Kierowca();

        // nowy obiekt Pasazer nie może być referencją klasy Kierowca, gdyż jest równorzędna klasą
        // Kierowca whoIsIt = new Pasazer();
        // nowy obiekt Osoba nie może być referencją klasy Kierowca, gdyż jest nadrzędną klasą nad Kierowca
        // Kierowca client = new Osoba();

        // nowy obiekt Kierowca jest referencją klasy Osoba
        Osoba kierowca3 = new Kierowca();
        // wywowałanie metody .setImie z klasy Osoba
        kierowca3.setImie("Ginger R. Lee");
        // wywowałanie metody .setRokUrodzenia z klasy Osoba
        kierowca3.setRokUrodzenia(1980);
        // nieprawidłowe wywołanie metody .setRokUzyskaniaPrawaJazdy, gdyż pracujemy
        // na referencji klasy Osoba, która nie zawiera takiej metody, ani jej klasa nadrzędna (Object)
        // kierowca3.setRokUzyskaniaPrawaJazdy(30000);

        // nowy obiekt Pasazer jest referencją klasy Osoba
        Osoba pasazer3 = new Pasazer();
        // poprawne rzutowanie obiekru pasazer3 na klasę rodzimą
        Pasazer pasazerAgain = (Pasazer) pasazer3;
        // niepoprawne rzutowanie obiekru pasazer3 na klasę Kierowca
        // obiekt ten nie ma pochodzenia klasy Kierowca
        // Kierowca employee = (Kierowca) pasazer3;

        // Możliwe wykorzystanie odniesienia klas podstawowych
        // Klasa Osoba może zbierać to tablicy elementów wszystkie obiekty
        // realizowane przez siebie i klasy podrzędne
        Osoba kierowca4 = new Kierowca();
        kierowca4.setImie("Ginger R. Lee");
        Pasazer pasazer4 = new Pasazer();
        pasazer4.setImie("Pauline E. Morgan");
        Kierowca kierowca5 = new Kierowca();
        kierowca5.setImie("Lawrence V. Jones");
        Osoba[] osobaWSamochodzies = {osoba, pasazer, kierowca};
    }
}

class Osoba {

    protected String imie;
    protected int rokUrodzenia;
    protected String adres;

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setRokUrodzenia(int rokUrodzenia) {
        this.rokUrodzenia = rokUrodzenia;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }
}

class Pasazer extends Osoba {

    protected String numerTelefonu;
}

class Kierowca extends Osoba {

    protected Integer rokUzyskaniaPrawaJazdy;

    public void setRokUzyskaniaPrawaJazdy(Integer rokUzyskaniaPrawaJazdy) {
        this.rokUzyskaniaPrawaJazdy = rokUzyskaniaPrawaJazdy;
    }
}