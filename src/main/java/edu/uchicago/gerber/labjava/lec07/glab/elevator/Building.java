package edu.uchicago.gerber.labjava.lec07.glab.elevator;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: ag
 * Date: 11/2/13
 * Time: 3:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class Building   {
    //a building has an array of floors and an elevator
    private Elevator mElevator;
   // private Floor[] mFloors;
    private Dimension mDimension;
    private int mCurrentFloor;
    private LinkedList<Rider> mWorkingRiders;
    private LinkedList<Rider> mWaitingRiders;
    private Graphics mGraphics;





    //static members
    public static final int NUM_FLOOR =5;
    public static final Color COLOR = Color.GRAY;



    public Building() {
        //an elevator has 1/3 -10 pixels the width and 1/num_floors height - 10
        mWorkingRiders = new LinkedList<>();
        mWaitingRiders = new LinkedList<>();

       // mElevator = new Elevator();



    }

    public void requestFloor(Rider rider){


    }

    public int getCurrentFloor() {
        return mCurrentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        mCurrentFloor = currentFloor;
    }

    public Dimension getDimension() {
        return mDimension;
    }

    public void setDimension(Dimension dimension) {
        mDimension = dimension;
    }


}
