package edu.uchicago.gerber.labjava.lec09.generics.basics;

import java.util.ArrayList;
import java.util.List;

public class PairInterfaceDriver {
    public static void main(String[] args) {
        List<Pair<String, ? extends Runnable>> list = new ArrayList<>();

        list.add(new Pair<>("To be or not to be", new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        }));
        list.add(new Pair<>("Do or do not do, there is no try", new Runnable() {
            @Override
            public void run() {
                System.out.println("good-bye");
            }
        }));

        for (Pair<String, ? extends Runnable> stringPair : list) {
            System.out.println(stringPair.getFirst());
            new Thread(stringPair.getSecond()).start();
        }


    }
}
