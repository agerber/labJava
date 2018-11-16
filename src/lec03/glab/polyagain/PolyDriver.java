package lec03.glab.polyagain;


import lec10.glab.lambdas.Circle;

import javax.lang.model.type.IntersectionType;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class PolyDriver  {

    public static void main(String[] args) {


//        Double dub = new Double(565.09);
//        Object obj = dub;
//
//        Object obj3 = new Double(98.99);
//
//        Circle circle = (Circle) obj3;


//

        Rectangle rec = new Rectangle(1,2,5,6);
        Rectangle2D rec2d = rec;
        Object obj = rec;










        Integer intMe = new Integer(2);
        Object obj2 = intMe;
        Number num4 = (Number) obj2;
        Integer intMe3 = new Integer(intMe + 1);




        Double dub3 = new Double(87.8);

        Number num = dub3;

        Object obj3 = num;

        System.out.println(dub3.getClass().getName());
        System.out.println(num.getClass().getName());
        System.out.println(obj3.getClass().getName());

        System.out.println(dub3 == num ? "yes they are the same object": "nope");

        System.out.println(obj3 == num ? "yes they are the same object": "nope");






    }
}
