package edu.uchicago.gerber.labjava.lec04.glab.override;

import java.util.LinkedList;

/**
 * Created by ag on 10/20/2014.
 */

//this is the example with 2A
public class AbstractDriver {


    public static void main(String[] args) {

        LinkedList<Vehicle> vehVehicles = new LinkedList<>();
        vehVehicles.add(new Mazarati("Mazarati 5400 LS"));
        vehVehicles.add(new Trike("Green Machine"));

        for (Vehicle vehVehicle : vehVehicles) {
            System.out.println(vehVehicle.getModel() +
                    " : " + vehVehicle.reportNumWheels());
        }


//        Drawable drawable = new Drawable() {
//            @Override
//            public void draw() {
//                System.out.println("adfasdf");
//            }
//        };

      //  System.out.println(drawable.getClass());


    }




}
