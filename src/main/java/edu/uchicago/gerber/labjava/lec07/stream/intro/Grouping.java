package edu.uchicago.gerber.labjava.lec07.stream.intro;

import java.util.*;

import static java.util.stream.Collectors.*;


public class Grouping {

    enum CaloricLevel { DIET, NORMAL, FAT };

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

    public static void main(String ... args) {


       printGroupDishes(menu.stream().collect(groupingBy(Dish::getType)));

        System.out.print("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");

       printGroupDishes(menu.stream().collect(
               groupingBy(dish -> {
                   if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                   else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                   else return CaloricLevel.FAT;
               } )));

        System.out.print("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");

        //group by number (count) of items in teach dish-type
        printMap(menu.stream().collect(groupingBy(Dish::getType, counting())));

        System.out.print("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");



        printMap(menu.stream().collect(groupingBy(Dish::getType,
                summingInt(Dish::getCalories))));

        System.out.print("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");



        printMap(menu.stream().collect(
                groupingBy(Dish::getType, mapping(
                        dish -> { if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                        else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                        else return CaloricLevel.FAT; },
                        toSet() ))));


//        System.out.println("Dishes grouped by type and caloric level: " + groupDishedByTypeAndCaloricLevel());
//        System.out.println("Count dishes in groups: " + countDishesInGroups());
//        System.out.println("Most caloric dishes by type: " + mostCaloricDishesByType());
//        System.out.println("Most caloric dishes by type: " + mostCaloricDishesByTypeWithoutOprionals());
//        System.out.println("Sum calories by type: " + sumCaloriesByType());
//        System.out.println("Caloric levels by type: " + caloricLevelsByType());
    }


    private static void printGroupDishes(Map<?, List<Dish>> map){
        for (Object object : map.keySet()) {
            System.out.println("######### " + object.toString() + " #############");
            List<Dish> list = map.get(object);
            for (Dish dish : list) {
                System.out.println("              " + dish.toString());
            }
        }
    }

    private static void printMap(Map<?,?> map){
        for (Object key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));

        }
    }




    private static Map<Dish.Type, Optional<Dish>> mostCaloricDishesByType() {
        return menu.stream().collect(
                groupingBy(Dish::getType,
                        reducing((Dish d1, Dish d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2)));
    }


    private static Map<Dish.Type, Integer> sumCaloriesByType() {
        return menu.stream().collect(groupingBy(Dish::getType,
                summingInt(Dish::getCalories)));
    }

    private static Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType() {
        return menu.stream().collect(
                groupingBy(Dish::getType, mapping(
                        dish -> { if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                        else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                        else return CaloricLevel.FAT; },
                        toSet() )));
    }
}
