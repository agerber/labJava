package edu.uchicago.gerber.labjava.lec04.phone2;

/**
 * Created by Adam on 10/17/2016.
 */
public class ApplePhone extends Phone {
    public ApplePhone(String model) {
        super(model);
    }

    @Override
    public String query() {
        return "Sorry, can you repeat that plese.";
    }
}
