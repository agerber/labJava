package edu.uchicago.gerber.labjava.lec03._employee;

import java.awt.Rectangle;
public class TheFourFinals {

    public static void main(String[] args) {

        //There are three uses of the keyword final in java.

        //1. the use of 'final' here ensures that the value in BOILING_WATER_CELCIUS will always be 100 and can not
        //be reassigned to any other value.
        final int BOILING_WATER_CELCIUS = 100;

        //2. the use of 'final' here ensures that the memory-address initialized in rec1 will always point to the
        // instance of  new Rectangle(1,2,3,4). If I attempt to re-assign this reference, the compiler will complain.
        final Rectangle rec1 = new Rectangle(1,2,3,4);
        //the compiler will complain if you uncomment these because I'm attempting to repoint rec1
        //rec1 = new Rectangle(6,7,8,9);
        //rec1 = null;

        //however, I can STILL mutate the rectangle at this address
        mutateRectangle(rec1);

        System.out.println("The value of BOILING_WATER_CELCIUS is " + BOILING_WATER_CELCIUS);
        System.out.println("The value of rec1 is " + rec1);

        //3. The third use of final relates to a final class definition, which means that class can NOT be extended.
        // see the Executive class in this package for an example.

        //4. The fourth use of final relates to a final method definition, which means it can not be overriden.
        // see the Executive class in this package for an example.

    }

    private static void mutateRectangle(Rectangle rectangle){
        rectangle.setLocation(800, 900);

    }
}
