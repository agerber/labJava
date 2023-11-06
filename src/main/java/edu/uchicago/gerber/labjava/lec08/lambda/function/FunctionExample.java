package edu.uchicago.gerber.labjava.lec08.lambda.function;

import java.util.function.Function;
import java.util.Date;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FunctionExample {
    public static void main(String[] args) {


        //takes an integer and returns a string
        Function<Integer, String> converter = (x) -> Integer.toString(x);

        //takes an integer and returns an integer
        Function<Integer, Integer> doubler = (x) -> x * 2;

        //takes a Date and returns a Long
        Function<Date, Long>  epoch = (d) -> d.getTime();


        System.out.println("The conversions is " + converter.apply(30));
        System.out.println("The double is " + doubler.apply(30));
        System.out.println("The epoch is " + epoch.apply(new Date()));


        Stream.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
                .map(doubler)
                .forEach(num -> System.out.println(num));




    }



}
