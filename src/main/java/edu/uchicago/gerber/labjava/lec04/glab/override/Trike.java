package edu.uchicago.gerber.labjava.lec04.glab.override;

/**
 * Created by ag on 10/20/2014.
 */
public class Trike extends Vehicle {

    public Trike(String model) {
        super(model);
    }

    @Override
    public String reportNumWheels() {
        return " has three plastic wheels";
    }




    //    @Override
//    public String reportNumWheels() {
//        return " has three plastic wheels";
//    }
}
