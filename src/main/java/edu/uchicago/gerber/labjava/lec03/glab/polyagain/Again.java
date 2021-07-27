package edu.uchicago.gerber.labjava.lec03.glab.polyagain;

import java.awt.*;

public class Again {

    public static void main(String[] args) {

        Double dub = new Double(2.1);

        // Rectangle's constructor is (x,y, width, height)
        Rectangle rec = new Rectangle(1,1,5,7);

        Number num = dub;
        Object obj = num;

        Comparable com1 = (Comparable) obj;


        Comparable com2 = rec.getWidth();  //rec.getWidth() is being auto-boxed by a Double

        System.out.println(com1.compareTo(com2) >= 0 ? "com1 is bigger than or equal to com2" : "com2 is bigger than com1 ");
        System.out.println("com1 is of type " + com1.getClass().getSimpleName() +  " and com2 is of type " + com2.getClass().getSimpleName());

    }
}
