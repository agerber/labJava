package lec08.pmnehls.finalproject.game.model;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by pmnehls on 12/4/14.
 */
public class ProtonPackDisplay extends Sprite
{

    public ProtonPackDisplay(int x, int y)
    {
        super();

        ArrayList<Point> pntCs = new ArrayList<Point>();

        pntCs.add(new Point(-1, -6));
        pntCs.add(new Point(0, -6));
        pntCs.add(new Point(2, -4));
        pntCs.add(new Point(2, -2));
        pntCs.add(new Point(1, -1));
        pntCs.add(new Point(1, 3));
        pntCs.add(new Point(2, 3));
        pntCs.add(new Point(2, 1));
        pntCs.add(new Point(3, 0));
        pntCs.add(new Point(3, 7));
        pntCs.add(new Point(4, 7));
        pntCs.add(new Point(4, -4));
        pntCs.add(new Point(0, -7));
        pntCs.add(new Point(-1, -7));
        pntCs.add(new Point(-1, -6));
        pntCs.add(new Point(-2, -6));
        pntCs.add(new Point(-2, -8));
        pntCs.add(new Point(0, -8));
        pntCs.add(new Point(5, -4));
        pntCs.add(new Point(5, 7));
        pntCs.add(new Point(4, 8));
        pntCs.add(new Point(3, 8));
        pntCs.add(new Point(2, 7));
        pntCs.add(new Point(2, 4));
        pntCs.add(new Point(-5, 4));
        pntCs.add(new Point(-5, 5));
        pntCs.add(new Point(-6, 5));
        pntCs.add(new Point(-6, 1));
        pntCs.add(new Point(-5, 1));
        pntCs.add(new Point(-5, -4));
        pntCs.add(new Point(-3, -6));

        assignPolarPoints(pntCs);

        setColor(Color.GRAY);

        //put pack display in correct location
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
