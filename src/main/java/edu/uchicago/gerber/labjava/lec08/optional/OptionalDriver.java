package edu.uchicago.gerber.labjava.lec08.optional;
import java.awt.Rectangle;
import java.util.Optional;
import java.util.function.Supplier;

public class OptionalDriver {

    public static void main(String[] args) throws Throwable {

        //uncommenting the null set will cause a null-pointer exception
        Rectangle rectangle = new Rectangle(1,2,3,4);
       // rectangle = null;
       // System.out.println(rectangle.toString());


        Optional<Rectangle> optionalRectangle = Optional.of(rectangle);


        System.out.println(optionalRectangle.orElse(new Rectangle(2,3,4,5)));

//      System.out.println(optionalRectangle.orElseThrow(new Supplier<Throwable>() {
//            @Override
//            public Throwable get() {
//                return new RuntimeException("bad");
//            }
//        }));







    }
}
