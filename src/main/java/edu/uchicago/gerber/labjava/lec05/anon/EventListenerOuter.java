package edu.uchicago.gerber.labjava.lec05.anon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventListenerOuter implements ActionListener {


    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.println("hello world");

    }
}
