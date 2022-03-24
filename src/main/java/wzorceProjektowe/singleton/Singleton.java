package wzorceProjektowe.singleton;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Test Singletona bez wątków
 */
class ScrabbleTest {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        System.out.println("Instance1 ID: " + System.identityHashCode(instance1));
        System.out.println("All letters: " + instance1.getLetterList());
        System.out.println("Letters for player 1: " + instance1.getTiles(7));

        System.out.println("-----------------");

        Singleton instance2 = Singleton.getInstance();
        System.out.println("Instance1 ID: " + System.identityHashCode(instance1));
        System.out.println("Instance2 ID: " + System.identityHashCode(instance2));
        System.out.println("All letters: " + instance2.getLetterList());
        System.out.println("Letters for player 2: " + instance1.getTiles(7));
    }
}

/**
 * Test Singletona z wieloma wątkami
 */
class ScrabbleThreadTest {
    public static void main(String[] args) {
        System.out.println("Wątek 1");
        Runnable getTiles = new GetTheTiles();
        new Thread(getTiles).start();

        System.out.println("--------------");

        System.out.println("Wątek 2");
        Runnable getTilesAgain = new GetTheTiles();
        new Thread(getTilesAgain).start();
    }
}

class GetTheTiles implements Runnable {

    @Override
    public void run() {
        Singleton instance = Singleton.getInstance();
        System.out.println("Instance ID: " + System.identityHashCode(instance));
        System.out.println("All letters: " + instance.getLetterList());
        System.out.println("Letters for player 1: " + instance.getTiles(7));

    }
}

/**
 * Singleton jest używany, gdy chesz wyeliminować opcję więcej niż jednej instancji obiektu
 * oraz chcesz mieć kontrolę nad danymi, zawartymi w ramach klasy.
 * Poniższy przykład obrazuje to na podstawie zestawu liter od Scrabble. Scrabble mająo określony
 * zestaw liter. Tworząc Singletona dajemy możliwość, że każdy gracz nie pobierze tych samych
 * liter, a otrzyma swój własny ograniczony zestaw liter.
 *
 * Źródło: https://www.youtube.com/watch?v=NZaXM67fxbs
 */
class Singleton {
    private static Singleton firstInstance = null;

    private static boolean thread = true;

    private static final String[] scrabbleLetters = {
            "a", "a", "a", "a", "a", "a", "a", "a", "a", "b", "b", "c", "c",
            "d", "d", "d", "d", "e", "e", "e", "e", "e", "e", "e", "e", "e",
            "e", "e", "e", "f", "f", "g", "g", "g", "h", "h", "i", "i", "i",
            "i", "i", "i", "i", "i", "i", "j", "k", "l", "l", "l", "l", "m",
            "m", "n", "n", "n", "n", "n", "n", "o", "o", "o", "o", "o", "o",
            "o", "o", "p", "p", "q", "r", "r", "r", "r", "r", "r", "s", "s",
            "s", "s", "t", "t", "t", "t", "t", "t", "u", "u", "u", "u", "v",
            "v", "w", "w", "x", "y", "y", "z",};

    private static final LinkedList<String> letterList = new LinkedList<>(Arrays.asList(scrabbleLetters));

    /**
     * Ustawianie pojednyczej instancji Singletona
     */
    public static Singleton getInstance() {
        if (firstInstance == null) {

            /**
             * Spowolnienie klasy - zrealizowane na potrzeby wytłumaczenia
             * problemów z instancjami dla wielu wątków
             */
            if (thread) {
                thread = false;
                Thread.currentThread();
                try {
                    Thread.sleep(2500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            /**
             * syncrhronized jest potrzebny, aby wiele wątków mogło równloegle pracować
             * i zapewnić tą samą instancję Singletona
             */
            synchronized (Singleton.class) {
                if (firstInstance == null) {
                    firstInstance = new Singleton();
                    Collections.shuffle(letterList);
                }
            }
        }
        return firstInstance;
    }


    public LinkedList<String> getLetterList() {
        return letterList;
    }

    public LinkedList<String> getTiles(int howManyTiles) {
        LinkedList<String> tilesToSend = new LinkedList<String>();

        for (int i = 0; i < howManyTiles; i++) {
            tilesToSend.add(letterList.remove(0));
        }
        return tilesToSend;
    }
}

