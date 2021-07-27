package edu.uchicago.gerber.labjava.lec08.glab.lambda.behaviorParam;

import java.util.function.BiPredicate;

/**
 * Created by Adam on 6/22/2016.
 */
//http://www.java2s.com/Tutorials/Java/java.util.function/Predicate/index.htm
public class UsingBiPredicates {



    public static void main(String[] args) {

        //using biPreidicates
        BiPredicate<Integer, Integer> bi = new BiPredicate<Integer, Integer>() {
            @Override
            public boolean test(Integer x, Integer y) {
                return x > y;
            }
        };

        System.out.println(bi.test(2, 3));



        boolean result = compare(new BiPredicate<Integer, Integer>() {
            @Override
            public boolean test(Integer a, Integer b) {
                return a / 2 == b;
            }
        }, 10, 5);

        System.out.println("Compare result: " + result);

    }

    public static boolean compare(BiPredicate<Integer, Integer> bi, Integer i1, Integer i2) {
        return bi.test(i1, i2);
    }
}
