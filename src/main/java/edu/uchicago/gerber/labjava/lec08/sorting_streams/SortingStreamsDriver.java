package edu.uchicago.gerber.labjava.lec08.sorting_streams;


import edu.uchicago.gerber.labjava.lec08.Dish;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class SortingStreamsDriver {
    public static void main(String[] args) {

       final List<Dish> menu =
                Arrays.asList( new Dish("pork", false, 800, Dish.Type.MEAT),

                        new Dish("chicken", false, 400, Dish.Type.MEAT),
                        new Dish("french fries", true, 530, Dish.Type.OTHER),
                        new Dish("rice", true, 350, Dish.Type.OTHER),
                        new Dish("season fruit", true, 120, Dish.Type.OTHER),
                        new Dish("pizza", true, 550, Dish.Type.OTHER),
                        new Dish("prawns", false, 400, Dish.Type.FISH),
                        new Dish("salmon", false, 450, Dish.Type.FISH),
                        new Dish("beef", false, 700, Dish.Type.MEAT));



           //We can toggle among, anon, lambda, and meth reference
            menu.stream()

                    .sorted(new Comparator<Dish>() {
                        @Override
                        public int compare(Dish o1, Dish o2) {
                           return o1.compareTo(o2);
                        }
                    })
                    .map(d -> d.getName())
                    .map(new Function<String, String>() {
                        @Override
                        public String apply(String s) {
                            return s.toUpperCase();
                        }
                    })
                    //.map(dish -> dish.getName())
                  //  .map(String::toUpperCase)
                    .forEach(d -> System.out.println(d));

        }
}
