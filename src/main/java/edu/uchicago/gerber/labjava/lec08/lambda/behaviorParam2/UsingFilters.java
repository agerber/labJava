package edu.uchicago.gerber.labjava.lec08.lambda.behaviorParam2;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

/**
 * Created by Adam on 7/15/2015.
 */
public class UsingFilters {
    public static void main(String[] args) {




        //some fun with simple predicates and consumers
        List<String> myList =   Arrays.asList("Adam", "Bobby", "Carolyn", "Doug", "Emily");

        Predicate<String> startsWithC =  s -> s.startsWith("C");
//        IntPredicate lessThanFive = n -> n < 6;
//
//        Function<String,String> capMe = s -> s.toUpperCase();
//
//        Consumer<String> consumeMe = s -> System.out.println(s);
//        IntConsumer consumeMeInt = s -> System.out.println(s);



        myList.stream()
                .filter(s -> startsWithC.test(s)) //intermediate
                .forEach(s -> System.out.println(s));  //terminal

        myList.stream()
                .filter(startsWithC.negate()) //intermediate
                .forEach(s -> System.out.println(s));  //terminal

        myList.stream()
                .filter(startsWithC.negate()) //intermediate
                .map(s -> s.length())
                .forEach(i -> System.out.println(i)); //terminal
                //.map(capMe) //intermediate
              //  .forEach(i -> consumeMeInt.accept(i)); //terminal










    }
}
