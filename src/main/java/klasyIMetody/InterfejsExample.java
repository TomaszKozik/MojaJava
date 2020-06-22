package klasyIMetody;

public class InterfejsExample {

    interface Interfejs {

        String STALA_STRING = "Stala interfejsu";

        // Metoda abstrakcyjna (poniższa) nie może mieć ciała. Może, a nie musi być opisana poprzez 'abstract'
        void metodaAbstrakcyjnaInterfejsu();

        static void metodaStatycznaInterfejsu() {
            System.out.println("Metoda statyczna w interfejsie");
        }

        default void metodaDomyslnaInterfejsu() {
            System.out.println("Metoda domyślna w interfejsie");
        }
    }

    static class KlasaImplementujacaInterface implements Interfejs {
        @Override
        public void metodaAbstrakcyjnaInterfejsu() {
            System.out.println("Nadpisanie metody instanceMethod()");
        }
    }

    public static void main(String args[]) {

        KlasaImplementujacaInterface instancjaKlasy = new KlasaImplementujacaInterface();

        // Wydrukowanie stałej interfejsu
        System.out.println(instancjaKlasy.STALA_STRING);  // Stala interfejsu

        // Wywołanie metody abstrakcyjnej interfejsu
        instancjaKlasy.metodaAbstrakcyjnaInterfejsu();    // Nadpisanie metody instanceMethod()

        // Wywołanie metody statycznej interfejsu
        // Można ja wywołać odnosząc się bezpośrednio do interfejsu
        Interfejs.metodaStatycznaInterfejsu();      // Metoda statyczna w interfejsie

        // Wywołanie metody abstrakcyjnej interfejsu
        // Można ja wywołać odnosząc się jedynie poprzez klasę implementującą
        instancjaKlasy.metodaDomyslnaInterfejsu();        // Metoda domyślna w interfejsie
    }
}
