package lec03.glab.polyagain;

import java.awt.*;

public class PolyWannaCracker {

    public static void main(String[] args) {

        //narrowing the aperture - requires no cast
        Double dub = new Double(29.9);
        Number num = dub;
        Comparable comparable =dub;
        Object obj = comparable;

       // obj = new Rectangle(2,2,2,2);

        //widening the aperture
        if (obj instanceof Number) {
            num = (Number) obj;
        }

        comparable = (Comparable) obj;


        System.out.println(dub == num && num == comparable && obj == dub);
















    }
}
