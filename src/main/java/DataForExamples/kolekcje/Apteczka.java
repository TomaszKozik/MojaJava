package DataForExamples.kolekcje;

import java.util.ArrayList;
import java.util.List;

public class Apteczka {

    public static List<String> apteczka = new ArrayList<>();

    public static List<String> getApteczka() {
        apteczka.add("instrukcja udzielania pierwszej pomocy");
        apteczka.add("sterylne kompresy gazowe");
        apteczka.add("plastry z opatrunkiem");
        apteczka.add("plaster bez opatrunku");
        apteczka.add("bandaże");
        apteczka.add("opaska elastyczna");
        apteczka.add("środek dezynfekujący (np. jodyna)");
        apteczka.add("ustnik do wykonania sztucznego oddychania metodą usta-usta");
        apteczka.add("chusta trójkątna");
        apteczka.add("lateksowe rękawiczki ochronne (przynajmniej jedna para)");
        apteczka.add("koc z foli termoizolacyjnej");
        apteczka.add("agrafki");
        apteczka.add("nożyczki");
        return apteczka;
    }
}
