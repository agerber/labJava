package lec08.timpone.finalproject.game.model;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

/**
 *  A Tree is a piece of scenery that can be destroyed by enemy missiles and bombs.  They serve no real purpose in the game other
 *  than to be destructible pieces of scenery.  
 */
public class Tree extends Sprite {

	// ==============================================================
	// FIELDS 
	// ==============================================================
	
	private static Random R;
	public static final int TREE_RADIUS = 25;			// size of the tree
	
	
	// ==============================================================
	// CONSTRUCTOR 
	// ==============================================================
	
	public Tree(Point pnt) {

		super();
		R = new Random();
		
		ArrayList<Point> pntCs = new ArrayList<Point>();		// Tree image is drawn with a series of cartesian points

		pntCs.add(new Point(0,17));
		pntCs.add(new Point(2,13));
		pntCs.add(new Point(1,13));
		pntCs.add(new Point(3,9));
		pntCs.add(new Point(2,9));
		pntCs.add(new Point(4,5));
		pntCs.add(new Point(1,5));
		pntCs.add(new Point(1,0));
		
		pntCs.add(new Point(-1,0));
		pntCs.add(new Point(-1,5));
		pntCs.add(new Point(-4,5));
		pntCs.add(new Point(-2,9));
		pntCs.add(new Point(-3,9));
		pntCs.add(new Point(-1,13));
		pntCs.add(new Point(-2,13));
		pntCs.add(new Point(0,17));

		assignPolarPoints(pntCs);
		
		// general settings
		setOrientation(270);
		setDeltaX(0);
		setDeltaY(0);
		setCenter(pnt);
		setRadius(TREE_RADIUS);
		setColor(Color.GREEN);
	}
	
}
