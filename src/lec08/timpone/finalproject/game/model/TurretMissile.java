package lec08.timpone.finalproject.game.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import lec08.timpone.finalproject.sounds.Sound;

/**
 *  TurretMissiles are the small missiles fired from Cities when the Turrets powerup is activated.  Much like the enemy msisile,
 *  the turret missile can be created with or without a target point.  The missile uses distance calculations to move toward
 *  the enemy target.  A turret missile can destroy enemies such as missiles, planes, and bombs.  Turret missiles leave a cyan
 *  colored contrail behind them as they move toward their target.   
 */
public class TurretMissile extends Sprite {

	// ==============================================================
	// FIELDS 
	// ==============================================================
	
	private static Random R;
	
	public Point pntStartPosition;							// missile's starting position
	public static final int TURRET_MISSILE_RADIUS = 15;		// size of the turret missile
	public static final int TURRET_MISSILE_SPEED = -5;
	
	
	// ==============================================================
	// CONSTRUCTOR 
	// ==============================================================
	
	public TurretMissile() {

		super();
		R = new Random();
		
		ArrayList<Point> pntCs = new ArrayList<Point>();		// missile drawing as a list of cartesian points

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
		setDeltaY(TURRET_MISSILE_SPEED);
		pntStartPosition = getStartingPoint();					// randomly gets a starting point that is either a city of the falcon 
		setCenter(pntStartPosition);
		setRadius(TURRET_MISSILE_RADIUS);
		setColor(Color.CYAN);
		
		Sound.playSound("LA_Sword_Spin.wav");					// turret missile spawn sound
	}

	// Overlaoded constructor - the Point parameter is the target that the missile will gradually move toward
	public TurretMissile(Point pnt){
		this();
		
		Double dXCoordTarget = pnt.getX();
		Double dXCoordTurretBullet = this.getCenter().getX();
		Double dXDistance = dXCoordTarget - dXCoordTurretBullet;	// distance to target
		
		Double dYCoordTarget = pnt.getY();
		Double dYCoordTurretBullet = this.getCenter().getY();
		Double dYDistance = dYCoordTarget - dYCoordTurretBullet;	// distance to target
		
		setDeltaX(dXDistance/(dYDistance/(double)getDeltaY()));
		
		double dXDistanceOrientation = pnt.getX()-getCenter().getX();
		double dYDistanceOrientation = pnt.getY()-getCenter().getY();
		
		int nAngle = -1*(int) Math.toDegrees(Math.atan2(dXDistanceOrientation,dYDistanceOrientation)) + 90; 
		setOrientation(nAngle);										// points missile toward target
	}

	
	// ==============================================================
	// METHODS 
	// ==============================================================
	
	// Randomly returns a point that is either the center of a city object or the center of the falcon object
	public Point getStartingPoint(){
		
		CopyOnWriteArrayList<Movable> movTargets = new CopyOnWriteArrayList<Movable>();
		CopyOnWriteArrayList<Movable> movFriends = CommandCenter.getMovFriends();
		
		for (Movable movFriend : movFriends) {		// locates the city objects currently in the movFriends array list
			if(movFriend instanceof City){
				movTargets.add(movFriend);
			}
		}

		try {
			int nTarget = R.nextInt(movTargets.size());			// attempts to return a city point
			int nXCoord = (int) movTargets.get(nTarget).getCenter().getX();
			int nYCoord = (int) movTargets.get(nTarget).getCenter().getY() - City.BUILDING_RADIUS;
			return new Point(nXCoord,nYCoord);
		} catch (Exception e) {
			return CommandCenter.getFalcon().getCenter();		// if this is not possible, returns the center of the falcon
		}
	}
	
	
	// Overrides Sprite's draw method to create a light blue contrail behind the missile as it moves across the screen
	@Override
	public void draw(Graphics g){
			super.draw(g);
			g.setColor(new Color(175,235,235));
			g.drawLine((int)pntStartPosition.getX(), (int)pntStartPosition.getY(), (int)getCenter().getX(), (int)getCenter().getY());
			g.drawLine((int)pntStartPosition.getX()-1, (int)pntStartPosition.getY(), (int)getCenter().getX()-1, (int)getCenter().getY());
	}

}
