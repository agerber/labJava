package lec08.timpone.finalproject.game.model;

import java.awt.*;
import java.util.ArrayList;

import lec08.timpone.finalproject.controller.Game;

/**
 *  The Falcon Missile Silo is the object that to the player appears to be the object that is firing counter missiles.  The
 *  Falcon constantly changes its angle to be facing the player's mouse using methods implemented in the Game class.  This class
 *  has the most complicated vector drawing, with over 200 Point objects being used.  Many methods in this class were adapted
 *  from the game base.  
 */
public class Falcon extends Sprite {

	// ==============================================================
	// FIELDS 
	// ==============================================================
	
	private boolean bProtected; 					// whether the Falcon is protected or not
	public static final int FALCON_RADIUS = 55;		// size of the Falcon
	
	
	// ==============================================================
	// CONSTRUCTOR 
	// ==============================================================
	
	public Falcon() {
		super();
		vectorDrawFalcon();			// draws the falcon using cartesian coords - moved to bottom of code due to large size
		
		// spawned at ground level in middle of the screen
		setCenter(new Point(Game.DIM.width / 2, Game.DIM.height-Game.GROUND_LEVEL-20));				

		// sets up the rest of the initial settings
		setColor(Color.white);
		setOrientation(270);
		setRadius(FALCON_RADIUS);
		setProtected(true);
		setFadeValue(0);
	}


	// ==============================================================
	// METHODS 
	// ==============================================================

	// Adjusts the Falcon's color - from the game base
	private int adjustColor(int nCol, int nAdj) {
		if (nCol - nAdj <= 0) {
			return 0;
		} else {
			return nCol - nAdj;
		}
	}

	// Adjusts the falcon's color if necessary
	public void draw(Graphics g) {
		Color colShip;						//does the fading at the beginning
		if (getFadeValue() == 255) {
			colShip = Color.white;
		} else {
			colShip = new Color(adjustColor(getFadeValue(), 200), adjustColor(getFadeValue(), 175), getFadeValue());
		}
		drawShipWithColor(g, colShip);
	}

	// Draws the ship with the specified color
	public void drawShipWithColor(Graphics g, Color col) {
		super.draw(g);
		g.setColor(col);
		g.drawPolygon(getXcoords(), getYcoords(), dDegrees.length);
	}

	// Controls fading if the ship is protected
	public void fadeInOut() {
		if (getProtected()) {
			setFadeValue(getFadeValue() + 3);
		}
		if (getFadeValue() == 255) {
			setProtected(false);
		}
	}
	
	// Sets the protection values
	public void setProtected(boolean bParam) {
		if (bParam) {
			setFadeValue(0);
		}
		bProtected = bParam;
	}

	// Overloaded to allow for additional parameters that control protection values
	public void setProtected(boolean bParam, int n) {
		if (bParam && n % 3 == 0) {
			setFadeValue(n);
		} else if (bParam) {
			setFadeValue(0);
		}
		bProtected = bParam;
	}	

	// Draws the Falcon Missile Silo using cartesian points
	public void vectorDrawFalcon() {
		
		ArrayList<Point> pntCs = new ArrayList<Point>();
		
		// middle missile
		pntCs.add(new Point(-3,3));
		pntCs.add(new Point(-2,3));
		pntCs.add(new Point(-3,3));
		pntCs.add(new Point(-2,11));
		pntCs.add(new Point(-2,3));
		pntCs.add(new Point(-2,11));
		pntCs.add(new Point(-2,15));
		pntCs.add(new Point(-1,17));
		pntCs.add(new Point(0,20));
		pntCs.add(new Point(0,20));
		pntCs.add(new Point(1,17));
		pntCs.add(new Point(2,15));
		pntCs.add(new Point(2,11));
		pntCs.add(new Point(3,3));
		pntCs.add(new Point(2,3));
		pntCs.add(new Point(2,11));
		pntCs.add(new Point(2,3));
		pntCs.add(new Point(2,3));
		pntCs.add(new Point(2,-1));
		pntCs.add(new Point(1,-1));
		pntCs.add(new Point(1,0));
		pntCs.add(new Point(2,0));
		pntCs.add(new Point(1,0));
		pntCs.add(new Point(1,1));
		pntCs.add(new Point(2,1));
		pntCs.add(new Point(1,1));
		pntCs.add(new Point(1,2));
		pntCs.add(new Point(2,2));
		pntCs.add(new Point(-2,2));
		pntCs.add(new Point(-2,-1));
		pntCs.add(new Point(2,-1));
		pntCs.add(new Point(-1,-1));
		pntCs.add(new Point(-1,0));
		pntCs.add(new Point(-2,0));
		pntCs.add(new Point(-1,0));
		pntCs.add(new Point(-1,1));
		pntCs.add(new Point(-2,1));
		pntCs.add(new Point(-1,1));
		pntCs.add(new Point(-1,2));
		pntCs.add(new Point(-1,-4));
		pntCs.add(new Point(1,-4));
		pntCs.add(new Point(1,-3));
		pntCs.add(new Point(0,-3));
		pntCs.add(new Point(0,-4));
		pntCs.add(new Point(0,-3));
		pntCs.add(new Point(-1,-3));
		pntCs.add(new Point(1,-3));
		pntCs.add(new Point(1,-4));
		pntCs.add(new Point(1,-1));
		pntCs.add(new Point(-2,-1));
		pntCs.add(new Point(-2,3));
		pntCs.add(new Point(-3,3));

		// left missile
		pntCs.add(new Point(-4,3));
		pntCs.add(new Point(-5,3));
		pntCs.add(new Point(-5,2));
		pntCs.add(new Point(-6,2));
		pntCs.add(new Point(-6,-1));
		pntCs.add(new Point(-5,-1));
		pntCs.add(new Point(-5,0));
		pntCs.add(new Point(-6,0));
		pntCs.add(new Point(-5,0));
		pntCs.add(new Point(-5,1));
		pntCs.add(new Point(-6,1));
		pntCs.add(new Point(-5,1));
		pntCs.add(new Point(-5,2));
		pntCs.add(new Point(-9,2));
		pntCs.add(new Point(-9,-1));
		pntCs.add(new Point(-8,-1));
		pntCs.add(new Point(-8,0));
		pntCs.add(new Point(-9,0));
		pntCs.add(new Point(-8,0));
		pntCs.add(new Point(-8,1));
		pntCs.add(new Point(-9,1));
		pntCs.add(new Point(-8,1));
		pntCs.add(new Point(-8,2));
		pntCs.add(new Point(-8,-4));
		pntCs.add(new Point(-6,-4));
		pntCs.add(new Point(-6,-3));
		pntCs.add(new Point(-8,-3));
		pntCs.add(new Point(-7,-3));
		pntCs.add(new Point(-7,-4));
		pntCs.add(new Point(-7,-3));
		pntCs.add(new Point(-6,-3));
		pntCs.add(new Point(-6,-1));
		pntCs.add(new Point(-9,-1));
		pntCs.add(new Point(-9,3));
		pntCs.add(new Point(-9,11));
		pntCs.add(new Point(-10,3));
		pntCs.add(new Point(-9,3));
		pntCs.add(new Point(-9,15));
		pntCs.add(new Point(-8,17));
		pntCs.add(new Point(-7,20));
		pntCs.add(new Point(-6,17));
		pntCs.add(new Point(-5,15));
		pntCs.add(new Point(-5,11));
		pntCs.add(new Point(-4,3));
		pntCs.add(new Point(-5,3));
		pntCs.add(new Point(-5,11));
		pntCs.add(new Point(-5,3));
		pntCs.add(new Point(-3,3));
		
		// missile platform
		pntCs.add(new Point(-5,3));
		pntCs.add(new Point(-5,2));
		pntCs.add(new Point(-9,2));
		pntCs.add(new Point(-9,3));
		pntCs.add(new Point(-12,3));
		pntCs.add(new Point(-14,-5));
		pntCs.add(new Point(-13,-7));
		pntCs.add(new Point(13,-7));
		pntCs.add(new Point(-2,-7));
		pntCs.add(new Point(-2,-12));
		pntCs.add(new Point(-2,-7));
		pntCs.add(new Point(-5,-7));
		pntCs.add(new Point(-5,-12));
		pntCs.add(new Point(-5,-8));
		pntCs.add(new Point(-11,-9));
		pntCs.add(new Point(-14,-12));
		pntCs.add(new Point(-14,-14));
		pntCs.add(new Point(-11,-15));
		pntCs.add(new Point(-5,-16));
		pntCs.add(new Point(5,-16));
		pntCs.add(new Point(11,-15));
		pntCs.add(new Point(14,-14));
		pntCs.add(new Point(11,-15));
		pntCs.add(new Point(5,-16));
		pntCs.add(new Point(-5,-16));
		pntCs.add(new Point(-11,-15));
		pntCs.add(new Point(-14,-14));
		pntCs.add(new Point(-14,-16));
		pntCs.add(new Point(-11,-17));
		pntCs.add(new Point(-5,-20));
		pntCs.add(new Point(5,-20));
		pntCs.add(new Point(11,-17));
		pntCs.add(new Point(14,-16));
		pntCs.add(new Point(14,-14));
		pntCs.add(new Point(14,-12));
		pntCs.add(new Point(11,-9));
		pntCs.add(new Point(5,-8));
		pntCs.add(new Point(5,-12));
		pntCs.add(new Point(5,-7));
		pntCs.add(new Point(2,-7));
		pntCs.add(new Point(2,-12));
		pntCs.add(new Point(2,-8));
		pntCs.add(new Point(-2,-8));
		pntCs.add(new Point(-2,-7));
		pntCs.add(new Point(-13,-7));
		pntCs.add(new Point(13,-7));
		pntCs.add(new Point(14,-5));
		pntCs.add(new Point(-14,-5));
		pntCs.add(new Point(14,-5));
		pntCs.add(new Point(12,3));
		
		// right missile
		pntCs.add(new Point(10,3));
		pntCs.add(new Point(9,3));
		pntCs.add(new Point(9,11));
		pntCs.add(new Point(10,3));
		pntCs.add(new Point(9,3));
		pntCs.add(new Point(9,2));
		pntCs.add(new Point(9,-1));
		pntCs.add(new Point(8,-1));
		pntCs.add(new Point(8,2));
		pntCs.add(new Point(9,2));
		pntCs.add(new Point(9,1));
		pntCs.add(new Point(8,1));
		pntCs.add(new Point(9,1));
		pntCs.add(new Point(9,0));
		pntCs.add(new Point(8,0));
		pntCs.add(new Point(9,0));
		pntCs.add(new Point(9,-1));
		pntCs.add(new Point(5,-1));
		pntCs.add(new Point(8,-1));
		pntCs.add(new Point(8,-4));
		pntCs.add(new Point(6,-4));
		pntCs.add(new Point(6,-3));
		pntCs.add(new Point(8,-3));
		pntCs.add(new Point(7,-3));
		pntCs.add(new Point(7,-4));
		pntCs.add(new Point(7,-3));
		pntCs.add(new Point(6,-3));
		pntCs.add(new Point(6,-1));
		pntCs.add(new Point(5,-1));
		pntCs.add(new Point(5,2));
		pntCs.add(new Point(6,2));
		pntCs.add(new Point(6,-1));
		pntCs.add(new Point(6,0));
		pntCs.add(new Point(5,0));
		pntCs.add(new Point(6,0));
		pntCs.add(new Point(6,1));
		pntCs.add(new Point(5,1));
		pntCs.add(new Point(6,1));
		pntCs.add(new Point(6,2));
		pntCs.add(new Point(5,2));
		pntCs.add(new Point(5,3));
		pntCs.add(new Point(4,3));
		pntCs.add(new Point(5,11));
		pntCs.add(new Point(5,2));
		pntCs.add(new Point(5,15));
		pntCs.add(new Point(6,17));
		pntCs.add(new Point(7,20));
		pntCs.add(new Point(8,17));
		pntCs.add(new Point(9,15));
		pntCs.add(new Point(9,2));
		pntCs.add(new Point(5,2));
		pntCs.add(new Point(5,3));
		pntCs.add(new Point(3,3));
		pntCs.add(new Point(2,11));
		pntCs.add(new Point(2,15));
		pntCs.add(new Point(1,17));
		pntCs.add(new Point(0,20));
		pntCs.add(new Point(-1,17));
		pntCs.add(new Point(-2,15));
		pntCs.add(new Point(-2,11));
		pntCs.add(new Point(-3,3));
		
		assignPolarPoints(pntCs);
	}


	// ==============================================================
	// GETTERS & SETTERS 
	// ==============================================================
	
	public boolean getProtected() {return bProtected;}

}
