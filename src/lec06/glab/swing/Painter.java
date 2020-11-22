package lec06.glab.swing;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

/**
 * Created by Adam on 11/2/2015.
 */
public class Painter implements ChangeListener {
    //define a frame
    private JFrame frm;
    private JPanel mPanelIndicator;
    private JPanel mPanelCenter;
    private JPanel mPanelSlider;

    private JSlider mSliderRed;
    private JSlider mSliderGreen;
    private JSlider mSliderBlue;

    private Color mColor;



    //creaete a main method that insantiates the ecnlosing object
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Painter window = new Painter();
                    window.frm.setVisible(true);
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
            frm = new JFrame();
        frm.setBounds(100, 100, 700, 476);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //lay our componnets out
        mPanelIndicator = new JPanel();

        //http://stackoverflow.com/questions/17083657/make-bottom-panel-in-borderlayout-to-expand-like-center-panel
        mPanelIndicator.setPreferredSize(new Dimension(frm.getWidth(), 50));

        frm.getContentPane().add(mPanelIndicator, BorderLayout.NORTH);

        mPanelCenter = new JPanel();
        frm.getContentPane().add(mPanelCenter, BorderLayout.CENTER);

        mPanelCenter.addMouseMotionListener(new MouseMotionAdapter() {

            @Override
            public void mouseDragged(MouseEvent e) {

                    Graphics graphics =  mPanelCenter.getGraphics();
                    graphics.setColor(mColor);
                    graphics.fillOval(e.getX(), e.getY(), 20,20);

            }
        });


        mSliderBlue = new JSlider(0,255);
        mSliderGreen = new JSlider(0,255);
        mSliderRed = new JSlider(0,255);

        mSliderBlue.addChangeListener(this);
        mSliderGreen.addChangeListener(this);
        mSliderRed.addChangeListener(this);




        mPanelSlider = new JPanel();
        mPanelSlider.add(mSliderRed);
        mPanelSlider.add(mSliderGreen);
        mPanelSlider.add(mSliderBlue);

        frm.getContentPane().add(mPanelSlider, BorderLayout.SOUTH);


        mColor = Color.GRAY;
        mPanelIndicator.setBackground(mColor);





    }


    /**
     * Invoked when the target of the listener has changed its state.
     *
     * @param e a ChangeEvent object
     */
    @Override
    public void stateChanged(ChangeEvent e) {
        mColor =  new Color(mSliderRed.getValue(),
                mSliderGreen.getValue(),
                mSliderBlue.getValue()

        );
        mPanelIndicator.setBackground(mColor);
    }
}
