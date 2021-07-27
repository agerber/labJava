package edu.uchicago.gerber.labjava.lec08.glab.lambda.behaviorParam;

/**
 * Created by Adam on 7/14/2015.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BehaviorParam {


    public static void main(String[] args) {


        //the evolution of behavior parameterization
        //anonymous inner classes
        new Thread(() -> {
            try {
                Toolkit.getDefaultToolkit().beep();
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        //similar using swing actionListener using swing adn the java event model with no gui
        new Timer(250, evt -> {
            Toolkit.getDefaultToolkit().beep();
            System.out.println(evt.getSource());
        }).start();


        //we can also wrap this into a class if we wanted
        class MyActionListener implements  ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                    Toolkit.getDefaultToolkit().beep();

            }
        }

        new Timer(750, new MyActionListener()).start();







    }







}
