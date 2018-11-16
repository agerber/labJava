package lec08.glab.lambda.supplier;

import java.util.function.Supplier;

public class Example1 {
    public static void main(String[] args) {
        Supplier<String> i  = ()-> "java2s.com";

        System.out.println(i.get());
    }

}
