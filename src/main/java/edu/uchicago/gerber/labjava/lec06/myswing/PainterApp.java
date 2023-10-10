package edu.uchicago.gerber.labjava.lec06.myswing;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class PainterApp {

    private JPanel panRoot;
    private JPanel panNorth;
    private JSlider sliderRed;
    private JSlider sliderGreen;
    private JSlider sliderBlue;
    private JPanel panCanvas;

    private Color color;

    public static void main(String[] args) {

        JFrame frame  = new JFrame("My Painter App");
        frame.setContentPane(new PainterApp().panRoot);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(new Dimension(1200, 800));
        frame.setVisible(true);

    }

    public PainterApp() {

        color = Color.GRAY;

       // 1/ you can not use reflection on the lambda because a lambda is not an object.
       // 2/ Any interface with exactly one contract method can be transformed into a lambda.


//        ChangeListener changeListener = e -> {
//            color = new Color(sliderRed.getValue(), sliderGreen.getValue(), sliderBlue.getValue());
//            panNorth.setBackground(color);
//            System.out.println(this.getClass().getName());
//        };

        ChangeListener changeListener = e -> {
            color = new Color(sliderRed.getValue(), sliderGreen.getValue(), sliderBlue.getValue());
            panNorth.setBackground(color);
            //System.out.println(this.getClass().getName());
        };


        sliderBlue.addChangeListener(changeListener);
        sliderGreen.addChangeListener(changeListener);
        sliderRed.addChangeListener(changeListener);

        panCanvas.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                    Graphics graphics = panCanvas.getGraphics();
                    graphics.setColor(color);
                    graphics.fillOval(e.getX(), e.getY(), 30, 30);
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });

    }



    //contracts methods of ChangeListener overridden to satisfy contract
//    @Override
//    public void stateChanged(ChangeEvent e) {
//        color = new Color(sliderRed.getValue(), sliderGreen.getValue(), sliderBlue.getValue());
//        panNorth.setBackground(color);
//    }

    //&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

    //contracts methods of MouseMotionListener overridden to satisfy contract
//    @Override
//    public void mouseDragged(MouseEvent e) {
//        Graphics graphics = panCanvas.getGraphics();
//        graphics.setColor(color);
//        graphics.fillOval(e.getX(), e.getY(), 30, 30);
//    }
//
//
//    @Override
//    public void mouseMoved(MouseEvent e) {
//            //required to satisfy contract
//    }

}
