package edu.uchicago.gerber.labjava.lec02.refs;

import  java.awt.Rectangle;
public class WhatIsStoredInRefDriver {

    public static void main(String[] args) {

        //instantiate a new object on the heap
        Rectangle rec1 = new Rectangle(2,3,7,5);

        //instantiate another one
        Rectangle rec2 = new Rectangle(200,892,769,501);


        //create some local primitives
        int myInt1 = 10;
        int myInt2 = 12;

        //in this case I am putting the value stored myInt2 into myInt1. After the statement, they both now store 12.
        myInt1 = myInt2;

        //all these conditions are true
        System.out.println("12 == myInt1 && 12 == myInt2 && myInt1 == myInt2");
        System.out.println(12 == myInt1 && 12 == myInt2 && myInt1 == myInt2);

        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");

        //what is happening here? I'm copying the value of the memory address stored in rec2 and
        //putting that value (memory address) into rec1. Both rec1 and rec2 now point to the same object [Rectangle(200,
        // 892,769,501)]. The Rectangle(2,3,7,5) object becomes orphaned and will be garbage collected.
        rec1 = rec2;

        //when using the double-equals operator '==' on references, it checks to see if the memory addresses stored in
        //both references are the same, meaning those two reference point to the SAME object on the heap.
        //In this case, both reference point to Rectangle(200,892,769,501)

        System.out.println("rec1 == rec2");
        System.out.println(rec1 == rec2);





    }
}
