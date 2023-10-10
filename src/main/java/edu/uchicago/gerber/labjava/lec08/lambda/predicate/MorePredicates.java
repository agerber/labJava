package edu.uchicago.gerber.labjava.lec08.lambda.predicate;

import java.util.Arrays;
import java.util.Date;
import java.util.function.Predicate;

public class MorePredicates {

    public static void main(String[] args) {


        Predicate<Date> myDatePredicate = date -> date.compareTo(new Date()) < 0;

        Date[] dates = {

                new Date(1L),
                new Date(Long.MAX_VALUE),
                new Date(1L),
                new Date(Long.MAX_VALUE)

        };

        //you don't need streams to take advantage of Functional Interfaces
        for (Date date : dates) {
            if (myDatePredicate.test(date)){
                System.out.println(date);
            }
        }

        //though you can use streams if you want.
        Arrays.stream(dates)
                .filter(myDatePredicate)
                .forEach(date -> System.out.println(date));

    }


}
