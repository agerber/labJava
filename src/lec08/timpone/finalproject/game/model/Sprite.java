package lec08.timpone.finalproject.game.model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import lec08.timpone.finalproject.controller.Game;

/**
 *  This class is virtually unchanged from the game base.  
 */
public abstract class Sprite implements Movable {

	// ==============================================================
	// FIELDS 
	// ==============================================================
	
	private Point pntCenter;			//the center-point of this sprite
	
	private double dDeltaX, dDeltaY;	//this causes movement; change in x and change in y
	private Dimension dim; 				//dim of the gaming environment (every sprite needs to know this)
	private int nRadius;				//the radius of circumscibing circle
	private int nOrientation;			//degrees (where the sprite is pointing out of 360)
	private int nExpiry; 				//natural mortality (short-living objects)
	private Color col;					//the color of this sprite

	public double[] dLengths;			// radial coordinates - game uses radial coordinates to draw graphics
	public double[] dDegrees;
	
	private int nFade;					//fade value for fading in and out

	private Point[] pntCoords; 			//an array of points used to draw polygon - don't need to interface w/these
	private int[] nXCoords;
	private int[] nYCoords;
	
	
	// ==============================================================
	// CONSTRUCTOR 
	// ==============================================================
	
	// Can be overriden by subclasses that extend Sprite
	public Sprite() {
		setDim(Game.DIM);
		setColor(Color.white);
		setCenter(new Point(Game.R.nextInt(Game.DIM.width), Game.R.nextInt(Game.DIM.height)));
	}	
	
	
	// ==============================================================
	// METHODS 
	// ==============================================================
	
	public void move() {

		Point pnt = getCenter();
		double dX = pnt.x + getDeltaX();
		double dY = pnt.y + getDeltaY();
		
		if (pnt.x > getDim().width) {				//this just keeps the sprite inside the bounds of the frame
			setCenter(new Point(1, pnt.y));
		} else if (pnt.x < 0) {
			setCenter(new Point(getDim().width - 1, pnt.y));
		} else if (pnt.y > getDim().height) {
			setCenter(new Point(pnt.x, 1));
		} else if (pnt.y < 0) {
			setCenter(new Point(pnt.x, getDim().height - 1));
		} else {
			setCenter(new Point((int) dX, (int) dY));
		}
	}

	protected double hypot(double dX, double dY) {
		return Math.sqrt(Math.pow(dX, 2) + Math.pow(dY, 2));
	}
	
	// Converts from cartesian to polar - much easier to draw a sprite as cartesian points
	protected double[] convertToPolarDegs(ArrayList<Point> pntPoints) {
		double[] dDegs = new double[pntPoints.size()];
		int nC = 0;
		for (Point pnt : pntPoints) {
			dDegs[nC++]=(Math.toDegrees(Math.atan2(pnt.y, pnt.x))) * Math.PI / 180 ;
		}
		return dDegs;
	}

	// Converts to polar coordinates
	protected double[] convertToPolarLens(ArrayList<Point> pntPoints) {

		double[] dLens = new double[pntPoints.size()];
		
		double dL = 0;						//determine the largest hypotenuse
		for (Point pnt : pntPoints)
			if (hypot(pnt.x, pnt.y) > dL)
				dL = hypot(pnt.x, pnt.y);

		int nC = 0;
		for (Point pnt : pntPoints) {
			if (pnt.x == 0 && pnt.y > 0) {
				dLens[nC] = hypot(pnt.x, pnt.y) / dL;
			} else if (pnt.x < 0 && pnt.y > 0) {
				dLens[nC] = hypot(pnt.x, pnt.y) / dL;
			} else {
				dLens[nC] = hypot(pnt.x, pnt.y) / dL;
			}
			nC++;
		}
		return dLens;
	}

	protected void assignPolarPoints(ArrayList<Point> pntCs) {
		setDegrees(convertToPolarDegs(pntCs));
		setLengths(convertToPolarLens(pntCs));
	}
	
    public void draw(Graphics g) {
        nXCoords = new int[dDegrees.length];
        nYCoords = new int[dDegrees.length];
        
        pntCoords = new Point[dDegrees.length];			// need this as well

        for (int nC = 0; nC < dDegrees.length; nC++) {
            nXCoords[nC] =    (int) (getCenter().x + getRadius() * dLengths[nC] 
                                  * Math.sin(Math.toRadians(getOrientation()) + dDegrees[nC]));
            nYCoords[nC] = (int) (getCenter().y - getRadius() * dLengths[nC] 
            					  * Math.cos(Math.toRadians(getOrientation()) + dDegrees[nC]));
            
            //need this line of code to create the points which we will need for debris
            pntCoords[nC] = new Point(nXCoords[nC], nYCoords[nC]);
        }
        g.setColor(getColor());
        g.drawPolygon(getXcoords(), getYcoords(), dDegrees.length);
    }

	public void expire() {}							// default is blank
	public void fadeInOut() {}						// default is blank
	public boolean isExploding() {return false;}	// default is false
	public int points() {return 0;}					// default is zero

	
	// ==============================================================
	// GETTERS & SETTERS 
	// ==============================================================

	public int getFadeValue() {return nFade;}
	public void setFadeValue(int n) {nFade = n;}	
	
	public Point[] getObjectPoints() {return pntCoords;}
	public void setObjectPoints(Point[] pntPs) {pntCoords = pntPs;}
	
	public void setObjectPoint(Point pnt, int nIndex) {pntCoords[nIndex] = pnt;}
	
	public int getExpire() {return nExpiry;}
	public void setExpire(int n) {nExpiry = n;}

	public double[] getLengths() {return this.dLengths;}
	public void setLengths(double[] dLengths) {this.dLengths = dLengths;}

	public double[] getDegrees() {return this.dDegrees;}
	public void setDegrees(double[] dDegrees) {this.dDegrees = dDegrees;}

	public Color getColor() {return col;}
	public void setColor(Color col) {this.col = col;}
	
	public int getOrientation() {return nOrientation;}
	public void setOrientation(int n) {nOrientation = n;}

	public double getDeltaX() {return dDeltaX;}
	public void setDeltaX(double dSet) {dDeltaX = dSet;}

	public double getDeltaY() {return dDeltaY;}
	public void setDeltaY(double dSet) {dDeltaY = dSet;}

	public int getRadius() {return nRadius;}
	public void setRadius(int n) {nRadius = n;}

	public Dimension getDim() {return dim;}
	public void setDim(Dimension dim) {this.dim = dim;}

	public Point getCenter() {return pntCenter;}
	public void setCenter(Point pntParam) {pntCenter = pntParam;}

	public int getXcoord( int nIndex) {return nXCoords[nIndex];}		// = nValue;
	public void setXcoord(int nValue, int nIndex) {nXCoords[nIndex] = nValue;}
	
	public int getYcoord( int nIndex) {return nYCoords[nIndex];}		// = nValue;
	public void setYcoord(int nValue, int nIndex) {nYCoords[nIndex] = nValue;}

	public int[] getXcoords() {return nXCoords;}
	public void setXcoords( int[] nCoords) {nXCoords = nCoords;}
	
	public int[] getYcoords() {return nYCoords;}
	public void setYcoords(int[] nCoords) {nYCoords =nCoords;}
	
}