package edu.uchicago.gerber.labjava.lec07.glab.midterm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseClicker {
    private JPanel panRoot;

    public static void main(String[] args) {
        JFrame frame = new JFrame("MouseClicker");
        frame.setContentPane(new MouseClicker().panRoot);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(new Dimension(600, 800));
    }

    public MouseClicker() {
       panRoot.addMouseListener(new MouseAdapter() {

           @Override
           public void mouseReleased(MouseEvent e) {
               super.mouseReleased(e);
           }

           @Override
           public void mouseMoved(MouseEvent e) {
               super.mouseMoved(e);
           }
       });
    }
}
