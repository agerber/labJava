package edu.uchicago.gerber.labjava.lec02.glab.refs;

import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;

public class AnonObjectsDemo {

    public static void main(String[] args) {
        // Define size for demonstration
        int size = 5;

       Rectangle rec =  new Rectangle(1,2,3,4);
        // Populate an array with anonymous Rectangle objects
        Rectangle[] rectanglesArray = new Rectangle[size];
        for (int i = 0; i < size; i++) {
            rectanglesArray[i] = new Rectangle(i, i, i + 1, i + 1);
            System.out.println("Array Rectangle " + i + ": " + rectanglesArray[i]);
        }

        // Populate a LinkedList with anonymous Rectangle objects
        List<Rectangle> rectanglesList = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            rectanglesList.add(new Rectangle(i, i, i + 2, i + 2));
            System.out.println("LinkedList Rectangle " + i + ": " + rectanglesList.get(i));
        }
        rectanglesList.add(rec);
    }
}
