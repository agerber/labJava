package edu.uchicago.gerber.labjava.lec07.glab.elevator;


import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: ag
 * Date: 11/2/13
 * Time: 2:51 PM
 * To change this template use File | Settings | File Templates.
 */

public class Rider implements Drawable {



    //Rider can be waiting, riding, or indisposed  (must we make this static?)
    public static enum State {RIDING, WAITING, IN_BUILDING, AWAY}
    private State mState;
    private int mFloor; //0-4
    private Dimension mDimension;
    private Point mPoint;




    //a rider must come into existence outside the building (unless is were a hospital with a maternity ward)
    public Rider(Dimension dimension) {
        mState = State.AWAY;
        mFloor = 0;
        mDimension = dimension;
    }

    public Point getPoint() {
        return mPoint;
    }

    public void setPoint(Point point) {
        mPoint = point;
    }

    @Override
    public void drawMe(Graphics g) {


    }

    public Dimension getDimension() {
        return mDimension;
    }

    public void setDimension(Dimension dimension) {
        mDimension = dimension;
    }

    public State getState() {
        return mState;
    }

    public void setState(State state) {
        mState = state;
    }

    public int getFloor() {
        return mFloor;
    }

    public void setFloor(int floor) {
        mFloor = floor;
    }
}
