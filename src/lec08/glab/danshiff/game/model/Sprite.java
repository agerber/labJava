package lec08.glab.danshiff.game.model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import lec08.glab.danshiff.controller.Game;

public abstract class Sprite implements Movable {
    public static final int RIGHT = 0, DOWN = 90, LEFT = 180, UP = 270; //Orientations.
    public static final int LOOPS=1, STICKS=2, LEAVES=3, STRONGSTICK=4; //Codes for the move method.

	//the center-point of this sprite
	private Point pntCenter;
	//this causes movement; change in x and change in y
	private double dDeltaX, dDeltaY;
	//every sprite needs to know about the size of the gaming environ
	private Dimension dim; //dim of the gaming environment

	//the radius of circumscibing circle
	private int nRadius;
	//is this DEBRIS, FRIEND, FOE, OR FLOATER 
	//private byte yFriend;
	//degrees (where the sprite is pointing out of 360)
	private int nOrientation;
	private int nExpiry; //natural mortality (short-living objects)
	//the color of this sprite
	private Color col;

	//radial coordinates
	//this game uses radial coordinates to render sprites
	public double[] dLengths;
	public double[] dDegrees;
	
	//for drawing alternative 
	//public double[] dLengthAlts;
	//public double[] dDegreeAlts;
	

	//fade value for fading in and out
	private int nFade;

	//these are used to draw the polygon. You don't usually need to interface with these
	private Point[] pntCoords; //an array of points used to draw polygon
	private int[] nXCoords;
	private int[] nYCoords;

    //Is it drawn filled in.
    private boolean bFull;
    //Is it off screen
    private boolean bOffScreen;

    /**
     * Primary move method now had int codes to describe how the movable interacts with boundaries.
     * @param nXCode    Can Loop (like asteroids), Stick (can't leave frame), or Leave the world
     * @param nYCode    As above (except loop) but can also StrongStick (can't go above a certain location)
     */
	public void move(int nXCode, int nYCode) {

		Point pnt = getCenter();
		double dX = pnt.x + getDeltaX();
		double dY = pnt.y + getDeltaY();
		
		//this just keeps the sprite inside the bounds of the frame
		if (pnt.x > getDim().width) {
			switch(nXCode){
                case LOOPS:
                    setCenter(new Point(1, pnt.y));
                    break;
                case STICKS:
                    setCenter(new Point(getDim().width - 1, pnt.y));
                    //Ants turn when they hit a wall.
                    if(this instanceof Ant){
                        ((Ant)this).turn();
                    }
                    break;
                case LEAVES:
                    bOffScreen = true;
                    break;
            }
		}
        else if (pnt.x < 0) {
            switch(nXCode){
                case LOOPS:
                    setCenter(new Point(getDim().width - 1, pnt.y));
                    break;
                case STICKS:
                    setCenter(new Point(1, pnt.y));
                    if(this instanceof Ant){
                        ((Ant)this).turn();
                    }
                    break;
                case LEAVES:
                    bOffScreen = true;
                    break;
            }
		}
        else if (pnt.y > Game.BOTTOM) {
            switch(nYCode){
                case STICKS:
                    setCenter(new Point(pnt.x, Game.BOTTOM));
                    break;
                case LEAVES:
                    bOffScreen = true;
                    break;
                case STRONGSTICK:
                    setCenter(new Point(pnt.x, Game.BOTTOM));
                    break;
            }
		}
        //The condition here is y is above the highest allowed location.
        else if (pnt.y < Game.BOTTOM - (BugHunter.PLAY_SPACE_ROWS * 2 * Game.STANDARD_RADIUS) && STRONGSTICK == nYCode){
			setCenter(new Point(pnt.x, Game.BOTTOM - (BugHunter.PLAY_SPACE_ROWS * 2 * Game.STANDARD_RADIUS)));
		}
        else {

			setCenter(new Point((int) dX, (int) dY));
		}

	}

    /**
     * Default move is to go off screen.
     */
    public void move(){
        move(LEAVES, LEAVES);
    }

	public Sprite() {

	//you can override this and many more in the subclasses

		setDim(Game.DIM);
		setColor(Color.white);
		setCenter(new Point(Game.R.nextInt(Game.DIM.width),
				Game.R.nextInt(Game.DIM.height)));
        setFull(false);


	}

    /**
     * Method for getting the ArrayList<Point> for a symmetric sprite
     * Give it the top, the points on the right (in order), and the bottom, and it does the rest.
     * @param top
     * @param pntRights
     * @param bottom
     * @return
     */
    public ArrayList<Point> symmetricSprite(int top, ArrayList<Point> pntRights, int bottom){
        ArrayList<Point> pntCs = new ArrayList<>();
        pntCs.add(new Point(0, top));

        for(Point pntRight : pntRights){
            pntCs.add(pntRight);
        }

        pntCs.add(new Point(0, bottom));

        for(Point pntSide : mirror(pntRights)){
            pntCs.add(pntSide);
        }

        return pntCs;
    }

    /**
     * Called by symmetricSprite to make the left side.
     * @param pntSides
     * @return
     */
    private ArrayList<Point> mirror(ArrayList<Point> pntSides){
        ArrayList<Point> pntMirrors = new ArrayList<>();
        for(Point pntSide : pntSides){
            pntMirrors.add(0, new Point(-1 * (int)pntSide.getX(), (int)pntSide.getY()));
        }

        return pntMirrors;
    }

	public void setExpire(int n) {
		nExpiry = n;

	}

	public double[] getLengths() {
		return this.dLengths;
	}

	public void setLengths(double[] dLengths) {
		this.dLengths = dLengths;
	}

	public double[] getDegrees() {
		return this.dDegrees;
	}

	public void setDegrees(double[] dDegrees) {
		this.dDegrees = dDegrees;
	}

	public Color getColor() {
		return col;
	}

	public void setColor(Color col) {
		this.col = col;

	}

	public int points() {
		//default is zero
		return 0;
	}

	public int getExpire() {
		return nExpiry;
	}

	public boolean isExploding() {
		return false;
	}

	public void fadeInOut() {
	};

	public int getOrientation() {
		return nOrientation;
	}

	public void setOrientation(int n) {
		nOrientation = n;
	}

	public void setDeltaX(double dSet) {
		dDeltaX = dSet;
	}

	public void setDeltaY(double dSet) {
		dDeltaY = dSet;
	}

	public double getDeltaY() {
		return dDeltaY;
	}

	public double getDeltaX() {
		return dDeltaX;
	}

	public int getRadius() {
		return nRadius;
	}

	public void setRadius(int n) {
		nRadius = n;

	}

	public Dimension getDim() {
		return dim;
	}

	public void setDim(Dimension dim) {
		this.dim = dim;
	}

	public Point getCenter() {
		return pntCenter;
	}

	public void setCenter(Point pntParam) {
		pntCenter = pntParam;
	}


	public void setYcoord(int nValue, int nIndex) {
		nYCoords[nIndex] = nValue;
	}

	public void setXcoord(int nValue, int nIndex) {
		nXCoords[nIndex] = nValue;
	}
	
	
	public int getYcoord( int nIndex) {
		return nYCoords[nIndex];// = nValue;
	}

	public int getXcoord( int nIndex) {
		return nXCoords[nIndex];// = nValue;
	}
	
	

	public int[] getXcoords() {
		return nXCoords;
	}

	public int[] getYcoords() {
		return nYCoords;
	}
	
	
	public void setXcoords( int[] nCoords) {
		 nXCoords = nCoords;
	}

	public void setYcoords(int[] nCoords) {
		 nYCoords =nCoords;
	}

    public boolean isOffScreen(){
        return bOffScreen;
    }

    public void setOffScreen(boolean offScreen){
        this.bOffScreen = offScreen;
    }

    public boolean isbOffScreen(){
        return bOffScreen;
    }

    public void setbOffScreen(boolean bOffScreen){
        this.bOffScreen = bOffScreen;
    }

    protected double hypot(double dX, double dY) {
		return Math.sqrt(Math.pow(dX, 2) + Math.pow(dY, 2));
	}

	
	//utility function to convert from cartesian to polar
	//since it's much easier to describe a sprite as a list of cartesean points
	//sprites (except Asteroid) should use the cartesean technique to describe the coordinates
	//see Falcon or Bullet constructor for examples
	protected double[] convertToPolarDegs(ArrayList<Point> pntPoints) {

		//ArrayList<Tuple<Double,Double>> dblCoords = new ArrayList<Tuple<Double,Double>>();
		double[] dDegs = new double[pntPoints.size()];

		int nC = 0;
		for (Point pnt : pntPoints) {
			dDegs[nC++]=(Math.toDegrees(Math.atan2(pnt.y, pnt.x))) * Math.PI / 180 ;
		}
		return dDegs;
	}
	//utility function to convert to polar
	protected double[] convertToPolarLens(ArrayList<Point> pntPoints) {

		double[] dLens = new double[pntPoints.size()];

		//determine the largest hypotenuse
		double dL = 0;
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

		// holds <thetas, lens>
		return dLens;

	}

	protected void assignPolarPoints(ArrayList<Point> pntCs) {
		setDegrees(convertToPolarDegs(pntCs));
		setLengths(convertToPolarLens(pntCs));

	}
	




	
    public void draw(Graphics g) {
        nXCoords = new int[dDegrees.length];
        nYCoords = new int[dDegrees.length];
        //need this as well
        pntCoords = new Point[dDegrees.length];
        

        for (int nC = 0; nC < dDegrees.length; nC++) {
            nXCoords[nC] =    (int) (getCenter().x + getRadius() 
                            * dLengths[nC] 
                            * Math.sin(Math.toRadians(getOrientation()) + dDegrees[nC]));
            nYCoords[nC] =    (int) (getCenter().y - getRadius()
                            * dLengths[nC]
                            * Math.cos(Math.toRadians(getOrientation()) + dDegrees[nC]));
            
            
            //need this line of code to create the points which we will need for debris
            pntCoords[nC] = new Point(nXCoords[nC], nYCoords[nC]);
        }
        
        
        

		
        
        g.setColor(getColor());
        if(bFull){
            g.fillPolygon(getXcoords(), getYcoords(), dDegrees.length);
        }
        else{
        g.drawPolygon(getXcoords(), getYcoords(), dDegrees.length);
        }
    }


    

	public Point[] getObjectPoints() {
		return pntCoords;
	}
	
	public void setObjectPoints(Point[] pntPs) {
		 pntCoords = pntPs;
	}
	
	public void setObjectPoint(Point pnt, int nIndex) {
		 pntCoords[nIndex] = pnt;
	}

    /**
     * I decided to give an expire method for removing a Sprite from a list. The idea is that subclasses can have the
     * no-param expire call expire(relevant list).
     * @param list
     */
	public void expire(CopyOnWriteArrayList<Movable> list) {
        if(getExpire() == 0){
            list.remove(this);
        }
        else{
            setExpire(getExpire() - 1);
        }
	}

    /**
     * Still need to be able to call expire on any sprite.
     */
    public void expire(){}

	public int getFadeValue() {
		return nFade;
	}

	public void setFadeValue(int n) {
		nFade = n;
	}

    public boolean isFull(){
        return bFull;
    }

    public void setFull(boolean full){
        bFull = full;
    }
}
