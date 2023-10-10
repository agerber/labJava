package edu.uchicago.gerber.labjava.lec09.generics.interfaces;

import java.util.Arrays;

class Person implements Comparable<Person> {
    public Person(String firstName, String surname) {
        this.firstName = firstName;
        this.surname = surname;
    }

    public String toString() {
        return firstName + " " + surname;
    }

    public int compareTo(Person person) {
        int result = surname.compareTo(person.surname);
        return result == 0 ? firstName.compareTo(((Person) person).firstName) : result;
    }

    private String firstName;

    private String surname;
}

public class ComparableDriver {
    public static void main(String[] args) {
        Person[] authors = {
                new Person("D", "S"),
                new Person("J", "G"),
                new Person("T", "C"),
                new Person("C", "S"),
                new Person("P", "C"),
                new Person("B", "B") };

        Arrays.sort(authors); // Sort using Comparable method

        System.out.println("\nOrder after sorting into ascending sequence:");
        for (Person author : authors) {
            System.out.println(author);
        }

        Person[] people = {
                new Person("C", "S"),
                new Person("N", "K"),
                new Person("T", "C"),
                new Person("C", "D") };
        int index = 0;
        System.out.println("\nIn search of authors:");

        for (Person person : people) {
            index = Arrays.binarySearch(authors, person);
            if (index >= 0) {
                System.out.println(person + " was found at index position " + index);
            } else {
                System.out.println(person + "was not found. Return value is " + index);
            }
        }
    }
}
