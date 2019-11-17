package lec07.glab.stream.intro;



import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;



public class NumericStreams{

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
    
        List<Integer> numbers = Arrays.asList(3,4,5,1,2);

        Arrays.stream(numbers.toArray()).forEach(System.out::println);
        int calories = menu.stream()
                           .mapToInt(Dish::getCalories)
                           .sum();
        System.out.println("Number of calories:" + calories);


        // max and OptionalInt
        OptionalInt maxCalories = menu.stream()
                                      .mapToInt(Dish::getCalories)
                                      .max();

        int max;
        if(maxCalories.isPresent()){
            max = maxCalories.getAsInt();
        }
        else {
            // we can choose a default value
            max = 1;
        }
        System.out.println(max);

        // numeric ranges
        IntStream evenNumbers = IntStream.range(1, 100)
                                 .filter(n -> n % 2 == 0);

        System.out.println("number of even values" + evenNumbers.count());



        Stream<int[]> pythagoreanTriples =
               IntStream.rangeClosed(1, 100).boxed()
                        .flatMap(a -> IntStream.rangeClosed(a, 100)
                                               .filter(b -> Math.sqrt(a*a + b*b) % 1 == 0).boxed()
                                               .map(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}));       

        pythagoreanTriples.forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2])); 

    }
   
    public static boolean isPerfectSquare(int n){
        return Math.sqrt(n) % 1 == 0;
    }

}
