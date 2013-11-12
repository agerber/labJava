package lec08.timpone.finalproject.game.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import lec08.timpone.finalproject.controller.Game;

/**
 *  The Missile class controls several aspects of enemy missiles.   As a missile moves towards its target, a white/gray contrail
 *  forms behind it that draws the path it has taken so far.  Missile size, speed, and contrail color can be changed by altering the
 *  constants found in the fields section.  A missile can be created with or without a target point due to the overloaded 
 *  constructor.  Math methods are used to point the missile toward its target.  
 */
public class Missile extends Sprite {

	// ==============================================================
	// FIELDS 
	// ==============================================================
	
	public Point pntStartPosition;								// missile starting position
	private static Random R;
	
	public static final int MISSILE_RADIUS = 30;				// missile size
	public static final int MISSILE_SPEED = 5;					// missile speed
	public static final int MISSILE_CONTRAIL_MODIFIER = 150;	// how white/gray the missile contrail appears
	
	
	// ==============================================================
	// CONSTRUCTOR 
	// ==============================================================
	
	// Default constructor
	public Missile() {

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
		
		setDeltaX(0);
		setDeltaY(MISSILE_SPEED);
		pntStartPosition = new Point(Game.R.nextInt(Game.DIM.height),0); 
		setCenter(pntStartPosition);
		setRadius(MISSILE_RADIUS);
		setColor(Color.RED);
	}
	
	// Overlaoded constructor - the point given as a parameter is the target that the missile will move towards
	public Missile(Point pnt){
		
		this();
		
		Double dXCoordTarget = pnt.getX();					
		Double dXCoordMissile = this.getCenter().getX();
		Double dXDistance = dXCoordTarget - dXCoordMissile;		// distance from target
		
		Double dYCoordTarget = pnt.getY();
		Double dYCoordMissile = this.getCenter().getY();
		Double dYDistance = dYCoordTarget - dYCoordMissile;		// distance from target
		
		setDeltaX(dXDistance/(dYDistance/(double)getDeltaY()));	// change in X depends on distance from target
		
		double dXDistanceOrientation = pnt.getX()-getCenter().getX();
		double dYDistanceOrientation = pnt.getY()-getCenter().getY();
		
		int nAngle = -1*(int) Math.toDegrees(Math.atan2(dXDistanceOrientation,dYDistanceOrientation)) + 95; 
		setOrientation(nAngle);									// points the missile toward the target
	}

	
	// ==============================================================
	// METHODS 
	// ==============================================================
	
	// Sprite's draw method is overridden to include a contrail behind the missile which shows the path it has taken
	@Override
	public void draw(Graphics g){
			super.draw(g);
			g.setColor(Color.white);
			
			int nGoal = MISSILE_CONTRAIL_MODIFIER;		// can modify how white/gray the contrail appears
			
			// Draws a line behind the missile as it moves toward the target
			int nCurrent = (int) (255 - (nGoal)*((double) (getCenter().getY()/(Game.DIM.getHeight()-Game.GROUND_LEVEL))));
			g.setColor(new Color(nCurrent,nCurrent,nCurrent));
			
			g.drawLine((int)pntStartPosition.getX(), (int)pntStartPosition.getY(), (int)getCenter().getX(), (int)getCenter().getY());
			g.drawLine((int)pntStartPosition.getX()-1, (int)pntStartPosition.getY(), (int)getCenter().getX()-1, (int)getCenter().getY());
	}

}
