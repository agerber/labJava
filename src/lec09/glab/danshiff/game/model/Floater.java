package lec09.glab.danshiff.game.model;

import lec09.glab.danshiff.controller.Game;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: danshiff
 * Date: 12/2/13
 * Time: 12:46 PM
 * To change this template use File | Settings | File Templates.
 */

/**
 * Abstract class for various power-ups. They also move in a drunk walk.
 */
public abstract class Floater extends Sprite{

    public static final int EXPIRE_TIME = 20 * 22; //I want about 20 sec 1000/45 ~22
    public static final int INITIAL_SPEED_RANGE = 7, SPEED_CHANGE = 2, MAX_SPEED = 20;
    public static final int TOP = 500, BOTTOM = 650;

    private int mX, mY;

    /**
     * Constructor requires a color and a starting location.
     * @param color
     * @param x
     * @param y
     */
    public Floater(Color color, int x, int y){
        setRadius(Game.STANDARD_RADIUS);
        setColor(color);
        setFull(true);
        setRadius(Game.STANDARD_RADIUS);
        setOrientation(UP);
        setCenter(new Point(x, y));

        ArrayList<Point> pntSs = new ArrayList<>();
        pntSs.add(new Point(10, 0));
        assignPolarPoints(symmetricSprite(10, pntSs, -10));

        setDeltaX(Game.R.nextInt((INITIAL_SPEED_RANGE * 2) -1) - INITIAL_SPEED_RANGE);
        setDeltaY(Game.R.nextInt((INITIAL_SPEED_RANGE * 2) -1) - INITIAL_SPEED_RANGE);

        setExpire(EXPIRE_TIME);
    }

    /**
     * Moves in a drunk walk. But won't go too high or low. Won't go too fast either
     */
    public void move(){
        super.move(LOOPS, STICKS);
        //Reverse direction if too high or low.
        if(getCenter().y < TOP){
            setDeltaY(Game.R.nextInt(INITIAL_SPEED_RANGE + 1) );
        }
        if(getCenter().y >= BOTTOM){
            setDeltaY(-1 * (Game.R.nextInt(INITIAL_SPEED_RANGE + 1)));
        }

        //Change speed a bit.
        setDeltaX(getDeltaX() + Game.R.nextInt((SPEED_CHANGE * 2) + 1) - SPEED_CHANGE);
        setDeltaY(getDeltaY() + Game.R.nextInt((SPEED_CHANGE * 2) + 1) - SPEED_CHANGE);

        //Don't go too quickly in X-direction.
        if(Math.abs(getDeltaX()) > MAX_SPEED){
            setDeltaX(getDeltaX() * -.5);
        }
    }

    public abstract void performEffect(Game game);  //All floaters do something to the game.

    public void expire(){
        expire(CommandCenter.movFloaters);
    }

}
