package lec09.glab.danshiff.game.model;

import lec09.glab.danshiff.controller.Game;
import lec09.glab.danshiff.sounds.Sound;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: danshiff
 * Date: 11/21/13
 * Time: 4:56 PM
 * To change this template use File | Settings | File Templates.
 */

/**
 * Flies drop from the top and take two hits to kill. They also leave mushrooms in their wake.
 */
public class Fly extends Foe{

    public static final int FLY_HITS = 2;
    public static final int FLY_SCORE = 75;
    public static final int SPEED_RANGE = 10, MIN_SPEED = 15;

    private int mHits;

    public Fly(){
        setRadius(Game.STANDARD_RADIUS);
        setValue(FLY_SCORE);
        setOrientation(UP);
        setDeltaY(Game.R.nextInt(1 + SPEED_RANGE) + MIN_SPEED);
        setColor(Color.LIGHT_GRAY);
        setCenter(new Point(Game.R.nextInt((int)Game.DIM.getWidth()), 3 * Game.STANDARD_RADIUS));

        ArrayList<Point> pntSs = new ArrayList<>();
        pntSs.add(new Point(1, 9));
        pntSs.add(new Point(2, 8));
        pntSs.add(new Point(4, 6));
        pntSs.add(new Point(7, 7));
        pntSs.add(new Point(8, 7));
        pntSs.add(new Point(10, 6));
        pntSs.add(new Point(10, 5));
        pntSs.add(new Point(9, 4));
        pntSs.add(new Point(7, 3));
        pntSs.add(new Point(5, 3));
        pntSs.add(new Point(5, 3));
        pntSs.add(new Point(5, 1));
        pntSs.add(new Point(4, -1));
        pntSs.add(new Point(3, -2));
        pntSs.add(new Point(2, -3));
        assignPolarPoints(symmetricSprite(9, pntSs, -3));

        Sound.playSound("fly.wav");
    }

    public int getHits(){
        return mHits;
    }

    public void setHits(int hits){
        mHits = hits;
    }

    public void move(){
        super.move(LOOPS, LEAVES);
        //The higher your level, the more shrooms you should have. This makes the fly's drop chance depend on
        //the level and how many there already are.
        if(Game.R.nextInt(CommandCenter.getLevel() * Game.ROW) > (2 * CommandCenter.movFungus.size())){
            dropMushroom();
        }
    }

    public void dropMushroom(){
        //Makes sure the mushroom snaps to the underlying grid regardless of the fly's position.
        int nX = ((getCenter().x/(2*Game.STANDARD_RADIUS)) * 2 * Game.STANDARD_RADIUS) + Game.STANDARD_RADIUS;
        int nY = ((getCenter().y/(2*Game.STANDARD_RADIUS)) * 2 * Game.STANDARD_RADIUS) + Game.STANDARD_RADIUS;
        if(nY != Game.BOTTOM){
            CommandCenter.addMushroom(new Mushroom(nX, nY));
        }
    }

    public void interactWithMushroom(Mushroom mus){
        //Do nothing
    }

    /**
     * Increases the hit count. Returns true if hit count is at limit.
     * @return
     */
    public boolean kill(){
        this.setHits(this.getHits() + 1);
        return this.getHits() == FLY_HITS;

    }
}
