package lec08.glab.danshiff.game.model;

import java.awt.*;
import java.util.ArrayList;

import lec08.glab.danshiff.controller.Game;

/**
 * This is almost unchanged from the initial falcon class. Just drawn differently and has some power-up based private
 * vars and getter and setter methods for them.
 */
public class BugHunter extends Sprite {

	// ==============================================================
	// FIELDS 
	// ==============================================================

    public static final int PLAY_SPACE_ROWS = 7;    //How many rows up the hunter can go.
    public static final int SPEED = 7;

    private int tripleShot;
    private boolean laser;
	
	// ==============================================================
	// CONSTRUCTOR 
	// ==============================================================
	
	public BugHunter() {
		super();

        setRadius(Game.STANDARD_RADIUS);

        setFull(true);

        // left
        ArrayList<Point> pntSides = new ArrayList<>();
        pntSides.add(new Point(7,-7));

        setOrientation(UP);

        assignPolarPoints(symmetricSprite(10, pntSides, -4));

        setCenter(new Point((int)(Game.DIM.getWidth()/2), Game.BOTTOM));
		

	}
	
	
	// ==============================================================
	// METHODS 
	// ==============================================================

	public void move() {
		super.move(LOOPS, STRONGSTICK);

	} //end move

    /**
     * Gets hunter to start moving.
     * @param nDir
     */
    public void move(int nDir){
        switch(nDir){
            case UP:
                setDeltaY(-SPEED);
                break;
            case DOWN:
                setDeltaY(SPEED);
                break;
            case LEFT:
                setDeltaX(-SPEED);
                break;
            case RIGHT:
                setDeltaX(SPEED);
                break;
            default:
                break;
        }
    }

    /**
     * Gets hunter to stop moving.
     * @param nDir
     */
    public void stopMove(int nDir){
        switch(nDir){
            case UP:
                setDeltaY(0);
                break;
            case DOWN:
                setDeltaY(0);
                break;
            case LEFT:
                setDeltaX(0);
                break;
            case RIGHT:
                setDeltaX(0);
                break;
            default:
                break;
        }
    }

	public void draw(Graphics g) {
		drawHunterWithColor(g, Color.WHITE);
	} //end draw()

	public void drawHunterWithColor(Graphics g, Color col) {
		super.draw(g);
		g.setColor(col);
		g.drawPolygon(getXcoords(), getYcoords(), dDegrees.length);
	}

    public int getTripleShot(){
        return tripleShot;
    }

    public void setTripleShot(int tripleShot){
        this.tripleShot = tripleShot;
        //Color is set to purplish elsewhere when it picks up the floater.
        if(this.tripleShot == 0){
            setColor(Color.WHITE);
        }
    }

    public boolean isLaser(){
        return laser;
    }

    public void setLaser(boolean laser){
        this.laser = laser;
        if(this.laser){
            setColor(Color.RED);
        }
        else{
            setColor(Color.WHITE);
        }
    }
} //end class
