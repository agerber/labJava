package edu.uchicago.gerber.labjava.lec08.meth_refs;



import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import       java.awt.Rectangle;

public class MethodReferenceDemo {

    // Example of a static method
    public static void staticMethod(String data) {
        System.out.println("Static Method: " + data);
    }

    // Example of an instance method
    public void instanceMethod(String data) {
        System.out.println("Instance Method: " + data);
    }

    public static void main(String[] args) {
        List<String> strings1 = Arrays.asList("One", "Two", "Three");

        // Reference to a static method
        strings1.forEach(MethodReferenceDemo::staticMethod);
        //the lambda expression equivalent
        strings1.forEach(s -> MethodReferenceDemo.staticMethod(s));

        // Reference to an instance method of a particular object
        MethodReferenceDemo demo = new MethodReferenceDemo();
        strings1.forEach(demo::instanceMethod);
        //the lambda expression equivalent
        strings1.forEach(s -> demo.instanceMethod(s));

        // Reference to an instance method of an arbitrary object of a particular type
        strings1.forEach(String::toLowerCase);
        //the lambda expression equivalent
        strings1.forEach(s -> s.toLowerCase());

        // Reference to a constructor
        Supplier<Rectangle> supplier = Rectangle::new;
         //the lambda expression equivalent
        Supplier<Rectangle> supplier2 = () -> new Rectangle();


        Rectangle rectangle = supplier.get();

        // Use the reference to call the instance method
        rectangle.setBounds(1,2,3,4);
        System.out.println(rectangle);

        //create some more ArrayLists of strings
        List<String> strings2 = Arrays.asList("Four", "Five");
        List<String> strings3 = Arrays.asList("Six", "Seven", "Eight");

        processStrings(strings1, strings2, strings3);

    }

    private static void processStrings(List<String>... lists){
        Arrays.stream(lists)
                .flatMap(Collection::stream)
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}

