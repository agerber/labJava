package lec08.glab.lambda.behaviorParam2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by Adam on 7/15/2015.
 */
public class UsingTheTrinity {
    public static void main(String[] args) {

        List<String> myList =   Arrays.asList("a1", "a2", "b1", "c2", "c1");

        Predicate<String> startsWithC = s -> s.startsWith("c");

        Function<String,String> capMe = s -> s.toUpperCase();

        Consumer<String> consumeMe = s -> System.out.println(s);


        //predicates are typically used in filters .filter returns a Stream
        //functions are typically used in maps .map returns a Stream
        //consumers are used with terminal operations - does not return, it consumes the stream so that the stream is now spent.
        myList.parallelStream()
                .filter(startsWithC) //intermediate - returns a stream
                .map(capMe) //intermediate - returns a stream
                .forEach(consumeMe); //terminal - consumes the stream.
    }
}
