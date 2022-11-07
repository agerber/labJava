package edu.uchicago.gerber.labjava.lec08.glab.bi_entities;

import edu.uchicago.gerber.labjava.lec09.glab.generics.basics.Pair;

import javax.print.attribute.standard.MediaSize;
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


        //let's assume this value comes from another query, or user-input at R/T
        final int minCharValue = 5;

        //BiPredicate use case, the second value can not be determined at compile time.
        BiPredicate<Dish, Integer> minChars = (dish, min) -> dish.getName().length() > min;

        menu.stream()
                .filter(dish -> minChars.test(dish, minCharValue))
                .forEach(dish -> System.out.println(dish));








        //are there TriPredicates or TriFunctions? No, create your own wrapper class, which wraps the
        //multiple classes and use that as your seocnd parameter.
        final int maxCals = 300;
        final String name = "Adam";
        Pref<Integer, String> pref = new Pref<>(maxCals, name);


        BiPredicate<Dish, Pref<Integer,String>> onlyUserPrefs = (dish, p) -> {
               if( pref.getSecond().equalsIgnoreCase("ADAM")) {
                 return dish.getCalories() < p.getFirst() * 2;
               } else {
                   return dish.getCalories() <  p.getFirst();
               }
        };



        System.out.println(":::::ONLY THOSE DISHES WITH CALS LESS THAN 400, unless it's Adam, in which case 600");

        menu.stream()
                .filter(d -> onlyUserPrefs.test(d, pref))
                .forEach(d -> System.out.println(d));



    }
}


