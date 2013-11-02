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
    public static final int NUM_FLOOR =5;
    public Dimension mDimension;

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
    public void drawMe(Graphics graphics) {

    }
}
