package edu.uchicago.gerber.labjava.lec05.glab.debug;

import javafx.scene.shape.Circle;

import java.awt.*;

/**
 * Created by ag on 10/27/2014.
 */
public class UncheckedDriver {

    public static void main(String[] args) {

        int[] nNums = new int[10];
        for (int nC = 0; nC < 10; nC++) {
            nNums[nC] = nC * 2;
        }


        Object obj = new Point(2,13);
        Circle cir = null;




        //this will throw an unchecked exception - this is the programmers fault! (ArrayIndexOutOfBoundsExcpetion)
        System.out.println(nNums[10]);

        //this will throw an unchekced exception - this is the programmers fault! (ClassCastException)
        Rectangle rec = (Rectangle) obj;

        //this will throw an unchekced exception - this is the programmers fault! (NullPointerException)
        System.out.println(cir.getCenterX());




    }
}
