package edu.uchicago.gerber.labjava.lec03.glab.simplefight;

public abstract class Dog  {

    // **********************************
    // ******* members
    // **********************************
    private String name;
    private int health;


    // **********************************
    // ******* constructors
    // **********************************
    public Dog(String name) {
        this.name = name;
        this.health = 10_000;
    }


    // **********************************
    // ******* getters and setters
    // **********************************
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }


    // **********************************
    // ******* abstract method
    // **********************************
    public abstract void bite(Dog dog);



    @Override
    public String toString() {
        return this.name + ", the " + this.getClass().getSimpleName() + " has " + health;
    }
}
