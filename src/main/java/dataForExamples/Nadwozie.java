package dataForExamples;

public class Nadwozie {

    public String kategoria;
    public String rodzaj;
    public int iloscDrzwi;
    public int iloscMiejsc;

    public Nadwozie(String kategoria, String rodzaj, int iloscDrzwi, int iloscMiejsc) {
        this.kategoria = kategoria;
        this.rodzaj = rodzaj;
        this.iloscDrzwi = iloscDrzwi;
        this.iloscMiejsc = iloscMiejsc;
    }

    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }

    public String getRodzaj() {
        return rodzaj;
    }

    public void setRodzaj(String rodzaj) {
        this.rodzaj = rodzaj;
    }

    public int getIloscDrzwi() {
        return iloscDrzwi;
    }

    public void setIloscDrzwi(int iloscDrzwi) {
        this.iloscDrzwi = iloscDrzwi;
    }

    public int getIloscMiejsc() {
        return iloscMiejsc;
    }

    public void setIloscMiejsc(int iloscMiejsc) {
        this.iloscMiejsc = iloscMiejsc;
    }
}
