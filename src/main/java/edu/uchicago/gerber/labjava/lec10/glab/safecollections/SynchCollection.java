package edu.uchicago.gerber.labjava.lec10.glab.safecollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//you can get a lock on an item by using the synchronized keyword.

//http://www.avajava.com/tutorials/lessons/how-do-i-synchronize-a-list-or-other-collection-in-java.html
public class SynchCollection {


    private static List<Integer> intNums = Collections.synchronizedList(new ArrayList<Integer>());


    public static void main(String[] args) {


        //populate the ArrayList with anonymous thread
        new Thread(new Runnable() {
            public void run() {
                synchronized (intNums) {
                    for (int nC = 0; nC < 1000; nC++) {
                        intNums.add(new Integer(nC));
                        System.out.println("adding " + nC);
                    }

                }
            }
        }).start();


        //remove any element
        new Thread(new Runnable() {
            public void run() {
                synchronized (intNums) {
                    for (int nC = 0; nC < 1000; nC++) {
                        intNums.remove(new Integer(nC));
                        System.out.println("remove " + nC);

                    }
                }
            }
        }).start();


        //print the elements (if they exist)
        new Thread(new Runnable() {
            public void run() {
                synchronized (intNums) {

                    for (Integer intMe : intNums) {
                        System.out.println("print " +intMe);
                    }
                }
            }
        }).start();


    }

}