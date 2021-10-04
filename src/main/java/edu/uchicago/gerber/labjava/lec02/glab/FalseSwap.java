package edu.uchicago.gerber.labjava.lec02.glab;

import java.awt.*;

public class FalseSwap {

    public static void main(String[] args) {

        Rectangle rec1 = new Rectangle(1,1,1,1);
        Rectangle rec2 = new Rectangle(2,2,2,2);

        System.out.println("BEFORE SWAP::::::::::::::::::::::::::::::::");
        System.out.println("rec1:" + rec1);
        System.out.println("rec2:" + rec2);

        mutate(rec1);
        mutate(rec2);
        swap(rec1, rec2);

        System.out.println("AFTER SWAP::::::::::::::::::::::::::::::::");
        System.out.println("rec1:" + rec1);
        System.out.println("rec2:" + rec2);

    }
    //you are passing a copy of the credit card, swapping addresses inside the method does nothing
    private static void swap(Rectangle param1, Rectangle param2){

        Rectangle recTemp = param1;
        param1 = param2;
        param2 = recTemp;

        System.out.println("INSIDE METHOD swap::::::::::::::::::::::::::::::::");
        System.out.println("param1:" + param1);
        System.out.println("param2:" + param2);


    }

    //you are passing a copy of the credit-card, you can mutate
    private static void mutate(Rectangle rec){
        rec.setSize((int) rec.getWidth() * 2,(int) rec.getHeight() * 2);

    }
}
