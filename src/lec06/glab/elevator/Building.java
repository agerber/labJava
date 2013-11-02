package lec06.glab.elevator;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: ag
 * Date: 11/2/13
 * Time: 3:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class Building implements  Drawable {
    //a building has an array of floors and an elevator
    private Elevator mElevator;
    private Floor[] mFloors;
    public Dimension mDimension;

    //static members
    public static final int NUM_FLOOR =5;
    private static final Color sColor = Color.GRAY;

    public Building(Dimension dimension) {
        mElevator = new Elevator();
        mFloors = new Floor[NUM_FLOOR];
        mDimension = dimension;
    }


    public Dimension getDimension() {
        return mDimension;
    }

    public void setDimension(Dimension dimension) {
        mDimension = dimension;
    }


    @Override
    public void drawMe(Graphics g) {

        g.setColor(sColor);
        g.fillRect(0,0,(int)mDimension.getWidth(),(int)mDimension.getHeight());

        //use iter as keyboard shortcut
        //draw the floors next
        for (Floor floor : mFloors) {
            floor.drawMe(g);
        }

        mElevator.drawMe(g);

    }
}
