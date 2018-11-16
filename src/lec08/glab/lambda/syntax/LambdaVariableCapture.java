package lec08.glab.lambda.syntax;

import java.util.function.Function;

public class LambdaVariableCapture {
    public static void main(String[] argv) {
        final String x = "Hello";
        Function<String,String> func1 = y -> {return y + " "+ x ;};
        System.out.println(func1.apply("java2s.com"));

    }
}
