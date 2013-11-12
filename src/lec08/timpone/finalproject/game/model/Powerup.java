package lec08.timpone.finalproject.game.model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import lec08.timpone.finalproject.controller.Game;
import lec08.timpone.finalproject.sounds.Sound;

/**
 *  The powerup class controls several settings for the various powerups that appear in the game.  A player picks up a powerup
 *  by shooting it with a counter missile.  After the powerup is picked up, the player temporarily gains a special ability.  
 *  Several key settings can be changed by altering the constants in the fields section.   
 */
public class Powerup extends Sprite {

	// ==============================================================
	// FIELDS 
	// ==============================================================
	
	private int nSpin;											// the spin modifier of the powerup
	private String strPower;									// a String describing the ability granted by the powerup
	private String strLetter;									// a letter that is displayed on the powerup image in game
	private Color colColor;										// color of the powerup when displayed in game
	
	public static final int POWERUP_SIZE = 20;					// size of the powerup object
	public static final int POWERUP_EXPIRE = 75;				// modifies the length of time before the powerup disappears
	public final static int POWERUP_FREQUENCY = 300;			// modifies how often powerups appear in game
	
	public static final int TURRET_AMMO = 20;					// number of turret shots before Turrets ability deactivates
	public static final int SPREAD_AMMO = 10;					// number of spread gun shots before Spread Gun ability deactivates
	public static final int FLAME_AMMO = 150;					// number of flame gun shots before Flame Gun ability deactivates
	
	// How often turret missiles fire when the Turrets ability is active (lower number = turrets fire faster)
	public final static int TURRET_FIRE_FREQUENCY = 20;			 

	
	// ==============================================================
	// CONSTRUCTOR 
	// ==============================================================
	
	/**
	 * Sets up the initial settings; most of this code was inspired by the NewShipFloater from the game base
	 * - strPower describes which ability the powerup grants (CityTurrets, SpreadGun, SuperNuke, FlameCloud)
	 * - strLetter determines which letter is displayed on the powerup image
	 * - col determines which color the powerup image is
	 */
	public Powerup(String strPower, String strLetter, Color col) {

		super();

		this.strPower = strPower;
		this.strLetter = strLetter;
		this.colColor = col;

		setExpire(POWERUP_EXPIRE);
		setRadius(POWERUP_SIZE);

		int nX = Game.R.nextInt(5);
		int nY = Game.R.nextInt(5);
		int nS = Game.R.nextInt(3)+2;					// spin is a random number between 2 and 4
		
		if (nX % 2 == 0){			// set random DeltaX
			setDeltaX(nX);
		}
		else{
			setDeltaX(-nX);
		}

		if (nY % 2 == 0){			// set random DeltaY
			setDeltaX(nY);
		}
		else{
			setDeltaX(-nY);
		}
		
		if (nS % 2 == 0){			// set random spin
			setSpin(nS);
		}
		else{
			setSpin(-nS);
		}
		
		setCenter(new Point(Game.R.nextInt(Game.DIM.width),Game.R.nextInt((int)(Game.DIM.height/2.0)+50)));
		setOrientation(Game.R.nextInt(360));	// random orientation 
		
		ArrayList<Point> pntCs = new ArrayList<Point>();

		pntCs.add(new Point(0,6));		// draws the powerup image using cartesian points
		pntCs.add(new Point(1,3));
		pntCs.add(new Point(4,4));
		pntCs.add(new Point(3,1));
		pntCs.add(new Point(6,0));
		pntCs.add(new Point(3,-1));
		pntCs.add(new Point(4,-4));
		pntCs.add(new Point(1,-3));
		pntCs.add(new Point(4,-4));
		pntCs.add(new Point(1,-3));
		
		pntCs.add(new Point(0,-6));
		pntCs.add(new Point(-1,-3));
		pntCs.add(new Point(-4,-4));
		pntCs.add(new Point(-3,-1));
		pntCs.add(new Point(-6,0));
		pntCs.add(new Point(-3,1));
		pntCs.add(new Point(-4,4));
		pntCs.add(new Point(-1,3));
		pntCs.add(new Point(0,6));

		assignPolarPoints(pntCs);
		
		Sound.playSound("LTTP_Sword_Charge.wav");		// powerup spawn sound effect
	}

	public void move() {
		super.move();
		setOrientation(getOrientation() + getSpin());
	}

	// Override the expire method - once a powerup expires, remove it from the array list.
	@Override
	public void expire() {
		if (getExpire() == 0){
			CommandCenter.movFloaters.remove(this);
		}
		else{
			setExpire(getExpire() - 1);
		}
	}

	@Override
	public void draw(Graphics g) {
		super.draw(g);
		g.setColor(colColor);
		g.fillPolygon(getXcoords(), getYcoords(), dDegrees.length);		// fill this polygon (with whatever color it has)
		g.setColor(Color.black);										// now draw a white border
		g.drawPolygon(getXcoords(), getYcoords(), dDegrees.length);
		
		g.setColor(Color.white);
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
		g.drawString(strLetter, (int) getCenter().getX()-getRadius()+14, (int) getCenter().getY()+7);
	}
	
	
	// ==============================================================
	// GETTERS & SETTERS 
	// ==============================================================
	
	public int getSpin() {return this.nSpin;}
	public void setSpin(int nSpin) {this.nSpin = nSpin;}

	public String getPower() {return strPower;}
	public void setPower(String power) {strPower = power;}

	public String getLetter() {return strLetter;}
	public void setLetter(String letter) {strLetter = letter;}

	public Color getColColor() {return colColor;}
	public void setColColor(Color colColor) {this.colColor = colColor;}
	
}