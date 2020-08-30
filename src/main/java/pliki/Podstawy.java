package pliki;

import java.io.File;
import java.io.IOException;

public class Podstawy {

    public static void main(String[] args) {
        File file = new File("./Files/Subdirectory/listaSamochodow.txt");
        File fileToMenage = new File("./Files/plikDoZarzadzenia.txt");
        File directory = new File("./Files/Subdirectory");

        // Nazwa pliku:
        System.out.println(file.getName());     // listaSamochodow.txt

        // Scieżka z nazwą pliku:
        System.out.println(file.getPath());     // .\Files\Subdirectory\listaSamochodow.txt

        // Czy wskazuje plik:
        System.out.println(file.isFile());      // true

        // Czy wskazuje katalog:
        System.out.println(file.isDirectory()); // false

        // Czy istnieje:
        System.out.println(file.exists());      // true

        // Katalog pliku:
        System.out.println(file.getParent());   // .\Files\Subdirectory

        // Katalog nadrzędny, jako File
        System.out.println(directory.getParentFile());  // .\Files

        // Katalog nadrzędny, jako String
        System.out.println(directory.getParent());      // .\Files

        // Lista nazw plików dla katalogu
        for (String s : directory.list()) {
            System.out.println(s);              // listaSamochodow.txt
        }

        // Lista ścieżek plików z nazwami plików dla katalogu
        for (File listFile : directory.listFiles()) {
            System.out.println(listFile);       // .\Files\Subdirectory\listaSamochodow.txt
        }

        // Tworzenie katalogu
        System.out.println(directory.mkdir());          // true, gdy utworzono plik; false, gdy plik istnieje

        // Tworzenie katalogu wraz z katalogami nadrzędnymi
        System.out.println(directory.mkdirs());         // true, gdy utworzono plik; false, gdy plik istnieje

        // Tworzenie pliku
        // Wymaga bloku try/catch lub zwrócenie błędu IOException
        try {
            System.out.println(fileToMenage.createNewFile());   // true, gdy utworzono plik; false, gdy plik istnieje
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Zmiana nazwy pliku i zamiennie zmiana miejsca docelowego
        File nowaNazwaPlikuISciezka = new File("./Files/Subdirectory/plikPrzeniesionyZeZmienionaNazwa.txt");
        System.out.println(fileToMenage.renameTo(nowaNazwaPlikuISciezka));    // true, gdy utworzono plik; false, gdy plik istnieje

        // Usuwanie plikow/katalogow
        System.out.println(nowaNazwaPlikuISciezka.delete());    // true, gdy utworzono plik; false, gdy plik istnieje
    }

}
