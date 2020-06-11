package DataForExamples.enums;

public enum RodzajNadwozia {

    SEDAN("osobowe", "sedan"),
    FASTBACK("osobowe", "fastback"),
    COUPE("osobowe", "coupe"),
    HATCHBACK("osobowe", "hatchback"),
    SKRZYNIA("dostawcze","skrzynia"),
    PICKUP("dostawcze","pick-up");

    private String kategoria;
    private String rodzajNadwozia;

    RodzajNadwozia(String kategoria, String rodzajNadwozia) {
        this.kategoria = kategoria;
        this.rodzajNadwozia = rodzajNadwozia;
    }


    public String getKategoria() {
        return kategoria;
    }

    public String getRodzajNadwozia() {
        return rodzajNadwozia;
    }
}
