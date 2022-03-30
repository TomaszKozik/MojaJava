package zmienne;

/**
 * Rodzaje zmiennych
 * <p>
 * Zmienna - to złożenie argumentu i parametru
 * Argument - to konkretna wartość
 * Parametr - to definicja zmiennej
 * <p>
 * Zobacz: https://hyperskill.org/learn/step/3522
 */
public class TypyPierwotne {

    public static void main(String[] args) {

        /**
         * boolean
         * Jest typem logicznym.
         * Może przyjmować tylko dwa rodzaje zmiennych `true` lub `false`
         */
        boolean prawda = true;
        boolean falsz = false;

        /**
         * byte
         * Jest liczbą całkowitą wielkości jednego bajta
         * Ma zakres liczb od -128 do 127
         */
        byte minByte = -128;
        byte maxByte = 127;

        /**
         * short
         * Jest liczbą całkowitą o wielkości dwóch bajtów
         * Ma zakres liczb od -32768 do 23767
         */
        short minShort = -32768;
        short maxShort = 32767;

        /**
         * short
         * Jest liczbą całkowitą o wielkości czterech bajtów
         * Ma zakres liczb -2147483648 do 2147483647
         */
        int minInt = -2147483648;
        int maxInt = 2147483647;

        /**
         * long
         * Jest liczbą całkowitą o wielkości ośmiu bajtów
         * Ma zakres liczb -2^63 do (2^63)-1
         * Do poprawnego jej przypisania wymaga sufixu 'L' na końcu wartości liczby
         */
        long long1 = 1000000L; // 1000000
        long long2 = 1_000_000L; // 1000000

        /**
         * float
         * Jest liczbą zmienno przecinkową o wielkości czterech bajtów
         * Do poprawnego jej przypisania wymaga sufixu 'F' lub `f` na końcu wartości liczby
         * Może mieć maksymalnie 8 cyfr.
         */
        float float1 = 1.1234567f; // 1.1234567
        float float2 = 1.12345678f; // 1.1234568 - pojawia się zaokrąglenie
        float float3 = 1234567.1234567f; // 1234567.1

        /**
         * double
         * Jest liczbą zmienno przecinkową o wielkości ośmiu bajtów
         * Do poprawnego jej przypisania wymaga sufixu 'F' lub `f` na końcu wartości liczby
         * Może mieć maksymalnie 15 cyfr.
         */
        double double1 = 1234567890.1234567; // 1.2345678901234567E9
        double double2 = 1234567890.1d;      // 1.2345678901E9
        double double3 = 5e-3;               // 5 * 10^(-3) = 0.005
        double double4 = 0.01e2;             // 0.01 * 10^2 = 1.0

        /**
         * Liczby nieskończenie dłgie
         */
        double posInf = Double.POSITIVE_INFINITY;   // Infinity
        double negInf = Double.NEGATIVE_INFINITY;   // -Infinity
        double anotherPosInf = +1 / 0.0;            // Infinity

        /**
         * Liczby z nieokreśloną wartością
         */
        double nan = Double.NaN;                    // NaN

            /*
              char
              prezentacja pojedynczego znaku Unicode
              4 bajty
              maksymalnie 1 znak
              Spis znaków: https://en.wikipedia.org/wiki/List_of_Unicode_characters
              Wyszukiwarka: http://www.fileformat.info/info/unicode/char/search.htm
             */
        /**
         * char
         * Jest liczbą reprezentującą znak z tablicy Unicode np. literę
         * Jest liczbą stałą o wielkości czterech bajtów zwracającą jeden znak
         * Spis znaków: https://en.wikipedia.org/wiki/List_of_Unicode_characters
         * Wyszukiwarka: http://www.fileformat.info/info/unicode/char/search.htm
         */
        char litera = 'S'; // S
        char postaćDziesiętnaZnaku = 83; // S
        char postacKoduUnicodeZnaku = '\u0053'; // S
    }
}


/**
 * Rzutowanie liczb pomiędzy typami pozwala nam na zmiannę jednego typu liczby na inny.
 *
 * Bez ograniczeń robi się to w kolejności:
 * byte -> short -> int -> long -> float -> double
 * char -> int
 *
 * W drugą stronę może zdarzyć się przepełnienie, czyli dana liczba
 * może mieć większą wartość niż typ, na który chcemy ją zmienić.
 */
class RzutowaniePomiedzyTypami {
    public static void main(String[] args) {

        // Rzutowanie bez ograniczeń

        // Rzutowanie short -> int
        short shortNum = 100;
        int intNum1 = shortNum; // 100

        // Rzutowanie char -> int
        char chZnak = 'S';
        int code = chZnak; // 83

        // Rzutowanie long -> float
        long bigLong = 1_200_000_002L;
        float bigFloat = bigLong; // 1.2E9 (= 1_200_000_000)


        // Rzutowanie z ograniczeniami typu

        // Rzutowanie double -> long
        double doubleNum = 2.00003;
        long longNum = (long) doubleNum; // 2

        // Rzutowanie long -> int
        int intNum = (int) longNum; // 2

        // Rzutowanie long -> int
        int val = (int) (3 + 2L); // 5

        // Rzutowanie long -> char
        char cha = (char) 55L; // '7'

        // Przepelnienie w rzutowaniu na przykladzie long -> int
        long bigNum = 100_000_000_000_000L;
        int n = (int) bigNum; // 276447232
    }
}

/**
 * Klasy opakowujące pozwalają nam reprezentować prymitywne typy jako obiekty,
 * które są referencyjnymi typami danych.
 *
 * Ich szczególne właściwości:
 * - przetwarzanie wartości typów pierwotnych jest szybsze niż przetwarzanie obiektów opakowań;
 * - mogą być używane, gdy potrzebujesz otrzymać 'null' jako wskaźnik braku wartości;
 * - typy pierwotne nie mogą być używane w standardowych kolekcjach (takich jak listy, zbiory itp.),
 * ale w formie klas opakowujących mogą.
 *
 * Wszystkie typy pierwotne i odpowiadające im klasy opakowań:
 * Typ pierwotny    Klasa opakowująca   Argumenty konstruktora
 * boolean          Boolean             boolean lub String
 * byte             Byte                byte lub String
 * char             Character           char
 * int              Integer             int lub String
 * float            Float               float, double lub String
 * double           Double              double lub String
 * long             Long                long lub String
 * short            Short               short lub String
 *
 *
 * Zobacz: https://hyperskill.org/learn/step/3595
 */
class KlasyOpakowujace {
    public static void main(String[] args) {

        /**
         * 'Ręczne' pakowanie i rozpakowanywanie typów na przykładzie int
         */
        String primitywna = "100";
        Integer opakowana = Integer.valueOf(primitywna);    // 100 - pakowanie typu pierwotnego
        int rozpakowana = opakowana.intValue();             // 100 - rozpakowanie typu opakowanego

        /**
         * Automatyczne pakowanie i rozpakowanywanie (autoboxing) typów na przykładzie int
         * Autoboxing działa tylko wtedy, gdy lewa i prawa część zadania mają ten sam typ.
         * W innych przypadkach pojawi się błąd kompilacji.
         */
        Long n1 = 10L;       // OK, poprawne przypisanie typu primitywnego long do klasy opakowującej
        Integer n2 = 10;     // OK, poprawne przypisanie typu primitywnego int do klasy opakowującej
        // Long n3 = 10;     // Błąd, nie poprawne przypisanie typu primitywnego int do klasy opakowującej Long
        // Integer n4 = 10L; // Błąd, nie poprawne przypisanie typu primitywnego long do klasy opakowującej Integer

        /**
         * Zamiana String'a na typy liczbowe w klasach opakowujących
         */
        Integer intVal = Integer.valueOf("2000");    // 2000 z String'a "2000"
        Long longVal = Long.parseLong("1000");    // 1000 z String'a "1000"

        /**
         * Porównanie danych liczbowych klas opakowujących
         * Używamy tutaj metody quals, gdyż klasy opakowujące zwracają referencje
         */
        Integer int1 = 1000;
        Integer int2 = 2000;
        System.out.println(int1 == int2);      // false
        System.out.println(int1.equals(int2)); // true
    }
}
