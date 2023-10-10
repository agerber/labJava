package edu.uchicago.gerber.labjava.lec03.simplefight;

public class Mastiff extends Dog  {


    public Mastiff(String name) {
        super(name);
    }

    @Override
    public void bite(Dog dog) {
        //a Mastiff is slow so his percetage is low, but his bit is stribng. and vice versa for mastiff
        int percentage = (int) (Math.random() * 30) ;  //from 70 to 99 percent
        int effective = (int) (Math.random() * 30) + 70;  //from 0 to 30 percent

        dog.setHealth(dog.getHealth() - percentage * effective);
    }
}
