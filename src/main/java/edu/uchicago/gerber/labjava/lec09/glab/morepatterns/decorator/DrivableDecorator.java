package edu.uchicago.gerber.labjava.lec09.glab.morepatterns.decorator;

public class DrivableDecorator implements Drivable {

    protected Drivable car;

    public DrivableDecorator(Drivable c){
        this.car=c;
    }

    @Override
    public void assemble() {
        this.car.assemble();
    }

}