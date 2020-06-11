package DataForExamples.enums;

public enum RodzajPaliwa {

    BENZYNA("benzyna");

    private String rodzajPaliwa;

    RodzajPaliwa(String rodzajPaliwa) {
        this.rodzajPaliwa = rodzajPaliwa;
    }

    public String getRodzajPaliwa() {
        return rodzajPaliwa;
    }
}
