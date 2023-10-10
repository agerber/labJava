package edu.uchicago.gerber.labjava.lec02.glab.composition;

import java.util.ArrayList;
import java.util.List;

public class CompositionDemo {

    public static void main(String[] args) {
        List<String> friends = new ArrayList<>();
        friends.add("Charlie");
        friends.add("Mia");

        Address address = new Address("123 Main St", "Springfield", "12345");
        User user = new User("Adam", 52, address, friends);

        System.out.println(user);
    }
}

class Address {


    private String street;
    private String city;
    private String zipCode;

    public Address(String street, String city, String zipCode) {

        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return street + ", " + city + ", " + zipCode;
    }
}

class User {

    private String name;
    private int age;  // primitive
    private Address address;  // object
    private List<String> friends;  // ArrayList<String>

    public User( String name, int age, Address address, List<String> friends) {

        this.name = name;
        this.age = age;
        this.address = address;
        this.friends = friends;
    }

    @Override
    public String toString() {
        return name + ": Age: " + age + ", Address: " + address + ", Friends: " + friends;
    }
}
