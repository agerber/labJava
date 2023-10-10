package edu.uchicago.gerber.labjava.lec08.lambda.behaviorParam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyB {

    public static void main(String[] args) {

        new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Toolkit.getDefaultToolkit().beep();
            }
        });

        new Timer(1000, e -> System.out.println(e.getWhen()) );
    }
}
