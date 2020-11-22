package lec04.glab.override;

import java.util.ArrayList;

/**
 * Created by ag on 10/20/2014.
 */

//this is the example with 2B
public class InterfaceDriver {


    public static void main(String[] args) {
        ArrayList<Drawable> draVehicles = new ArrayList<>();
        draVehicles.add(new Corsair("Corsair 89000 Luxury"));
        draVehicles.add(new Bike("Swhinn magna"));
        draVehicles.add(new Ambulance("GM 1200"));


      //  Drawable drawable = new Corsair("Corsair 87000 Luxur");




        for (Drawable draVehicle : draVehicles) {

            System.out.println(draVehicle.getClass() );

            draVehicle.draw();



        }

//        for (Drawable draVehicle : draVehicles) {
//            System.out.println(draVehicle.getClass().getName() + " : " + ((Vehicle)draVehicle).getModel() + " : " + ((Vehicle)draVehicle).reportNumWheels() + "\n");
//            draVehicle.draw();
//        }
    }




}
