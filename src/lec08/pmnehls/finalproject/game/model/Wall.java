package lec08.pmnehls.finalproject.game.model;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by pmnehls on 11/19/14.
 */
public class Wall extends Sprite
{

    public Wall(int x, int y)
    {
        super();

        ArrayList<Point> pntCs = new ArrayList<Point>();

        //simple square wall
        pntCs.add(new Point(1, 1));
        pntCs.add(new Point(1, -1));
        pntCs.add(new Point(-1, -1));
        pntCs.add(new Point(-1, 1));

        assignPolarPoints(pntCs);

        setColor(new Color(0,0,180));

        setCenter(new Point(TargetSpace.TS_WIDTH * x - TargetSpace.TS_WIDTH/2,
                TargetSpace.TS_HEIGHT* y - TargetSpace.TS_HEIGHT/2));

        setRadius(6);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.fillPolygon(getXcoords(), getYcoords(), dDegrees.length);
    }

}
