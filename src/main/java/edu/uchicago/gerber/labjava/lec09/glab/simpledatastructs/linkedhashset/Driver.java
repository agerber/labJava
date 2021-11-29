package edu.uchicago.gerber.labjava.lec09.glab.simpledatastructs.linkedhashset;

import java.util.LinkedHashSet;
import java.util.Set;

public class Driver {
    public static void main(String[] args) {
        Set<String> rankedSquashPlayers = new LinkedHashSet<>(29);
        rankedSquashPlayers.add("ALI FARAG");
        rankedSquashPlayers.add("MOHAMED ELSHORBAGY");
        rankedSquashPlayers.add("PAUL COLL");
        rankedSquashPlayers.add("TAREK MOMEN");
        rankedSquashPlayers.add("DIEGO ELIAS");
        rankedSquashPlayers.add("MOSTAFA ASAL");
        rankedSquashPlayers.add("FARES DESSOUKY");
        rankedSquashPlayers.add("MARWAN ELSHORBAGY");
        rankedSquashPlayers.add("JOEL MAKIN");
        rankedSquashPlayers.add("KARIM ABDEL GAWAD");
        rankedSquashPlayers.add("MAZEN HESHAM");
        rankedSquashPlayers.add("MIGUEL RODRIGUEZ");
        rankedSquashPlayers.add("GREGOIRE MARCHE");
        rankedSquashPlayers.add("MOHAMED ABOUELGHAR");
        rankedSquashPlayers.add("SAURAV GHOSAL");
        rankedSquashPlayers.add("YOUSSEF IBRAHIM");
        rankedSquashPlayers.add("YOUSSEF SOLIMAN");
        rankedSquashPlayers.add("EAIN YOW NG");
        rankedSquashPlayers.add("RAPHAEL KANDRA");
        rankedSquashPlayers.add("BAPTISTE MASOTTI");

        //When seeking, will use hashtable, so O(1)
        System.out.println("O(1) is MIGUEL RODRIGUEZ ranked? :" + rankedSquashPlayers.contains("MIGUEL RODRIGUEZ"));

        //when iterating, will use linkedList in order, and O(n) where n is the number of elements, not buckets.
        int nC = 1;
        System.out.println("\n\nO(n) ordered, where n is the number of elements, not buckets:");
        for (String rankedSquashPlayer : rankedSquashPlayers) {
            System.out.println(nC++ + ": " + rankedSquashPlayer);
        }



    }
}
