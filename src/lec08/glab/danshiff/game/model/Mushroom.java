package lec08.glab.danshiff.game.model;

import lec08.glab.danshiff.controller.Game;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: danshiff
 * Date: 11/20/13
 * Time: 2:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class Mushroom extends Sprite{

    //Colors for shrooms in various states of destruction, poison.
    public static final Color FULL = new Color(95, 187, 179),
        QUARTER = new Color(50, 163, 255),
        HALF = new Color(4, 9, 255),
        THREEQ = new Color(31, 18, 155),
        POISON_Q = new Color(0, 241, 21),
        POISON_F = new Color(213, 255, 26),
        POISON_H = new Color(43, 169, 6),
        POISON_T = new Color(34, 105, 6);

    private boolean mPoisonous;
    private int mHits;  //Mushroom takes four hits to destroy

    public Mushroom(Point pntLocation){
        super();
        setRadius(Game.STANDARD_RADIUS);
        setCenter(pntLocation);
        mHits = 0;
        mPoisonous = false;
        setFull(true);
        setColor(FULL);
        setOrientation(UP);
        drawMushroom();
    }

    /**
     * Overload to make mushroom w/ location coordinates instead of the point.
     * @param nX
     * @param nY
     */
    public Mushroom(int nX, int nY){
        this(new Point(nX, nY));
    }

    /**
     * Overload to make a shroom w/ one more hit spawn from a shroom.
     * @param musHit
     */
    public Mushroom(Mushroom musHit){
        this(musHit.getCenter());
        mHits = musHit.getHits() + 1;
        switch(mHits){
            case(1):
                setColor(QUARTER);
                break;
            case(2):
                setColor(HALF);
                break;
            case(3):
                setColor(THREEQ);
                break;
            default:
                break;
        }
        setPoisonous(musHit.isPoisonous());
    }

    public void drawMushroom(){
        ArrayList<Point> pntSides = new ArrayList<>();
        int bottom = -10;

        pntSides.add(new Point(3,9));
        pntSides.add(new Point(6,8));
        pntSides.add(new Point(8,6));
        pntSides.add(new Point(9,3));
        pntSides.add(new Point(8,2));
        pntSides.add(new Point(7,2));
        pntSides.add(new Point(5,4));
        pntSides.add(new Point(3,5));

        pntSides.add(new Point(3,bottom+2 ));
        pntSides.add(new Point(2,bottom+1 ));







        assignPolarPoints(symmetricSprite(9, pntSides, bottom));
    }

    public int getHits(){
        return mHits;
    }

    public void setHits(int hits){
        mHits = hits;
    }

    public boolean isPoisonous(){
        return mPoisonous;
    }

    public void setPoisonous(boolean poisonous){
        mPoisonous = poisonous;
        if(mPoisonous){
            switch(mHits){
                case 0:
                    setColor(POISON_F);
                    break;
                case 1:
                    setColor(POISON_Q);
                    break;
                case 2:
                    setColor(POISON_H);
                    break;
                case 3:
                    setColor(POISON_T);
                    break;
            }
        }
    }
}
