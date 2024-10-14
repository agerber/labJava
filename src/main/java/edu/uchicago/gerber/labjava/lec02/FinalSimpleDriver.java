package edu.uchicago.gerber.labjava.lec02;

import java.util.Date;

public class FinalSimpleDriver {

    public static void main(String[] args) {

        final int AGE = 21;
        // the following line will not compile
        // AGE = 51;
        System.out.println(AGE);

        final Date date = new Date(); //now
        //the following lines will not compile
        //date = new Date(date.getTime() - 1000L);
        //date = null;

        System.out.println(date);
        //I can still MUTATE this final object
        date.setTime(date.getTime() + 900_000_000_000L);

        System.out.println(date);


    }
}
