package typyZmiennych.string;

import java.util.Scanner;

//todo wrzucic na blog
/**
 * Zastosowanie:
 * 1. Przyśpieszenie działania programu, gdy konieczne jest
 * wykonywanie wielu operacji na stringach.
 * 2. Gdy potrzebujemy operować na stringach, jak na tablicy
 *
 * Source: https://hyperskill.org/learn/step/3812
 */
public class StringBuilderExample {

    static class OperacjeNaObiektachStringBuilder {
        public static void main(String[] args) {

            /*
              Zbudowanie Stringa w oparciu o StringBuilder
              Wykorzystujemy do tego konstruktor klasy StringBuilder
              new StringBuilder(String str)
             */
            System.out.println("---- Zbudowanie Stringa w oparciu o StringBuilder ----");
            StringBuilder sb = new StringBuilder("Syrena 105L");
            System.out.println("Utworzony string to:");
            System.out.println(sb); // Syrena 105L


            /*
              Pobranie długości Stringa
              Ta metoda nie modyfikuje obiektu
              .length()
             */
            System.out.println("---- Pobranie długości stringa ----");
            System.out.println("Długość stringa 'Syrena 105L' to:");
            System.out.println(sb.length()); // 16

            /*
              Zwrócenie znaku zgodnie z indeksem.
              Indeks liczymy o 0
              Ta metoda nie modyfikuje obiektu
              .charAt(int index)
             */
            System.out.println("---- Zwrócenie znaku zgodnie z indeksem ----");
            System.out.println("Indeks 0 dla stringa 'Syrena 105L' to: ");
            System.out.println(sb.charAt(0)); // 'S'
            System.out.println("Indeks 7 dla stringa 'Syrena 105L' to:");
            System.out.println(sb.charAt(7)); // '1'

            /*
              Zamiana znaku w ciągu względem indeksu
              .setCharAt(int index, char ch)
             */
            System.out.println("---- Zamiana znaku w ciągu względem indeksu ----");
            sb.setCharAt(6, '-');
            System.out.println("Zamieniono spację (indeks 6) na myślnik dla stringa 'Syrena 105L' Wynik to:");
            System.out.println(sb); // 'Syrena-105L
            sb.setCharAt(6, ' '); // 'Syrena 105 L'

            /*
              Usunięcie znaku z ciągu zgodnie z indeksem
              .deleteCharAt(int index)
             */
            System.out.println("---- Usunięcie znaku z ciągu zgodnie z indeksem ----");
            sb.deleteCharAt(10);
            System.out.println("Usunięto literę 'L' z Stringa 'Syrena 105L'. Wynik to:");
            System.out.println(sb); // 'Syrena 105'

            /*
              Dodanie nowego stringa z już istniejącym stringiem
              .append(String str)
             */
            System.out.println("---- Dodanie nowego stringa z już istniejącym stringiem  ----");
            sb.append("L");
            System.out.println("Dodano literę 'L' do stringa 'Syrena 105'. Wynik to:");
            System.out.println(sb); // 'Syrena 105L'

            /*
              Połączenie nowego stringa z już istniejącym stringiem - rozszerzenie
              Możliwe jest także wielokrotne wywoływanie tej metody na tym samym obiekcie
              w tej samej instrukcji, ponieważ ta metoda zwraca ten sam zmodyfikowany obiekt.
              .append(String str)
             */
            System.out.println("---- Połączenie nowego stringa z już istniejącym stringiem - rozszerzenie ----");
            sb.append("\n")
                    .append("Wyprodukowany w 1980r. Jego długość to 4,04m.\n")
                    .append("Włączyłem go dziś o 01:05.");
            System.out.println("Dodanie wielu stringów do stringa 'Syrena 105L'. Wynik to:");
            System.out.println(sb);
            /*
            Syrena 105L
            Wyprodukowany w 1980r. Jego długość to 4,04m.
            Włączyłem go dziś o 01:05.
             */

            /*
              Usuwanie znaków z Stringa w zależności od indeksu startowego i końcowego
              .delete(int start, int end)
             */
            System.out.println("---- Usuwanie znaków z Stringa w zależności od indeksu startowego i końcowego ----");
            sb.delete(11,84);
            System.out.println("Usunięcie wcześniej dodanych stringów według indeksu od 11 do 84. Wynik to:");
            System.out.println(sb); // Syrena 105L

            /*
              Wstawianie stringa np. do środka innego stringa według indeksu
              .insert(int offset, String str)
             */
            System.out.println("---- Wstawianie stringa np. do środka innego stringa według indeksu  ----");
            sb.insert(7, "najlepsza to model ");
            System.out.println("Wstawienie stringa 'najlepsza to ' do stringa 'Syrena 105L'. Wynik to:");
            System.out.println(sb); // 'Syrena najlepsza to model 105L'

            /*
              Zamiana fragmentu stringa na inny według indeksu początka i końca
              .replace(int start, int end, String str)
             */
            System.out.println("---- Zamiana fragmentu stringa na inny według indeksu początka i końca ----");
            sb.replace(7,20,"");
            System.out.println("Zamiana ze stringa 'Syrena najlepsza to model 105L' jego fragmentu 'najlepsza to ' na brak znaku, czyli w zasadzie usuwanie fragmentu");
            System.out.println(sb); // Syrena model 105L

            /*
              Odwrócenie stringa
              .reverse()
             */
            System.out.println("---- Odwrócenie stringa ----");
            sb.reverse();
            System.out.println("Odwrócenie stringa 'Syrena model 105L' da wynik:");
            System.out.println(sb); // 'L501 ledom aneryS'
        }
    }

    /**
     * Długość, a pojemność
     * Długość to rzeczywista liczba znaków
     * Pojemnosć to ilość pamięci dostępnej dla nowo wstawionych znaków, po przekroczeniu której
     * nastąpi nowy przydział. Pojemność jest częścią wewnętrznej reprezentacji, StringBuildera
     * jej wartość będzie się dynamicznie zmieniać. StringBuilder widzi każdy string jako tablicę
     * znaków. Aby poszerzyć string dokłada tak jakby kolejną tablicę do już istniejącej.
     * Maksimum to 2147483639 znaków.
     */
    static class DlugoscPojemnosc {
        public static void main(String[] args) {

            // Zbudowanie pustego stringa
            StringBuilder sb = new StringBuilder(); // początkowa pojemność to 16

            System.out.println("Pusty ciąg ma długość:");
            System.out.println(sb.length()); // 0
            System.out.println("Pusty ciąg ma pojemność:");
            System.out.println(sb.capacity()); // 16

            sb.append("Syrena 105L w kolorze wiśni");
            System.out.println("String 'Syrena 105L w kolorze wiśni' ma długość:");
            System.out.println(sb.length()); // 18
            System.out.println("String 'Syrena 105L w kolorze wiśni' ma pojemność:");
            System.out.println(sb.capacity()); // 34
        }
    }

    /**
     * Zadanie https://hyperskill.org/learn/step/3813
     * Usuń wszystkie cyfry i połącz otrzymane stringi bez spacji
     */
    static class ConcatenateStringsProblem {
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
