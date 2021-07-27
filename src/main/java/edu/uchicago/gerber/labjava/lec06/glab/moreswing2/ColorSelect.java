package edu.uchicago.gerber.labjava.lec06.glab.moreswing2;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class ColorSelect {
    private ChangeListener mChangeListener;

    private JPanel mPanel;
    private JPanel panNorth;
    private JPanel panSouth;
    private JSlider sliderRed;
    private JSlider sliderGreen;
    private JSlider sliderBlue;

    private static JFrame sFrame;

    public static void main(String[] args) {
        sFrame = new JFrame("ColorSelect");
        sFrame.setContentPane(new ColorSelect().mPanel);
        sFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sFrame.pack();
        sFrame.setSize(600, 400);
        sFrame.setVisible(true);
    }


    public ColorSelect() {



        //create listeners here
        mChangeListener = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                setColor(e);
            }
        };
        sliderBlue.addChangeListener(mChangeListener);
        sliderGreen.addChangeListener(mChangeListener);
        sliderRed.addChangeListener(mChangeListener);

        setColor();
    }

    private void setColor(ChangeEvent e) {
        System.out.println((((JSlider) e.getSource()).getValue()));

        panNorth.setBackground(new Color(sliderRed.getValue(), sliderGreen.getValue(), sliderBlue.getValue()));

    }

    private void setColor() {

        panNorth.setBackground(new Color(sliderRed.getValue(), sliderGreen.getValue(), sliderBlue.getValue()));

    }
}
