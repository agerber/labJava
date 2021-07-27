package edu.uchicago.gerber.labjava.lec02.glab2;

public class Convert {

    public static double tempToMetric(double dFar){
        return (dFar -32) * 5.0/9.0;
    }
    public static double tempToImperial(double dCel){
        return dCel * 9.0/5.0 + 32;
    }
}
