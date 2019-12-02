package lec09.glab.morepatterns.decorator;

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