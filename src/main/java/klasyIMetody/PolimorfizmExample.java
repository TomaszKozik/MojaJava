package klasyIMetody;

public class PolimorfizmExample {

    public static void main(String[] args) {
        new SamochodOsobowy(1);
    }

    public static class Samochod {
        private int count;

        public Samochod(int count) {
            this.count = count;
            ilosc();
        }

        private void ilosc() {
            System.out.println("Samochod: " + count);
        }
    }

    public static class SamochodOsobowy extends Samochod {
        private int count;

        public SamochodOsobowy(int count) {
            super(count);
            this.count = count;
            ilosc();
        }

        protected void ilosc() {
            System.out.println("Samochod osobowy: " + count);
        }
    }
}
