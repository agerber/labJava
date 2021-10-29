package edu.uchicago.gerber.labjava.lec05.glab.reflection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class TypeAnonDriver {
    public static void main(String[] args) {

        //this is TYPE ANONYMITY

        Timer timer = new Timer(1000,

                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Date date = new Date();
                        System.out.println("reference and type anonymous at the time is " + date);
                        Reflector.printClass(this.getClass());
                        Toolkit.getDefaultToolkit().beep();
                    }
                }


        );

        timer.start();


      // Reflector.printClass(number.getClass());

    }

}
