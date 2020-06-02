package string;

import java.util.Locale;
import java.util.Scanner;

/**
 * Zastosowanie: Pobranie od użytkownika danych wprowadzanych z klawiatury
 *
 * Wymagana biblioteka: java.util.Scanner
 *
 * Source: https://hyperskill.org/learn/step/9055
 */
public class ScannerExample {

    public static void main(String[] args) {

        /*
          Tworzenie obiektu Scanner, który umożliwia korzystania z metod
          wprowadzania danych. System.in wskazuje, że program będzie czytał
          wprowadzany tekst.
         */
        Scanner scan = new Scanner(System.in);

        /*
          Ustawienia regionalne dla wprowadzanego tekstu.
          Stosuje się je np. do definiowana speratara liczb dziesiętnych
         */
        scan.useLocale(Locale.FRANCE); // wprowadzanie liczb z przecinkiem jako separatorem np. 50,102
        scan.useLocale(Locale.ENGLISH); // wprowadzanie liczb z kropką jako separatorem np. 50.102

        /*
          Wprowadzanie pojedynczego słowa, liczby jako stringi.
          Funkcja przyjmuje tylko jedno słowo lub liczbę wprowadzoną z klawiatury.
          Każdy biały znak informuje program o nowym słowie, liczbie.
          np. wpisanie 'Syrena' wyświetli 'Syrena'
          np. wpisanie 'Syrena 105L' wprowadzi do programu tylko 'Syrena'
         */
        System.out.println("---- Wprowadzanie pojedynczego słowa, liczby jako stringi ----");
        System.out.println("Wprowadź dowolny jednowyrazowy tekst");
        String string1 = scan.next();
        System.out.println(string1);

        /*
          Wprowadzanie dowolnych słów, liczb jako stringi.
          Funkcja przyjmuje dowolnie wprowadzony ciąg i w pełni go wyświetli.
          np. wpisanie 'Syrena 105L' wprowadzi do programu 'Syrena 105L'
         */
        System.out.println("---- Wprowadzanie dowolnych słów, liczb jako stringi ----");
        System.out.println("Wprowadź dowolny tekst");
        String string = scan.nextLine();
        System.out.println(string);

        /*
          Wprowadzanie liczb jako liczby całkowite int
          Funkcja przyjmuje tylko cyfry.
          Przekazanie innych znaków lub liczb niecałkowitych spowoduje błąd 'java.util.InputMismatchException'
          np. wpisanie '105' wprowadzi do programu '105'
         */
        System.out.println("---- Wprowadzanie liczb jako liczby całkowite int ----");
        System.out.println("Wprowadź dowolną liczbe całkowitą");
        Integer integer = scan.nextInt();
        System.out.println(integer);

        /*
          Wprowadzanie liczb jako liczby dziesięte dobule
          Funkcja przyjmuje tylko cyfry.
          Przekazanie innych znaków spowoduje błąd 'java.util.InputMismatchException'
          np. wpisanie '105' wprowadzi do programu '105'
          np. wpisanie '105.5' wprowadzi do programu '105.5' dla ustawień regionalnych ENGLISH
          np. wpisanie '105,5' wprowadzi do programu '105.5' dla ustawień regionalnych FRANCE
         */
        System.out.println("---- Wprowadzanie liczb jako liczby dziesięte dobule ----");
        System.out.println("Wprowadź dowolną liczbe dziesiętną");
        Double aDouble = scan.nextDouble();
        System.out.println(aDouble);

        /*
          Wprowadzanie wartości logicznej true lub false
          Funkcja przyjmuje tylko 'true' lub 'false'.
          Przekazanie innych znaków spowoduje błąd 'java.util.InputMismatchException'
          np. wpisanie 'treu' wprowadzi do programu 'true'
          np. wpisanie 'false' wprowadzi do programu 'false'
         */
        System.out.println("---- boolean ----");
        System.out.println("Wprowadź dowolną wartość logiczna 'true' lub 'false'");
        Boolean aBoolean = scan.nextBoolean();
        System.out.println(aBoolean);
    }
}
