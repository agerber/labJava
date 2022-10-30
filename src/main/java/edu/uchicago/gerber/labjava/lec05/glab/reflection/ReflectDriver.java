package edu.uchicago.gerber.labjava.lec05.glab.reflection;

import edu.uchicago.gerber.labjava.lec01.glab.Card;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ag
 * Date: 11/18/13
 * Time: 11:20 AM
 * To change this template use File | Settings | File Templates.
 */
public class ReflectDriver {

    public static void main(String[] args) {

        List<Object> objects = new ArrayList<>();


        objects.add(new Integer(45)); //can remove new-keyword, but still an Integer object due to auto-boxing
//        objects.add(new String("Hello")); // can remove new-keyword, but String is still an object
//        objects.add(new Rectangle(5,4,12,8));
//        objects.add(new Date());

       // reportName(objects);
       reportHierarchy(objects);


    }

    private static void reportName(List<Object> objects) {
        for (Object object : objects) {
            if (object instanceof Rectangle){
                System.out.println(":::::::::draw-colons:::::::::::::" + object.getClass().getCanonicalName());
            } else {
                System.out.println(object.getClass().getCanonicalName());
            }

        }
    }

    private static void reportHierarchy(List<Object> objects) {
        for (Object object : objects) {
            Reflector.printClass(object.getClass());
        }
    }



}
