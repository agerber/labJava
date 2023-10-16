package edu.uchicago.gerber.labjava.lec03._more_interfaces;

public class Person implements Comparable<Person> {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Person other) {
        // Compare based on age
        return this.age - other.age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + '}';
    }

    public static void main(String[] args) {
        Person person1 = new Person("Alice", 30);
        Person person2 = new Person("Bob", 25);

        if (person1.compareTo(person2) > 0) {
            System.out.println(person1.getName() + " is older than " + person2.getName());
        } else if (person1.compareTo(person2) < 0) {
            System.out.println(person1.getName() + " is younger than " + person2.getName());
        } else {
            System.out.println(person1.getName() + " and " + person2.getName() + " are of the same age");
        }
    }
}
