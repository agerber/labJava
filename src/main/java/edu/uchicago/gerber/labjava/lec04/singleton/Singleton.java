package edu.uchicago.gerber.labjava.lec04.singleton;

import java.util.ArrayList;
import java.util.List;

public class Singleton {
    // create an object of Singleton
    private static Singleton instance;


    private List<String> values;


    // make the constructor private so that this class cannot be instantiated
    private Singleton() {
        values = new ArrayList<>();
    }

    // get the only object available
    public static Singleton getInstance() {
        if (null == instance) {
            instance = new Singleton();
        }
        return instance;
    }

    public List<String> getValues() {
        return values;
    }
}
