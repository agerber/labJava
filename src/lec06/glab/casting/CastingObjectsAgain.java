package lec06.glab.casting;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Created by Adam on 5/2/2016.
 */
public class CastingObjectsAgain {


    //consider the

    public static void main(String[] args) {
        Object objMe = new Rectangle(1,2,3,4);

       // Rectangle recMe = new Object();

        Rectangle2D rec2dMe = (Rectangle2D) objMe;
        System.out.println(rec2dMe.getX());

        System.out.println(rec2dMe.getClass());


        Rectangle recMeAgain = (Rectangle) rec2dMe;
        System.out.println(recMeAgain.getX());


        Shape shpMe = (Shape) recMeAgain;
        System.out.println(shpMe.getBounds().getX());

       // DefaultCaret carMe = (DefaultCaret) shpMe;

       // Date datMe = (Date) objMe;






    }

}

