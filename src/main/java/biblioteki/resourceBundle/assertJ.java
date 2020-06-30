package biblioteki.resourceBundle;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.time.ZonedDateTime.parse;
import static org.assertj.core.api.Assertions.*;

/**
 * AssertJ to biblioteka Java zapewniająca bogaty zestaw asercji,
 * naprawdę pomocne komunikaty o błędach, poprawiająca czytelność kodu testowego
 * i zaprojektowana tak, aby była bardzo łatwa w użyciu w ulubionym IDE.
 *
 * Asercja jest sprawdzenie warunków np. czy jedna wartość jest równa innej.
 * W przypadku niespełnionego warunku zwracany jest błąd 'AssertionError'
 *
 * Dokumentacja: https://assertj.github.io/doc/#assertj-overview
 * Dokumentacja: https://www.javadoc.io/doc/org.assertj/assertj-core/latest/index.html
 */
public class assertJ {

    public static void main(String[] args) {

        // Dane do przykładów
        Boolean prawda = true;
        Boolean falsz = false;

        String syrena = "Syrena";
        String fiat = "Fiat";
        String warszawa = "Warszawa";

        List<String> samochody = new ArrayList<>();
        samochody.add(syrena);
        samochody.add(fiat);
        samochody.add(warszawa);

        // Porównanie zmiennych
        assertThat(prawda).isTrue();    // Czy jest prawdą
        assertThat(falsz).isFalse();    // Czy jest fałszem
        assertThat(syrena).isEqualTo(syrena);   // Czy ciąg jest równy ...
        assertThat(syrena).isNotEqualTo(fiat);  // Czy ciąg nie jest równy ...

        // Weryfikacja string'ów
        assertThat(warszawa)
                .isNotEmpty() // Ciąg nie jest pusty
                .startsWith("War")// Ciąg zaczyna się od ...
                .endsWith("awa") // Ciąg kończy się na ...
                .contains("sz") // Ciąg zawiera ...
                .containsPattern("\\w") // Zawiera znaki według patternu (regex)
                .doesNotContain("syrena", "maluch") // Nie zawiera ... (tablica wartości)
                .doesNotContainPattern("\\d") // Nie zawiera znaków według patternu (regex)
                .hasSize(8) // Ilość znaków ciągu to ..
                .hasSizeBetween(8,8) // Ilość znaków jest między ..., a ...
                .isEqualToIgnoringCase("warszawa") // Wielkość liter jest pomijana, ale nie ilość
                .isIn(samochody); // Czy ciąg znajduje się w liście ...

        // Weryfikacja list bez filtrowania
        assertThat(samochody)
                .contains("Syrena") // Lista zawiera ...
                .doesNotContain("ford", "porshce") // Lista nie zawiera ... (tablica wartości)
                .hasSize(3) // Lista ma elementów ...
        ;

        // Weryfikacja list z filtrowaniem
        assertThat(samochody)
                .filteredOn(elem -> elem.contains("ena")) // Filtrowanie elementów zawierających tylko ...
                .containsOnly("Syrena"); // Czy przefiltorawna lista zawiera tylko ...

        // Weryfikacja wyjątków
        assertThatThrownBy(() -> { throw new Exception("Pi bip!!"); }).hasMessage("Pi bip!!");  // Czy zgłoszony błąd wrzucił ...
        // lub
        Throwable thrown = catchThrowable(() -> { throw new Exception("Pi bip!!"); });
        assertThat(thrown).hasMessageContaining("Pi bip"); // Czy zgłoszony błąd zawiera ...

        // Opisywanie asercji
        // Opis wyświetla sie w przypadku wystąpienia błędu asercji
        // Dodaje się go poprzez metodę .as()
        assertThat(syrena).as("Czy 'Syrena' to 'Syrena'").isEqualTo(syrena);
        assertThat(syrena).as("Czy '%s' to '%s'", syrena, syrena).isEqualTo(syrena);

        // Matches
        assertThat(syrena).matches(p -> p.length() == 6 && p.contains("ena")); // Sprawdzanie warunków na podstawie predykatów

        // Asercje na datach
        ZonedDateTime now = ZonedDateTime.now();
        assertThat(now)
                .isAfter(parse("2020-01-02T00:00:00Z")) // Data jest nowsza niż ...
                .isBetween("2020-01-01T00:00:00Z", "2030-01-01T00:00:00Z") // Data jest pomiędzy ...
                .isNotIn("2020-01-01T00:00:00Z", // Data nie jest jedną z ...
                        "2030-01-01T00:00:00Z");
    }

}
