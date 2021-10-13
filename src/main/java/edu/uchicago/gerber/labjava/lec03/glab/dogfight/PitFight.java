package edu.uchicago.gerber.labjava.lec03.glab.dogfight;

public class PitFight {

    public static void main(String[] args) {

        Dog attacker = new Chiwawa("Rico");
        Dog attackee = new Mastiff("Gianni");

        //declare a temporary reference used for swapping
        Dog dogTemp;

        while (attackee.getHealth() > 0){


            //swap
            dogTemp = attackee;
            attackee = attacker;
            attacker = dogTemp;

            //bite
            attacker.bite(attackee);


            System.out.println(attacker +  " bites " + attackee);


        }

        System.out.println("\nFinal score:");
        System.out.println(attacker.toStringHealth());
        System.out.println(attackee.toStringHealth());




    }
}
