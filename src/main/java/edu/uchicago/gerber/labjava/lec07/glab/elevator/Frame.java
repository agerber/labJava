package edu.uchicago.gerber.labjava.lec07.glab.elevator;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: ag
 * Date: 11/3/13
 * Time: 5:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class Frame implements Drawable {
    private JPanel mPanel;
    public static Dimension sDimension;

    //a building has an array of floors and an elevator
    private Elevator mElevator;
    // private Floor[] mFloors;
    //private Dimension mDimension;
    private int mCurrentFloor;
    private LinkedList<Rider> mWorkingRiders;
    private LinkedList<Rider> mWaitingRiders;
    private Graphics mGraphics;


    //static members
    public static final int NUM_FLOOR =5;
    public static final Color COLOR = Color.GRAY;


    public static void main(String[] args) {
        JFrame frame = new JFrame("Elevator Model");
        frame.setContentPane(new Frame().mPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        sDimension = new Dimension(600, 900);

        frame.setSize(sDimension);

        frame.setVisible(true);


    }

    public Frame() {
        //an elevator has 1/3 -10 pixels the width and 1/num_floors height - 10
        mWorkingRiders = new LinkedList<>();
        mWaitingRiders = new LinkedList<>();

      //  mElevator = new Elevator(new Dimension((int)(sDimension.getWidth()/3 -10),(int)(sDimension.getHeight()/NUM_FLOOR -10)));

        //mFloors = new Floor[NUM_FLOOR];
        mGraphics = mPanel.getGraphics();
        drawMe(mGraphics);


    }

    public void requestFloor(Rider rider){


    }

    public int getCurrentFloor() {
        return mCurrentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        mCurrentFloor = currentFloor;
    }




    @Override
    public void drawMe(Graphics g) {

        g.setColor(new Color(100,100,100));
        g.fillRect(0,0,(int)sDimension.getWidth(),(int)sDimension.getHeight());

        Rectangle rec = new Rectangle(new Dimension((int)sDimension.getWidth()-6, (int)(sDimension.getHeight() / NUM_FLOOR )-6));
        // Color colFloor = Color.DARK_GRAY;
        g.setColor(Color.DARK_GRAY);
        for (int nC = NUM_FLOOR - 1; nC >= 0 ; nC--) {
            //multiply the 1/5 the height o
            g.fillRect(3, (int) (sDimension.getHeight() / NUM_FLOOR * nC + 3), (int)rec.getWidth()-3, (int)rec.getHeight()-3 );
        }

        //draw the riders in the building


        // mElevator.drawMe(g);

    }


}
