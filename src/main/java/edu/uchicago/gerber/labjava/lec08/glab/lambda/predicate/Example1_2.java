package edu.uchicago.gerber.labjava.lec08.glab.lambda.predicate;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Example1_2 {
    public static void main(String[] args) {

        String[] states = {"Illinois", "Michigan", "Colorado", "Florida", "New York", "Maine",
                "Rhode Island", "Connecticut", "California", "Mississippi", "Montana", "Minnesota"};


        Arrays.stream(states)
                .filter(s -> s.startsWith("M"))
                .map(s -> {

                    final int INDENT = 30;
                    int colonLen = INDENT - s.length();

                    StringBuilder stringBuilder = new StringBuilder();
                    while (colonLen-- > 0){
                        stringBuilder.append(':');
                    }

                    return stringBuilder + s.toUpperCase();

                })
                .forEach(x -> System.out.println(x));



    }
}
