package lec06.glab.elevator;

import lec09.glab.structs.Queue;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: ag
 * Date: 11/2/13
 * Time: 3:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class Floor {

    //a floor stores a zero-based integer determinng which store it is
    private int mLevel; //0-4
    private LinkedList<Rider> mWorkingRiders;
    private LinkedList<Rider> mWaitingRiders;

    public Floor(int level) {
        mLevel = level;
    }

    public int getLevel() {
        return mLevel;
    }

    public void setLevel(int level) {
        mLevel = level;
    }


}
