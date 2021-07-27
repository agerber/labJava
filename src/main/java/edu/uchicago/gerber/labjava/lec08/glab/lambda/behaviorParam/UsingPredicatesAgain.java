package edu.uchicago.gerber.labjava.lec08.glab.lambda.behaviorParam;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

/**
 * Created by Adam on 6/23/2016.
 */
public class UsingPredicatesAgain {

    public static void main(String[] args) {

        //soeme predicates
        Predicate<String> longerThanFive  = (s)-> s.length() > 5;
        Predicate<String> containsChicago  = (s)-> s.contains("chicago");
        Predicate<String> containsBoston  = (s)-> s.contains("boston");

        System.out.println(longerThanFive.test("uchicago"));
        System.out.println(containsChicago.test("uchicago"));
        System.out.println(containsBoston.test("uchicago"));

        //some bi-predicates AND
        BiPredicate<Integer, Integer> bi = (x, y) -> x > y;

        BiPredicate<Integer, Integer> eq = (x, y) -> x -2 > y;

        System.out.println(bi.test(2, 3));
        System.out.println(bi.and(eq).test(2, 3));
        System.out.println(bi.and(eq).test(8, 3));


        //negate exemple
        BiPredicate<Integer, Integer> binegate = (x, y) -> x > y;

        System.out.println(binegate.test(2, 3));
        System.out.println(binegate.negate().test(2, 3));





    }
}
