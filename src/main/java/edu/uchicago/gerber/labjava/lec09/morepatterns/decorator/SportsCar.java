package edu.uchicago.gerber.labjava.lec09.morepatterns.decorator;

public class SportsCar extends DrivableDecorator {

    public SportsCar(Drivable c) {
        super(c);
    }

    @Override
    public void assemble(){
        super.assemble();
        System.out.print(" Adding features of Sports Drivable.");
    }
}
