package lec08.glab.lambda.consumers;

import java.awt.*;
import java.util.function.Consumer;

public class MyConsumer {
    public static void main(String[] args) {

        //A consumer is like a function but it returns void
        Consumer<Rectangle> rectangleConsumer =
                rectangle -> {
                  rectangle.setSize(
                            new Dimension((int) rectangle.getWidth()* 2,
                                    (int) rectangle.getHeight() * 2 ));
                    System.out.println(rectangle);
                };


        Rectangle[] rectangles = {

                new Rectangle(1,2,3,4),
                new Rectangle(1,2,3,4),
                new Rectangle(1,2,3,4),
                new Rectangle(1,2,3,4),
                new Rectangle(1,2,3,4)
        };

        for (Rectangle rectangle : rectangles) {
            rectangleConsumer.accept(rectangle);
        }


    }
}
