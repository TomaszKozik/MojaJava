package string;

import java.util.*;

/**
 * Zastosowanie: Gdy potrzebujemy operować na String'u, jak na tablicy znaków
 *
 */
public class StringToArray {

    static class Przyklady {
        public static void main(String[] args) {

            /*
              Budowanie String'a z tablicy znaków char
              String.valueOf(char[] char)
             */
            System.out.println("---- Budowanie String'a z tablicy znaków char {'S', 'y', 'r', 'e', 'n', 'a'} ----");
            char[] chars = {'S', 'y', 'r', 'e', 'n', 'a'};
            String stringFromChars = String.valueOf(chars);
            System.out.println("Zbudowany string to:");
            System.out.println(stringFromChars); // 'Syrena'

            /*
              Budowanie String'a z tablicy znaków char - drugi sposób, za pomocą konstruktora
              new String(char[] char)
             */
            System.out.println("---- Budowanie stringa z tablicy znaków char {'S', 'y', 'r', 'e', 'n', 'a'} - drugi sposób ----");
            String theSameString = new String(chars); // "Syrena"
            System.out.println("Zbudowany string to:");
            System.out.println(theSameString); // 'Syrena'

            /*
              Rozbicie String'a na tablicę znaków char
              .toCharArray()
             */
            System.out.println("---- Rozbicie String'a 'Syrena' na tablicę znaków char ----");
            String syrena = "Syrena";
            char[] charsFromString = syrena.toCharArray(); // { 'A', 'B', 'C', 'D', 'E', 'F' }

            /*
              Rozbicie String'a na tablicę znaków String'ów
              .split("")
             */
            System.out.println("---- Rozbicie strina 'Syrena' na tablicę znaków char ----");
            String[] parts = syrena.split(""); // {"S", "y", "r", "e", "n", "a"}

            /*
              Iterowanie po stringu
              Za pomocą pętli for oraz .charAt(int i)
             */
            System.out.println("---- Iterowanie po stringu ----");
            System.out.println("Zinterowany string to: ");
            for (int i = 0; i < syrena.length(); i++) {
                System.out.print(syrena.charAt(i) + " "); // S y r e n a
            }

            /*
              Liczenie sumy wartości dziesiętnej znaków ASCII
             */
            System.out.println("---- Liczenie sumy wartości dziesiętnej znaków ASCII ----");
            System.out.println();
            String syrena2 = "Syrena";
            System.out.println("'S' ma wartość 83, 'y' ma wartość 121, 'r' ma wartość 114, 'e' ma wartość 101, 'n' ma wartość 110, 'a' ma wartość 97");
            int suma = syrena2.chars().sum(); //
            System.out.println(suma); //626

        }
    }


    /**
     * Najdłuższe słowo
     * Wybranie najdłuższego słowa z zdania
     */
    static class Zadanie1 {
        static class Main {
            public static void main(String[] args) {
                String syrena = "Syrena 105L o kolorze kości słoniowej";
                String longest = Arrays.stream(syrena.split(" "))
                        .max(Comparator.comparingInt(String::length))
                        .get();
                System.out.println(longest); // 'słoniowej'
            }
        }
    }

    /**
     * Sprawdzamy, czy pierwsza połowa liczby będącej String'iem jest równa drugiej połowie
     * np. 12344321 - prawda
     *     125322 - nie prawda
     */
    static class Zadanie2 {
        static class Main {
            public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                String number = scanner.nextLine();
                int sumFirstPart = number.substring(0, number.length() / 2).chars().sum();
                int sumSecondPart = number.substring(number.length() / 2).chars().sum();
                System.out.println((sumFirstPart == sumSecondPart) ? "YES" : "NO");
            }
        }
    }
}
