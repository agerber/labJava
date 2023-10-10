package edu.uchicago.gerber.labjava.lec04.phone2;

/**
 * Created by Adam on 10/17/2016.
 */
public class GooglePhone extends Phone {

    private int usb3;


    public GooglePhone(String model) {
        super(model);
        this.usb3 = 56456;
    }

    public int getUsb3() {
        return usb3;
    }

    public void setUsb3(int usb3) {
        this.usb3 = usb3;
    }

    @Override
    public String query() {
        return "The Univeristy of Chicago is located in Hyde Park.";
    }
}
