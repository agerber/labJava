package lec08.lunarlander.game.model;


/*
This terrain block  will be 50px wide  and from 10-100 px tal

 */



import java.awt.*;

public class TerrainBlock extends Rectangle implements  Movable{

    //static members
    public static int WIDTH = 50;

    //instance members
    private boolean mLanding;


    public TerrainBlock(int nX, int nY, int nW, int nH, boolean landing) {
        super(nX,nY,nW,nH);
        mLanding = landing;

    }



    //we're going to need a draw method so that we can draw this block the the graphics context of the double-buffered
    //image
    @Override
    public void draw(Graphics g){
        if (isLanding()){
            g.setColor(Color.CYAN);
        } else {
            g.setColor(Color.RED);
        }
        g.fillRect(x, y, width, height);
    }

    @Override
    public void move() {
        //To change body of implemented methods use File | Settings | File Templates.
    }


    @Override
    public int points() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Point getCenter() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getRadius() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void expire() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void fadeInOut() {
        //To change body of implemented methods use File | Settings | File Templates.
    }



    public boolean isLanding() {
        return mLanding;
    }

    public void setLanding(boolean landing) {
        mLanding = landing;
    }


}
