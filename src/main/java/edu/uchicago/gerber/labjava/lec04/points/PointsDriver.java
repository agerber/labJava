package edu.uchicago.gerber.labjava.lec04.points;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adam on 10/16/2016.
 */
public class PointsDriver {
    public static void main(String[] args) {

        List<TDPoint> points = new ArrayList<>();
        points.add(new TDPoint(7,8,9));
        points.add(new TDPoint(17,18,99));
        points.add(new TDPoint(47,88,94));


        System.out.println( getPerimeter2D(points));
        System.out.println( getPerimeter3D(points));



    }

    private static double getPerimeter3D(List<TDPoint> points) {
        TDPoint currentPoint = points.get(0);
        double dDistance =0;
        for (int nC = 1; nC < points.size(); nC++) {

            TDPoint nextPoint = points.get(nC);
            dDistance += currentPoint.get3DimensionalDistance(nextPoint);
            currentPoint = nextPoint;
        }
        return dDistance;
    }


    private static double getPerimeter2D(List<TDPoint> points) {
        TDPoint currentPoint = points.get(0);
        double dDistance =0;
        for (int nC = 1; nC < points.size(); nC++) {

            TDPoint nextPoint = points.get(nC);
            dDistance += currentPoint.get2DimensionalDistance(nextPoint);
            currentPoint = nextPoint;
        }
        return dDistance;
    }




}
