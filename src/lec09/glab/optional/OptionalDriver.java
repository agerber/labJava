package lec09.glab.optional;

import java.awt.*;
import java.util.Optional;

public class OptionalDriver {
    public static void main(String[] args) throws Exception {

        //the 10Billion dollar problem
        Rectangle rectangle = new Rectangle(1,2,3,4);
        rectangle = null;
        System.out.println(rectangle.getX());

        Optional<Rectangle> rectangleOptional = Optional.of(rectangle);
        System.out.println(rectangleOptional.isPresent() ? rectangleOptional.get().toString() :
                "not found");

        rectangleOptional.orElse(new Rectangle(2,5,6,9));
        Rectangle myReturnedRectange  =
              rectangleOptional.orElseThrow(Exception::new);







    }
}
