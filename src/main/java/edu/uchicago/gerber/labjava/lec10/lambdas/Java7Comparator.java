package edu.uchicago.gerber.labjava.lec10.lambdas;

import java.util.Comparator;


public class Java7Comparator implements Comparator<Circle> {
    /*
    * This is our custom comparator for a Circle
    * it compares the area of one circle to another
    * */
    @Override
    public int compare(Circle o1, Circle o2) {
        return Double.compare(o1.getArea(), o2.getArea());
    }
}
