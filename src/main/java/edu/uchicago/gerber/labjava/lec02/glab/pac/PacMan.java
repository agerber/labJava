package edu.uchicago.gerber.labjava.lec02.glab.pac;

import java.lang.*;

public class PacMan extends Object {



    public Ghost eat(Ghost ghost){


        if (Math.random() * 100 <50){
            System.out.println("Yummmm..." + ghost);
            return ghost;
        } else {
            return null;
        }
    }

}
