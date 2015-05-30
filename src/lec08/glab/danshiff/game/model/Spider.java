package lec08.glab.danshiff.game.model;

import lec08.glab.danshiff.controller.Game;
import lec08.glab.danshiff.sounds.Sound;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: danshiff
 * Date: 11/21/13
 * Time: 6:17 PM
 * To change this template use File | Settings | File Templates.
 */

/**
 * Spiders scuttle around in and near your playing area. They eat mushrooms.
 */
public class Spider extends Foe{

    public static final int SPIDER_SCORE = 50;
    public static final int RADIUS = 15;
    public static final int EATS_SHROOM_CHANCE = 4;
    public static final int TOP = 400, BOTTOM = 665;

    public Spider(boolean leftSide, int row){   //First param is whether it enters on left (or right). This affects
                                                //starting center, and initial x-speed's sign.
        setRadius(RADIUS);
        setColor(new Color(154, 59, 15));
        setFull(true);
        setValue(SPIDER_SCORE);
        setOrientation(UP);

        ArrayList<Point> pntSs = new ArrayList<>();
        pntSs.add(new Point(1,12));
        pntSs.add(new Point(2,11));
        pntSs.add(new Point(2,9));
        pntSs.add(new Point(1,8));
        pntSs.add(new Point(3,7));
        pntSs.add(new Point(4,7));
        pntSs.add(new Point(6,8));
        pntSs.add(new Point(7, 9));
        pntSs.add(new Point(8,11));
        pntSs.add(new Point(10,14));
        pntSs.add(new Point(9,11));
        pntSs.add(new Point(5,6));
        pntSs.add(new Point(6,4));
        pntSs.add(new Point(11,6));
        pntSs.add(new Point(13,10));
        pntSs.add(new Point(13,4));
        pntSs.add(new Point(6,1));
        pntSs.add(new Point(7,-2));
        pntSs.add(new Point(11,-3));
        pntSs.add(new Point(13,-4));
        pntSs.add(new Point(15,-7));
        pntSs.add(new Point(15,-12));
        pntSs.add(new Point(13,-6));
        pntSs.add(new Point(7,-3));
        pntSs.add(new Point(5,-7));
        pntSs.add(new Point(8,-8));
        pntSs.add(new Point(11,-10));
        pntSs.add(new Point(12,-12));
        pntSs.add(new Point(12,-14));
        pntSs.add(new Point(8,-10));
        pntSs.add(new Point(4,-8));
        pntSs.add(new Point(1,-10));
        assignPolarPoints(symmetricSprite(12, pntSs, -10));

        //Horizontal speed is between 4 and 8
        int xSpeed = Game.R.nextInt(5)+4;
        if(leftSide){
            setDeltaX(xSpeed);
        }
        else{
            setDeltaX(-1 * xSpeed);
        }

        //Vertical speed is between 0 and 3.
        setDeltaY(Game.R.nextInt(7)-3);

        setCenter(new Point(leftSide ? 1 : (int)Game.DIM.getWidth()-1, row));

        Sound.playSound("spider.wav");
    }

    public void interactWithMushroom(Mushroom musEat){

        if(Game.R.nextInt(EATS_SHROOM_CHANCE)==0){
            CommandCenter.removeMushroom(musEat);
        }
    }

    public boolean kill(){
        return true;
    }

    public void move(){
        super.move(LEAVES, STICKS); //When they leave, they're gone.
        //After moving, their speed randomly adjusts by a bit so they drunk walk.
        setDeltaX(getDeltaX() -2 + Game.R.nextInt(5));
        setDeltaY(getDeltaY() -1 + Game.R.nextInt(3));
        //If they get too high or low, correct them w/ a hard change of the vertical speed.
        if(getCenter().y < TOP){
            setDeltaY(3);
        }
        if(getCenter().y > BOTTOM){
            setDeltaY(-5);
        }
    }
}
