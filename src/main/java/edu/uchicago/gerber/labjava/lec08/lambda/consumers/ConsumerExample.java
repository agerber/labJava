package edu.uchicago.gerber.labjava.lec08.lambda.consumers;

import java.awt.*;
import java.util.Arrays;
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {

        //A consumer is like a function but it returns void
        Consumer<Rectangle> printRectangle = r -> System.out.println(r.toString());

        Rectangle[] rectangles = {

                new Rectangle(1,2,3,4),
                new Rectangle(1,2,3,4),
                new Rectangle(1,2,3,4),
                new Rectangle(1,2,3,4),
                new Rectangle(1,2,3,4)
        };

        //we can use a consumer in an imperative way.
        for (Rectangle rectangle : rectangles) {
            printRectangle.accept(rectangle);
        }

        //we can also use consumers in a stream. Notice that this is a terminal operation.
        Arrays.stream(rectangles)
                .forEach(printRectangle);


    }
}
