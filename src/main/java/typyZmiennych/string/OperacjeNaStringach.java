package typyZmiennych.string;

/**
 * Proste operacje na String'ach. Typu wypisanie Stringa, pobranie długości,
 * usuwanie białych znaków, zmiana wielkości liter, podmiana liter
 * <p>
 * Source: https://hyperskill.org/learn/step/3523
 */
public class OperacjeNaStringach {

    public static void main(String[] args) {

        /* Przykładowe String'i na których będą wykonane poniższe operacje */
        String stringMultiLine = "Mój samochód to FSM Syrena 105L.\nWyprodukowany w 1980r.\nJego długość to 4,04m.";
        String stringOneLine = "Syrena 105L";

        /*---- Drukowanie String'a na ekranie ----*/
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
          Pobranie długości String'a
          Znak nowej linii jest również dodawany do ilości znaków
          .length()
         */
        System.out.println("---- Pobranie długości String'a ----");
        System.out.println("String długi ma długość:");
        int dlugoscString = stringMultiLine.length();
        System.out.println(dlugoscString); // 78

        /*
          Weryfikacja, czy String jest pusty
          Zwraca true lub false
          .isEmpty()
         */
        System.out.println("---- Weryfikacja, czy String jest pusty ----");
        System.out.println("String 'Syrena 105L' nie jest pusty, więc mamy:");
        boolean czyStringPusty = stringOneLine.isEmpty();
        System.out.println(czyStringPusty); // false
        System.out.println("String '' jest pusty, więc mamy:");
        String pustyStirng = "";
        boolean czyString2Pusty = pustyStirng.isEmpty();
        System.out.println(czyString2Pusty); // true

        /*
          Zmiana wielkości liter
          .toUpperCase() - wszystkie znaki na duże
          .toLowerCase() - wszystkie znaki na małe
         */
        System.out.println("---- Zmiana wielkości liter ----");
        System.out.println("String 'Syrena 105L' zmienił się na:");
        String duzeLitery = stringOneLine.toUpperCase();
        System.out.println(duzeLitery);// SYRENA 105L
        System.out.println("String 'Syrena 105L' zmienił się na:");
        String maleLitery = stringOneLine.toLowerCase();
        System.out.println(maleLitery); // syrena 105l

        /*
          Weryfikacja zawartości String'a
          Zwraca true lub false
          .contains(str)
         */
        System.out.println("---- Weryfikacja zawartości stringa ----");
        System.out.println("Weryfikacja, czy String 'Syrena 105L' zawiera String 'ren'. Wynik to:");
        boolean czyZawiera = stringOneLine.contains("ren");
        System.out.println(czyZawiera); // true

        /*
          Wycięcie fragmentu String'a w zależności od pozycji znaku
          .substring(int beginIndex) - usuń od indeksu do końca String'a
          .substring(int beginIndex, int endIndex) - usuń do indeksu do indeksu
         */
        System.out.println("---- Wycięcie fragmentu String'a w zależności od pozycji znaku ----");
        System.out.println("Wytnij z stringa 'Syrena 105L' fragment od indexu 7 do 10");
        String krotszyString = stringOneLine.substring(7, 10);
        System.out.println(krotszyString); // 105

        /*
          Zamiana framgentu String'a na inny
          .replace(String str, String str)
         */
        System.out.println("---- Zamiana framgentu String'a na inny ----");
        System.out.println("Zamień w stringu 'Syrena 105L' fragment '105L' na 'Bosto'");
        String zmianaWStringu = stringOneLine.replace("105L", "Bosto");
        System.out.println(zmianaWStringu); // 'Syrena Bosto'

        /*
          Zamiana framgentu String'a na inny w zaleźności od wyrażenia regularnego
          .replaceAll(String regex, String replacement)
          Zobacz: https://regexr.com/
         */
        System.out.println("---- Zamiana znaków zgodnie z wyrażeniem regularnym (regex) ----");
        System.out.println("Z stringa 'Syrena 105L' usuń wszystkie cyfry. Wynik to:");
        String zmianaWStringuZRegex = stringOneLine.replaceAll("\\d", "");
        System.out.println(zmianaWStringuZRegex); // Syrena L

        /*
          Usuwanie białych znaków z początku i końca String'a
          .trim()
         */
        System.out.println("---- Usuwanie białych znaków z początku i końca String'a ----");
        System.out.println("Z stringa 'Syrena 105L' usuń białe znaki z obu jego końców");
        String stringBezBialychZnakow = stringOneLine.trim();
        System.out.println(stringBezBialychZnakow); // Syrena 105L

        /*
          Łączenie String'ów
          używa się operatora '+' lub .concat(String str)
         */
        System.out.println("---- Laczenie String'ów ----");
        System.out.println("Do stringa 'Syrena 105L' dołącz za pomocą '.concat()' string ' o kolorze kość słoniowa':");
        String polaczonyStringConcat = stringOneLine.concat(" o kolorze kość słoniowa");
        System.out.println(polaczonyStringConcat); // Syrena 105L o kolorze kość słoniowa
        System.out.println("Do stringa 'Syrena 105L' dołącz za pomocą '+' string ' o kolorze wiśni':");
        String polaczonyStringPlus = stringOneLine + " o kolorze wiśni";
        System.out.println(polaczonyStringPlus); // Syrena 105L o kolorze wiśni

        /*
          Pobieranie hashCode dla String'a
          .hashCode()
         */
        System.out.println("---- Pobieranie hashCode dla String'a ----");
        System.out.println("hashCode dla stringa 'Syrena 105L' to:");
        int hashCode = stringOneLine.hashCode();
        System.out.println(hashCode); // 561646090
    }
}
