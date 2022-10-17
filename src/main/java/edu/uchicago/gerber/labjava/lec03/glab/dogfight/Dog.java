package edu.uchicago.gerber.labjava.lec03.glab.dogfight;

public abstract class Dog {


    private String name;
    private int health;

    public Dog(String name) {
        this.name = name;
        this.health = 10_000;
    }

    public Dog() {
        this.name = "Woody";
        this.health = 8888;
    }

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


    public abstract void bite(Dog dog);

    @Override
    public String toString() {
        return this.name + ":" + this.getClass().getSimpleName();
    }

    public String toStringHealth() {
        return toString() + ":" + getHealth();
    }
}
