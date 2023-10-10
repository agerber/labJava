package edu.uchicago.gerber.labjava.lec04.phone2;

import java.util.ArrayList;

/**
 * Created by Adam on 10/17/2016.
 */
public class NumberDriver {

    public static void main(String[] args) {
        ArrayList<Number> numbers = new ArrayList<>();

        numbers.add(new Integer(564));
        numbers.add(new Double(564.99));
        numbers.add(new MyNumber(4564564L));

        for (Number number : numbers) {
            System.out.println(number.intValue());
        }

    }
}
