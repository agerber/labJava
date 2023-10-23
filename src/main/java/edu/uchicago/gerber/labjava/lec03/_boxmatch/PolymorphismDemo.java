package edu.uchicago.gerber.labjava.lec03._boxmatch;

import java.util.Random;

  class Boxer {
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

    //Let's run this demo, and then refactor so that punch is an abstract method.
      //forcing the extending classes to implement punch.
    public void punch(Boxer opponent) {
        Random random = new Random();
        if (random.nextInt(100) < 30) {
            System.out.println( this.getClass().getSimpleName() + " lands a punch!");
            opponent.setHitpoints(opponent.getHitpoints() - 10);
        }
    }
     //public abstract void punch(Boxer opponent);

    public String report() {
        return this.getClass().getSimpleName() + " has " + hitpoints + " hitpoints.";
    }
}

class Human extends Boxer {
    public Human() {
        super(105);
    }

}

class Kangaroo extends Boxer {
    public Kangaroo() {
        super(100);
    }

}

public class PolymorphismDemo {
    public static void main(String[] args) {
        Boxer boxPuncher = new Human();
        Boxer boxPunchee = new Kangaroo();

        while (boxPuncher.getHitpoints() > 0 && boxPunchee.getHitpoints() > 0) {
            boxPuncher.punch(boxPunchee);
            Boxer temp = boxPuncher;
            boxPuncher = boxPunchee;
            boxPunchee = temp;
        }

        System.out.println("--------------------------\nKNOCK-OUT!  ");
        System.out.print(boxPuncher.report() + "\n");
        System.out.println(boxPunchee.report());
    }
}
