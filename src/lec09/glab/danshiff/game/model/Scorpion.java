package lec09.glab.danshiff.game.model;

import lec09.glab.danshiff.controller.Game;
import lec09.glab.danshiff.sounds.Sound;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: danshiff
 * Date: 11/21/13
 * Time: 8:30 PM
 * To change this template use File | Settings | File Templates.
 */

/**
 * Scorpions walk slowly and in a straight line. They are unlikely to touch you. But they do poison every mushroom they
 * tocuh.
 */
public class Scorpion extends Foe{

    public static final int SCORP_SCORE = 75;
    public static final int SCORP_SPEED = 4;

    public Scorpion(boolean left, int row){ //First param is whether it enters on the left side.
                                            //Orientation, initial position (obviously), and sign of speed (but not
                                            //absolute value) affected by this.
        setRadius(Game.STANDARD_RADIUS);
        setColor(Color.RED);
        setFull(true);
        setValue(SCORP_SCORE);
        setOrientation(RIGHT + (left ? 0 : 180));

        ArrayList<Point> pntCs = new ArrayList<>();

        pntCs.add(new Point(0,7));
        pntCs.add(new Point(1,7));
        pntCs.add(new Point(2,6));
        pntCs.add(new Point(3,4));
        pntCs.add(new Point(6,6));
        pntCs.add(new Point(9,4));
        pntCs.add(new Point(6,7));
        pntCs.add(new Point(8,8));
        pntCs.add(new Point(7,6));
        pntCs.add(new Point(5,4));
        pntCs.add(new Point(4,2));
        pntCs.add(new Point(4,1));
        pntCs.add(new Point(6,1));
        pntCs.add(new Point(4,0));
        pntCs.add(new Point(4,-2));
        pntCs.add(new Point(6,-3));
        pntCs.add(new Point(4,-3));
        pntCs.add(new Point(3,-5));
        pntCs.add(new Point(6,-6));
        pntCs.add(new Point(3,-6));
        pntCs.add(new Point(2,-7));
        pntCs.add(new Point(3,-7));
        pntCs.add(new Point(6,-8));
        pntCs.add(new Point(7,-6));
        pntCs.add(new Point(6,-5));
        pntCs.add(new Point(7,-3));
        pntCs.add(new Point(5,-1));
        pntCs.add(new Point(8,-2));
        pntCs.add(new Point(9,-5));
        pntCs.add(new Point(8,-8));
        pntCs.add(new Point(5,-9));
        pntCs.add(new Point(0,-8));
        pntCs.add(new Point(-2,-6));
        pntCs.add(new Point(-3,-5));
        pntCs.add(new Point(-7,-4));
        pntCs.add(new Point(-4,-3));
        pntCs.add(new Point(-4,-2));
        pntCs.add(new Point(-7,-1));
        pntCs.add(new Point(-4,-1));
        pntCs.add(new Point(-4,1));
        pntCs.add(new Point(-7,2));
        pntCs.add(new Point(-4,2));
        pntCs.add(new Point(-3,3));
        pntCs.add(new Point(-5,4));
        pntCs.add(new Point(-6,4));
        pntCs.add(new Point(-8,9));
        pntCs.add(new Point(-6,6));
        pntCs.add(new Point(-4,8));
        pntCs.add(new Point(-5,5));
        pntCs.add(new Point(-3,4));
        pntCs.add(new Point(-1,7));

        assignPolarPoints(pntCs);

        setCenter(new Point(left ? 1 : (int)Game.DIM.getWidth() , row * (Game.STANDARD_RADIUS * 2) + Game.STANDARD_RADIUS));

        setDeltaX(SCORP_SPEED * (left ? 1 : -1));

        Sound.playSound("scorpion.wav");

    }

    /**
     * Make the shroom poisonous.
     * @param mus
     */
    public void interactWithMushroom(Mushroom mus){
        mus.setPoisonous(true);
    }

    /**
     * Die without fanfare
     * @return
     */
    public boolean kill(){
        return true;
    }
}
