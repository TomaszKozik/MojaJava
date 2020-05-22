package string;

/**
 * Przykłady opracji na stringach
 * @see https://hyperskill.org/learn/step/3523
 */
public class OperacjeNaStringach {

    public static void main(String[] args) {

        String stringMultiLine = "Mój samochód to FSM Syrena.\nWyprodukowany w 1980r.\nJego długość to 4,04m.";
        String stringOneLine = "Syrena";

        // Drukowanie stringa
        System.out.println(stringMultiLine);
        System.out.println(stringOneLine);

        System.out.println("---- Długość stringa ----");
        // Znak nowej linii jest również dodawany, jako kolejny znak
        System.out.println(stringMultiLine.length()); //73

        System.out.println("---- Weryfikacja, czy string jest pusty ----");
        System.out.println(stringOneLine.isEmpty());
        System.out.println("".isEmpty());

        System.out.println("---- Zmiana wielkości liter ----");
        System.out.println(stringOneLine.toUpperCase());
        System.out.println(stringOneLine.toLowerCase());

        System.out.println("---- Czy zawiera ciąg znaków 'ren' ----");
        System.out.println(stringOneLine.contains("ren"));

        System.out.println("---- Wycięcie 'ren' ----");
        System.out.println(stringOneLine.substring(2,5));

        System.out.println("---- Replace 'ren' na 'ner' ----");
        System.out.println(stringOneLine.replace("ren", "ner"));

        System.out.println("---- Replace dla Regexa ----");
        String stringToReplace = stringOneLine + 5;
        System.out.println(stringToReplace);
        System.out.println(stringToReplace.replaceAll("\\d", ""));

        System.out.println("---- Usuwanie białych znaków ----");
        System.out.println(stringOneLine.trim());

        System.out.println("---- Laczneie stringow ----");
        System.out.println(stringOneLine.concat(" 105L"));
        System.out.println(stringOneLine + " 105L");

        System.out.println("---- Pobieranie hashCode ----");
        System.out.println(stringOneLine.hashCode());
    }
}
