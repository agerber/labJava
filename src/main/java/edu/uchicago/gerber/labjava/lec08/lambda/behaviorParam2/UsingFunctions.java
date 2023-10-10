package edu.uchicago.gerber.labjava.lec08.lambda.behaviorParam2;

import java.util.Arrays;
import java.util.function.Function;

/**
 * Created by Adam on 7/15/2015.
 */
public class UsingFunctions {

    public static void main(String[] args) {
        Function<Integer,Integer> addOne = x -> x + 1;

        Function<String, String> getCountOfString = str -> str + ":" + str.length();


        String[] names = {"Adam", "Heidi", "Bert", "Eddy"};
        Arrays.stream(names)
                .map(getCountOfString)
                .forEach(s -> System.out.println(s));


//        //non-stream
//        Integer some = addOne.apply(12);
//        System.out.println(some);
//
//        //streamed
//        //functions are typically used in maps
//        List<Integer> list = Arrays.asList(1,2,3,4,5);
//        list.stream()
//                .map(addOne)
//                .forEach(x -> System.out.println(x));



    }
}
