package pliki;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ZapisStringow {

    public static void main(String[] args) {
        // Dane wejściowe
        File plikDoZapisuString = new File("./Files/Subdirectory/file.txt");
        String zawartoscDoZapisania = "ZawartoscZapisana\n";
        String pustaZawartosc = "";

        // Przykład dopisania do pliku
        // Dla FileWriter wartość true, informuje, że ma dopisywać do pliku, jego brak lub false nadpisuje plik
        try (FileWriter zapisz = new FileWriter(plikDoZapisuString, true)) {
            zapisz.write(zawartoscDoZapisania);
            zapisz.write(zawartoscDoZapisania);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Przykład nadpisania pliku
        try (FileWriter zapisz = new FileWriter(plikDoZapisuString)) {
            zapisz.write(pustaZawartosc);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
