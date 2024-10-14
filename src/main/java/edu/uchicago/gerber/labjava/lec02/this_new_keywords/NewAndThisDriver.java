package edu.uchicago.gerber.labjava.lec02.this_new_keywords;

import java.util.ArrayList;

public class NewAndThisDriver {
    public static void main(String[] args) {


        //the constructor returns the memory address of the
        //newly instantiated object.

        //'this' keyword provides two things:
        //1. provides a way to call other constructors from within constructors
        //2. a way to access instances members.
        //3. provides a way to get a reference to the object on the heap at runtime, which is NOT know to us at
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

        /////////////////////////////////////////
        // exceptions to using the new keyword to instantiate
        /////////////////////////////////////////
        String str1 = new String("me");
        //this is a shortcut, but we are still constructing as above.
        String str2 = "me";

        printPair(str1, str2);


        ///////////////////////////////////////////
        double[] vals1 = new double[3];
        vals1[0] = 23.1;
        vals1[1] = 19.2;
        vals1[2] = 21.3;
        //this is a shortcut, but we are still constructing like above
        double[] vals2 = {23.1, 19.2, 21.3};

        printPair(vals1, vals2);

        ///////////////////////////////////////////
        Integer myInt1 = new Integer(14);
        //this is a shortcut, but we are still constructing like above
        Integer myInt2 = 14;

        printPair(myInt1, myInt2);

        ///////////////////////////////////////////

        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(new Integer(101));
        //Auto-Boxing
        nums.add(102);

        System.out.println("Iterating over this ArrayList of Integer objects");
        for (Integer num : nums) {
            System.out.println(num.getClass().getSimpleName() + " : " + num.intValue());
        }

        //Auto-UnBoxing
        int primitiveValue101 = nums.get(0);
        System.out.println("Auto-UnBoxing");
        System.out.println("This is a primitive int: " + primitiveValue101);

        //returns the doubled-object
        System.out.println(new Person("Adam", 50).doubleAgeOfPerson());


    }

    private static void printPair(Object obj1, Object obj2){
        System.out.println(obj1 + " : " + obj2);
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


    public void setAge(int age) {
        this.age = age;
    }

    // Method that mutates the existing object.
    public Person doubleAgeOfPerson() {
        // Use of 'new' to create a new object
        setAge(this.age * 2);
        return this;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}
