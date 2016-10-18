package lec04.glab.points2;

import java.awt.*;

/**
 * Created by Adam on 10/17/2016.
 */
public class PointsDriver {
    public static void main(String[] args) {

        TDimPoint tDimPoint1 = new TDimPoint(7,8,9);
        System.out.println(tDimPoint1.getZ());
        Point point = (Point) tDimPoint1;
        System.out.println(point.getX());

       // Number num = new Number();




    }
}
