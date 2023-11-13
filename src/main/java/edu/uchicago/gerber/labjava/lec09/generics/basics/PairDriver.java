package edu.uchicago.gerber.labjava.lec09.generics.basics;

import edu.uchicago.gerber.labjava.lec04.points.TDPoint;
import java.awt.Point;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PairDriver {
    public static void main(String[] args) {

        List<Pair<String, ?>> list = new ArrayList<>();

        list.add(new Pair<>("To be or not to be", "Shakespeare"));
        list.add(new Pair<>("Do or do not do, there is no try", "Yoda"));
        list.add(new Pair<>("Let there be light", -2000L));

        //? param can be ANY object
        for (Pair<String, ?> stringPair : list) {
            System.out.println(stringPair);
        }

        System.out.println("########################################################");

        //(? extends Number) param can be an object that extends Number
        List<Pair<String, ? extends Number>> list2 = new ArrayList<>();

        list2.add(new Pair<>("New York", 68)); //Integer
        list2.add(new Pair<>("Tokyo", 24.2));  //Double
        list2.add(new Pair<>("Vienna", 23.5)); //Double

        //note that extends is for a concrete, abstract, or interace.
        for (Pair<String, ? extends Number> stringPair : list2) {
            if (stringPair.getSecond() instanceof Double){
                System.out.println("The Celcius temp is " + stringPair);
            } else {
                System.out.println("The Fahrenheit temp is " + stringPair);
            }
        }

        System.out.println("########################################################");

        //(? extends Serializable) param can be an object that implements Serializable
        //note that extends is for a concrete, abstract, or interface.There is no 'implements' in this context.
        List<Pair<String, ? extends Serializable>> list3 = new ArrayList<>();

        list3.add(new Pair<>("String", "Adam"));
        list3.add(new Pair<>("Double", 24.2));
        list3.add(new Pair<>("ArrayList", new ArrayList<String>()));


        for (Pair<String, ? extends Serializable> stringPair : list3) {
            System.out.println(stringPair);
        }

        System.out.println("########################################################");

        //(? super TDPoint) param can be an object that is a TDPoint or a super-class of TDPoint
        List<Pair<String, ? super TDPoint>> list4 = new ArrayList<>();

        list4.add(new Pair<>("My TDPoint", new TDPoint(1,2,3)));
        list4.add(new Pair<>("My Point", new Point(1,2)));
        list4.add(new Pair<>("My Object", new Object()));

        for (Pair<String, ? super TDPoint> stringPair : list4) {
            System.out.println(stringPair);
        }






    }
}
