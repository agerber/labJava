package lec08.lunarlander.game.model;


/*
This terrain block  will be 50px wide  and from 10-100 px tal

 */

import java.awt.*;

public class TBlock {

    //static members
    private static int sWidth = 50;

    //instance members
    private Point mOrigin;
    private boolean mLanding;


    public TBlock(Point origin,  boolean landing) {
        mOrigin = origin;
        mLanding = landing;

    }

    public Rectangle getBounds(){
        return new Rectangle(mOrigin, new Dimension((int)mOrigin.getY(), sWidth));
    }

    //we're going to need a draw method so that we can draw this block the the graphics context of the double-buffered
    //image
    public void draw(Graphics g){

    }

    public Point getOrigin() {
        return mOrigin;
    }

    public void setOrigin(Point origin) {
        mOrigin = origin;
    }


    public boolean isLanding() {
        return mLanding;
    }

    public void setLanding(boolean landing) {
        mLanding = landing;
    }


}
