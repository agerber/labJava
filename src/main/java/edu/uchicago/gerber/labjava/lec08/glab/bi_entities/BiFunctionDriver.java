package edu.uchicago.gerber.labjava.lec08.glab.bi_entities;

import java.util.ArrayList;
import java.awt.Rectangle;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Stream;

public class BiFunctionDriver {

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



        //let's assume this variable is coming from the user, and therefore we can not set it at compile time.
        final String someString = "s";

        //one good use case for BiFunctions is that the second parameter is not known at R/T
        BiFunction<Dish, String, Dish> dishStringDishBiFunction = (d, s) ->
        {
            if (d.getName().startsWith(s))
               return new Dish(d.getName().toUpperCase(), d.isVegetarian(), d.getCalories(), d.getType());
            else
                return d;
        };

        menu.stream()
                .map(d -> dishStringDishBiFunction.apply(d, someString ))
                .forEach(d -> System.out.println(d));

    }


}

