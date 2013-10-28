package lec05.glab.moreswing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created with IntelliJ IDEA.
 * User: ag
 * Date: 10/28/13
 * Time: 10:46 AM
 * To change this template use File | Settings | File Templates.
 */
public class DrawRectangle {
    private JPanel mPanel;
    private Point mStart, mEnd;

    public static void main(String[] args) {
        JFrame frame = new JFrame("DrawRectangle");
        frame.setContentPane(new DrawRectangle().mPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(600,400);
        frame.setVisible(true);
    }

    public DrawRectangle() {
        //init

        //actionlisteners
        mPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.

            }

            @Override
            public void mousePressed(MouseEvent e) {

                  mStart = e.getPoint();

            }

            @Override
            public void mouseReleased(MouseEvent e) {

                mEnd = e.getPoint();
                double dWidth = Math.abs(mStart.getX() - mEnd.getX());
                double dHeight = Math.abs(mStart.getY() - mEnd.getY());
                mPanel.getGraphics().drawRect(mStart.x, mStart.y, (int)dWidth, (int)dHeight);



            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });
    }
}
