package edu.uchicago.gerber.labjava.lec02.glab._2023.refs;

public class FalseSwapDemo {

    public static void main(String[] args) {
        Person personA = new Person("Alice");
        Person personB = new Person("Bob");

        System.out.println("Before swap:");
        System.out.println("personA: " + personA);
        System.out.println("personB: " + personB);

        falseSwap(personA, personB);

        System.out.println("\nAfter swap:");
        System.out.println("personA: " + personA);
        System.out.println("personB: " + personB);
    }

    public static void falseSwap(Person a, Person b) {
        Person temp = a;
        a = b;
        b = temp;

        // Let's print inside the method after the swap
        System.out.println("\nInside method after swap:");
        System.out.println("a: " + a);
        System.out.println("b: " + b);
    }
}

class Person {
    String name;

    Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
