package lec05.glab.eventmodel;

import javax.swing.*;
import java.awt.event.*;

/**
 * Created with IntelliJ IDEA.
 * User: ag
 * Date: 10/28/13
 * Time: 3:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class MouseClicker {
    private JPanel mPanel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("MouseClicker");
        frame.setContentPane(new MouseClicker().mPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(600,400);
        frame.setVisible(true);
    }


    public MouseClicker() {

        mPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                  JOptionPane.showMessageDialog(mPanel,
                       "you clicked " + e.getSource() + " at point " + e.getPoint());

            }

        });

        mPanel.addMouseMotionListener(new MouseMotionAdapter() {


            @Override
            public void mouseMoved(MouseEvent e) {
                System.out.println(e.getPoint());
            }
        });


    }
}
