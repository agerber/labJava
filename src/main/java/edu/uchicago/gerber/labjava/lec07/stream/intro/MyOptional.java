package edu.uchicago.gerber.labjava.lec07.stream.intro;



import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class MyOptional {

    public static void main(String[] args) {

        //The BILLION-DOLLAR problem: null



       List<Optional<Rectangle>> rectangleOptionals = new ArrayList<>();
       rectangleOptionals.add( Optional.ofNullable(getRandomRectangle()) );
       rectangleOptionals.add( Optional.ofNullable(getRandomRectangle()) );
       rectangleOptionals.add( Optional.ofNullable(getRandomRectangle()) );
       rectangleOptionals.add( Optional.ofNullable(getRandomRectangle()) );
       rectangleOptionals.add( Optional.ofNullable(getRandomRectangle()) );
       rectangleOptionals.add( Optional.ofNullable(getRandomRectangle()) );
       rectangleOptionals.add( Optional.ofNullable(getRandomRectangle()) );
       rectangleOptionals.add( Optional.ofNullable(getRandomRectangle()) );

        for (Optional<Rectangle> rectangleOptional : rectangleOptionals) {


                System.out.println(rectangleOptional.toString());

        }




    }

    private static Rectangle getRandomRectangle(){

        Random random = new Random();
        boolean isTrue = random.nextBoolean();

        if (isTrue){
            return new Rectangle(1,2,3,4);
        } else {
            return null;
        }
    }

}
