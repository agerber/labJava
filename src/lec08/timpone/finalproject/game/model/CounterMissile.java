package lec08.timpone.finalproject.game.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

import lec08.timpone.finalproject.sounds.Sound;

/**
 *  A CounterMissile is the primary weapon the player uses to fire at enemies and pickup powerups.  The counter missile is not so 
 *  much as a missile as it is an explosion that the player creates by clicking.  Each time the player clicks, a counter missile 
 *  will be created where the click took place.  The counter missile grows larger, then smaller, then disappears. The size and 
 *  length of the explosion can be altered by changing the constants in the fields section.  
 *  
 *  Also note that CounterMissile are used to create an 'afterburner' effect for the SuperNuke.  
 */
public class CounterMissile extends Sprite {

	// ==============================================================
	// FIELDS 
	// ==============================================================
	
	private final int MAX_EXPIRE = 15;					// how long the explosion lasts
	private final int MIN_EXPLOSION_RADIUS = 30;		// size of the explosion immediately after the click
	private final int MAX_EXPLOSION_RADIUS = 60;		// maximum size of the explosion before becoming small again
	
	private static Random R;
	
	
	// ==============================================================
	// CONSTRUCTOR 
	// ==============================================================
	
	// Sets up the counter missile's settings
	public CounterMissile(Point pnt) {
	
		super();
		R = new Random();
		
		setDeltaX(0);						// explosion does not move
		setDeltaY(0);
		setCenter(pnt);

		setExpire(MAX_EXPIRE);
		setRadius(MIN_EXPLOSION_RADIUS);
		
		Sound.playSound("EXPLOSM.WAV");		// sound when player clicks the mouse and creates a counter missile
	}

	
	// ==============================================================
	// METHODS 
	// ==============================================================
	
	// The draw method is overriden to create the explosion effect.  Colored circles animate the explosion, with each circle
	// gradually growing larger, then smaller.  
	@Override
    public void draw(Graphics g) {

		// briefly draws a white line from the Falcon, creating the illusion that it was 'fired' from the Falcon
		if(getExpire() == MAX_EXPIRE){
			g.setColor(Color.white);
			g.drawLine((int) CommandCenter.getFalcon().getCenter().getX(), 			 
                       (int) CommandCenter.getFalcon().getCenter().getY(), 
                       (int) getCenter().getX(), (int) getCenter().getY());
		}
		
		g.setColor(getRandomColor());			// color is randomized
        
		// Controls the size of the circles being drawn depending on how long the counter missile has been alive
		double nIncrement = (MAX_EXPLOSION_RADIUS - MIN_EXPLOSION_RADIUS)/(MAX_EXPIRE/2.0);
        
        double nRadius = 0;
        if((double)getExpire() < MAX_EXPIRE/2.0){
        	nRadius = MAX_EXPLOSION_RADIUS - nIncrement*(MAX_EXPIRE/2.0-(getExpire()));
        }
        else{
        	nRadius = MIN_EXPLOSION_RADIUS + nIncrement*(MAX_EXPIRE-(getExpire()));
        }
        g.fillOval((int)getCenter().getX()-(int)nRadius/2, (int)getCenter().getY()-(int)nRadius/2, (int)nRadius, (int)nRadius);
        
        setRadius((int)nRadius);
    }
	
	// Randomly returns a color - white has a 40% chance of being selected, while red, yellow, and orange have a 20% chance each
	public Color getRandomColor(){
		int nColorID = R.nextInt(5);
		Color col = null;
		if(nColorID < 2){
			col = Color.white;
		}
		else if(nColorID == 2){
			col = Color.red;
		}
		else if(nColorID == 3){
			col = Color.yellow;
		}
		else if(nColorID == 4){
			col = Color.orange;
		}
		return col;
	}
	
	// Overrides the expire method - once an object expires remove it from the movFriends array list
	@Override
	public void expire() {
		if (getExpire() == 0){
			CommandCenter.movFriends.remove(this);
		}
		else{
			setExpire(getExpire() - 1);
		}
	}
}
