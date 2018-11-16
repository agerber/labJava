package lec08.glab.lambda.behaviorParam2;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

/**
 * Created by Adam on 7/15/2015.
 */
public class UsingFilters {
    public static void main(String[] args) {




        //some fun with simple predicates and consumers
        List<String> myList =   Arrays.asList("afjhasdfjasfdsdfa", "basfd", "casf", "dasfdadfs", "easasdfasdsfaafds");

        Predicate<String> startsWithC =  s -> s.startsWith("c");
        IntPredicate lessThanFive = n -> n < 6;

        Function<String,String> capMe = s -> s.toUpperCase();

        Consumer<String> consumeMe = s -> System.out.println(s);
        IntConsumer consumeMeInt = s -> System.out.println(s);


        myList.stream()
                .filter(startsWithC.negate()) //intermediate
                .map(s -> s.length())
                .filter(i -> lessThanFive.test(i))
                //.map(capMe) //intermediate
                .forEach(i -> consumeMeInt.accept(i)); //terminal










    }
}
