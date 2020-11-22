package lec04.glab.override;

/**
 * Created by ag on 10/20/2014.
 */

//an abstract class has zero or more abstract methods which MUST be overriden in subclasses
public abstract    class Vehicle {

    protected Vehicle(String model) {
        mModel = model;
    }

    private String mModel;

    public String getModel() {
        return mModel;
    }

    public void setModel(String model) {
        mModel = model;
    }


    //an abstract method
    public abstract String reportNumWheels();
}
