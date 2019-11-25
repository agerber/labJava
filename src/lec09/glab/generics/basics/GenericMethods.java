package lec09.glab.generics.basics;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GenericMethods {

    public static void main(String[] args) {

        Number[] numbers = {

                2,
                5.6,
                new Byte((byte)34),
                new Short((short)927),
                12,
                Integer.parseInt("45"),
                78.9
        };

        List<Number> myList = fromArrayToList(numbers);

        for (Number number : myList) {
            System.out.println(getDubGenerically(number));
        }

    }

    //convert an array to a list generically
    private static <T> List<T> fromArrayToList(T[] a) {
        return Arrays.stream(a).collect(Collectors.toList());
    }

    private static <T extends Number> double getDubGenerically(T value){
         return value.doubleValue();
    }
}
