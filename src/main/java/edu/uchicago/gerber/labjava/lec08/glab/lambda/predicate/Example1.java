package edu.uchicago.gerber.labjava.lec08.glab.lambda.predicate;


import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Example1 {
    public static void main(String[] args) {

        String[] states = {"Illinois", "Michigan", "Colorado", "Florida", "New York", "Maine",
                "Rhode Island", "Connecticut", "California", "Mississippi", "Montana", "Minnesota"};

        Predicate<String> startsWithM  = s -> s.startsWith("M");

        //must be idempotent. Highly deterministic. is a property of some operations such that no matter how many times
        // you execute them, you achieve the same result.
        Function<String, String> rightAlign = s -> {
            final int INDENT = 30;
            int colonLen = INDENT - s.length();

            StringBuilder stringBuilder = new StringBuilder();

            while(colonLen-- > 0){
                stringBuilder.append(":");
            }
            return stringBuilder + s.toUpperCase();
        };

        Consumer<String> printMe = s -> System.out.println(s);


        Arrays.stream(states)
                .filter(startsWithM)
                .map(rightAlign)
                .forEach(printMe);




    }
}
