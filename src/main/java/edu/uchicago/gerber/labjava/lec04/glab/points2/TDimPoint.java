package edu.uchicago.gerber.labjava.lec04.glab.points2;

import java.awt.*;

/**
 * Created by Adam on 10/17/2016.
 */
public class TDimPoint extends Point {

    public int z;


    public TDimPoint(int z) {
        this.z = z;
    }

    public TDimPoint(Point p, int z) {
        super(p);
        this.z = z;
    }

    public TDimPoint(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }



    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }






}
