package klasyIMetody;

/**
 * Nadpisanie metod dotyczy metod znajdujących się w dziedziczonych klasach.
 * Nadpisać metodę można, gdy każda z metod ma takie same dane wejściowe, jak i wyjściowe.
 * Adnotację @Override stosuje się, jako informację o nadpisaniu.
 */
public class NadpisanieMetod {

    public static void main(String args[]) {
        FirstClass firstClass = new FirstClass();
        firstClass.metodaDoNadpisania();

        SecondClass secondClass = new SecondClass();
        secondClass.metodaDoNadpisania();
    }

    static class FirstClass {
        public void metodaDoNadpisania() {
            System.out.println("Przed nadpisaniem");
        }
    }

    static class SecondClass extends FirstClass {
        @Override
        public void metodaDoNadpisania() {
            System.out.println("Po nadpisaniu");
        }
    }
}
