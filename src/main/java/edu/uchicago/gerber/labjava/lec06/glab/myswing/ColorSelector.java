package edu.uchicago.gerber.labjava.lec06.glab.myswing;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class ColorSelector implements ChangeListener {
    private JPanel panRoot;
    private JPanel panColor;
    private JPanel panControl;
    private JSlider sldRed;
    private JSlider sldGreen;
    private JSlider sldBlue;


    public static void main(String[] args) {
        JFrame frame = new JFrame("ColorSelector");
        frame.setContentPane(new ColorSelector().panRoot);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(new Dimension(1200,800));
        frame.setVisible(true);
    }


    public ColorSelector() {
        setColor();
        sldBlue.addChangeListener(this);
        sldGreen.addChangeListener(this);
        sldRed.addChangeListener(this);
    }

    /**
     * Invoked when the target of the listener has changed its state.
     *
     * @param e a ChangeEvent object
     */
    @Override
    public void stateChanged(ChangeEvent e) {
        setColor();
    }

    private void setColor() {
        panColor.setBackground(new Color(sldRed.getValue(),
                                         sldGreen.getValue(),
                                         sldBlue.getValue()));
    }

}
