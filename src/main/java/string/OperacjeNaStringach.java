package string;

/**
 * Zastosowanie: Wszędzie tam, gdzie potrzebujemy sprawdzić stringi
 * lub wykonać na nich proste operacje
 *
 * Source: https://hyperskill.org/learn/step/3523
 */
public class OperacjeNaStringach {

    public static void main(String[] args) {

        // Przykładowe stringi na których będą wykonane poniższe operacje
        String stringMultiLine = "Mój samochód to FSM Syrena 105L.\nWyprodukowany w 1980r.\nJego długość to 4,04m.";
        String stringOneLine = "Syrena 105L";

        // Drukowanie stringa
        System.out.println("---- Drukowanie stringa na ekranie ----");
        System.out.println(stringMultiLine);
        /*
        Mój samochód to FSM Syrena 105L.
        Wyprodukowany w 1980r.
        Jego długość to 4,04m.
         */
        System.out.println(stringOneLine);
        // Syrena 105L

        System.out.println("---- Pobranie długości stringa ----");
        System.out.println(stringMultiLine.length());
        // 78
        // Znak nowej linii jest również dodawany do ilości znaków

        System.out.println("---- Weryfikacja, czy string jest pusty ----");
        System.out.println(stringOneLine.isEmpty());
        // false
        System.out.println("".isEmpty());
        // true

        System.out.println("---- Zmiana wielkości liter ----");
        System.out.println(stringOneLine.toUpperCase());
        // SYRENA 105L
        System.out.println(stringOneLine.toLowerCase());
        // syrena 105l

        System.out.println("---- Czy string zawiera ciąg znaków 'ren' ----");
        System.out.println(stringOneLine.contains("ren"));
        // true

        System.out.println("---- Wycięcie fragmentu stringa w zależności od pozycji znaku ----");
        System.out.println(stringOneLine.substring(2,5));
        // ren
        // pozycje liczymy o 0, nie od 1, czyli w słowie 'syrena' litera 's' ma pozycję 0

        System.out.println("---- Zamiana liter 'ren' na 'ner' ----");
        System.out.println(stringOneLine.replace("ren", "ner"));
        // Synera 105L

        System.out.println("---- Zamiana znaków zgodnie z wyrażeniem regularnym (regex) ----");
        System.out.println(stringOneLine.replaceAll("\\d", ""));
        // Syrena L
        // \\d - usuwa wszystkie cyfry
        // Zobacz: https://regexr.com/

        System.out.println("---- Usuwanie białych znaków ----");
        System.out.println(stringOneLine.trim());
        // Syrena 105L

        System.out.println("---- Laczneie stringow ----");
        System.out.println(stringOneLine.concat(" o kolorze kość słoniowa"));
        // Syrena 105L o kolorze kość słoniowa
        System.out.println(stringOneLine + " o kolorze wiśni");
        // Syrena 105L o kolorze wiśni

        System.out.println("---- Pobieranie hashCode ----");
        System.out.println(stringOneLine.hashCode());
        // 561646090
    }
}
