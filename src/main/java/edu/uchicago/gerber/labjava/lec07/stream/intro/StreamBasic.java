package edu.uchicago.gerber.labjava.lec07.stream.intro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class StreamBasic {

    public static void main(String...args){
        // Java 7
        getHighCaloricDishesNamesInJava7(Dish.menu);


        System.out.println("---");

        // Java 8
        getHighCaloricDishesNamesInJava8(Dish.menu);

    }

    public static void getHighCaloricDishesNamesInJava7(List<Dish> dishes){
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for(Dish d: dishes){
            if(d.getCalories() > 400){
                lowCaloricDishes.add(d);
            }
        }
        List<String> lowCaloricDishesName = new ArrayList<>();
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            public int compare(Dish d1, Dish d2){
                return Integer.compare(d1.getCalories(), d2.getCalories());
            }
        });
        for(Dish d: lowCaloricDishes){
            lowCaloricDishesName.add(d.getName());
        }

        for (String dish : lowCaloricDishesName) {
            System.out.println(dish);
        }

    }

    public static void getHighCaloricDishesNamesInJava8(List<Dish> dishes){
         dishes.stream()
                .filter(d -> d.getCalories() > 400)
                .sorted(comparing(d -> d.getCalories()))
                .map(d -> d.getName())
                .forEach(s -> System.out.println(s));
    }
}
