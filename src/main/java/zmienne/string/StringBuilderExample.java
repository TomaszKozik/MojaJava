package zmienne.string;

/**
 * Zastosowanie:
 * 1. Przyśpieszenie działania programu, gdy konieczne jest
 * wykonywanie wielu operacji na stringach.
 * 2. Gdy potrzebujemy operować na stringach, jak na tablicy
 *
 * Source: https://hyperskill.org/learn/step/3812
 */
public class StringBuilderExample {

    public static void main(String[] args) {

        System.out.println("---- Budowanie String'a 'Syrena 105L' za pomocą StringBuilder ----");
        StringBuilder stringBuilder = new StringBuilder("Syrena 105L");
        System.out.println(stringBuilder);              // Syrena 105L

        System.out.println("---- Pobranie String'a 'Syrena 105L' ----");
        System.out.println(stringBuilder.length());     // 11

        System.out.println("---- Zwrócenie znaku zgodnie z indeksem ----");
        System.out.println(stringBuilder.charAt(5));    // a

        System.out.println("---- Zamiana znaku w ciągu względem indeksu ----");
        stringBuilder.setCharAt(6, '-');
        System.out.println(stringBuilder);              // Syrena-105L

        System.out.println("---- Zamiana fragmentu stringa na inny według indeksu początka i końca ----");
        stringBuilder.replace(6, 7, " ");
        System.out.println(stringBuilder);              // Syrena model 105L

        System.out.println("---- Usunięcie litery 'L' z ciągu 'Syrena-105L' zgodnie z numerem indeksu ----");
        stringBuilder.deleteCharAt(10);
        System.out.println(stringBuilder);              // 'Syrena 105'

        System.out.println("---- Dodanie nowego String'a (litery 'L') do String'a 'Syrena-105'  ----");
        stringBuilder.append("L");
        System.out.println(stringBuilder);              // 'Syrena 105L'

        System.out.println("---- Dodanie nowego String'a ' Wyprodukowany w 1980r. Jego długość to 4,04m.' do String'a 'Syrena-105L'  ----");
        stringBuilder.append(" Wyprodukowany w 1980r. Jego długość to 4,04m.");
        System.out.println(stringBuilder);              // 'Syrena 105L Wyprodukowany w 1980r. Jego długość to 4,04m.'

        System.out.println("---- Usuwanie znaków z String'a ' Wyprodukowany w 1980r. Jego długość to 4,04m.' w zależności od indeksu startowego i końcowego ----");
        stringBuilder.delete(11, 84);
        System.out.println(stringBuilder);              // Syrena 105L

        System.out.println("---- Wstawianie stringa np. do środka innego stringa według indeksu  ----");
        stringBuilder.insert(7, "najlepsza to model ");
        System.out.println(stringBuilder);              // 'Syrena najlepsza to model 105L'

        System.out.println("---- Odwrócenie stringa ----");
        stringBuilder.reverse();
        System.out.println(stringBuilder);             // 'L501 ledom aneryS'
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
}


