package edu.uchicago.gerber.labjava.lec05.anon;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyEvent {

    public static void main(String[] args) {

//        ActionListener actionListener = new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                //$1
//                System.out.println("Hello there" + this.getClass().getName());
//            }
//        };

        new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hello there" + this.getClass().getName());
            }
        }).start();
    }
}
