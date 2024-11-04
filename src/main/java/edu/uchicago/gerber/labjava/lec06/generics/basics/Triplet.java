package edu.uchicago.gerber.labjava.lec06.generics.basics;

public class Triplet<F,S,T extends Number> {

    private F first;
    private S second;
    private T third;

    public Triplet(F first, S second, T third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }


    public F getFirst() {
        return first;
    }

    public void setFirst(F first) {
        this.first = first;
    }

    public S getSecond() {
        return second;
    }

    public void setSecond(S second) {
        this.second = second;
    }

    public T getThird() {
        return third;
    }

    public void setThird(T third) {
        this.third = third;
    }

    @Override
    public String toString() {
        return first.toString() + ":" +
                second.toString() + ":" + third.doubleValue();
    }
}
