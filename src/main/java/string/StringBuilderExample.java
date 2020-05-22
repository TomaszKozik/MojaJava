package string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * StringBuilder przyśpiesza program, gdy wykonujemy wiele operacji na stringach
 *
 * @see https://hyperskill.org/learn/step/3812
 */
public class StringBuilderExample {

    static class Konstuktor {
        public static void main(String[] args) {
            // Poniższa linijka jest równoznaczna z String sb = "Hello"
            StringBuilder sb = new StringBuilder("Hello!");
            System.out.println(sb); // "Hello!"
        }
    }

    /**
     * Dłogść to rzeczywista liczba znaków
     * Pojemnosć to ilość pamięci dostępnej dla nowo wstawionych znaków, po przekroczeniu której
     * nastąpi nowy przydział. Pojemność jest częścią wewnętrznej reprezentacji, StringBuildera
     * jej wartość będzie się dynamicznie zmieniać
     */
    static class DlugoscPojemnosc {
        public static void main(String[] args) {
            StringBuilder sb = new StringBuilder(); // initial capacity is 16

            System.out.println(sb.length());   // 0
            System.out.println(sb.capacity()); // 16

            sb.append("A very long string");

            System.out.println(sb.length());   // 18
            System.out.println(sb.capacity()); // 34
        }
    }

    static class WazneMetody {
        public static void main(String[] args) {
            System.out.println("---- int length()zwraca długość (liczbę znaków) jak dla zwykłego ciągu. Ta metoda nie modyfikuje obiektu ----");
            StringBuilder sb = new StringBuilder("I use Java");
            System.out.println(sb);
            System.out.println(sb.length()); // 10

            System.out.println("---- char charAt(int index)zwraca znak znajdujący się pod określonym indeksem. Pierwszy znak ma indeks 0. Ta metoda nie modyfikuje obiektu ----");
            StringBuilder sb2 = new StringBuilder("I use Java");
            System.out.println(sb2);
            System.out.println(sb2.charAt(0)); // 'I'
            System.out.println(sb2.charAt(6)); // 'J'

            System.out.println("---- void setCharAt(int index, char ch)ustawia znak znajdujący się pod określonym indeksem na ch ----");
            StringBuilder sb3 = new StringBuilder("start");
            System.out.println(sb3);
            sb3.setCharAt(1, 'm');
            System.out.println(sb3); // "smart"

            System.out.println("---- StringBuilder deleteCharAt(int index) usuwa znak z określonej pozycji. ----");
            StringBuilder sb4 = new StringBuilder("dessert");
            System.out.println(sb4);
            sb4.deleteCharAt(2);
            System.out.println(sb4); // "desert"

            System.out.println("---- StringBuilder append(String str)konkatenuje podany ciąg z końcem wywołującego obiektu StringBuilder. Istnieje również kilka przeciążeń, aby przyjmować prymitywne typy, a nawet tablice znaków. ----");
            StringBuilder sb5 = new StringBuilder("abc");
            System.out.println(sb5);
            sb5.append("123");
            System.out.println(sb5); // "abc123"

            System.out.println("---- Możliwe jest także wielokrotne wywoływanie tej metody na tym samym obiekcie w tej samej instrukcji, ponieważ ta metoda zwraca ten sam zmodyfikowany obiekt. ----");
            StringBuilder messageBuilder = new StringBuilder(); // empty
            messageBuilder
                    .append("From: Kate@gmail.com\n")
                    .append("To: Max@gmail.com\n")
                    .append("Text: I lost my keys. ")
                    .append("Please, open the door!");
            System.out.println(messageBuilder);

            System.out.println("---- StringBuilder insert(int offset, String str)wstawia podany ciąg do istniejącego StringBuilderobiektu w danej pozycji. to jest przesunięcie. Metoda ma wiele przeciążeń dla różnych typów. ----");
            StringBuilder sb6 = new StringBuilder("I'm a programmer.");
            System.out.println(sb6);
            sb6.insert(6, "Java ");
            System.out.println(sb6); // I'm a Java programmer.

            System.out.println("---- StringBuilder replace(int start, int end, String str) zamienia podciąg z określonego indeksu ciągów (włącznie) na indeks końcowy (wyłączny) na dany ciąg.\n ----");
            StringBuilder sb7 = new StringBuilder("Let's use C#");
            System.out.println(sb7);
            sb7.replace(10,12,"Java");
            System.out.println(sb7); // Let's use Java

            System.out.println("---- StringBuilder delete(int start, int end) usuwa podciąg z indeksu początkowego (włącznie) do indeksu końcowego (wyłączny).\n ----");
            StringBuilder sb8 = new StringBuilder("Welcome");
            System.out.println(sb8);
            sb8.delete(0,3);
            System.out.println(sb8); // "come"

            System.out.println("---- StringBuilder reverse() powoduje zastąpienie tej sekwencji znaków odwrotnością sekwencji.\n ----");
            StringBuilder sb9 = new StringBuilder("2 * 3 + 8 * 4");
            System.out.println(sb9);
            sb9.reverse();
            System.out.println(sb9); // "4 * 8 + 3 * 2"
        }
    }

    // https://hyperskill.org/learn/step/3813
    static class Zadanie1 {
        public static String concatenateStringsWithoutDigits(String[] strings) {
            StringBuilder messageBuilder = new StringBuilder();
            for (String string : strings) {
                messageBuilder.append(string.replaceAll("\\d", ""));
            }
            return messageBuilder.toString();
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String[] strings = scanner.nextLine().split("\\s+");
            String result = concatenateStringsWithoutDigits(strings);
            System.out.println(result);
        }
    }
}
