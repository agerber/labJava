package edu.uchicago.gerber.labjava.lec07.glab.stream.create.from_strings;

import java.util.regex.Pattern;

public class Ex2 {
    public static void main(String[] args) {
        String str = "XML,CSS,HTML";
        Pattern.compile(",")
                .splitAsStream(str)
                .forEach(System.out::println);

    }
}