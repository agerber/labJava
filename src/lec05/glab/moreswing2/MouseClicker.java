package lec05.glab.moreswing2;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Created by Adam on 11/2/2015.
 */
public class MouseClicker {

    //step creat the frame
    private JFrame frm;
    private JPanel mPanelCenter;

    //step 2 create create the swing main method
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MouseClicker window = new MouseClicker();
                    window.frm.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    //4 call init from the construtor
    public MouseClicker() {
        initialize();
    }

    //3 create the intialize method
    private void initialize() {
        frm = new JFrame();
        frm.setBounds(100, 100, 450, 476);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mPanelCenter = new JPanel();



    }
}
