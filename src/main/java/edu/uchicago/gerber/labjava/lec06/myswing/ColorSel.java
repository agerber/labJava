package edu.uchicago.gerber.labjava.lec06.myswing;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class ColorSel implements ChangeListener {
    private JPanel root;
    private JPanel north;
    private JPanel south;
    private JSlider red;
    private JSlider green;
    private JSlider blue;
    private JPanel sample;

    //used to store the paint color
    private Color color;

    public static void main(String[] args) {
        JFrame frame = new JFrame("ColorSelector");
        frame.setContentPane(new ColorSel().root);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(new Dimension(1200,800));
        frame.setVisible(true);
    }

    public ColorSel() {

        red.addChangeListener(this);
        green.addChangeListener(this);
        blue.addChangeListener(this);

        north.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Graphics graphics = north.getGraphics();
                graphics.setColor(color);
                graphics.fillOval(e.getX(), e.getY(), 30, 30);
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });


        changeTheColor();
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        changeTheColor();
    }

    private void changeTheColor() {
       // north.setBackground(new Color(red.getValue(), green.getValue(), blue.getValue()));
        color = new Color(red.getValue(), green.getValue(), blue.getValue());
        sample.setBackground(color);
    }
}
