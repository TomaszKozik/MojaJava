package dataForExamples;

public class Silnik {

    public String rodzajPaliwa;
    public int pojemnoscSkokowa;

    public Silnik(String rodzajPaliwa, int pojemnoscSkokowa) {
        this.rodzajPaliwa = rodzajPaliwa;
        this.pojemnoscSkokowa = pojemnoscSkokowa;
    }

    public String getRodzajPaliwa() {
        return rodzajPaliwa;
    }

    public void setRodzajPaliwa(String rodzajPaliwa) {
        this.rodzajPaliwa = rodzajPaliwa;
    }

    public int getPojemnoscSkokowa() {
        return pojemnoscSkokowa;
    }

    public void setPojemnoscSkokowa(int pojemnoscSkokowa) {
        this.pojemnoscSkokowa = pojemnoscSkokowa;
    }
}
