package lec08.pmnehls.finalproject.game.model;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by pmnehls on 12/1/14.
 */
public class Cherry extends Sprite
{

    public Cherry()
    {
        super();

        ArrayList<Point> pntCs = new ArrayList<Point>();

        pntCs.add(new Point(6, 6));
        pntCs.add(new Point(6, 4));
        pntCs.add(new Point(4, 4));
        pntCs.add(new Point(4, 2));
        pntCs.add(new Point(3, 2));
        pntCs.add(new Point(3, 1));
        pntCs.add(new Point(2, 1));
        pntCs.add(new Point(2, 0));
        pntCs.add(new Point(4, 0));
        pntCs.add(new Point(4, -1));
        pntCs.add(new Point(5, -1));
        pntCs.add(new Point(5, -5));
        pntCs.add(new Point(4, -5));
        pntCs.add(new Point(4, -6));
        pntCs.add(new Point(0, -6));
        pntCs.add(new Point(0, -5));
        pntCs.add(new Point(-1, -5));
        pntCs.add(new Point(-1, -1));
        pntCs.add(new Point(0, -1));
        pntCs.add(new Point(0, 0));
        pntCs.add(new Point(1, 0));
        pntCs.add(new Point(1, 1));
        pntCs.add(new Point(2, 1));
        pntCs.add(new Point(2, 2));
        pntCs.add(new Point(3, 2));
        pntCs.add(new Point(3, 4));
        pntCs.add(new Point(2, 4));
        pntCs.add(new Point(2, 3));
        pntCs.add(new Point(0, 3));
        pntCs.add(new Point(0, 2));
        pntCs.add(new Point(-1, 2));
        pntCs.add(new Point(-1, 1));
        pntCs.add(new Point(0, 1));
        pntCs.add(new Point(0, 0));
        pntCs.add(new Point(-1, 0));
        pntCs.add(new Point(-1, -1));
        pntCs.add(new Point(-2, -1));
        pntCs.add(new Point(-2, -4));
        pntCs.add(new Point(-5, -4));
        pntCs.add(new Point(-5, -3));
        pntCs.add(new Point(-6, -3));
        pntCs.add(new Point(-6, 1));
        pntCs.add(new Point(-5, 1));
        pntCs.add(new Point(-5, 2));
        pntCs.add(new Point(-1, 2));
        pntCs.add(new Point(-1, 3));
        pntCs.add(new Point(0, 3));
        pntCs.add(new Point(0, 4));
        pntCs.add(new Point(2, 4));
        pntCs.add(new Point(2, 5));
        pntCs.add(new Point(3, 5));
        pntCs.add(new Point(3, 6));

        assignPolarPoints(pntCs);

        setColor(Color.RED);

        //put cherry in correct location
        setCenter(new Point(TargetSpace.TS_WIDTH*(14),
                TargetSpace.TS_HEIGHT*(20) + TargetSpace.TS_HEIGHT/2));

        setOrientation(270);

        setRadius(14);
    }

    public void draw(Graphics g)
    {
        super.draw(g);
        g.fillPolygon(getXcoords(), getYcoords(), dDegrees.length);
    }
}
