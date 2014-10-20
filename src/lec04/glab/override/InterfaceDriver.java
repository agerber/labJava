package lec04.glab.override;

import java.util.ArrayList;

/**
 * Created by ag on 10/20/2014.
 */

//this is the example with 2A
public class InterfaceDriver {


    public static void main(String[] args) {
        ArrayList<Drawable> draVehicles = new ArrayList<>();
        draVehicles.add(new Corsair("Corsair 89000 Luxury"));
        draVehicles.add(new Bike("Swhinn magna"));
        draVehicles.add(new Ambulance("GM 1200"));


        for (Drawable draVehicle : draVehicles) {
            System.out.println(((Vehicle)draVehicle).getModel() + " : " + ((Vehicle)draVehicle).reportNumWheels() + "\n");
            draVehicle.draw();
        }
    }




}
