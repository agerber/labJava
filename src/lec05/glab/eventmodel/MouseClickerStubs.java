package lec05.glab.eventmodel;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Created by ag on 11/3/2014.
 */
public class MouseClickerStubs {
    private JPanel mPanel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("MouseClickerStubs");
        frame.setContentPane(new MouseClickerStubs().mPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public MouseClickerStubs() {

        mPanel.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(mPanel,
                        "you clicked " + e.getSource() + " at point " + e.getPoint());
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        mPanel.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                System.out.println(e.getPoint());
            }
        });

    }
}
