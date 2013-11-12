package lec08.timpone.finalproject.game.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *  A city is a non-moving, non-respawning object that the player tries to protect from enemy missiles and bombs.  The city not
 *  drawn with vector graphics like the Falcon, instead it is drawn using colored rectangles created by the fillRect method.  
 */
public class City extends Sprite {

	// ==============================================================
	// FIELDS 
	// ==============================================================
	
	public static final int BUILDING_RADIUS = 50;							// size of the city

	
	// ==============================================================
	// CONSTRUCTOR 
	// ==============================================================
	
	// Sets up the cities settings
	public City(Point pnt){
		super();
		setDeltaX(0);														
		setDeltaY(0);
		setRadius(BUILDING_RADIUS);											
		setCenter(pnt);
	}

	
	// ==============================================================
	// METHODS 
	// ==============================================================
	
	// Overrides the draw method to draw colored rectangles instead of the normal vector-based line graphics
	@Override
	public void draw(Graphics g){

		int nXCoord = (int) (getCenter().getX());
		int nYCoord = (int) (getCenter().getY() - BUILDING_RADIUS/2.0);
		
		g.setColor(new Color(150,150,150));										// sets color to dark grey
		g.fillRect(nXCoord-5, nYCoord-25, 10, (int) (BUILDING_RADIUS*1.5));
		
		g.setColor(new Color(175,175,175));										// sets color to a lighter grey
		g.fillRect(nXCoord+5, nYCoord-15, 10, (int) (BUILDING_RADIUS*1.5)-10);
		g.fillRect(nXCoord-15, nYCoord-10, 10, (int) (BUILDING_RADIUS*1.5)-15);
		
	}
}
