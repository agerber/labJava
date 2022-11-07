package edu.uchicago.gerber.labjava.lec08.glab.group_by;





import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import edu.uchicago.gerber.labjava.lec08.glab.*;

public class GroupByDriver {
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

    public static void main(String[] args) {

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


        }
}

