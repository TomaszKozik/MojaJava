package klasyIMetody.refleksje;

import dataForExamples.Samochod;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Refleksja to proces uzyskiwania dostępu i modyfikowania aplikacji w czasie wykonywania.
 * Dzięki refleksji możesz np. wyświetlić wszystkie nazwy i typy klas, zmiennych, metod,
 * konstruktorów i ich elementów. Możesz je również modyfikować
 *
 * Dzięki refleksji wszystkie pola klas, nawet prywatne, stają się widoczne,
 * dzięki czemu można je zapisać w pliku zewnętrznym. Często jest to wykorzystywane
 * w serializacji obiektów
 *
 * Dzięki refleksji jest możliwa introspekcja kodu w celu wykrycia adnotacji.
 * Tak właśnie przetwarzane są prawie wszystkie adnotacje w Javie.
 *
 * Źródło: https://hyperskill.org/learn/step/3609
 * Źródło: https://hyperskill.org/learn/step/8108
 */
public class RefleksjePrzyklady {

    public static void main(String[] args) {
        PrzykladyPobieraniaDanych();
    }

    /**
     * Metody zwracające - to metody dzięki którym zwracane są dane dotyczące klas i ich ciał.
     * Na ich podstawie możemy wyciągać i modyfikować zmienne, metody, konstruktory
     */
    public static void MetodyZwracajace() throws ClassNotFoundException {
        // Metody zwracające klasy - na podstawie nazwy klasy, jako String
        // Wymaga throws ClassNotFoundException
        Class studentClass = Class.forName("Samochody");

        // Metody zwracające klasy - dla klasy nadrzędnej
        String.class.getSuperclass();

        // Metody zwracające klasy - zwraca wszystko z danej i nadrzędnych klas, interfejsów, enum'ów
        String.class.getClasses();

        // Metody zwracające klasy - zwraca wszystko z danej konkretnej klasy, interfejsu, enuma
        String.class.getDeclaredClasses();
    }

    /**
     * Przykłady pobiernia danych
     */
    public static void PrzykladyPobieraniaDanych() {
        Samochod samochody = new Samochod();
        Class samochod = samochody.getClass();

        // Pobieranie danych o kontruktorze danej klasy
        Constructor[] declaredConstructors = samochod.getDeclaredConstructors();
        // Pobieranie danych o kontruktorze danej klasy i nadrzędnych
        Constructor[] constructors = samochod.getConstructors();
        // Pobieranie danych o polach danej klasy
        Field[] declaredFields = samochod.getDeclaredFields();
        // Pobieranie danych o polach danej klasy i nadrzędnych
        Field[] fields = samochod.getFields();
        // Pobieranie danych o metodach danej klasy
        Method[] declaredMethods = samochod.getDeclaredMethods();
        // Pobieranie danych o metodach danej klasy i nadrzędnych
        Method[] methods = samochod.getMethods();

        for(Constructor dc : declaredConstructors) {
            System.out.println("Zdeklarowany konstruktor danej klasy: " + dc.getName());
        }
        for (Constructor c : constructors) {
            System.out.println("Zdeklarowany konstruktor danej klasy i nadrzędnych: " + c.getName());
        }
        for (Field df : declaredFields) {
            System.out.println("Zdeklarowane pole danej klasy: " + df.getName());
        }
        for (Field f : fields) {
            System.out.println("Zdeklarowane pole danej klasy i nadrzędnych: " + f.getName());
        }
        for (Method dm : declaredMethods) {
            System.out.println("Zdeklarowana metoda danej klasy: " + dm.getName());
        }
        for (Method m : methods) {
            System.out.println("Zdeklarowana metoda danej klasy i nadrzędnych: " + m.getName());
        }


        // Istnieje poszerzenie pobierania informacji o modyfikatory dostępu
        // Źródło: https://hyperskill.org/learn/step/8104
        System.out.println("---- Pobieranie pełnych informacji o metodach ----");
        Field[] fieldsOfStudent = samochod.getDeclaredFields();
        for (Field field : fieldsOfStudent) {
            int modifiers = field.getModifiers(); // wymagana zmienna do możliwości określenia modyfikatora
            if (Modifier.isPublic(modifiers)) {
                System.out.print("public ");
            }
            if (Modifier.isProtected(modifiers)) {
                System.out.print("protected ");
            }
            if (Modifier.isPrivate(modifiers)) {
                System.out.print("private ");
            }
            if (Modifier.isStatic(modifiers)) {
                System.out.print("static ");
            }
            if (Modifier.isFinal(modifiers)) {
                System.out.print("final ");
            }

            System.out.print(field.getType() + " ");
            System.out.println(field.getName());
        }
    }
}
