package edu.uchicago.gerber.labjava.lec06.patterns.adapter.example.round;

/**
 * EN: RoundPegs are compatible with RoundHoles.
 *
 * RU: КруглыеКолышки совместимы с КруглымиОтверстиями.
 */
public class RoundPeg {
    private double radius;

    public RoundPeg() {}

    public RoundPeg(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}
