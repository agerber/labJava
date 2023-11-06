package edu.uchicago.gerber.labjava.lec08.bi_entities;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;

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


        Scanner in = new Scanner(System.in);
        System.out.println("Enter your character:");

        //let's assume this variable is coming from the user, and therefore we can not set it at compile time.
        final Character someChar = String.valueOf(in.nextLine()).charAt(0);


        //one good use case for BiFunctions is that the second parameter is not known at R/T, or is passed in.
        BiFunction<Dish, Character, Dish> dishStringDishBiFunction = (dish, c) ->
        {
            if (dish.getName().charAt(0) == c)
               return new Dish(dish.getName().toUpperCase(), dish.isVegetarian(), dish.getCalories(), dish.getType());
            else
                return dish;
        };

        menu.stream()
                .map(d -> dishStringDishBiFunction.apply(d, someChar ))
                .forEach(d -> System.out.println(d));

    }


}

