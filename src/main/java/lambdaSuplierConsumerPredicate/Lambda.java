package lambdaSuplierConsumerPredicate;

class Lambda {

    public static void main(String args[]) {

        /** Lambda expressions
         * https://www.tutorialspoint.com/java8/java8_lambda_expressions.htm
         */

        // Bez parametrów
        Nothing doNothing = () -> System.out.println("aa");
        doNothing.nothing();

        // Jeden parametr na wejściu
        Greeting sayHello = text -> System.out.println("Say " + text);
        sayHello.saySomething("Tomek");

        // Dwa paremetry na wejściu, wyjście obliczeniowe
        MyMath multiply = (i, j) -> i * j;
        int b = multiply.twoInt(5,5);
        System.out.println(b);

        // Dwa paremetry na wejściu, wyjście obliczeniowe z klamrami
        MyMath added = (i, j) -> {int aInternal = i * 100;
            int bInternal = j * 100;
            return aInternal + bInternal;};
        int c = added.twoInt(5,5);
        System.out.println(c);
    }

    @FunctionalInterface
    interface Nothing {
        void nothing ();
    }

    @FunctionalInterface
    interface Greeting {
        void saySomething (String string);
    }

    @FunctionalInterface
    interface MyMath {
        int twoInt (int i, int j);
    }
}