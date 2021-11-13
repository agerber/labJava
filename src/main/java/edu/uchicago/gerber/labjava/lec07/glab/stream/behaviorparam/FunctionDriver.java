package edu.uchicago.gerber.labjava.lec07.glab.stream.behaviorparam;




import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionDriver {
    public static void main(String[] args) {

        List<Rectangle> rectangles = new LinkedList<>();

        rectangles.add(new Rectangle(2,3,5,6));
        rectangles.add(new Rectangle(1,2,4,7));
        rectangles.add(new Rectangle(0,0,8,9));
        rectangles.add(new Rectangle(0,0,5,6));
        rectangles.add(new Rectangle(0,0,5,60));

        Predicate<Rectangle> predOriginZero = r -> r.getX() == 0 && r.getY() == 0;
        Function<Rectangle, Double> rectangleAreaFunction =
                r -> r.getHeight() * r.getWidth();

        //we must iterate through the entire collection, with an O(n)
        for (Rectangle rectangle : rectangles) {
            if (predOriginZero.test(rectangle)) {
                System.out.println(rectangleAreaFunction.apply(rectangle));
            }
        }




    }
}
