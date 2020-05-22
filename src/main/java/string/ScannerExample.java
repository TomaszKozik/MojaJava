package string;

import java.util.Locale;
import java.util.Scanner;

public class ScannerExample {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("---- ustawienie regionu ----");
        scan.useLocale(Locale.ENGLISH);      //wprowadzanie liczb z kropką jako separatorem
        //scan.useLocale(Locale.GERMANY);    //wprowadzanie danych z przecinkiem

        System.out.println("---- Stringi ----");
        String string = scan.nextLine();
        System.out.println(string);

        System.out.println("---- int ----");
        Integer integer = scan.nextInt();
        System.out.println(integer);

        System.out.println("---- double ----");
        Double aDouble = scan.nextDouble();
        System.out.println(aDouble);

        System.out.println("---- boolean ----");
        Boolean aBoolean = scan.nextBoolean();
        System.out.println(aBoolean);
    }
}
