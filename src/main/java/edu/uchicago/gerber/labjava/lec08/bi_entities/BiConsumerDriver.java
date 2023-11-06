package edu.uchicago.gerber.labjava.lec08.bi_entities;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiConsumer;

public class BiConsumerDriver {

    //1. use-case either you are consuming a map, or Pair. See: GroupByDriver.java
    //2. you don't know the second parameter until R/T. see below:

    public static void main(String[] args) {

        final List<Dish> menu =
                Arrays.asList( new Dish("pork", false, 800, Dish.Type.MEAT),
                        new Dish("beef", false, 700, Dish.Type.MEAT),
                        new Dish("chicken", false, 400, Dish.Type.MEAT),
                        new Dish("french fries", true, 530, Dish.Type.OTHER),
                        new Dish("rice", true, 350, Dish.Type.OTHER),
                        new Dish("season fruit", true, 120, Dish.Type.OTHER),
                        new Dish("pizza", true, 550, Dish.Type.OTHER),
                        new Dish("prawns", false, 400, Dish.Type.FISH),
                        new Dish("salmon", false, 450, Dish.Type.FISH));


        //let's assume this value comes from another query at R/T

        Scanner in = new Scanner(System.in);
        System.out.println("What is your left-tab message:");

        //let's assume this variable is coming from the user, and therefore we can not set it at compile time.
        final String message = String.valueOf(in.nextLine());


        //BiConsumer use case, the second value can not be determined at compile time.
        BiConsumer<Dish, String> dishWithMessage = (dish, s) -> System.out.println(s + ":"  + dish);

        menu.stream()
                .forEach(d -> dishWithMessage.accept(d, message));



        //are there TriPredicates or TriFunctions? No, create your own wrapper class, which wraps the
        //multiple classes and use that as your seocnd parameter.



    }



}
