package dataForExamples.enums;

public enum Kolory {

    BEZOWY("beżowy"),
    CZARNY("czarny"),
    CZERWONY("czerwony"),
    NIEBIESKI("niebieski"),
    ZIELONY("zielony");

    private String kolor;

    Kolory(String kolor) {
        this.kolor = kolor;
    }

    public String getKolor() {
        return kolor;
    }
}
