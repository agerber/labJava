package lec08.glab.lambda.predicate;

import java.util.function.Function;

public class YetMoreMethodRefs2 {

    public static void main(String[] args) {
        Function<Double, String> stringFunction = dub -> String.valueOf(dub);

        Function<Double, String> stringFunction2 = String::valueOf;




    }
}
