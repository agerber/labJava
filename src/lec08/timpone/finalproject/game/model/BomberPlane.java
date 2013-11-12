package lec08.timpone.finalproject.game.model;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import lec08.timpone.finalproject.controller.Game;
import lec08.timpone.finalproject.sounds.Sound;

/**
 *  A BomberPlane is an enemy object that appears that the beginning of a new level.  It moves left-to-right or right-to-left 
 *  across the screen and drops three bombs at randomly determined x-coordinates.  The direction (left or right) that the plane
 *  moves is randomly determined in the Game class.
 */
public class BomberPlane extends Sprite {

	// ==============================================================
	// FIELDS 
	// ==============================================================
	
	private Random R;
	public Point pntStartPosition;						// the point where the BomberPlane is spawned
	
	private int nTarget1;								// the three x-coordinates where the plane will drop a bomb
	private int nTarget2;
	private int nTarget3;
	
	public static final int BomberPlane_RADIUS = 40;	// size of plane
	
	
	// ==============================================================
	// CONSTRUCTOR 
	// ==============================================================
	
	public BomberPlane(String strStartingSide) {
		
		super();
		
		R = new Random();
		
		setDeltaY(0);											// the plane's delta-y remains constant
		
		ArrayList<Point> pntCs = new ArrayList<Point>();		// defined the points on a cartesean grid
		
		if(strStartingSide.equals("left")){						// settings for a plane that enters from the left side of the screen
			pntStartPosition = new Point(0,R.nextInt(175)+25);
			setDeltaX(5);
			
			pntCs.add(new Point(10,2));
			pntCs.add(new Point(13,9));
			pntCs.add(new Point(15,9));
			pntCs.add(new Point(14,2));
			pntCs.add(new Point(16,2));
			pntCs.add(new Point(16,0));
			pntCs.add(new Point(7,-2));
			pntCs.add(new Point(-4,-2));
			pntCs.add(new Point(-16,-1));
			pntCs.add(new Point(-16,0));
			pntCs.add(new Point(-14,2));

			assignPolarPoints(pntCs);
		}
		else{													// settings for a plane that enters from the right side of the screen
			pntStartPosition = new Point((int) Game.DIM.getWidth(),R.nextInt(175)+25);
			setDeltaX(-5);

			pntCs.add(new Point(-10,2));
			pntCs.add(new Point(-13,9));
			pntCs.add(new Point(-15,9));
			pntCs.add(new Point(-14,2));
			pntCs.add(new Point(-16,2));
			pntCs.add(new Point(-16,0));
			pntCs.add(new Point(-7,-2));
			pntCs.add(new Point(4,-2));
			pntCs.add(new Point(16,-1));
			pntCs.add(new Point(16,0));
			pntCs.add(new Point(14,2));

			assignPolarPoints(pntCs);
		}
		
		setRadius(BomberPlane_RADIUS);					// rest of the plane's settings
		setCenter(pntStartPosition);
		setOrientation(270);
		setColor(Color.WHITE);
		
		int nInt = (int)Game.DIM.getWidth()/5;			// randomly determining the plane's targets
		nTarget1 = R.nextInt(nInt)*5;					// divided and multiplied by 5 to normalize the integers a little bit
		nTarget2 = R.nextInt(nInt)*5;					// without the normalizing, the bomb drops were unreliable
		nTarget3 = R.nextInt(nInt)*5;
		
		Sound.playSound("Transmission.wav");			// sound that plays when a new plane is spawned
	}

	
	// ==============================================================
	// METHODS 
	// ==============================================================

	// Plays a "bomb dropped" sound and adds a new bomb to the movFoes array list in the command center
	public void dropBomb(){
		Sound.playSound("LA_Link_Bounce.wav");
		CommandCenter.movFoes.add(new Bomb(getCenter()));
	}

	// 
	@Override
	public void move(){
		
		super.move();
		int nCurrX = (int)getCenter().getX();									// gets the plane's current x-coord
		
		if(nCurrX  == nTarget1 || nCurrX == nTarget2 || nCurrX == nTarget3){	// if the plane is at a target, it drops a bomb
			dropBomb();
		}

		if(getCenter().getX() - pntStartPosition.getX() > Game.DIM.getWidth()){	
			CommandCenter.movFoes.remove(this);					// removes the plane from the screen when it reaches the other side
		}
	}
}
