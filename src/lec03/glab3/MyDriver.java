package lec03.glab3;

import java.awt.*;
import java.util.Date;

public class MyDriver {

    public static void main(String... args) {

       // int[] myArray = {1,3,5,89};
        iterateArray(3, 4.5, new Rectangle(1,2,3,7), new Date(), "asdf");


    }

  private static void iterateArray(Object... objects){
      for (Object object : objects) {
          System.out.println(object.getClass().getSimpleName() + " : " + object.toString());
      }
  }


}
