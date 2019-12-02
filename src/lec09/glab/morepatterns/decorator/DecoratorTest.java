package lec09.glab.morepatterns.decorator;

public class DecoratorTest {

    public static void main(String[] args) {
        Drivable sportsCar = new SportsCar(new BasicCar());
        sportsCar.assemble();
        System.out.println("\n*****");

        Drivable sportsLuxuryCar = new SportsCar(new LuxuryCar(new BasicCar()));
        sportsLuxuryCar.assemble();
    }

}