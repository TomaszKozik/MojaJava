package typyZmiennych.string;

/**
 * Proste operacje na String'ach. Typu wypisanie Stringa, pobranie długości,
 * usuwanie białych znaków, zmiana wielkości liter, podmiana liter
 * <p>
 * Source: https://hyperskill.org/learn/step/3523
 */
public class OperacjeNaStringach {

    // Przykładowe String'i na których będą wykonane poniższe operacje
    private static final String emptyString = "";
    private static final String oneLineString = "Syrena 105L";
    private static final String multiLineString = "Mój samochód to FSM Syrena 105L.\nWyprodukowany w 1980r.\nJego długość to 4,04m.";
    private static final String stringWithWhiteSpaces = "  Fiat 125P  ";

    // Wywołanie przykładów
    public static void main(String[] args) {

        System.out.println("---- Drukowanie stringa na ekranie String'a 'Syrena 105L'");
        System.out.println(oneLineString);

        System.out.println("---- Drukowanie String'a na ekranie długiego stringa ----");
        System.out.println(multiLineString);

        System.out.println("---- Pobranie długości wielolinijkowego String'a ----");
        System.out.println(getLengthOfMultiLineString());       // 78

        System.out.println("---- Weryfikacja, czy pusty String jest pusty ----");
        System.out.println(isEmptyStringIsEmpty());             // true

        System.out.println("---- Weryfikacja, czy String 'Syrena 105L' jest pusty ----");
        System.out.println(isOneLineStringIsEmpty());           // false

        System.out.println("---- Zmiana wielkości liter String'a 'Syrena 105L' na duże ----");
        System.out.println(getUpperedOneLineString());               // SYRENA 105L

        System.out.println("---- Zmiana wielkości liter String'a 'Syrena 105L' na małe ----");
        System.out.println(getLoweredOneLineString());               // syrena 105l

        System.out.println("---- Weryfikacja, czy String 'Syrena 105L' zawiera String '105' ----");
        System.out.println(isStringContainAnotherString());

        System.out.println("---- Wycięcie z String'a 'Syrena 105L' znaków od indeksu 7 do końca Stringa ----");
        System.out.println(getPartOfStringFromBeginIndexToEndOfString());     // 105L

        System.out.println("---- Wycięcie z String'a 'Syrena 105L' znaków od indeksu 7 do 10 ----");
        System.out.println(getPartOfStringFromBeginIndexToEndIndex());     // 105

        System.out.println("---- Zamiana fragmentu Stringa z '105L' na 'Bosto' ----");
        System.out.println(getStringWithReplacedPart());     // Syrena Bosto

        System.out.println("---- Zamiana fragmentu Stringa za pomocą wyrażenia regularnego Regex ----");
        System.out.println(getStringWithReplacedPartByRegex());     // Syrena L

        System.out.println("---- Usuwanie białych znaków z początku i końca String'a '  Fiat 125P  ' ----");
        System.out.println(trimStringWithWhiteSpaces());

        System.out.println("---- Łączenie String'ów za pomocą znaku '+'. Dodanie do 'Syrena 105L' Stringa ' o kolorze kość słoniowa'");
        System.out.println(getOneLineStringWithAddedStringByPlusSign());

        System.out.println("---- Łączenie String'ów za pomocą metody concat(). Dodanie do 'Syrena 105L' Stringa ' o kolorze wiśni'");
        System.out.println(getOnelineStringWithAddedStringByConcat());

        System.out.println("---- Pobieranie hashCode dla String'a 'Syrena 105L' ----");
        System.out.println(getHashCodeForOneLineString());
    }

    /**
     * Pobranie długości String'a
     * Znak nowej linii jest również dodawany do ilości znaków
     * .length()
     *
     * @return int length of String
     */
    private static int getLengthOfMultiLineString() {
        return multiLineString.length();      // 78
    }

    /**
     * Weryfikacja, czy String jest pusty
     * Zwraca true lub false
     * .isEmpty()
     *
     * @return boolean true for emptyString
     */
    private static boolean isEmptyStringIsEmpty() {
        return emptyString.isEmpty();           // true
    }

    /**
     * Weryfikacja, czy String jest pusty - ciąg dalszy
     *
     * @return boolean false for oneLineString
     */
    private static boolean isOneLineStringIsEmpty() {
        return oneLineString.isEmpty();         // false
    }

    /** Zmiana wielkości wszystkich liter na duże
     * .toUpperCase()
     *
     * @return String Upper of oneLineString
     */
    private static String getUpperedOneLineString() {
        return oneLineString.toUpperCase();     // SYRENA 105L
    }

    /** Zmiana wielkości wszystkich liter na małe
     * .toLowerCase()
     *
     * @return String lower of oneLineString
     */
    private static String getLoweredOneLineString() {
        return oneLineString.toLowerCase();     // syrena 105l
    }

    /**
     * Weryfikacja zawartości String'a, czy zawiera String '105'
     * Zwraca true lub false
     * .contains(str)
     *
     * @return boolean true if oneLineString contains '105'
     */
    private static boolean isStringContainAnotherString() {
        return oneLineString.contains("105");   // true
    }

    /**
     * Wycięcie fragmentu String'a w od indeksu do końca
     * .substring(int beginIndex) - wyciągnij znaki do indeksu do końca
     *
     * @return String Part of oneLineString by index from 7 to end of string
     */
    private static String getPartOfStringFromBeginIndexToEndOfString() {
        return oneLineString.substring(7);      // 105L
    }

    /**
     * Wycięcie fragmentu String'a w zależności od pozycji znaku
     * .substring(int beginIndex, int endIndex) - wyciągnij znaki do indeksu do indeksu
     *
     * @return String Part of oneLineString by index from 7 to 9
     */
    private static String getPartOfStringFromBeginIndexToEndIndex() {
        return oneLineString.substring(7, 10);  // 105
    }

    /**
     * Zmiana fragmentu String'a na inny
     * Zmiana '105L' na 'Bosto'
     * .replace(String str, String str)
     * 
     * @return String String with replaced part
     */
    private static String getStringWithReplacedPart() {
        return oneLineString.replace("105L", "Bosto");  // Syrena Bosto
    }

    /**
     * Zamiana framgentu String'a na inny w zaleźności od wyrażenia regularnego
     * Zamieniamy cyfry na puste znaki (usuwamy cyfry)
     * .replaceAll(String pattern, String string)
     * Zobacz: https://regexr.com/
     *
     * @return String get String without digits
     */
    private static String getStringWithReplacedPartByRegex() {
        return oneLineString.replaceAll("//d", ""); // Syrena L
    }
    
    /**
     * Usuwanie białych znaków z początku i końca String'a
     * .trim()
     *
     * @return trimed stringWithWhiteSpaces
     */
    private static String trimStringWithWhiteSpaces() {
        return stringWithWhiteSpaces.trim();
    }

    /**
     * Łączenie String'ów za pomocą znaku '+'
     *
     * @return String onlelineString with ' o kolorze kość słoniowa'
     */
    private static String getOneLineStringWithAddedStringByPlusSign() {
        return oneLineString + " o kolorze kość słoniowa";
    }

    /**
     * Łączenie String'ów za pomocą znaku metody concat
     * .concat(String string)
     *
     * @return String  onlelineString with ' o kolorze wiśni'
     */
    private static String getOnelineStringWithAddedStringByConcat() {
        return oneLineString.concat(" o kolorze wiśni");
    }

    /**
     * Pobieranie hashCode dla String'a
     * .hashCode()
     *
     * @return int hashCode for OnelineString
     */
    private static int getHashCodeForOneLineString() {
        return oneLineString.hashCode();
    }
}
