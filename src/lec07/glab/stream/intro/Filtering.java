package lec07.glab.stream.intro;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;


public class Filtering{



    public static final List<Dish> menu =
            Arrays.asList( new Dish("pork", false, 800, Dish.Type.MEAT),
                    new Dish("beef", false, 700, Dish.Type.MEAT),
                    new Dish("chicken", false, 400, Dish.Type.MEAT),
                    new Dish("french fries", true, 530, Dish.Type.OTHER),
                    new Dish("rice", true, 350, Dish.Type.OTHER),
                    new Dish("season fruit", true, 120, Dish.Type.OTHER),
                    new Dish("pizza", true, 550, Dish.Type.OTHER),
                    new Dish("prawns", false, 400, Dish.Type.FISH),
                    new Dish("salmon", false, 450, Dish.Type.FISH));

    public static void main(String...args){

       Predicate<Dish> dishPredicate = d -> d.getCalories() > 400;

       Function<Dish, String> getName = d -> d.getName();

       Consumer<Dish> printMe = d -> System.out.println(d);

       boolean areFrenchFriesFattening = dishPredicate.test(menu.get(3));
       System.out.println("French fries have lots of calories ? " + areFrenchFriesFattening);

       String theName = getName.apply(menu.get(3));
        System.out.println(theName);


//
//
         menu.stream()
               .filter(d -> d.getCalories() > 400)     //Stream<Dish>
               .map(d -> new Dish(d.getName(), d.isVegetarian(), d.getCalories() * 2, d.getType()))  //Stream<Dish>
               .forEach(d -> System.out.println(d));


       // List<Dish> accumulator = new ArrayList<>();

//        for (Dish dish : menu) {
//            if (dish.getCalories() > 400){
//                dish = new Dish(dish.getName(), dish.isVegetarian(), dish.getCalories() * 2, dish.getType());
//                System.out.println(dish);
//
//            }
//        }





//        for (Dish dish : menu) {
//            if (dishPredicate.test(dish)){
//                System.out.println(dish);
//            }
//        }
//        for (Dish dish : menu) {
//            System.out.println(dishStringFunction.apply(dish));
//        }














//        // Filtering with predicate
//        List<Dish> vegetarianMenu =
//            menu.stream()
//                .filter(Dish::isVegetarian)
//                .collect(toList());
//
//        vegetarianMenu.forEach(System.out::println);
//
//        // Filtering unique elements
//        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
//        numbers.stream()
//               .filter(i -> i % 2 == 0)
//               .distinct()
//               .forEach(System.out::println);
//
//        // Truncating a stream
//        List<Dish> dishesLimit3 =
//            menu.stream()
//                .filter(d -> d.getCalories() > 300)
//                .limit(3)
//                .collect(toList());
//
//        dishesLimit3.forEach(System.out::println);
//
//        // Skipping elements
//        List<Dish> dishesSkip2 =
//            menu.stream()
//                .filter(d -> d.getCalories() > 300)
//                .skip(2)
//                .collect(toList());
//
//        dishesSkip2.forEach(System.out::println);
    }
}
