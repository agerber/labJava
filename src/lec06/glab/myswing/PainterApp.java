package lec06.glab.myswing;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class PainterApp implements ChangeListener, MouseMotionListener {

    private JPanel panRoot;
    private JPanel panCenter;
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
        sliderBlue.addChangeListener(this);
        sliderGreen.addChangeListener(this);
        sliderRed.addChangeListener(this);

        panCanvas.addMouseMotionListener(this);
    }

    /**
     * Invoked when the target of the listener has changed its state.
     *
     * @param e a ChangeEvent object
     */
    @Override
    public void stateChanged(ChangeEvent e) {
        color = new Color(sliderRed.getValue(), sliderGreen.getValue(), sliderBlue.getValue());
        panNorth.setBackground(color);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Graphics graphics = panCanvas.getGraphics();
        graphics.setColor(color);
        graphics.fillOval(e.getX(), e.getY(), 30, 30);
    }


    @Override
    public void mouseMoved(MouseEvent e) {
            //required to satisfy contract
    }
}
