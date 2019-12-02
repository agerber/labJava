package lec09.glab.morepatterns.decorator;

public class BasicCar implements Drivable {

    @Override
    public void assemble() {
        System.out.print("Basic Drivable.");
    }

}