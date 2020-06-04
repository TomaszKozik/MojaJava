import java.util.Arrays;
import java.util.Scanner;

public class Tablice {

    public static void main(String[] args) {

        /*
          Deklaracja tablicy
         */
        int[] tablicaInt1; // częściej praktykowany zapis
        int tablicaInt2[];

        /*
          Deklaracja tablicy int z bezpośrednim przypisaniem czterech elementów
          Tablica wówczas jest 4-elementowa.
         */
        int[] numbers = {1, 2, 3, 4};

        /*
          Deklaracja tablicy poprzez konstruktor  z określeniem ilości elementów
          w tym przykładzie n=4
         */
        int n = 4;
        int[] tablicaInt3 = new int[n];

        /*
          Deklaracja tablicy poprzez konstruktor z przypisaniem elementów
         */
        float[] floatNumbers = new float[]{1.02f, 0.03f, 4f};

        /*
          Tablica wielowymiarowa
         */
        int[][] tablicaDwuwymiarowa = {
                {1, 2, 3, 1}, // tablica 1
                {3, 4, 1, 2}, // tablica 2
                {4, 4, 1, 0}  // tablica 3
        };

        /*
          Pobieranie elementów z tablicy
          Tablica jest indeksowana od wartości 0. Podając w nawiasie kwadratowym
          numer indeksu zwracany jest odpowiedni element
         */
        int[] numbers2 = {1, 2, 3, 4};
        System.out.println(numbers2[0]); // 1
        System.out.println(numbers2[1]); // 2
        System.out.println(numbers2[2]); // 3
        System.out.println(numbers2[3]); // 4

        /*
          Przetwarzanie tablicy
          Realizowane jest przez klasę Arrays
          Wymaga importu java.util.Arrays;
          Tablice są typami referencyjnimi. Oznacza to, że jeśli zmienisz rzeczywistą
          wartość (elementy tablicy) w treści metody, zobaczysz te zmiany poza metodą.
         */
        int[] famousNumbers = {0, 1, 2, 8, 3, 10, 20, 4}; // przykładowa tablica
        String arrayAsString = Arrays.toString(famousNumbers);
        System.out.println(arrayAsString);  // [0, 1, 2, 8, 3, 10, 20, 4]
        Arrays.sort(famousNumbers);
        System.out.println(Arrays.toString(famousNumbers)); // [0, 1, 2, 3, 4, 8, 10, 20]
    }

    static class Varargs {

        /**
         * Tablice wieloelementowe
         * Możliwe jest przekazanie dowolnej liczby argumentów tego samego typu
         * do metody przy użyciu specjalnej składni o nazwie varargs (argumenty o zmiennej długości).
         * Argumenty te są określone przez trzy kropki po typie.
         * W treści metody można przetworzyć ten parametr jako zwykłą tablicę określonego typu.
         *
         * @param numbers
         */
        public static void method(int... numbers) {
            System.out.println(numbers.length);
        }

        /**
         * Poprawny zapis tablic varargs z zmiennymi, jako argumenty w metodzie
         */
        public static void method(int a, double... varags) { /* do something */ }
    }

    /**
     * Zadanie 1
     * Wykorzystanie refenecji tablicy dla zmian jej parametrów
     */
    public static class Zadanie1 {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            long[] array = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToLong(Long::parseLong)
                    .toArray();
            int index = scanner.nextInt();
            long value = scanner.nextLong();
            addValueByIndex(array, index, value); // Ingerencja w parametry tablicy
            Arrays.stream(array).forEach(e -> System.out.print(e + " "));
        }

        private static void addValueByIndex(long[] array, int index, long value) {
            for (int i = 0; i < array.length; i++) {
                if (index == i) {
                    array[i] += value;
                }
            }
        }
    }
}
