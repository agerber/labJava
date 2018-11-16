package lec08.glab.lambda.behaviorParam;

import java.util.Date;
import java.util.function.Supplier;

/**
 * Created by Adam on 6/23/2016.
 */
public class UsingSuppliers {
    public static void main(String[] args) {
        Supplier<String> supplier  = ()-> "UChicago";

        System.out.println(supplier.get());

        //another exampnl

        Supplier<Date> dateSupplier = () -> new Date("01/01/1970");

        System.out.println(dateSupplier.get());



    }
}
