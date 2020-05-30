package string;

/**
 * Proste operacje na String'ach. Typu wypisanie Stringa, pobranie długości,
 * usuwanie białych znaków, zmiana wielkości liter, podmiana liter
 *
 * Source: https://hyperskill.org/learn/step/3523
 */
public class OperacjeNaStringach {

    public static void main(String[] args) {

        /* Przykładowe stringi na których będą wykonane poniższe operacje */
        String stringMultiLine = "Mój samochód to FSM Syrena 105L.\nWyprodukowany w 1980r.\nJego długość to 4,04m.";
        String stringOneLine = "Syrena 105L";

        /*---- Drukowanie stringa na ekranie ----*/
        System.out.println("---- Drukowanie String'a na ekranie ----");
        System.out.println("Drukowanie String'a na ekranie długiego stringa");
        System.out.println(stringMultiLine);
        /*
        Mój samochód to FSM Syrena 105L.
        Wyprodukowany w 1980r.
        Jego długość to 4,04m.
         */
        System.out.println("---- Drukowanie stringa na ekranie String'a 'Syrena 105L'");
        System.out.println(stringOneLine); // Syrena 105L

        /*
          Pobranie długości stringa
          Znak nowej linii jest również dodawany do ilości znaków
          .length()
         */
        System.out.println("---- Pobranie długości String'a ----");
        System.out.println("String długi ma długość:");
        System.out.println(stringMultiLine.length()); // 78

        /*
          Weryfikacja, czy string jest pusty
          Zwraca true lub false
          .isEmpty()
         */
        System.out.println("---- Weryfikacja, czy String jest pusty ----");
        System.out.println("String 'Syrena 105L' nie jest pusty, więc mamy:");
        System.out.println(stringOneLine.isEmpty()); // false
        System.out.println("String '' jest pusty, więc mamy:");
        System.out.println("".isEmpty()); // true

        /*
          Zmiana wielkości liter
          .toUpperCase() - wszystkie znaki na duże
          .toLowerCase() - wszystkie znaki na małe
         */
        System.out.println("---- Zmiana wielkości liter ----");
        System.out.println("String 'Syrena 105L' zmienił się na:");
        System.out.println(stringOneLine.toUpperCase());// SYRENA 105L
        System.out.println("String 'Syrena 105L' zmienił się na:");
        System.out.println(stringOneLine.toLowerCase()); // syrena 105l

        /*
          Weryfikacja zawartości stringa
          Zwraca true lub false
          .contains(str)
         */
        System.out.println("---- Weryfikacja zawartości stringa ----");
        System.out.println("Weryfikacja, czy String 'Syrena 105L' zawiera String 'ren'. Wynik to:");
        System.out.println(stringOneLine.contains("ren")); // true

        /*
          Wycięcie fragmentu stringa w zależności od pozycji znaku
          .substring(int beginIndex) - usuń od indeksu do końca stringa
          .substring(int beginIndex, int endIndex) - usuń do indeksu do indeksu
         */
        /*----  ----*/
        System.out.println("---- Wycięcie fragmentu String'a w zależności od pozycji znaku ----");
        System.out.println("Wytnij z stringa 'Syrena 105L' fragment od indexu 7 do 10");
        System.out.println(stringOneLine.substring(7, 10)); // 105

        /*
          Zamiana framgentu stringa na inny
          .replace(String str, String str)
         */
        System.out.println("---- Zamiana framgentu String'a na inny ----");
        System.out.println("Zamień w stringu 'Syrena 105L' fragment '105L' na 'Bosto'");
        System.out.println(stringOneLine.replace("105L", "Bosto")); // 'Syrena Bosto'

        /*
          Zamiana framgentu stringa na inny w zaleźności od wyrażenia regularnego
          .replaceAll(String regex, String replacement)
          Zobacz: https://regexr.com/
         */
        System.out.println("---- Zamiana znaków zgodnie z wyrażeniem regularnym (regex) ----");
        System.out.println("Z stringa 'Syrena 105L' usuń wszystkie cyfry. Wynik to:");
        System.out.println(stringOneLine.replaceAll("\\d", "")); // Syrena L

        /*
          Usuwanie białych znaków z początku i końca stringa
          .trim()
         */
        System.out.println("---- Usuwanie białych znaków z początku i końca String'a ----");
        System.out.println("Z stringa 'Syrena 105L' usuń białe znaki z obu jego końców");
        System.out.println(stringOneLine.trim()); // Syrena 105L

        /*
          Łączenie stringów
          używa się operatora '+' lub .concat(String str)
         */
        System.out.println("---- Laczenie String'ów ----");
        System.out.println("Do stringa 'Syrena 105L' dołącz za pomocą '.concat()' string ' o kolorze kość słoniowa':");
        System.out.println(stringOneLine.concat(" o kolorze kość słoniowa")); // Syrena 105L o kolorze kość słoniowa
        System.out.println("Do stringa 'Syrena 105L' dołącz za pomocą '+' string ' o kolorze wiśni':");
        System.out.println(stringOneLine + " o kolorze wiśni"); // Syrena 105L o kolorze wiśni

        /*
          Pobieranie hashCode dla stringa
          .hashCode()
         */
        System.out.println("---- Pobieranie hashCode dla String'a ----");
        System.out.println("hashCode dla stringa 'Syrena 105L' to:");
        System.out.println(stringOneLine.hashCode()); // 561646090
    }
}
