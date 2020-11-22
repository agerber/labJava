package lec05.glab.inner;

import lec05.glab.reflection.Reflector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

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







