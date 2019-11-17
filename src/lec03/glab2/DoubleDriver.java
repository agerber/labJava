package lec03.glab2;

import java.awt.*;
import java.io.Serializable;

public class DoubleDriver {
    public static void main(String[] args) {

        Double dub= new Double(2.3);
       // Comparable com = dub;
        Number num = dub;
       // Serializable ser =  num;
        Object obj = num;

        //why is this flagging me? Narrowing is automatic, widening is dangerous and requires a cast.
        Double dub2 = (Double)  obj;

        //This is legal, but will it be ok?
       // Rectangle rec = (Rectangle) obj;



        System.out.println(obj);


    }

    private static void overAperture(){

        //the aperture is too wide for the underlying object
       // Double dub =  new Object();

    }
}
