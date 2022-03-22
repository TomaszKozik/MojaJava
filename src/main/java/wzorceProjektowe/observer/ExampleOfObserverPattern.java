package wzorceProjektowe.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Wzorzec Observer służy do nasłuchiwania wątków,a dokładniej do sprawdzania końca ich pracy.
 * Jest to potrzebne np. gdy spodziewamy się dłuższych czasów na pobieranie np. plików z serwera.
 *
 * Wymaga interfejsu, który narzuca metody informujące o końcu działania wątku (poniżej Observer)
 * w klasie, która potrzebuje informacji o zakończeniu pracy wątku.
 */
public class ExampleOfObserverPattern {
    public static void main(String[] args) {
        Subject subject = new Subject();        // Nowy wątek
        subject.addObserver(new Client1());     // Pierwszy klient nasłuchujący wątek
        subject.addObserver(new Client2());     // Drugi klient nasłuchujący wątek
        subject.startWork();                    // Start wątku
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Do something else in the middle of the thread");
    }
}

interface Observer {

    void update();
}

/**
 * Klient 1 oczekujący na zakończenie wątku
 */
class Client1 implements Observer {

    @Override
    public void update() {
        System.out.println("Koniec pracy: " + getClass().getName());
    }
}

/**
 * Klient 2 oczekujący na zakończenie wątku
 */
class Client2 implements Observer {

    @Override
    public void update() {
        System.out.println("Koniec pracy: " + getClass().getName());
    }
}

/**
 * Klasa Subject symuluje pracę wątku, który ma trwać przez jakiś nieokreślony czas
 * i poprzez metodę interfejsu Observer ma zwrócić informacje o swoim zakończeniu.
 */
class Subject {

    public List<Observer> observers;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public Subject() {
        observers = new ArrayList<>();
    }

    public void startWork() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 100; i++) {
                    System.out.println("Czas: " + i * 100 + "ms");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                observers.forEach(Observer::update);
            }
        });
        thread.start();
    }
}
