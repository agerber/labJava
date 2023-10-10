package edu.uchicago.gerber.labjava.lec02.this_new_keywords;

public class NewAndThisDriver {
    public static void main(String[] args) {


        //the constructor returns the memory address of the
        //newly instantiated object.

        //'this' keyword provides two things:
        //1. provides a way to call other constructors from within constructors
        //2. provides a way to get a reference to the object on the heap at runtime, which is NOT know to us at
        // compile-time.


        //one-arg consturctor
        Person person1 = new Person("Alice");

        //two-arg constructor
        Person person2 = new Person("Bob", 25);

        //no-arg constructor
        Person person3 = new Person();

        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person3);
    }
}

class Person {
    private String name;
    private int age;

    // Constructor using only the name and setting a default age
    public Person() {
        // Use of 'this' to call another constructor
        this("Adam", 0);
    }


    // Constructor using only the name and setting a default age
    public Person(String name) {
        // Use of 'this' to call another constructor
        this(name, 0);
    }

    // Constructor using both name and age
    public Person(String name, int age) {
        // Use of 'this' to refer to the instance's variable and distinguish from method parameters
        this.name = name;
        this.age = age;
    }

    // Method that creates and returns a new instance of Person with the same details
    public Person createCopy() {
        // Use of 'new' to create a new object
        return new Person(this.name, this.age);
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}
