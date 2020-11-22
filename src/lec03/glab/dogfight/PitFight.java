package lec03.glab.dogfight;

import java.util.ArrayList;

public class PitFight {

    public static void main(String[] args) {


        Dog attacker = new Chiwawa("Rico");
        Dog attackee = new Mastiff("Gianni");

//        ArrayList<Dog> dogs = new ArrayList<>();
//        dogs.add(attackee);


        while (attackee.getHealth() > 0){

            //bite
            attacker.bite(attackee);

            //swap
             Dog dogTemp;
            dogTemp = attackee;

            attackee = attacker;
            attacker = dogTemp;



            System.out.println(attacker.getName() + ", the " +  attacker.getClass().getSimpleName() +  " attacks " + attackee.getName() + " with health " + attackee.getHealth());


        }

        System.out.println(attacker.getName() +
                " wins, " + attackee.getName() +" is dead.");




    }
}
