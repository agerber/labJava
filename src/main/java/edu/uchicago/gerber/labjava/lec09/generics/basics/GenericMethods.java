package edu.uchicago.gerber.labjava.lec09.generics.basics;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GenericMethods {

    public static void main(String[] args) {


        String[] myNames = {"Adam", "Bobby", "Charlie"};

        Number[] numbers = {

                2,
                5.6,
                new Byte((byte)34),
                new Short((short)927),
                12,
                Integer.parseInt("45"),
                78.9
        };

        List<String> myNamesList = fromArrayToList(myNames);


        List<Number> myList = fromArrayToList(numbers);

        for (Number number : myList) {
            System.out.println(getDubGenerically(number));
        }
        //double myDub = getDubGenerically(new Rectangle(1,2,3,4));

    }

    //convert an array to a list generically
    private static <T> List<T> fromArrayToList(T[] a) {
        return Arrays.stream(a).collect(Collectors.toList());
    }

    private static <T extends Number> double getDubGenerically(T value){
         return value.doubleValue();
    }

    private List getList(List list){
        return list;
    }
}
