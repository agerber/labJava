package lec08.lunarlander.game.model;


/*
This terrain block  will be 50px wide  and from 10-100 px tal

 */

public class TBlock {
    private int mWidth;
    private int mHeight;
    private boolean mLanding;


    //constructor
    public TBlock(int height, boolean landing, int width) {
        mHeight = height;
        mLanding = landing;
        mWidth = width;
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
