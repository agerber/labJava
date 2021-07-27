package edu.uchicago.gerber.labjava.lec08.glab.lambda.syntax;

import java.util.function.Function;

public class LambdaAndThis {
    public LambdaAndThis(){
        Function<String,String> func1 = x -> {System.out.println(this);return x ;};
        System.out.println(func1.apply(""));
    }
    public String toString(){
        return "Main";
    }
    public static void main(String[] argv) {
        new LambdaAndThis();
    }
}