package edu.uchicago.gerber.labjava.lec08.glab.lambda.behaviorParam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.function.Supplier;

/**
 * Created by Adam on 6/23/2016.
 */
public class UsingSuppliers {
    public static void main(String[] args) {
        Supplier<String> supplier  = ()-> "UChicago";
         final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
         Supplier<String> dateTimeSupplier = () -> dtf.format(LocalDateTime.now());



        System.out.println(supplier.get());

        //another exampnl

        Supplier<Date> dateSupplier = () -> new Date("01/01/1970");

        System.out.println(dateSupplier.get());



    }
}
