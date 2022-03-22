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
public class DesignPattern_Observer {
    public static void main(String[] args) {
        Subject subject = new Subject();
        subject.addObserver(new Client1());
        subject.addObserver(new Client2());
        subject.startWork();
    }
}

interface Observer {

    void update();
}

class Client1 implements Observer {

    @Override
    public void update() {
        System.out.println("Koniec pracy: " + getClass().getName());
    }
}

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
                for (int i = 0; i < 100; i++) {
                    System.out.println(i);
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
