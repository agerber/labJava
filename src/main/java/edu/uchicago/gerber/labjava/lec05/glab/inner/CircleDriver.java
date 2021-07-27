package edu.uchicago.gerber.labjava.lec05.glab.inner;

import java.awt.*;

public class CircleDriver {

    public static void main(String[] args) {

     System.out.println(new Circle(5.4, new Point(2,3)).getArea());
//

           // new Timer(1000, new MyEventListener()).start();
    }


}




 class Circle {

    private double rad;
    private Point center;

    public Circle(double rad, Point center) {
        this.rad = rad;
        this.center = center;
    }

    public double getArea(){
        return Math.PI * rad * rad;
    }
}







