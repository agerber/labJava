package edu.uchicago.gerber.labjava.lec08.glab.lambda.predicate;

import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        Predicate<String> i  = (s)-> s.length() > 5;

        System.out.println(i.test("Gerber"));
    }
}



//    default  Predicate<T> negate()
//    default  Predicate<T> and(Predicate<? super T> other)
//    default  Predicate<T> or(Predicate<?  super T> other)
//    static <T> Predicate<T> isEqual(Object  targetRef)
//    negate() negates a Predicate from the original predicate.
//
//        and() combines two predicates with a short-circuiting logical AND.
//
//        or() combines two predicates with a short-circuiting logical OR.
//
//        isEqual() returns a predicate that tests if two arguments are equal according to Objects.equals(Object, Object).