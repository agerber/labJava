package edu.uchicago.gerber.labjava.lec02.glab.refs;

import  java.awt.Rectangle;
public class WhatIsStoredInRefDriver {

    public static void main(String[] args) {

        //instantiate a new object on the heap
        Rectangle rec1 = new Rectangle(2,3,7,5);

        //instantiate another one
        Rectangle rec2 = new Rectangle(200,892,769,501);


        //what is happening here?
        rec1 = rec2;

        int myInt1 = 10;
        int myInt2 = 12;

        myInt1 = myInt2;




        System.out.println(rec1);


    }
}
