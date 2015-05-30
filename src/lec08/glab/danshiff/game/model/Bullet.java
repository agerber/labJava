package lec08.glab.danshiff.game.model;

import lec08.glab.danshiff.controller.Game;

import java.awt.Point;
import java.util.ArrayList;


public class Bullet extends Sprite {

	  private final double FIRE_POWER = Game.STANDARD_RADIUS * 2;

	 
	
public Bullet(BugHunter fal){
		
		super();
		
		
		//defined the points on a cartesean grid
		ArrayList<Point> pntCs = new ArrayList<Point>();
		
		pntCs.add(new Point(0,3)); //top point
		
		pntCs.add(new Point(1,-1));
		pntCs.add(new Point(0,-2));
		pntCs.add(new Point(-1,-1));

		assignPolarPoints(pntCs);

		//a bullet expires after 20 frames
	    setExpire( Game.ROW );
	    setRadius(6);
	    

	    //everything is relative to the falcon ship that fired the bullet
	    setDeltaX( fal.getDeltaX() +
	               Math.cos( Math.toRadians( fal.getOrientation() ) ) * FIRE_POWER );
	    setDeltaY( fal.getDeltaY() +
	               Math.sin( Math.toRadians( fal.getOrientation() ) ) * FIRE_POWER );
	    setCenter( fal.getCenter() );

	    //set the bullet orientation to the falcon (ship) orientation
	    setOrientation(fal.getOrientation());


	}

    //override the expire method - once an object expires, then remove it from the arrayList. 
	public void expire(){
 		expire(CommandCenter.movFriends);
	}

}
