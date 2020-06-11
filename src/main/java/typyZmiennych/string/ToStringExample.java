package typyZmiennych.string;

import java.lang.reflect.Array;

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


    // https://hyperskill.org/learn/step/3000
    static class Zadanie1 {

        private String login;
        private String firstName;
        private String lastName;

        public Zadanie1(String login, String firstName, String lastName) {
            this.login = login;
            this.firstName = firstName;
            this.lastName = lastName;
        }

        @Override
        public String toString() {
            return "login=" + login + ",firstName=" + firstName + ",lastName=" + lastName;
        }
    }

    // https://hyperskill.org/learn/step/3002
    static class Zadanie2 {
        private int hours;
        private int minutes;
        private int seconds;

        public Zadanie2(int hours, int minutes, int seconds) {
            this.hours = hours;
            this.minutes = minutes;
            this.seconds = seconds;
        }

        @Override
        public String toString() {
            return String.format("%02d:%02d:%02d", hours, minutes, seconds);
        }
    }

    // https://hyperskill.org/learn/step/3001
    static class Zadanie3 {
        static class Book {
            private String title;
            private int yearOfPublishing;
            private String[] authors;

            public Book(String title, int yearOfPublishing, String[] authors) {
                this.title = title;
                this.yearOfPublishing = yearOfPublishing;
                this.authors = authors;
            }

            @Override
            public String toString() {
                return "title=" + title + ",yearOfPublishing=" + yearOfPublishing + ",authors=[" + String.join(",", authors) + "]";
            }

            public static void main(String[] args) {
                String[] array = {"Mario Fusco", "Alan Mycroft"};
                Book book = new Book("Java 8 & 9 in Action",2017, array);
                System.out.println(book.toString());
            }
        }
    }
}