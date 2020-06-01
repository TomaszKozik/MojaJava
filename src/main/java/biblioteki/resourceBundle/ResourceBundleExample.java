package biblioteki.resourceBundle;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleExample {
    public static void main(String[] args) {

        /*
          Ustawienie parametrów lokalizacji (języka i kraju)
         */
        String language = "pl";
        String country = "PL";
        Locale currentLocale = new Locale(language, country);

        /*
          Ustawienie plików z językami oraz wybranych parametrów lokalizacji
          W poniższym przypadku "MessagesBundle" określa początek nazwy plików z tłumaczeniami.
          Wszystkie pliku tłumaczeń znajdują się w katalogu src\main\resources\
          Tłumaczenia dla innych języków muszą mieć w nazwach swoich plików dopisany kod języka i kraju
          np. _en_EN
          W definiowaniu obieku wpisujemy tylko nazwę pliku domyślnego dłumaczenia.
         */
        ResourceBundle message = ResourceBundle.getBundle("MessagesBundle", currentLocale);

        /*
          Wypisanie klucza greetings dla domyślnej lokalizacji
         */
        System.out.println(message.getString("greetings")); // cześć

        /*
          Wypisanie klucza greetings dla lokalizacji angielskiej
         */
        Locale locale_EN = new Locale("en", "EN");
        ResourceBundle message_EN = ResourceBundle.getBundle("MessagesBundle", locale_EN);
        System.out.println(message_EN.getString("greetings")); // Hello

    }
}
