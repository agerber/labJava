package edu.uchicago.gerber.labjava.lec09.morepatterns.factory;

import java.util.List;

public class FactoryDriver {
    public static void main(String[] args) {

       //a static method that constructs an object for you, typically with some input.
       List list = ListFactory.createList(ListFactory.Type.LINKED);
       list.add("Hello");
       list.add("Goodbye");

       list.forEach(System.out::println);
    }
}
