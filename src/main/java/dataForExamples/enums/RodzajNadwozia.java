package dataForExamples.enums;

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

    public static RodzajNadwozia getRodzajNadwozia(String rodzajNadwozia) {
        for (RodzajNadwozia rodzaj: values()) {
            if (rodzajNadwozia.equals(rodzaj.rodzajNadwozia)) {
                return rodzaj;
            }
        }
        return null;
    }

}
