package lec08.timpone.finalproject.game.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

import lec08.timpone.finalproject.controller.Game;
import lec08.timpone.finalproject.sounds.Sound;

/**
 *  SuperNukeExplosions are created when the super nuke object expires (i.e. this is debris created by an exploding super nuke).  
 *  It is added to the movFriends array list in command center, and therefore, it DOES interact with other game objects.  The 
 *  explosion starts small, grows bigger, then grows small again and expires.  The length and size of the explosion can be 
 *  controlled by the constants in the fields section.   
 */
public class SuperNukeExplosion extends Sprite {

	// ==============================================================
	// FIELDS 
	// ==============================================================
	
	private static Random R;

	private final int MAX_EXPIRE = 45;				// how long the explosion lasts
	private final int MIN_EXPLOSION_RADIUS = 50;	// size of the explosion immediately after the click
	private final int MAX_EXPLOSION_RADIUS = 600;	// maximum size of the explosion before becoming small again
	
	
	// ==============================================================
	// CONSTRUCTOR 
	// ==============================================================
	
	public SuperNukeExplosion(Point pnt) {
		super();
		R = new Random();
		
		setDeltaX(0);
		setDeltaY(0);
		setCenter(pnt);

		setExpire(MAX_EXPIRE);
		setRadius(MIN_EXPLOSION_RADIUS);
	}

	
	// ==============================================================
	// METHODS 
	// ==============================================================
	
	// The draw method is overriden to create the explosion effect.  Colored circles animate the explosion, with each circle
	// gradually growing larger, then smaller.  Explosion sounds will be played intermittently as the explosion grows and
	// shrinks.  
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
        
        if(nRadius>0 && Game.getTick() % 3 == 0){
        	playRandomExplosionSound();					// plays a random explosion sound at regular intervals
        }
        setRadius((int)nRadius);
    }
	
	// Plays a randomly selected explosion sound
	public void playRandomExplosionSound(){
		int nColorID = R.nextInt(5);
		if(nColorID == 0){
			Sound.playSound("EXPLOLRG.WAV");
		}
		else if(nColorID == 1){
			Sound.playSound("EXPLOMED.WAV");
		}
		else if(nColorID == 2){
			Sound.playSound("EXPLOSM.WAV");
		}
		else if(nColorID == 3){
			Sound.playSound("anotherexplo2.wav");
		}
		else{
			Sound.playSound("anotherexplos.wav");
		}
	}
	
	// Returns a random color - white has a 43% chance of being selected, dark red, yellow, red, and orange have about a 14% chance
	public Color getRandomColor(){
		int nColorID = R.nextInt(7);
		
		Color col = null;
		if(nColorID < 3){
			col = Color.WHITE;
		}
		else if(nColorID == 3){
			col = new Color(178,34,34);		// dark red color
		}
		else if(nColorID == 4){
			col = Color.yellow;
		}
		else if(nColorID == 5){
			col = Color.red;
		}
		else if(nColorID == 6){
			col = Color.orange;
		}
		return col;
	}

	// Overrides the expire method - once the object expires, it is removed from the appropriate array list in command center
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
