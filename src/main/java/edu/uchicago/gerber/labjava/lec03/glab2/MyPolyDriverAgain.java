package edu.uchicago.gerber.labjava.lec03.glab2;

public class MyPolyDriverAgain {

    public static void main(String[] args) {
        Double dub = new Double(2.3);
        Number num = dub;
        Object obj = num;

       // System.out.println(num.);

       // Double dub2 = new Object();
      //  Rectangle rec = new Double(4.5);
       // obj = new Date();

        Double dub2 = (Double) obj;

    }
}
