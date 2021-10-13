package edu.uchicago.gerber.labjava.lec03.glab.dogfight;

public class Chiwawa extends Dog {

    public Chiwawa(String name) {
        super(name);
    }

    @Override
    public void bite(Dog dog) {

        int speed = ((int) (Math.random() * 30 + 70));
        int strength = ((int) (Math.random() * 30) );

        dog.setHealth(dog.getHealth() - speed * strength);

    }
}
