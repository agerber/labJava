package lec08.pmnehls.finalproject.game.model;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by pmnehls on 11/23/14.
 */
public class Life extends Sprite
{
    public Life(int x, int y)
    {
        super();

        ArrayList<Point> pntCs = new ArrayList<Point>();

        pntCs.add(new Point(3, 7));
        pntCs.add(new Point(3, 6));
        pntCs.add(new Point(5, 6));
        pntCs.add(new Point(5, 5));
        pntCs.add(new Point(6, 5));
        pntCs.add(new Point(6, 3));
        pntCs.add(new Point(4, 3));
        pntCs.add(new Point(4, 2));
        pntCs.add(new Point(1, 2));
        pntCs.add(new Point(1, 1));
        pntCs.add(new Point(-2, 1));
        pntCs.add(new Point(-2, 0));
        pntCs.add(new Point(1, 0));
        pntCs.add(new Point(1, -1));
        pntCs.add(new Point(4, -1));
        pntCs.add(new Point(4, -2));
        pntCs.add(new Point(6, -2));
        pntCs.add(new Point(6, -4));
        pntCs.add(new Point(5, -4));
        pntCs.add(new Point(5, -5));
        pntCs.add(new Point(3, -5));
        pntCs.add(new Point(3, -6));
        pntCs.add(new Point(-2, -6));
        pntCs.add(new Point(-2, -5));
        pntCs.add(new Point(-4, -5));
        pntCs.add(new Point(-4, -4));
        pntCs.add(new Point(-5, -4));
        pntCs.add(new Point(-5, -2));
        pntCs.add(new Point(-6, -2));
        pntCs.add(new Point(-6, 3));
        pntCs.add(new Point(-5, 3));
        pntCs.add(new Point(-5, 5));
        pntCs.add(new Point(-4, 5));
        pntCs.add(new Point(-4, 6));
        pntCs.add(new Point(-2, 6));
        pntCs.add(new Point(-2, 7));

        assignPolarPoints(pntCs);

        setColor(Color.yellow);

        //put life in correct location
        setCenter(new Point(x, y - TargetSpace.TS_HEIGHT/4));

        setOrientation(270);

        setRadius(12);
    }

    public void draw(Graphics g)
    {
        super.draw(g);
        g.fillPolygon(getXcoords(), getYcoords(), dDegrees.length);
    }



}
