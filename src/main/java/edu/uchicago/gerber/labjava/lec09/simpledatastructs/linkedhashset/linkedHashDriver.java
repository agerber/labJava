package edu.uchicago.gerber.labjava.lec09.simpledatastructs.linkedhashset;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class linkedHashDriver {
    public static void main(String[] args) {


        Set<String> hashSet = new HashSet<>(29);

        hashSet.add("[ranked 1] ALI FARAG");
        hashSet.add("MOHAMED ELSHORBAGY");
        hashSet.add("PAUL COLL");
        hashSet.add("TAREK MOMEN");
        hashSet.add("DIEGO ELIAS");
        hashSet.add("MOSTAFA ASAL");
        hashSet.add("FARES DESSOUKY");
        hashSet.add("MARWAN ELSHORBAGY");
        hashSet.add("JOEL MAKIN");
        hashSet.add("KARIM ABDEL GAWAD");
        hashSet.add("MAZEN HESHAM");
        hashSet.add("MIGUEL RODRIGUEZ");
        hashSet.add("GREGOIRE MARCHE");
        hashSet.add("MOHAMED ABOUELGHAR");
        hashSet.add("SAURAV GHOSAL");
        hashSet.add("YOUSSEF IBRAHIM");
        hashSet.add("YOUSSEF SOLIMAN");
        hashSet.add("EAIN YOW NG");
        hashSet.add("RAPHAEL KANDRA");
        hashSet.add("BAPTISTE MASOTTI");




        //When seeking, will use hashtable, so O(1)
        System.out.println("O(1) is MIGUEL RODRIGUEZ ranked? :" + hashSet.contains("MIGUEL RODRIGUEZ"));

        //when iterating uses O(n) unordered where n is the number buckets.
        int nC = 1;
        System.out.println("\n\nO(n) unordered and unsorted, where n is the number of buckets:");
        for (String rankedSquashPlayer : hashSet) {
            System.out.println(nC++ + ": " + rankedSquashPlayer);
        }




        Set<String> linkedHashSet = new LinkedHashSet<>(29);
        linkedHashSet.add("[ranked 1] ALI FARAG");
        linkedHashSet.add("MOHAMED ELSHORBAGY");
        linkedHashSet.add("PAUL COLL");
        linkedHashSet.add("TAREK MOMEN");
        linkedHashSet.add("DIEGO ELIAS");
        linkedHashSet.add("MOSTAFA ASAL");
        linkedHashSet.add("FARES DESSOUKY");
        linkedHashSet.add("MARWAN ELSHORBAGY");
        linkedHashSet.add("JOEL MAKIN");
        linkedHashSet.add("KARIM ABDEL GAWAD");
        linkedHashSet.add("MAZEN HESHAM");
        linkedHashSet.add("MIGUEL RODRIGUEZ");
        linkedHashSet.add("GREGOIRE MARCHE");
        linkedHashSet.add("MOHAMED ABOUELGHAR");
        linkedHashSet.add("SAURAV GHOSAL");
        linkedHashSet.add("YOUSSEF IBRAHIM");
        linkedHashSet.add("YOUSSEF SOLIMAN");
        linkedHashSet.add("EAIN YOW NG");
        linkedHashSet.add("RAPHAEL KANDRA");
        linkedHashSet.add("BAPTISTE MASOTTI");


        //When seeking, will use hashtable, so O(1)
        System.out.println("O(1) is MIGUEL RODRIGUEZ ranked? :" + linkedHashSet.contains("MIGUEL RODRIGUEZ"));

        //when iterating, will use linkedList in order (not sorted), and O(n) where n is the number of ->
        //-> elements, not buckets.
        int nD = 1;
        System.out.println("\n\nO(n) ordered but unsorted, where n is the number of elements, not buckets:");
        for (String rankedSquashPlayer : linkedHashSet) {
            System.out.println(nD++ + ": " + rankedSquashPlayer);
        }






    }
}
