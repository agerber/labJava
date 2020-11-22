package lec08.glab.lambda.predicate;

import java.util.function.Predicate;

public class Example1 {
    public static void main(String[] args) {
        Predicate<String> i  = (s)-> s.length() > 5;

        System.out.println(i.test("hello there"));
    }
}