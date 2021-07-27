package edu.uchicago.gerber.labjava.lec07.glab.stream.behaviorparam;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BehaviorParam1 {

    public static void main(String[] args) {


        //the problems
        //1 functions are second class citizens in Java. Previously, if we wanted to pass a function into a method,
        //we had to wrap it in an (anonymous) object of an interface. This is wasteful.

        //2 There is a lot of boilerplate that we don't need here. If there is only one method in this interface,
        //we can iner the interface name, the method name, and even the parameter types. So, get rid of them.


        final ActionListener actionListener7 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getWhen());
            }
        };



        Timer timer1 = new Timer(1000, e -> System.out.println(e.getWhen()));
        timer1.start();




        //in Java8
        //extract variable

        final ActionListener actionListener8 = e -> {
            System.out.println(e.getWhen());
        };
        Timer timer2 = new Timer(1000, actionListener8);
        timer2.start();


        //we couldn't do this on a MouseClick interface b/c it has more than one contract method



    }
}
