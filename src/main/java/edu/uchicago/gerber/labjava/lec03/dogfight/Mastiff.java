package edu.uchicago.gerber.labjava.lec03.dogfight;

public class Mastiff extends Dog{

    public Mastiff(String name) {
        super(name);
    }

    @Override
    public void bite(Dog dog) {

        int speed = ((int) (Math.random() * 30));
        int strength = ((int) (Math.random() * 30 + 70));


        System.out.println(super.getName());
        System.out.println(this.getName());
        dog.setHealth(dog.getHealth() - speed * strength);

    }

    @Override
    public String getName() {
        return "Mastiff:" + this.getName();
    }
}
