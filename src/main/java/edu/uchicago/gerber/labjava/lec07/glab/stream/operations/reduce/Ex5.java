package edu.uchicago.gerber.labjava.lec07.glab.stream.operations.reduce;

import java.util.Optional;
import java.util.stream.Stream;
//from   w ww.ja  va 2s  .c om
public class Ex5 {
    public static void main(String[] args) {
        Optional<Integer> max = Stream.of(1, 2, 3, 4, 5).reduce(Integer::max);

        if (max.isPresent()) {
            System.out.println("max = " + max.get());
        } else {
            System.out.println("max is not  defined.");
        }

        max = Stream.<Integer> empty().reduce(Integer::max);
        if (max.isPresent()) {
            System.out.println("max = " + max.get());
        } else {
            System.out.println("max is not  defined.");
        }

    }
}