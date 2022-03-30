package klasyIMetody;

/**
 * Intefejsy stanowią pewien kontrakt, który każda implementująca go klasa musi spełnić,
 * czyli musi zawierać metody, które ten interfejs narzuca. Np. jeżeli podstawową funkcjonalnością
 * zegarka, telefonu, laptopa jest alarm, to dzięki implementacji interesju posiadającego metodę
 * 'alarm', każdy z tych obiektów będzie go musiał posiadać.
 *
 * Intefejsy deklaruje się za pomocą 'interface' w przeciwieństwie do klas 'class',
 * czy typów wyliczeniowych 'enum1.
 *
 * Interfejs nie może zawierać pól (tylko stałe ), konstruktorów ani niepublicznych metod abstrakcyjnych.
 *
 * Żródło wiedzy: https://hyperskill.org/learn/step/3615
 */
interface AlarmClock {

    /**
     * Przykład stałej publicznej, nie jest ona polem.
     */
    String DEFAULT_ALARM_TIME = "07:00";

    /**
     * Przykład podstawowej metody interfesju, która musi być implementowana przez klasy
     * Jest ona abstrakcyjna bezimplementacji  (słowo kluczowe `abstract` jest tutaj niewymagane)
     * Nie może ona posiadać ciała, za to może mieć argumenty.
     * Są domyślnie publiczne (słowo kluczonwe `public` jest tutaj niewymagane)
     * Jeśli modyfikatory nie zostaną określone po zadeklarowaniu metody,
     * jej parametry będą domyślnie abstrakcją publiczną.
     */
    void alarm();

    /**
     * To zwykła metoda statyczna
     * Głównym celem metod statycznych interfejsu jest zdefiniowanie funkcjonalności użytkowej,
     * która jest wspólna dla wszystkich klas implementujących interfejs.
     * Pomagają uniknąć powielania kodu i tworzenia dodatkowych klas narzędziowych.
     */
    static void displayTime() {
        System.out.println("Metoda statyczna w interfejsie: displayTime");
    }

    /**
     * Można ją nadpisać w klasach. Nie musi być implementowana, a przez to nadpisywana
     */
    default void metodaDomyslnaInterfejsu() {
        System.out.println("Metoda domyślna w interfejsie");
    }

    /**
     * Może być używana do dekompozycji medot domyślnych
     */
    private void metodaPrywatna() {
        System.out.println("Metoda prywatna w interfejsie");
    }
}

class Watch implements AlarmClock {

    /**
     * Metoda alarma, którą narzucił interface AlarmClock
     */
    @Override
    public void alarm() {
        System.out.println("Pobudka z zegarka!!");
    }

    @Override
    public void metodaDomyslnaInterfejsu() {
        System.out.println("Metoda domyślna interefjsu - nadpisana");
    }
}

class Phone implements AlarmClock {

    /**
     * Metoda alarma, którą narzucił interface AlarmClock
     */
    @Override
    public void alarm() {
        System.out.println("Pobudka z teefonu!!");
    }
}

class Interfejsy {
    public static void main(String args[]) {

        /**
         * Ważną zaletą interfejsów jest to, że można ich używać, jako typów.
         * Jest to kolejny sposób wspierania polimorfizmu. W wielu przypadkach ważniejsza jest wiedza o tym,
         * co obiekt może zrobić, a nie jak robi to, co robi. Jest to powód, dla którego interfejsy
         * są powszechnie używane do deklarowania typu zmiennej.
         */
        AlarmClock watch = new Watch();
        AlarmClock phone = new Phone();

        /**
         * Wywołanie stałej interfejsu
         * Można to zrobić bezpośrednio z interfejsu lub pośrednio przez klasy implementujące
         */
        System.out.println(AlarmClock.DEFAULT_ALARM_TIME);
        System.out.println(watch.DEFAULT_ALARM_TIME);

        /**
         * Wywołanie metody alarm
         */
        watch.alarm();
        phone.alarm();

        /**
         * Wywołanie metody statycznej interfejsu
         * Wywołuje się ją bezpośrednio z interfesju, z poziomu klas implementujących nie można.
         */
        AlarmClock.displayTime();

        /**
         * Wywołanie metody domyślnej
         * Można ja wywołać odnosząc się jedynie poprzez klasę implementującą
         */
        watch.metodaDomyslnaInterfejsu();
        phone.metodaDomyslnaInterfejsu();
    }
}
