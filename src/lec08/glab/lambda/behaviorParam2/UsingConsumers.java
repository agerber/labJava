package lec08.glab.lambda.behaviorParam2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by Adam on 7/15/2015.
 */
public class UsingConsumers {

    public static void main(String[] args) {

        List<String> myList =   Arrays.asList("a1", "a2", "b1", "c2", "c1");


        Consumer<String> consumeMe = s -> System.out.println(s);



        //consumers are typically used in terminal operations
        myList.stream()
                .filter(s -> s.startsWith("c")) //intermediate
                .map(s -> s.toUpperCase()) //intermediate
                .forEach(consumeMe); //terminal
    }
}
