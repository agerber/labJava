package edu.uchicago.gerber.labjava.lec07.stream.intro;

import java.util.Optional;

public class MyOptionalAgain {
    public static void main(String[] args) {
        Optional<String> stringOptional = Optional.of("MALE");
        String answer1 = "Yes";
        String answer2 = null;

        System.out.println("Non-Empty Optional:" + stringOptional);
        System.out.println("Non-Empty Optional: Gender value : " + stringOptional.get());
        System.out.println("Empty Optional: " + Optional.empty());

        System.out.println("ofNullable on Non-Empty Optional: " + Optional.ofNullable(answer1));
        System.out.println("ofNullable on Empty Optional: " + Optional.ofNullable(answer2));

        // java.lang.NullPointerException
        System.out.println("ofNullable on Non-Empty Optional: " + Optional.of(answer2));


    }
}
