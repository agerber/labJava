package edu.uchicago.gerber.labjava.lec07.stream.intro;



import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;


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


        Predicate<Dish> predicateMoreThan400 = d -> d.getCalories() > 400;

        Function<Dish, Dish>
                functionSuperSizeMe = d -> new Dish(d.getName(), d.isVegetarian(), d.getCalories() * 2, d.getType());

        BiConsumer<Dish.Type, List<Dish>> printMe = (t, list) -> System.out.println(t + ":" + list);

      //  Map<Dish.Type, List<Dish>>  map =
      menu.stream()
               .filter(predicateMoreThan400)
               .map(functionSuperSizeMe)
                .collect(Collectors.groupingBy(dish -> dish.getType()))
               .forEach(printMe);








//        List<String> langs = new ArrayList<>();
//
//        langs.add( "Java");
//        langs.add(  "C++");
//        langs.add(  "Python");
//        langs.add(  "TypeScript");
//        langs.add(  "Kotlin");
//
//        final String python = "Python";
//
//        langs.stream()
//                .filter()
//                .forEach(s -> System.out.println(s));



















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
