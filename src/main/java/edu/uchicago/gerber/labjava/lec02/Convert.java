package edu.uchicago.gerber.labjava.lec02;

/**
 * Created with IntelliJ IDEA.
 * User: ag
 * Date: 10/7/13
 * Time: 1:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class Convert {

    private Convert() {}


//    private String name;
//
//    public Convert(String name) {
//        this.name = name;
//    }
//    public Convert(){}
//    @Override
//    public String toString() {
//       return  name;
//    }

    public static double tempToMetric(double dFar){
       //(°F  -  32)  x  5/9
        return (dFar -32) * 5.0/9.0;
    }

    public static double tempToImperial(double dCel){
       // °C  x  9/5 + 32
       return  dCel * 9.0/5.0 + 32;
    }



}
