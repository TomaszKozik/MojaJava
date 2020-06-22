package dataForExamples;

public class Rower extends Pojazdy {

    public int iloscPrzerzutek;

    public Rower(String marka, String model, String kolor, int przebieg, int iloscPrzerzutek) {
        super(marka, model, kolor, przebieg);
        this.iloscPrzerzutek = iloscPrzerzutek;
    }

    public int getIloscPrzerzutek() {
        return iloscPrzerzutek;
    }

    public void setIloscPrzerzutek(int iloscPrzerzutek) {
        this.iloscPrzerzutek = iloscPrzerzutek;
    }
}
