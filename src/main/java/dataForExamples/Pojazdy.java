package dataForExamples;

public abstract class Pojazdy {

    protected String marka;
    protected String model;
    protected String kolor;
    protected int przebieg;

    public Pojazdy(String marka, String model, String kolor, int przebieg) {
        this.marka = marka;
        this.model = model;
        this.kolor = kolor;
        this.przebieg = przebieg;
    }

    public Pojazdy() {}

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getKolor() {
        return kolor;
    }

    public void setKolor(String kolor) {
        this.kolor = kolor;
    }

    public int getPrzebieg() {
        return przebieg;
    }

    public void setPrzebieg(int przebieg) {
        this.przebieg = przebieg;
    }
}
