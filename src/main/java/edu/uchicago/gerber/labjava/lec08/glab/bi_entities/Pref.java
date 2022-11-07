package edu.uchicago.gerber.labjava.lec08.glab.bi_entities;

public class Pref<F,S> {
    private F first;
    private S second;

    public Pref(F first, S second) {
        this.first = first;
        this.second = second;
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
}
