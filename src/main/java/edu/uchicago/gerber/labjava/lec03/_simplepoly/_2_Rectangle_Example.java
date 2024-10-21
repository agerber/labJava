package edu.uchicago.gerber.labjava.lec03._simplepoly;

import java.awt.Rectangle;
import  java.awt.geom.*;

public class _2_Rectangle_Example {
    public static void main(String[] args) {


        //block 1
        Rectangle rectangle = new Rectangle(1,2,3,4);
        printMe(rectangle);

        //block 2
        Rectangle2D rectangle2D = (Rectangle2D) rectangle;
        printMe(rectangle2D);

        //block 3
        Object object = (Object) rectangle2D;
        printMe(object);

        //block 4
        RectangularShape rectangularShape = (RectangularShape) object;
        printMe(rectangularShape);

        //block 5
        Rectangle rectangle2 = (Rectangle) rectangularShape;
        printMe(rectangle2);




    }
    private static void printMe(Object object){
        System.out.print("This is a " + object.getClass().getSimpleName());
        if (object instanceof Rectangle)
            System.out.println("toString()  " + ((Rectangle) object).toString());
        else
            System.out.println("Object toString()  " + object.toString());
    }
}
