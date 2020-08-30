package pliki;

import java.io.*;

public class ZapisBajtow {
    public static void main(String[] args) {

        // Dane wejściowe
        File plikDoZapisuString = new File("./Files/Subdirectory/file.txt");
        byte[] zawartoscDoZapisania = new byte[] {'Z', 'a', 'w', 'a', 'r', 't', 'o', 's', 'c', '\n'};
        String string2Byte = "String do zamiany na bajty";
        byte[] byteZStringa = string2Byte.getBytes();   // Zamienia String'i na tabele byte[]
        byte[] pustaZawartosc = new byte[] {};

        // Przykład dopisania do pliku
        // Dla FileWriter wartość true, informuje, że ma dopisywać do pliku, jego brak lub false nadpisuje plik
        try (OutputStream zapisz = new FileOutputStream(plikDoZapisuString, true)) {
            zapisz.write(zawartoscDoZapisania);
            zapisz.write(byteZStringa);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Przykład nadpisania pliku
        try (OutputStream zapisz = new FileOutputStream(plikDoZapisuString)) {
            zapisz.write(pustaZawartosc);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
