package edu.uchicago.gerber.labjava.lec02.refs;

import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;

public class AnonObjectsDemo {

    public static void main(String[] args) {
        // Define size for demonstration
        int size = 5;

        // Populate an array with anonymous Rectangle objects
        Rectangle[] rectanglesArray = new Rectangle[size];
        for (int i = 0; i < size; i++) {
            //Rectangle rec1 = new Rectangle(1,2,3,4);
            rectanglesArray[i] = new Rectangle(i, i, i + 1, i + 1);
            System.out.println("Array Rectangle " + i + ": " + rectanglesArray[i]);
        }

        // Populate a LinkedList with anonymous Rectangle objects
        List<Rectangle> rectanglesList = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            rectanglesList.add(new Rectangle(i, i, i + 2, i + 2));
            System.out.println("LinkedList Rectangle " + i + ": " + rectanglesList.get(i));
        }

        //create an object and store it in a reference, then add it to the list.
        //this is the counter-example to above where we are passing reference-anonymous objects
        Rectangle rec =  new Rectangle(1,2,3,4);
        rectanglesList.add(rec);
    }
}
