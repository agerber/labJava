package edu.uchicago.gerber.labjava.lec03._boxmatch;

import java.util.Random;

abstract class Boxer {
    private int hitpoints;

    public Boxer(int hitpoints) {
        this.hitpoints = hitpoints;
    }

    public int getHitpoints() {
        return hitpoints;
    }

    public void setHitpoints(int hitpoints) {
        this.hitpoints = hitpoints;
    }

    public abstract void punch(Boxer opponent);

    public String report() {
        return this.getClass().getSimpleName() + " has " + hitpoints + " hitpoints.";
    }
}

class Human extends Boxer {
    public Human() {
        super(100);
    }

    @Override
    public void punch(Boxer opponent) {
        Random random = new Random();
        if (random.nextInt(100) < 30) {
            opponent.setHitpoints(opponent.getHitpoints() - 10);
        }
    }
}

class Kangaroo extends Boxer {
    public Kangaroo() {
        super(100);
    }

    @Override
    public void punch(Boxer opponent) {
        Random random = new Random();
        if (random.nextInt(100) < 30) {
            opponent.setHitpoints(opponent.getHitpoints() - 10);
        }
    }
}

public class PolymorphismDemo {
    public static void main(String[] args) {
        Boxer boxPuncher = new Human();
        Boxer boxPunchee = new Kangaroo();

        while (boxPuncher.getHitpoints() > 0 && boxPunchee.getHitpoints() > 0) {
            boxPuncher.punch(boxPunchee);
            System.out.println(boxPunchee.report());
            Boxer temp = boxPuncher;
            boxPuncher = boxPunchee;
            boxPunchee = temp;
        }

        System.out.println(boxPuncher.report());
        System.out.println(boxPunchee.report());
    }
}
