package edu.uchicago.gerber.labjava.lec04.points;

import java.awt.*;

/**
 * Created by Adam on 10/16/2016.
 */
public class TDPoint extends Point {

    private int z;


    //constructors
    public TDPoint(int z) {
        super(0,0);
        this.z = z;
    }

    public TDPoint(Point p, int z) {
        super(p);
        this.z = z;
    }

    public TDPoint(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }



    //getters and setters
        public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }


    public double get2DimensionalDistance(Point point){

        //get the hypotenuse
       return Math.sqrt( Math.pow(this.x - point.x,2) + Math.pow(this.y - point.y,2) );

    }


    public double get3DimensionalDistance(TDPoint tdPoint){

        //get the hypotenuse
        return Math.sqrt( Math.pow(this.x - tdPoint.x,2) + Math.pow(this.y - tdPoint.y,2) + Math.pow(this.z - tdPoint.z,2) );

    }


}
