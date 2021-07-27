package edu.uchicago.gerber.labjava.lec03.glab.simplefight;

public class PitFight {

    public static void main(String[] args) {

        Dog attacker = new Chiwawa("Rico");
        Dog attackee = new Mastiff("Gianni");


        while (attackee.getHealth() > 0){

           attacker.bite(attackee);

             //swap
             Dog dogTemp = attacker;
             attacker = attackee;
             attackee = dogTemp;

            System.out.println(attacker);
        }

        System.out.println("Poor "  + attackee.getName() + " is dead.  " + attacker.getName() + " is triumphant.");

    }
}
