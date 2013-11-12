package lec08.timpone.finalproject.game.model;

import java.awt.*;

/**
 *  This class remains virtually unchanged from the game base code 
 */
public interface Movable {
	
	public void move();			// for the game to draw
	public void draw(Graphics g);
	public int points();
	public Point getCenter();
	public int getRadius();
	public void expire();		// for short-lasting objects (powerups, bullets, etc) - controls nExpiry that counts down to removal
	public void fadeInOut();	// for fading objects
}
