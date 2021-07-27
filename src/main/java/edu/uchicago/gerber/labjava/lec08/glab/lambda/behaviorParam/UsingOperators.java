package edu.uchicago.gerber.labjava.lec08.glab.lambda.behaviorParam;

import java.util.Date;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

/**
 * Created by Adam on 6/23/2016.
 */
public class UsingOperators {

    public static void main(String[] args) {

        //unary opeator
        UnaryOperator<String> unaryOp  = (x)-> x.toUpperCase();

        System.out.println(unaryOp.apply("adam"));



        //binary operator
        BinaryOperator<Integer> adder = (n1, n2) -> n1 + n2;

        System.out.println(adder.apply(3, 41));


        //another binary operator
        BinaryOperator<Date> dateBinaryOperatorSubtractor = (dat1, dat2) ->  new Date(dat1.getTime() - dat2.getTime());

        System.out.println(dateBinaryOperatorSubtractor.apply(new Date(), new Date()));

    }


}
