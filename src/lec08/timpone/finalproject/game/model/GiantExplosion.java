package lec08.timpone.finalproject.game.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

import lec08.timpone.finalproject.sounds.Sound;

/**
 *  GiantExplosion is a visual effect that is spawned when a bomb or bomber plane are destroyed (i.e. this is debris created by an
 *  exploding bomb or bomber plane).  The explosion itself is just a visual effect and does not interact with other game objects.  
 *  The length and size of the explosion can be controlled by changing the constants in the fields section.   
 */
public class GiantExplosion extends Sprite {

	// ==============================================================
	// FIELDS 
	// ==============================================================

	private static Random R;

	private final int MAX_EXPIRE = 15;						// how long the explosion lasts
	public static final int MIN_EXPLOSION_RADIUS = 30;		// size of the explosion immediately after the click
	public static final int MAX_EXPLOSION_RADIUS = 200;		// maximum size of the explosion before becoming small again
	
	
	// ==============================================================
	// CONSTRUCTOR 
	// ==============================================================
	
	// sets up the explosion's initial settings
	public GiantExplosion(Point pnt) {

		super();
		R = new Random();

		setDeltaX(0);
		setDeltaY(0);
		setCenter(pnt);
		setExpire(MAX_EXPIRE);
		setRadius(MIN_EXPLOSION_RADIUS);
		
		Sound.playSound("anotherexplo2.wav");
	}

	
	// ==============================================================
	// METHODS 
	// ==============================================================
	
	// The draw method is overriden to create the explosion effect.  Colored circles animate the explosion, with each circle
	// gradually growing larger, then smaller.  
	@Override
    public void draw(Graphics g) {
        g.setColor(getRandomColor());	// randomly selects a color
        
        // Controls the size of the circles being drawn depending on how long the counter missile has been alive
        double nIncrement = (MAX_EXPLOSION_RADIUS - MIN_EXPLOSION_RADIUS)/(MAX_EXPIRE/2.0);
        double nRadius = 0;
        if((double)getExpire()<MAX_EXPIRE/2.0){
        	nRadius = MAX_EXPLOSION_RADIUS - nIncrement*(MAX_EXPIRE/2.0-(getExpire()));
        }
        else{
        	nRadius = MIN_EXPLOSION_RADIUS + nIncrement*(MAX_EXPIRE-(getExpire()));
        }
        g.fillOval((int)getCenter().getX()-(int)nRadius/2, (int)getCenter().getY()-(int)nRadius/2, (int)nRadius, (int)nRadius);
        setRadius((int)nRadius);
    }
	
	// Randomly returns a color - white has a 40% chance of being selected, while magenta, cyan, and aqua have a 20% chance each
	public Color getRandomColor(){
		int nColorID = R.nextInt(5);

		Color col = null;
		if(nColorID < 2){
			col = Color.magenta;
		}
		else if(nColorID == 2){
			col = Color.LIGHT_GRAY;
		}
		else if(nColorID == 3){
			col = Color.cyan;
		}
		else if(nColorID == 4){
			col = new Color(0,255,255);		// 'aqua' color
		}
		return col;
	}

	// Overrides the expire method - once an object expires remove it from the movFriends array list
	@Override
	public void expire() {
		if (getExpire() == 0){
			CommandCenter.movDebris.remove(this);
		}
		else{
			setExpire(getExpire() - 1);
		}
	}
}
