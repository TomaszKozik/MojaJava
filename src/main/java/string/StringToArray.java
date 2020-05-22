package string;

import java.util.*;

public class StringToArray {

    /**
     * Zamiana tablicy znaków na stringi i odwrotnie
     */
    static class PrzyklaydNajprostsze {
        public static void main(String[] args) {
            // Tablica znaków na string
            char[] chars = {'A', 'B', 'C', 'D', 'E', 'F'};
            String stringFromChars = String.valueOf(chars); // "ABCDEF"
            System.out.println(stringFromChars);

            // 1. String na tablicę znaków
            char[] charsFromString = stringFromChars.toCharArray(); // { 'A', 'B', 'C', 'D', 'E', 'F' }
            String theSameString = new String(charsFromString); // "ABCDEF"
            System.out.println(theSameString);

            // 2. String na tablicę znaków
            String text = "Hello";
            String[] parts = text.split(""); // {"H", "e", "l", "l", "o"}
        }
    }

    static class IterowaniePoStringu {
        public static void main(String[] args) {
            String scientistName = "Isaac Newton";
            for (int i = 0; i < scientistName.length(); i++) {
                System.out.print(scientistName.charAt(i) + " "); // print the current character
            }
        }
    }

    // https://hyperskill.org/learn/step/2282
    static class Zadanie1 {
        static class Main {
            public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                String longest = Arrays.stream(scanner.nextLine().split(" "))
                        .max(Comparator.comparingInt(String::length))
                        .get();
                System.out.println(longest);
            }
        }
    }

    // https://hyperskill.org/learn/step/2282
    static class Zadanie3 {
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
