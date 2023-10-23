package edu.uchicago.gerber.labjava.lec04.singleton;

import java.util.List;

public class SingletonDriver {
    public static void main(String[] args) {

        //The reason I might want to do this, is if my singleton was 1/ managing state, and 2/ passed around to many
        // objects. The following keeps track of the players of Mortal Kombat

        Singleton.getInstance().getValues().add("Raiden");
        Singleton.getInstance().getValues().add("Sub-Zero");
        Singleton.getInstance().getValues().add("Kano");
        Singleton.getInstance().getValues().add("Jax");
        Singleton.getInstance().getValues().add("Scorpion");

        Singleton.getInstance().getValues().remove("Sub-Zero");



        List<String> theValues = Singleton.getInstance().getValues();
        for (String theValue : theValues) {
            System.out.println(theValue);
        }
    }
}
