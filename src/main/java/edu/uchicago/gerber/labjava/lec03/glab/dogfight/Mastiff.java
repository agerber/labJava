package edu.uchicago.gerber.labjava.lec03.glab.dogfight;

public class Mastiff extends Dog{

    public Mastiff(String name) {
        super(name);
    }

    @Override
    public void bite(Dog dog) {

        int speed = ((int) (Math.random() * 30));
        int strength = ((int) (Math.random() * 30 + 70));

        dog.setHealth(dog.getHealth() - speed * strength);

    }
}
