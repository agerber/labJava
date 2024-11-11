package edu.uchicago.gerber.labjava.lec07.stream.behaviorparam;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BehaviorParam1 {

    public static void main(String[] args) throws InterruptedException {


        //the problems
        //1 functions are second class citizens in Java. Previously, if we wanted to pass a function into a method,
        //we had to wrap it in an (anonymous) object of an interface. This is wasteful.

        //2 There is a lot of boilerplate that we don't need here. If there is only one method in this interface,
        //we can iner the interface name, the method name, and even the parameter types. So, get rid of them.

       //this.getClass().getSimpleName() +

        //In Java7 and before


        //In order to pass behavior, by wrapping it in an anonymous object (e.g. $1)

        final ActionListener actionListener7 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getWhen());
            }
        };

        Timer timer1 = new Timer(1000, actionListener7);
        timer1.start();

        //We could also inline this behavior as an anonymous inner class. This saves us a little bit of boiler-plate.

        Timer timer2 = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getWhen());
            }
        });
        timer2.start();

        //in Java8
        //extract variable

        final ActionListener actionListener8 = evt -> System.out.println(evt.getWhen());

        Timer timer3 = new Timer(1000, actionListener8);
        timer3.start();


        // we can also inline it
        Timer timer4 = new Timer(1000, e -> System.out.println(e.getWhen()));
        timer4.start();



        while(true){
            Thread.sleep(20_000);
            System.out.println("hello");
        }







    }
}
