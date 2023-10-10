package edu.uchicago.gerber.labjava.lec04.override;

/**
 * Created by ag on 10/20/2014.
 */
public class Mazarati extends  Vehicle {

    public Mazarati(String model) {
        super(model);

    }

    @Override
    public String reportNumWheels() {
        return " has 4 21-inch Perelli all-weather tires";
    }


}
