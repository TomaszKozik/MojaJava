package klasyIMetody.refleksje;

class Samochody_KlasaDoPrzykladow {
    public String marka;
    public String model;
    public int wiek;
    protected String paliwo;
    private String rodzajSilnika;
    private String ukladZawieszenia;

    Samochody_KlasaDoPrzykladow(){
    }

    public Samochody_KlasaDoPrzykladow(String marka, String model){
        this.marka= marka;
        this.model= model;
    }

    private String jakasPrywatnaMetodya(String ukladZawieszenia){
        return ukladZawieszenia;
    }

    public void jakasPublicznaMetoda(String ukladZawieszenia) {
        ukladZawieszenia = jakasPrywatnaMetodya(ukladZawieszenia);
        this.ukladZawieszenia = ukladZawieszenia;
    }
}
