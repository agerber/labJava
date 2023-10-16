package edu.uchicago.gerber.labjava.lec03._simplepoly;

import java.awt.Rectangle;
public class CastingDownWrong {

    public static void main(String[] args) {

        //let's examine each in turn


        Object object = new Object();
        GodView.print(Object.class, GodView.Size.SMALL, false);
        GodView.print(Object.class, GodView.Size.SMALL, true);
        //down-casting (widening) be careful, this is dangerous!
        // Double dub2 = (Double) object;


        System.out.println("vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv");

        //we are attempting to do this
        GodView.print(Double.class, GodView.Size.LARGE, false);
        GodView.print(Object.class, GodView.Size.SMALL, true);





        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");




//        Object rectangle = new Rectangle();
//        GodView.print(Object.class, GodView.Size.SMALL, false);
//        GodView.print(java.awt.Rectangle.class, GodView.Size.LARGE, true);

        //down-casting (widening) be careful, this is dangerous!
        //Double dub = (Double) rectangle;

//        System.out.println("vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv");
//
//        //we are attempting to do this
//        GodView.print(Double.class, GodView.Size.LARGE, false);
//        GodView.print(Rectangle.class, GodView.Size.SKEW, true);



    }
}
