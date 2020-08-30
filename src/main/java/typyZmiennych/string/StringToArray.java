package typyZmiennych.string;

import java.util.*;

/**
 * Zastosowanie: Gdy potrzebujemy operować na String'u, jak na tablicy znaków
 *
 */
public class StringToArray {

    // Przykładowe parametry i argumenty, na których będą wykonane poniższe operacje
    private static final char[] chars = {'S', 'y', 'r', 'e', 'n', 'a'};
    private static final String syrena = "Syrena";

    // Wywołanie przykładów
    public static void main(String[] args) {

        System.out.println("---- Budowanie String'a z tablicy znaków char {'S', 'y', 'r', 'e', 'n', 'a'} za pomocą metody .valueOf() ----");
        System.out.println(getStringFromCharArrayByValueOf());       // Syrena

        System.out.println("---- Budowanie stringa z tablicy znaków char {'S', 'y', 'r', 'e', 'n', 'a'} za pomocą kontruktora ----");
        System.out.println(getStringFromCharArrayByConstructor());  // Syrena

        System.out.println("---- Rozbicie String'a 'Syrena' na tablicę znaków char ----");
        System.out.println(getCharArrayFromString().length);        // 6 - ilość liter tablicy znaków {'S', 'y', 'r', 'e', 'n', 'a'}

        System.out.println("---- Rozbicie String'a 'Syrena' na tablicę znaków String ----");
        System.out.println(getStringArrayFromString().length);      // 6 - ilość liter tablicy znaków {"S", "y"', "r", "e", "n", "a"}

        System.out.println("---- Iterowanie po stringu ----");
        stringIteration();

        System.out.println("---- Sumwa wartosci dziesiętnej dla String 'Syrena' ----");
        System.out.println(sumOfString());                          // 626
    }

    /**
     * Budowanie String'a z tablicy znaków char za pomocą metody .valueOf()
     * String.valueOf(char[] char)
     *
     * @return String z tablicy znaków
     */
    private static String getStringFromCharArrayByValueOf() {
        return String.valueOf(chars);           // Syrena
    }

    /**
     * Budowanie String'a z tablicy znaków char za pomocą konstruktora
     * String.valueOf(char[] char)
     *
     * @return String z tablicy znaków
     */
    private static String getStringFromCharArrayByConstructor() {
        return new String(chars);              // Syrena
    }

    /**
     * Rozbicie String'a na tablicę znaków char
     * .toCharArray()
     *
     * @return Zwrócona tablica char z String'a 'Syrena'
     */
    private static char[] getCharArrayFromString() {
        return syrena.toCharArray();        // {'S', 'y', 'r', 'e', 'n', 'a'}
    }

    /**
     * Rozbicie String'a na tablicę znaków String
     * .split("")
     *
     * @return Zwrócona tablica String'ów z String'a 'Syrena'
     */
    private static String[] getStringArrayFromString() {
        return syrena.split("");        // {"S", "y", "r", "e", "n", "a"}
    }

    /**
     * Iterowanie po stringu Za pomocą pętli for oraz .charAt(int i)
     *
     */
    private static void stringIteration() {for (int i = 0; i < syrena.length(); i++) {
        System.out.print(syrena.charAt(i) + " ");   // S y r e n a
    }}

    /**
     * Suma wartości dziesiętnej znaków ASCII dla String'a
     *
     * @return Sumwa wartosci dziesiętnej dla String 'Syrena'
     */
    private static int sumOfString() {
        System.out.println("'S' ma wartość 83, 'y' ma wartość 121, 'r' ma wartość 114, 'e' ma wartość 101, 'n' ma wartość 110, 'a' ma wartość 97");
        return syrena.chars().sum(); //626
    }

    /**
     * Przykład zadania na wyszukanie najdłuższego słowa z zdania
     */
    static class LongestWord {
        public static void main(String[] args) {
            String sentence = "Syrena 105L o kolorze kości słoniowej";
            String longestWord = Arrays.stream(sentence.split(" "))
                    .max(Comparator.comparingInt(String::length))
                    .get();
            System.out.println(longestWord); // 'słoniowej'
        }
    }

    /**
     * Przykład zadania na weryfikację, czy pierwsza połowa liczby będącej String'iem jest równa drugiej połowie
     * np. 12344321 - prawda
     *     125322 - nie prawda
     */
    static class LeftIsEqualRight {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String number = scanner.nextLine();
            int sumFirstPart = number.substring(0, number.length() / 2).chars().sum();
            int sumSecondPart = number.substring(number.length() / 2).chars().sum();
            System.out.println((sumFirstPart == sumSecondPart) ? "YES" : "NO");
        }
    }
}
