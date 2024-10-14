package edu.uchicago.gerber.labjava.lec02.hidden;
//import java.lang.*;
import java.awt.Rectangle;
public class HiddenJavaDriver  {


    //   HIDDEN JAVA
    //1. by default the java.lang.* package is imported for you. The import java.lang.* above is redundant.
    //2. All classes in Java "extends Object" by default, even Drivers and utility classes.  The 'extends Object'
          //is totally redundant.
    //3. If you do not provide a constructor in your class (see below), a default no-arg constructor is provided to you.
         //Upon construction, all fields will be set to their default values, so intValue will be set to 0, dubValue
         // will be set to 0.0, and rectangle will be set to null.



    public static void main(String[] args) {
        System.out.println(new MySimple());
    }

}


class MySimple  {
    private int intValue;
    private double dubValue;
    private Rectangle rectangle;




    @Override
    public String toString() {
        return "MySimple{" +
                "intValue=" + intValue +
                ", dubValue=" + dubValue +
                ", rectangle=" + rectangle +
                '}';
    }
}

