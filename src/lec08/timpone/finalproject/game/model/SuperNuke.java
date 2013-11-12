package lec08.timpone.finalproject.game.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

/**
 *  SuperNuke is a game object that is created when the player picks up the SuperNuke powerup.  It is a large missile fired from
 *  the falcon that moves directly upwards into the middle of the screen until it expires (at which time it creates a 
 *  SuperNukeExplosion).  The draw method is overridden to create a flame-colored contrail behind the supernuke as it moves,
 *  and to create a series of counter missiles behind it to create an 'afterburner' effect.   
 */
public class SuperNuke extends Sprite {

	// ==============================================================
	// FIELDS 
	// ==============================================================

	private static Random R;

	public Point pntStartPosition;
	public static final int SUPER_NUKE_RADIUS = 40;			// size of the super nuke
	private final int MAX_EXPIRE = 75;						// controls how long the super nuke is alive before exploding
	
	
	// ==============================================================
	// CONSTRUCTOR 
	// ==============================================================
	
	public SuperNuke(Point pnt){
		
		super();
		R = new Random();
		
		ArrayList<Point> pntCs = new ArrayList<Point>();		// super nuke drawn as a series of cartesian points

		pntCs.add(new Point(0,20));
		pntCs.add(new Point(2,16));
		pntCs.add(new Point(2,6));
		pntCs.add(new Point(4,4));
		pntCs.add(new Point(2,4));
		pntCs.add(new Point(2,1));
		pntCs.add(new Point(4,0));

		pntCs.add(new Point(-4,0));
		pntCs.add(new Point(-2,1));
		pntCs.add(new Point(-2,6));
		pntCs.add(new Point(-4,4));
		pntCs.add(new Point(-2,4));
		pntCs.add(new Point(-2,16));
		pntCs.add(new Point(0,20));

		assignPolarPoints(pntCs);
		
		// general settings
		setDeltaX(0);
		setDeltaY(-5);
		pntStartPosition = CommandCenter.getFalcon().getCenter();
		setCenter(pntStartPosition);
		setExpire(MAX_EXPIRE);									// a TurretBullet TurretBullet expires after 25 frames
		setRadius(SUPER_NUKE_RADIUS);
		setColor(Color.orange);
		
		Double dXCoordTarget = pnt.getX();
		Double dCoordSuperNuke = this.getCenter().getX();
		Double dXDistance = dXCoordTarget - dCoordSuperNuke;	// distance from target
		
		Double dYCoordTarget = pnt.getY();
		Double dYCoordSuperNuke = this.getCenter().getY();
		Double dYDistance = dYCoordTarget - dYCoordSuperNuke;	// distance from target
		
		setDeltaX(dXDistance/(dYDistance/(double)getDeltaY()));
		
		double dXDistanceOrientation = pnt.getX()-getCenter().getX();
		double dYDistanceOrientation = pnt.getY()-getCenter().getY();
		
		int nAngle = -1*(int) Math.toDegrees(Math.atan2(dXDistanceOrientation,dYDistanceOrientation)) + 90; 
		setOrientation(nAngle);				// points the super nuke toward the target
	}

	
	// ==============================================================
	// METHODS 
	// ==============================================================

	// Sprite's draw method is overridden to draw a flashing flame-colored contrail behind the supernuke and to create a 
	// series of counter missiles behind it as it moves
	@Override
	public void draw(Graphics g){
			
			super.draw(g);
			g.setColor(getRandomColor());	// color is randomized
			
			// Draws a flashing yellow/red/white/orange line behind the supernuke as it moves up
			g.drawLine((int)pntStartPosition.getX(), (int)pntStartPosition.getY(), (int)getCenter().getX(), (int)getCenter().getY());
			g.drawLine((int)pntStartPosition.getX()-1, (int)pntStartPosition.getY(), (int)getCenter().getX()-1, (int)getCenter().getY());
			g.drawLine((int)pntStartPosition.getX()-2, (int)pntStartPosition.getY(), (int)getCenter().getX()-2, (int)getCenter().getY());
			g.drawLine((int)pntStartPosition.getX()+1, (int)pntStartPosition.getY(), (int)getCenter().getX()+1, (int)getCenter().getY());
			g.drawLine((int)pntStartPosition.getX()+2, (int)pntStartPosition.getY(), (int)getCenter().getX()+2, (int)getCenter().getY());
			
			// Adds a series of counter missiles behind the supernuke to create an 'afterburner' effect as it moves
			int nXCoord = (int) getCenter().getX();
			int nYCoord = (int) getCenter().getY() + getRadius()/4 + (getExpire() % 7) + 2;
			CommandCenter.movFriends.add(new CounterMissile(new Point(nXCoord,nYCoord)));		
	}
	
	// Expire method overridden to remove the supernuke once it expires
	@Override
	public void expire() {
		if (getExpire() == 0){
			CommandCenter.movFriends.add(new SuperNukeExplosion(getCenter()));
			CommandCenter.movDebris.remove(this);
		}
		else{
			setExpire(getExpire() - 1);
		}
	}
	
	// Randomly returns a color - white has a 40% chance while red, yellow, and orange have a 20% chance each
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
