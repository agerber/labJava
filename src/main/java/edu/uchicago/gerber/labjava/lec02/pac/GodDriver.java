package edu.uchicago.gerber.labjava.lec02.pac;

import java.util.ArrayList;

public class GodDriver {

    public static final String GAME_NAME = "PAC MAN";


    public static void main(String[] args) {
        PacMan pacMan = new PacMan();

        Ghost[] ghosts = {new Ghost("Harry"),new Ghost("Marry"),new Ghost("Larry"),new Ghost("Carry") };

        ArrayList<Ghost> deadGhosts = new ArrayList<>(4);

        for (Ghost ghost : ghosts) {
            Ghost tryEatGhost = pacMan.eat(ghost);
          if (null !=  tryEatGhost){
              deadGhosts.add(tryEatGhost);
          }
        }

        for (Ghost deadGhost : deadGhosts) {
            System.out.println(Integer.parseInt((deadGhost.toString())));
        }

    }
}
