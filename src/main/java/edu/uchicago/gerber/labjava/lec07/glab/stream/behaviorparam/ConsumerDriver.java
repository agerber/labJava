package edu.uchicago.gerber.labjava.lec07.glab.stream.behaviorparam;

import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;


public class ConsumerDriver {
    public static void main(String[] args) {

        List<Rectangle> rectangles = new LinkedList<>();

        rectangles.add(new Rectangle(2,3,5,6));
        rectangles.add(new Rectangle(1,2,4,7));
        rectangles.add(new Rectangle(0,0,8,9));
        rectangles.add(new Rectangle(0,0,5,6));
        rectangles.add(new Rectangle(0,0,5,60));

        Consumer<Rectangle> consumerPrint = r -> System.out.print(r);
        Consumer<Rectangle> consumerPrintArea = r -> System.out.println(r.getWidth() * r.getHeight());

        //we must iterate through the entire collection, with an O(n)
        for (Rectangle rectangle : rectangles) {
           // consumerPrint.andThen(consumerPrintArea).accept(rectangle);
            consumerPrint.accept(rectangle);
        }




    }
}
