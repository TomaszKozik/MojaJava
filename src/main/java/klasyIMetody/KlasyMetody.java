package klasyIMetody;
/**
 * Cześć!
 * Zaczynamy przygodę z Java od komentarza dokumentującego.
 * Każdy komentarz dokumentujący znajduję się pomiędzy znacznikami zaczynając od /** a kończąc na odwrotnym
 * w linii nr 9
 * <p>
 * Komentarze dokumentujące są nam potrzebne do opisu działania naszego kodu (składni).
 * Będziemy ich na bieżąco używać
 */

/**
 * Poniżej tego komentarza mamy zapis "public class Main {", a na samym końcu samotne "}"
 * Informuje on nas, iż zdefiniowaliśmy naszą pierwszą klasę. Klasa określa jakiś obiekt, jego stan oraz zachowanie.
 * Np. obiektem może być statek, który szereg parametrów (zmiennych) i funkcji (metod). Wiemy, dzięki temu
 * jaką funkcję pełni, ile osób może na nim pracować, jaki ma kolor, jak jest długi, itd.
 * Obiekt, który został stworzony na podstawie danej klasy nazywany jest jej instancją, czyli jeśli mamy więcej
 * statków, to mamy więcej instancji.
 *
 * Na określenie klasy składa się:
 * public - oznacza, iż nasza klasa jest publiczna, czyli wszystko i wszyscy mają do niej dostęp.
 *          Jest to tzw. modyfikator dostępu. W Java znamy ich jeszcze 3. Omówimy je dogłębnie później.
 * class  - słowo to oznacza deklarację klasy.
 *          W tym miejscu możesz jeszcze spotkać np. interface - o tym również później.
 * Main   - jest to nazwa klasy. Sami ją nadajemy. Zawsze powinna zaczynać się z dużej litery
 *          oraz musi się nazywać identycznie, jak plik w którym zamieszczony jest nasz kod.
 *          Również w tym przykładzie mogłaby mieć inną nazwę.
 * { }    - ten nawias klamrowy informuje nas, gdzie zaczyna się i gdzie kończy ciało klasy.
 *          Ciało klasy, to nic innego jak kod, składnia, wobec której nasz skrypt, aplikacja, program będzie działał
 */
public class KlasyMetody {
    /**
     * Każda klasa może zawierać metody i zmienne.
     * Najważniejszą metodą jest metoda o nazwiie "main", którą widzisz poniżej komentarza.
     * Dzięki "main" możemy w Java uruchamiać nasz kod i sprawdzać jak działa.
     * Ta metoda scala wszystko. Jest to główna metoda uruhomieniowa.
     * Zadaniem poniższej metody jest wypisanie "Metoda główna"
     * <p>
     * Obok nazwy metody "main" mamy:
     * public - identycznie, jak w przypadku klasy oznacza modyfikator dostępu.
     *          Metoda musi być publiczna. Inaczej nie uruchomimy naszego kodu.
     * static - to słowo kluczowe oznacza coś wspólnego i z ogółu niezmiennego, np. funckja uruchamiania WiFi
     *          w telefonie. Dla każdego rodzaju telefonu działa identycznie, więc powinna być statyczna.
     *          Obiekty statyczne są tworzone przy uruchamianiu programu, w zasadzie jego kompilowacji (budowy).
     *          Uruchamiając program dana metoda jest w pełni skończona i gotowa do użycia.
     *          Obiekty niestatyczne są tworzone w trakcie działania programu. Mogą być tworzone, zmieniane
     *          w trakcie jego działania. Taką metodą może być określenie wyglądu telefonu przez obsługującego program.
     *          W naszym przypadku metoda main musi być statyczna, czyli ówcześnie utworzona, aby program mógł ruszyć.
     * void   - z ang. unieważnić, w wolniejszym tłumaczeniu nieważny, nieistotny.
     *          Informuje, iż dana metoda nic nam nie zwraca.
     *          Nie potrzebujemy wyniku pracy tej metody przetważać w innych miejscach kodu.
     * String[] - oznacza, iż zmienna args (patrz dalej) jest typem zmiennej tablicowej (tablicy),
     *          która przyjmuje dowolne ciągi znaków jako elementy tej tablicy
     * args   - jest umownie wpisanym słowem, skrótem od "arguments". Możesz tutaj wpisać cokolwiek innego, a program
     *          się wykona.
     *          Wykorzystywane jest, gdy program wywołujemy z konsoli (wiersza poleceń).
     *          Aby nasz program uruchomić w konsoli musimy wpisać "java Main". Jeśli do tego dopiszemy
     *          jakieś informacje np. "-f file.txt", czyli w naszym przypadku będzie to "java Main -f file.txt",
     *          to te dodatkowe informacje będą stanowć argumenty naszej metody. Spacja pomiędzy nimi jest separatorem.
     *          Także w tym przykładzie "-f" jest pierwszym argumentem, a "file.txt" jest drugim argumentem.
     * { }    - określa ciało metody. Analogicznie do ciała klasy.
     *
     * @param args - ten zapis w komentarzu dokumentującym jest ważny. Informuje, że do danej metody są przekazywane
     *             argumenty. W naszym przypadku wyjątkowo opisaliśmy je powyżej. Właściwie cały opis poniżej powinien
     *             znajdować się obok słowa args w tej linii (56).
     */
    public static void main(String[] args) {
        System.out.println("Metoda główna");
    }
    /**
     * Komentarz dokumentacyjny
     *
     * @param args opis argumentu
     * @return opis zwracanego parametru
     */
}
