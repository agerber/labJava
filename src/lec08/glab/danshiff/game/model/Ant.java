package lec08.glab.danshiff.game.model;

import lec08.glab.danshiff.controller.Game;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: danshiff
 * Date: 11/21/13
 * Time: 12:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class Ant extends Foe{

    public static final int LOWEST_SPEED = 10;
    public static final int TOP = 530;  //Where bug won't go above after going below.

    private static double sSpeed = LOWEST_SPEED;

    private boolean bGoingUp;   //Is the ant going up.
    private int nCode = STICKS; //Initially, the ant's y movement is sticks. This changes to strong sticks if it reaches
                                //the bottom.
    private boolean bPoisoned;

    public Ant(){
        super();
        setRadius(Game.STANDARD_RADIUS);
        setFull(true);

        ArrayList<Point> pntSs = new ArrayList<>();
        pntSs.add(new Point(2, 9));
        pntSs.add(new Point(4, 10));
        pntSs.add(new Point(3, 8));
        pntSs.add(new Point(4, 6));
        pntSs.add(new Point(7, 7));
        pntSs.add(new Point(5, 5));
        pntSs.add(new Point(5, 2));
        pntSs.add(new Point(8, 3));
        pntSs.add(new Point(5, 1));
        pntSs.add(new Point(5, -1));
        pntSs.add(new Point(8, 1));
        pntSs.add(new Point(5, -2));
        pntSs.add(new Point(5, -3));
        pntSs.add(new Point(4, -6));
        pntSs.add(new Point(3, -8));
        pntSs.add(new Point(2, -9));



        assignPolarPoints(symmetricSprite(10, pntSs, -10));

        setValue((int)(Ant.getSpeed()));


        setColor(Color.ORANGE);

        setDeltaX(sSpeed);
        setValue((int)sSpeed);


    }

    /**
     * Method for getting ant to turn.
     */
    public void turn(){
        setDeltaX(-1 * getDeltaX());
        //If the bug reaches the bottom:
        if(getCenter().y == Game.BOTTOM){
            bGoingUp = true;    //It starts going up
            bPoisoned = false;  //Isn't poisoned
            setDeltaX(getDeltaX() + (.25 * (getDeltaX() > 0 ? 1 : -1)));    //Goes a bit faster
            nCode = STRONGSTICK;    //Won't go arbitrarily high
        }
        if(getCenter().y == TOP){
            bGoingUp = false;   //So that it doesn't have weird behavior at top of player-zone
        }

        //Go up or down a row on the turn.
        if(bGoingUp){
            setCenter(new Point(getCenter().x, getCenter().y - (2 * Game.STANDARD_RADIUS)));
        }
        else{
            setCenter(new Point(getCenter().x, getCenter().y + (2 * Game.STANDARD_RADIUS)));
        }
        setOrientation((getOrientation() + 180) % 360);
    }

    public static void setSpeed(double speed){
        sSpeed = speed;
    }

    public static double getSpeed(){
        return sSpeed;
    }

    /**
     * Moves normally if not poisoned. Charges if poisoned.
     */
    public void move(){
        if(!bPoisoned){
            move(STICKS, nCode);
        }
        else{
            super.move(STICKS, nCode);
            turn();
        }
    }

    /**
     * Gets poisoned by poison mushrooms. Turns at all other mushrooms and loses poison at them too.
     * @param mus
     */
    public void interactWithMushroom(Mushroom mus){
        if(mus.isPoisonous()){
            setbPoisoned(true);
            setbGoingUp(false);
            return;
        }
        setbPoisoned(false);
        if(this.getCenter().x < mus.getCenter().x){
            this.setCenter(
                    new Point(mus.getCenter().x - 2 - (2 * Game.STANDARD_RADIUS), mus.getCenter().y));
        }
        else{
            this.setCenter(
                    new Point(mus.getCenter().x + 2 + (2 * Game.STANDARD_RADIUS), mus.getCenter().y));
        }
        this.turn();
    }

    /**
     * When killed, they turn into mushrooms if there's space.
     * @return
     */
    public boolean kill(){
        Point pntDied = this.getCenter();
        Point pntShroom = new Point(1, 1);
        pntShroom.setLocation((pntDied.x/(2*Game.STANDARD_RADIUS))*(2*Game.STANDARD_RADIUS) + Game.STANDARD_RADIUS, pntDied.y);
        CommandCenter.addMushroom(new Mushroom(pntShroom));


        return true;
    }

    public boolean isbPoisoned(){
        return bPoisoned;
    }

    public void setbPoisoned(boolean bPoisoned){
        this.bPoisoned = bPoisoned;
    }

    public boolean isbGoingUp(){
        return bGoingUp;
    }

    public void setbGoingUp(boolean bGoingUp){
        this.bGoingUp = bGoingUp;
    }
}
