package edu.uchicago.gerber.labjava.lec08.lambda.behaviorParam;

import java.util.Date;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by Adam on 6/23/2016.
 */
public class UsiingFunctions {

    public static void main(String[] args) {

        //crate a FUNCTION
        //takes and integer and returns a string

        //start out with an anonymous inner class then migrate to lambda
        String string = calc(new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return String.valueOf(this.getClass().toString() + ":"+ integer);
                //return String.valueOf( ":"+ integer);
            }
        },8);


        System.out.println(string);


        //crate a BI FUNCTION

        long stringFromBiFunction = calcBi(new BiFunction<Integer, Date, Long>() {
            @Override
            public Long apply(Integer integer, Date date) {
                return date.getTime() + integer;
            }
        }, 5, new Date());

        System.out.println(stringFromBiFunction);



        BiFunction<Integer,Date,Long> anotherBiFunction = (integer, date) -> date.getTime() + integer;

        System.out.println(anotherBiFunction.apply(67, new Date()));





    }

    private static String calc(Function<Integer, String> function, Integer integer){
        return function.apply(integer);
    }

    private static Long calcBi(BiFunction<Integer, Date , Long> function, Integer integer, Date date){
        return function.apply(integer, date);
    }


}
