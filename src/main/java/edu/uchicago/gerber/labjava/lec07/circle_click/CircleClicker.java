package edu.uchicago.gerber.labjava.lec07.circle_click;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CircleClicker {
    private JPanel mPanel;
    private JButton btnGo;


    //my vars
    private Point pntStart, pntEnd;

    public static void main(String[] args) {
        JFrame frame = new JFrame("CircleClicker");
        frame.setContentPane(new CircleClicker().mPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(new Dimension(800, 600));
    }

    //best to drag from bottom-right to top-left
    public CircleClicker() {



        btnGo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(CircleClicker.this.getClass());
            }
        });


        mPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

                pntStart = e.getPoint();

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                pntEnd = e.getPoint();

                double verticalLeg = Math.abs(pntEnd.y - pntStart.y);
                double horizontalLeg = Math.abs(pntEnd.x - pntStart.x);
                double hypotenus = Math.hypot(verticalLeg, horizontalLeg);

                Circle circle = new Circle(pntStart, hypotenus, Color.black);
                circle.draw(mPanel.getGraphics());
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

    }


    class Circle {
        private Point center;
        private double radius;
        private Color color;


        public Circle(Point center, double radius, Color color) {
            this.center = center;
            this.radius = radius;
            this.color = color;
        }

        public void draw(Graphics graphics){
            graphics.setColor(color);
            //drawOval starts to draw at the top-left corner, so we must subtract the raduis from center-point to adjust
            graphics.drawOval((int)(center.getX() - radius), (int) (center.getY() -radius), (int) (2*radius), (int)(2*radius));
        }
    }
}
