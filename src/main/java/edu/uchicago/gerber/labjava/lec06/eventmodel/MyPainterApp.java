package edu.uchicago.gerber.labjava.lec06.eventmodel;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MyPainterApp implements MouseMotionListener, ChangeListener {
    private JPanel panelRoot;
    private JPanel panNorth;
    private JPanel panCanvas;
    private JPanel panSouth;
    private JSlider sliderRed;
    private JSlider sliderGreen;
    private JSlider sliderBlue;

    private Color color;

    public static void main(String[] args) {
        JFrame frame = new JFrame("painter");
        frame.setContentPane(new MyPainterApp().panelRoot);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(1600,1400);
        frame.setVisible(true);
    }

    public MyPainterApp(){

        panCanvas.addMouseMotionListener(this);
        sliderRed.addChangeListener(this);
        sliderGreen.addChangeListener(this);
        sliderBlue.addChangeListener(this);


    }

    @Override
    public void stateChanged(ChangeEvent e) {

        color = new Color(sliderRed.getValue(), sliderGreen.getValue(), sliderBlue.getValue());
        panNorth.setBackground(color);
        JSlider mySlider = (JSlider) e.getSource();


    }


    @Override
    public void mouseDragged(MouseEvent e) {
        Graphics graphics = panCanvas.getGraphics();
        graphics.setColor(color);
        graphics.fillOval(e.getX(), e.getY(), 20, 40);
    }


    @Override
    public void mouseMoved(MouseEvent e) {

    }


}
