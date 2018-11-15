package lec03.glab.dogfight;

public class PitFight {

    public static void main(String[] args) {


        Dog attacker = new Chiwawa("Rico");
        Dog attackee = new Mastiff("Gianni");


        while (attackee.getHealth() > 0){

            //bite
            attacker.bite(attackee);

            Dog dogTemp;
            dogTemp = attackee;

            attackee = attacker;
            attacker = dogTemp;


            //swap dogs
            System.out.println(attacker.getName() + "bites" );


        }

        System.out.println(attacker.getName() +
                " wins" + attackee.getName() +" is dead.");




    }
}
