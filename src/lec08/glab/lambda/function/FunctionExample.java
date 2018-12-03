package lec08.glab.lambda.function;

import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {
        Function<Integer, String> converter = (i) -> Integer.toString(i);


        System.out.println("The result is " + converter.apply(3));
        System.out.println("The result is " + converter.apply(30));


       // String result = calc((a) -> "Result: " + (a * 2), 10);

      //  System.out.println(result);
    }

//    public static String calc(Function<Integer, String> bi, Integer i) {
//        return bi.apply(i);
//    }


}
