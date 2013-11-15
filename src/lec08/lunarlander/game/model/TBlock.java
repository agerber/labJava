package lec08.lunarlander.game.model;


/*
This terrain block  will be 50px wide  and from 10-100 px tal

 */

import java.awt.*;

public class TBlock {
    private int mWidth;
    private int mHeight;
    private Point pntOrigin;
    private boolean mLanding;





    //we're going to need a draw method so that we can draw this block the the graphics context of the double-buffered
    //image
    public void draw(Graphics g){

    }



    //getters and setters
    public int getHeight() {
        return mHeight;
    }

    public void setHeight(int height) {
        mHeight = height;
    }

    public boolean isLanding() {
        return mLanding;
    }

    public void setLanding(boolean landing) {
        mLanding = landing;
    }

    public int getWidth() {
        return mWidth;
    }

    public void setWidth(int width) {
        mWidth = width;
    }
}
