package edu.uchicago.gerber.labjava.lec05.glab.exceptions;

import java.awt.*;
import java.util.Date;

public class UncheckedDriver {

    public static void main(String[] args) {

        Double dub = new Double(89.9);
        dub = null;
        //this will throw NullPointerException

        System.out.println(dub.doubleValue());



        Object[] objects = {"Adam", 4.0, new Date()};
        //this will throw an ArrayIndexOutOfBoundsException
        System.out.println(objects[3].toString());


        //this will throw a ArithmethicException
        System.out.println(47 / 0);

        Object object = new Date();
        //This will throw a ClassCastException
        Rectangle rectangle = (Rectangle) object;
        System.out.println(rectangle.toString());



    }
}
