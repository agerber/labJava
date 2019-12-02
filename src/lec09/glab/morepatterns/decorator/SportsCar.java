package lec09.glab.morepatterns.decorator;

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