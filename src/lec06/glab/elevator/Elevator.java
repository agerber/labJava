package lec06.glab.elevator;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: ag
 * Date: 11/2/13
 * Time: 3:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class Elevator implements Drawable {

    private LinkedList<Rider> mRiders;
    private int mFloor;

    public Elevator() {
        mRiders = new LinkedList<>();
        mFloor = 0; //optional - zero is the default value anyway, even if I hadn't assigned it

    }


    @Override
    public void drawMe(Graphics graphics) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}