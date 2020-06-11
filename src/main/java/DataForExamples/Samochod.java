package DataForExamples;

public class Samochod extends Pojazdy {

    public double spalanie;
    private String nrRejestracyjny;
    public Nadwozie Nadwozie;
    public Silnik Silnik;

    public Samochod(String marka, String model, String kolor, int przebieg, double spalanie, String kategoria, String rodzaj, int iloscDrzwi, int iloscMiejsc, String rodzajPaliwa, int pojemnoscSkokowa) {
        super(marka, model, kolor, przebieg);
        this.spalanie = spalanie;
        Nadwozie = new Nadwozie(kategoria, rodzaj, iloscDrzwi, iloscMiejsc);
        Silnik = new Silnik(rodzajPaliwa, pojemnoscSkokowa);
    }

    public Samochod() {
        super();
    };

    public double getSpalanie() {
        return spalanie;
    }

    public void setSpalanie(double spalanie) {
        this.spalanie = spalanie;
    }

    private String getNrRejestracyjny() {
        return nrRejestracyjny;
    }

    private void setNrRejestracyjny(String nrRejestracyjny) {
        this.nrRejestracyjny = nrRejestracyjny;
    }

    public DataForExamples.Nadwozie getNadwozie() {
        return Nadwozie;
    }

    public void setNadwozie(DataForExamples.Nadwozie nadwozie) {
        Nadwozie = nadwozie;
    }

    public DataForExamples.Silnik getSilnik() {
        return Silnik;
    }

    public void setSilnik(DataForExamples.Silnik silnik) {
        Silnik = silnik;
    }
}
