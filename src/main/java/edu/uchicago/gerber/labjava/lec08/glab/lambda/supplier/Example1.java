package edu.uchicago.gerber.labjava.lec08.glab.lambda.supplier;

import java.util.function.Supplier;

public class Example1 {
    public static void main(String[] args) {
        Supplier<String> i  = ()-> "Adam Gerber";

        System.out.println(i.get());
    }

}
