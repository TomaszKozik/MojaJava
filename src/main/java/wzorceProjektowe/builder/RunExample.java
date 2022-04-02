package wzorceProjektowe.builder;

/**
 * Wzorzec Builder
 * Służy do elastycznego budowania obiektów.
 * Ogranicza ilość konstruktorów
 * Wykorzystuje Fluent interface, dzięki czemu kod jest czytelniejszy.
 */
class FirstAidKit {
    protected int bandage;
    protected int scissors;
    protected int gloves;
    protected int slices;

    public FirstAidKit() {}

    public FirstAidKit(int bandage, int scissors, int var3, int slices) {
        this.bandage = bandage;
        this.scissors = scissors;
        this.gloves = var3;
        this.slices = slices;
    }

    public int getBandage() {
        return bandage;
    }

    public int getScissors() {
        return scissors;
    }

    public int getGloves() {
        return gloves;
    }

    public int getSlices() {
        return slices;
    }

    @Override
    public String toString() {
        return "FirstAidKit{" +
                "bandage=" + bandage +
                ", scissors=" + scissors +
                ", gloves=" + gloves +
                ", slices=" + slices +
                '}';
    }
}

class FirstAidKidBuilder extends FirstAidKit {

    public FirstAidKidBuilder() {
        super();
    }

    public FirstAidKidBuilder(int bandage, int scissors, int var3, int slices) {
        super(bandage, scissors, var3, slices);
    }

    public FirstAidKidBuilder builder() {
        return this;
    }

    public FirstAidKidBuilder addBandage(int bandage) {
        this.bandage = bandage;
        return this;
    }
    public FirstAidKidBuilder addScissors(int scissors) {
        this.scissors = scissors;
        return this;
    }
    public FirstAidKidBuilder addGloves(int gloves) {
        this.gloves = gloves;
        return this;
    }
    public FirstAidKidBuilder addSlices(int slices) {
        this.slices = slices;
        return this;
    }

    public FirstAidKit build() {
        return new FirstAidKit(bandage, scissors, gloves, slices);
    }
}

public class RunExample {
    public static void main(String[] args) {
        FirstAidKit firstAidKit1 = new FirstAidKidBuilder()
                .builder()
                .addBandage(1)
                .addGloves(3)
                .build();
        System.out.println(firstAidKit1);

        FirstAidKit firstAidKit2 = new FirstAidKidBuilder()
                .builder()
                .addGloves(1)
                .addBandage(2)
                .addScissors(1)
                .addSlices(10)
                .builder();
        System.out.println(firstAidKit2);
    }
}