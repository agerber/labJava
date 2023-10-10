package edu.uchicago.gerber.labjava.lec09.morepatterns.decorator;

public class LuxuryCar extends DrivableDecorator {

    public LuxuryCar(Drivable c) {
        super(c);
    }

    @Override
    public void assemble(){
        super.assemble();
        System.out.print(" Adding features of Luxury Drivable.");
    }
}
