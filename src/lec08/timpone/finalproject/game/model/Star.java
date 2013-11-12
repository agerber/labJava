package lec08.timpone.finalproject.game.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

/**
 *  Star is a passive object that does not interact with game objects.  It is just part of the scenery.  Stars are created at 
 *  random positions in the background and twinkle white, cyan, and yellow at random intervals.  
 */
public class Star extends Sprite {

	// ==============================================================
	// FIELDS 
	// ==============================================================
	
	public static final int STAR_RADIUS = 2;		// size of the star
	public static Random R;
	
	// ==============================================================
	// CONSTRUCTOR 
	// ==============================================================
	
	// Sets up the star's basic settings - starting position is determined by the Point parameter
	public Star(Point pntCenter) {
		super();
		R = new Random();
		
		setDeltaX(0);
		setDeltaY(0);
		setRadius(STAR_RADIUS);
		setCenter(pntCenter);
	}
	
	
	// ==============================================================
	// METHODS 
	// ==============================================================
	
	// Overridden to include 'twinkle' effect that colors stars at random intervals 
	@Override
	public void draw(Graphics g){
		g.setColor(getTwinkleColor());		// randomly selects a color
		g.fillRect((int)getCenter().getX(), (int)getCenter().getY(), STAR_RADIUS, STAR_RADIUS);		// draws the star in the game
	}
	
	// Randomly returns a color - white (86% chance), cyan (7% chance), or yellow (7% chance)
	public Color getTwinkleColor(){
		int nTwinkle = R.nextInt(15);
		Color col = Color.white;
		if(nTwinkle == 0){
			col = Color.cyan;
		}
		if(nTwinkle == 1){
			col = Color.yellow;
		}
		return col;
	}

}
