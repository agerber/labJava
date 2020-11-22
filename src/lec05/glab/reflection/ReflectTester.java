package lec05.glab.reflection;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by ag on 10/27/2014.
 */
public class ReflectTester {



    //store an HashMap in a Map Interface

    public static void main(String[] args) {

        //store a concrete class in an abstract super-class reference
//        Rectangle2D r2dRec = new Rectangle(1,2,3,4);
////        if (r2dRec instanceof Rectangle)
////            Reflector.printClass(r2dRec.getClass());
//
//
//        if ( r2dRec.getClass().getSimpleName().toString().equalsIgnoreCase("Rectangle"))
//            System.out.println("I am a Rectangle");

//        //store a concreate class object in an implemented interface reference
        Map<String, String> map = new HashMap<>();
        map.put("Jason", "CS");
        map.put("Liz", "Econ");
        map.put("Dan", "Physics");
        Reflector.printClass(map.getClass());
//
//        //store a concrete class in an concrete super-class reference
//        Object obj = (Object) r2dRec;
//        Reflector.printClass(obj.getClass());



    }
}
