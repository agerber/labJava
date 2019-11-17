package lec07.glab.stream.intro;



import java.util.Arrays;
import java.util.List;


public class Reducing{

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

//        List<Integer> numbers = Arrays.asList(3,4,5,1,2);
//        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
//        System.out.println(sum);
//
//        int sum2 = numbers.stream().reduce(0, Integer::sum);
//        System.out.println(sum2);
//
//        int max = numbers.stream().reduce(0, (a, b) -> Integer.max(a, b));
//        System.out.println(max);
//
//        Optional<Integer> min = numbers.stream().reduce(Integer::min);
//        min.ifPresent(System.out::println);

        int calories = menu.stream()
                           .map(Dish::getCalories)
                           .reduce(0, Integer::sum);
        System.out.println("Number of calories:" + calories);
    }
}
