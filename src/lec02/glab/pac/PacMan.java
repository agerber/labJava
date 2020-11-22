package lec02.glab.pac;

import com.sun.corba.se.impl.naming.cosnaming.InterOperableNamingImpl;

import java.lang.*;
import java.util.Random;

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
