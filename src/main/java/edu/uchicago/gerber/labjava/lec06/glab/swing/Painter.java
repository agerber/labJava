package edu.uchicago.gerber.labjava.lec06.glab.swing;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

/**
 * Created by Adam on 11/2/2015.
 */
public class Painter {
    //define a frame
    private JFrame frame;
    private JPanel panelColor;
    private JPanel panelCanvas;

    private JSlider sliderRed;
    private JSlider sliderGreen;
    private JSlider sliderBlue;

    private Color color;




    //creaete a main method that insantiates the ecnlosing object
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Painter window = new Painter();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    //constructor calls init
    public Painter() {
        initialize();
    }

    //use BorderLayout. this is the easiest one.
    //https://docs.oracle.com/javase/tutorial/uiswing/layout/border.html

    //our init methhod
    private void initialize() {
            frame = new JFrame();
        frame.setBounds(100, 100, 700, 476);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //lay our componnets out
        panelColor = new JPanel();

        //http://stackoverflow.com/questions/17083657/make-bottom-panel-in-borderlayout-to-expand-like-center-panel
        panelColor.setPreferredSize(new Dimension(frame.getWidth(), 50));

        frame.getContentPane().add(panelColor, BorderLayout.NORTH);

        panelCanvas = new JPanel();

        frame.getContentPane().add(panelCanvas, BorderLayout.CENTER);


        panelCanvas.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Graphics graphics = panelCanvas.getGraphics();
                graphics.setColor(color);
                graphics.fillOval(e.getX(), e.getY(), 20,20);
            }

        });


        sliderBlue = new JSlider(0,255);
        sliderGreen = new JSlider(0,255);
        sliderRed = new JSlider(0,255);

        ChangeListener changeListener = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                setColor();
            }
        };

        sliderBlue.addChangeListener(changeListener);
        sliderGreen.addChangeListener(changeListener);
        sliderRed.addChangeListener(changeListener);


        JPanel  panelSlider = new JPanel();
        panelSlider.add(sliderRed);
        panelSlider.add(sliderGreen);
        panelSlider.add(sliderBlue);

        frame.getContentPane().add(panelSlider, BorderLayout.SOUTH);


        color = Color.GRAY;
        panelColor.setBackground(color);





    }

    private void setColor() {
        color = new Color(sliderRed.getValue(),
                sliderGreen.getValue(),
                sliderBlue.getValue());
        panelColor.setBackground(color);
    }


}
