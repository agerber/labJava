package edu.uchicago.gerber.labjava.lec09.morepatterns.decorator;

public class BasicCar implements Drivable {

    @Override
    public void assemble() {
        System.out.print("Basic Drivable.");
    }

}
