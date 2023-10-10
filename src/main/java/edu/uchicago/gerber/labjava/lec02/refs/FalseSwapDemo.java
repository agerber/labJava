package edu.uchicago.gerber.labjava.lec02.refs;

public class FalseSwapDemo {

    public static void main(String[] args) {
        Person personA = new Person("Alice");
        Person personB = new Person("Bob");

        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");

        System.out.println("Before falseSwap:");
        System.out.println("personA: " + personA);
        System.out.println("personB: " + personB);

        falseSwap(personA, personB);

        System.out.println("\nAfter falseSwap:");
        System.out.println("personA: " + personA);
        System.out.println("personB: " + personB);

        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");

        System.out.println("Before mutateThenFalseSwap:");
        System.out.println("personA: " + personA);
        System.out.println("personB: " + personB);

        mutateThenFalseSwap(personA, personB);

        System.out.println("\nAfter mutateThenFalseSwap:");
        System.out.println("personA: " + personA);
        System.out.println("personB: " + personB);

        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");

        System.out.println("Before mutateObjects:");
        System.out.println("personA: " + personA);
        System.out.println("personB: " + personB);

        mutateObjects(personA, personB);

        System.out.println("\nAfter mutateObjects:");
        System.out.println("personA: " + personA);
        System.out.println("personB: " + personB);
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");

    }

    public static void falseSwap(Person a, Person b) {

        //because these references (memory addresses) are copies, however, if we attempt to repoint the
        //local references, these changes are NOT reflected outside the scope of this method.
        Person temp = a;
        a = b;
        b = temp;

        // Let's print inside the method after the swap
        System.out.println("\nInside method after swap:");
        System.out.println("a: " + a);
        System.out.println("b: " + b);
    }

    public static void mutateObjects(Person a, Person b){
        //When you pass an object reference (copy of memory address) into a method, the method
        //can still MUTATE the objects
        a.setName(a.getName() + "-|MUTATED|-");
        b.setName(b.getName() + "-|MUTATED|-");

    }

    public static void mutateThenFalseSwap(Person a, Person b) {

        //When you pass an object reference (copy of memory address) into a method, the method
        //can still MUTATE the objects
        a.setName(a.getName() + "-|MUTATED|-");
        b.setName(b.getName() + "-|MUTATED|-");

        //because these references (memory addresses) are copies, however, if we attempt to repoint the
        //local references, these changes are NOT reflected outside the scope of this method.
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

    //getter (accessor)
    public String getName() {
        return name;
    }

    //setter (mutator)
    public void setName(String name) {
        this.name = name;
    }


}
