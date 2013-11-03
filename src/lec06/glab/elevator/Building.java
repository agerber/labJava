package lec06.glab.elevator;

import java.awt.*;
import java.util.LinkedList;

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
    private Dimension mDimension;
    private LinkedList<Rider> mRequestors;

    //static members
    public static final int NUM_FLOOR =5;
    public static final Color COLOR = Color.GRAY;

    public Building(Dimension dimension) {
        //an elevator has 1/3 -10 pixels the width and 1/num_floors height - 10

        mRequestors = new LinkedList<>();
        mElevator = new Elevator(new Dimension((int)(dimension.getWidth()/3 -10),(int)(dimension.getHeight()/NUM_FLOOR -10)));
        mDimension = dimension;
        mFloors = new Floor[NUM_FLOOR];

        for (int nC = 0; nC <mFloors.length; nC++) {
            mFloors[nC].setDimension(new Dimension((int)dimension.getWidth(), (int)(dimension.getHeight() / NUM_FLOOR)));
            mFloors[nC].setLevel(nC);
        }
    }

    public void requestFloor(Rider rider){

        mRequestors.addLast(rider);
    }


    public Dimension getDimension() {
        return mDimension;
    }

    public void setDimension(Dimension dimension) {
        mDimension = dimension;
    }


    @Override
    public void drawMe(Graphics g) {

        g.setColor(COLOR);
        g.fillRect(0,0,(int)mDimension.getWidth(),(int)mDimension.getHeight());

        //use iter as keyboard shortcut
        //draw the floors next
        for (Floor floor : mFloors) {
            floor.drawMe(g);
        }

        mElevator.drawMe(g);

    }
}
