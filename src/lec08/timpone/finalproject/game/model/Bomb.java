package lec08.timpone.finalproject.game.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

/**
 *  A bomb is an enemy object that is dropped from a BomberPlane.  Once the bomb is created, it will drop to the ground at the same
 *  speed without changing its x-axis.  When a bomb explodes, it causes area-of-effect damage in a small radius around the explosion,
 *  meaning it can destroy other enemies around it (this effect is implemented in the Game class).  
 */
public class Bomb extends Sprite {

	// ==============================================================
	// FIELDS 
	// ==============================================================
	
	private Random R;
	public Point pntStartPosition;				// the point where the bomb is spawned
	
	public static final int BOMB_RADIUS = 10;	// size of the bomb
	public static final int BOMB_DROP_SPEED = 5;
	
	
	// ==============================================================
	// CONSTRUCTOR 
	// ==============================================================
	
	public Bomb(Point pnt) {
		
		super();
		
		R = new Random();
		
		setDeltaX(0);											
		setDeltaY(BOMB_DROP_SPEED);								// bomb's speed is determined by constant
		
		ArrayList<Point> pntCs = new ArrayList<Point>();		// cartesian points in the bomb drawing
		
		pntCs.add(new Point(0,6));
		pntCs.add(new Point(4,6));
		pntCs.add(new Point(4,3));
		pntCs.add(new Point(2,3));
		pntCs.add(new Point(4,0));
		pntCs.add(new Point(4,-6));
		pntCs.add(new Point(3,-8));
		pntCs.add(new Point(0,-9));
		
		pntCs.add(new Point(-3,-8));
		pntCs.add(new Point(-4,-6));
		pntCs.add(new Point(-4,0));
		pntCs.add(new Point(-2,3));
		pntCs.add(new Point(-4,3));
		pntCs.add(new Point(-4,6));
		pntCs.add(new Point(0,6));

		assignPolarPoints(pntCs);
		
		pntStartPosition = pnt;									// assigning the rest of the bomb's attributes
		setCenter(pntStartPosition);
		setRadius(BOMB_RADIUS);
		setOrientation(270);
		setColor(Color.WHITE);
	}

	
	// ==============================================================
	// METHODS 
	// ==============================================================
	
	@Override
	public void draw(Graphics g){
			super.draw(g);
			
			g.setColor(getRandomColor());												// draws the bomb's color-changing contrail
			g.drawLine((int)pntStartPosition.getX(), (int)pntStartPosition.getY(), 
					   (int)getCenter().getX(), (int)getCenter().getY()-BOMB_RADIUS);
			
			g.setColor(getRandomColor());
			g.drawLine((int)pntStartPosition.getX()-1, (int)pntStartPosition.getY(), 
					   (int)getCenter().getX()-1, (int)getCenter().getY()-BOMB_RADIUS);
			
			g.setColor(getRandomColor());
			g.drawLine((int)pntStartPosition.getX()+1, (int)pntStartPosition.getY(), 
					   (int)getCenter().getX()+1, (int)getCenter().getY()-BOMB_RADIUS);
	}

	// Returns a random color - white has a 40% chance of being selected, while red, yellow, and orange have a 20% chance
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
}