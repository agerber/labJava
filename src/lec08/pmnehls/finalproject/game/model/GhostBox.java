package lec08.pmnehls.finalproject.game.model;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by pmnehls on 11/20/14.
 */
public class GhostBox extends Sprite
{
    private boolean isLid;

    public GhostBox(int x, int y)
    {
        super();

        if (y == 16 && (x == 14 || x == 15))
        {
            isLid = true;
        }
        ArrayList<Point> pntCs = new ArrayList<Point>();



        if (isLid)
        {
            pntCs.add(new Point(1, 5));
            pntCs.add(new Point(1, -5));
            pntCs.add(new Point(-1, -5));
            pntCs.add(new Point(-1, 5));

            assignPolarPoints(pntCs);
            setColor(Color.WHITE);
            setRadius(8);
        }
        else
        {
            pntCs.add(new Point(1, 1));
            pntCs.add(new Point(1, -1));
            pntCs.add(new Point(-1, -1));
            pntCs.add(new Point(-1, 1));

            assignPolarPoints(pntCs);
            setColor(new Color(0,0,180));
            setRadius(6);
        }

        int nHeight = TargetSpace.TS_HEIGHT;
        int nWidth = TargetSpace.TS_WIDTH;

        setCenter(new Point(nWidth * (x - 1) + nWidth/2, nHeight * (y - 1) + nHeight/2));

    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.fillPolygon(getXcoords(), getYcoords(), dDegrees.length);
    }
}
