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
        Function<String, String> upperCaseMe = s -> s.toUpperCase();
        final StringBuilder stringBuilder = new StringBuilder();

        Consumer<String> printWithColons = s -> {

            final int INDENT = 30;
            int colonLen = INDENT - s.length();

            stringBuilder.setLength(0);
            while(colonLen-- > 0){
                stringBuilder.append(":");
            }
            System.out.println(stringBuilder + s);


        };

        Arrays.stream(states)
                .filter(startsWithM)
                .map(upperCaseMe)
                .forEach(printWithColons);




    }
}
