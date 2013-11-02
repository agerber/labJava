package lec06.glab.elevator;

import lec09.glab.structs.Queue;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: ag
 * Date: 11/2/13
 * Time: 3:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class Floor implements  Drawable {

    //a floor stores a zero-based integer determinng which store it is
    private int mLevel; //0-4
    private LinkedList<Rider> mWorkingRiders;
    private LinkedList<Rider> mWaitingRiders;
    private Dimension mDimension;

    public Floor(Dimension dimension, int level) {
        mDimension = dimension;
        mLevel = level;
        mWorkingRiders = new LinkedList<>();
        mWaitingRiders = new LinkedList<>();
    }

    public Dimension getDimension() {
        return mDimension;
    }

    public void setDimension(Dimension dimension) {
        mDimension = dimension;
    }

    public Floor(int level) {
        mLevel = level;
    }

    public int getLevel() {
        return mLevel;
    }

    public void setLevel(int level) {
        mLevel = level;
    }


    @Override
    public void drawMe(Graphics graphics) {

    }
}
