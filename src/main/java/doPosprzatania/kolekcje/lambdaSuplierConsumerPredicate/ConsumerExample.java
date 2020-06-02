package doPosprzatania.kolekcje.lambdaSuplierConsumerPredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;


/**
 * Consumer
 * Reprezentuje operację, która akceptuje pojedynczy argument wejściowy dowolnego typu i wykonuje
 * określone przez programiste funckcje np. drukowanie napisów, zapis do pliku lub inne funkcje
 * zwane potocznie efektem ubocznym.
 * Nie zwraca wyniku.
 *
 * Consumer jest intefejsem funkcjonalnym, dzięki czemu używamy do tworzenia dla niego funkcji
 * w oparciu o lambdy.
 *
 * Wywołujemy napisany kod poprzez .accept(<argument>)
 *
 * @param <T> typ danych wejściowych do operacji
 *
 * @Od wesji Java 1.8
 *
 * @see https://programuj.pl/blog/java8-lambdy-praktyczne-przyklady
 * @see https://nullpointerexception.pl/kurs-java-dla-poczatkujacych-8-streamy-i-lambdy/
*/

class ConsumerExample {

    /**
     * Przykład najprostszego użycia
     */
    public static class Consumer_NajprostszyPrzyklad {
        public static void main(String[] args) {
            Consumer<String> cons = x -> System.out.println(x);
            System.out.println("--- WYNIK CONSUMERA ---");
            cons.accept("Warszawa była produkowana przez 22 lata");
        }
    }


    public static class Consumer_Przyklad2 {

        public static void main(String[] args) {

            // Consumer to multiply 2 to every integer of a list
            Consumer<List<Integer>> modify = list -> {
                for (int i = 0; i < list.size(); i++)
                    list.set(i, 2 * list.get(i));
            };

            // Consumer to display a list of numbers
            Consumer<List<Integer>> dispList = list -> list.stream().forEach(a -> System.out.print(a + " "));

            List<Integer> list = new ArrayList<>();
            list.add(2);
            list.add(1);
            list.add(3);

            // Implement modify using accept()
            modify.accept(list);

            // Implement dispList using accept()
            dispList.accept(list);
        }
    }

}

