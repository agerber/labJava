package edu.uchicago.gerber.labjava.lec03._simplepoly;

import java.awt.*;

public class PolySimpleWrong {

    public static void main(String[] args) {

        //this statement is illegal
        //Double dubMe = new Object();
        GodView.print(Double.class, GodView.Size.LARGE, false);
        GodView.print(Object.class, GodView.Size.SMALL, true);


        //Integer intMe = new java.awt.Rectangle();
        GodView.print(Integer.class, GodView.Size.LARGE, false);
        GodView.print(java.awt.Rectangle.class, GodView.Size.SKEW, true);











    }
}
