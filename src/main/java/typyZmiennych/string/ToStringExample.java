package typyZmiennych.string;

/**
 * Główna klasa Java Objectma toString()metodę uzyskania reprezentacji ciągu obiektu.
 * Jeśli chcesz mieć swój ciąg znaków, zastąp tę metodę w swojej klasie.
 */
public class ToStringExample {

    static class PrzykladDlaKlasBezDziedziczenia {
        public static void main(String[] args) {
            Account account = new Account(1121, "111-123", 400_000L);
            System.out.println(account.toString()); // Account{id=1121,code=111-123,balance=400000}
            System.out.println(account);            // możliwe dla IntelliJ IDEA - posiada domyślnie pobieranie dla toString
        }

        static class Account {
            private long id;
            private String code;
            private Long balance;

            public Account(long id, String code, Long balance) {
                this.id = id;
                this.code = code;
                this.balance = balance;
            }

            // getters and setters

            @Override
            public String toString() {
                return "Account{id=" + id + ",code=" + code + ",balance=" + balance + "}";
            }
        }
    }

    static class PrzykladDlaKlasZDziedziczeniem {

        public static void main(String[] args) {
            Person person = new Person("Helena");
            Employee employee = new Employee("Michael", 10_000);
            System.out.println(person);   // Person{name=Helena}
            System.out.println(employee); // Employee{name='Michael,salary=10000}
        }

        static class Person {
            protected String name;

            public Person(String name) {
                this.name = name;
            }

            @Override
            public String toString() {
                return "Person{name=" + name + "}";
            }
        }

        static class Employee extends Person {
            protected long salary;

            public Employee(String name, long salary) {
                super(name);
                this.salary = salary;
            }

            @Override
            public String toString() {
                return "Employee{name='" + name + ",salary=" + salary + "}";
            }
        }
    }
}