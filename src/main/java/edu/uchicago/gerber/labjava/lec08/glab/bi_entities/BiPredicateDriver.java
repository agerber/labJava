package edu.uchicago.gerber.labjava.lec08.glab.bi_entities;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

public class BiPredicateDriver {


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
        final int minCharValue = 5;

        //BiPredicate use case, the second value can not be determined at compile time.
        BiPredicate<Dish, Integer> minChars = (dish, i) -> dish.getName().length() > i;

        menu.stream()
                .filter(d -> minChars.test(d, minCharValue))
                .forEach(d -> System.out.println(d));


    }
}


