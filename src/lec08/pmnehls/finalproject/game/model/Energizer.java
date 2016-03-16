package lec08.pmnehls.finalproject.game.model;

import lec08.pmnehls.finalproject.controller.Game;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by pmnehls on 11/19/14.
 */
public class Energizer extends Sprite
{
    private int nEnergizerX;
    private int nEnergizerY;
    public Energizer(int x, int y)
    {
        super();

        nEnergizerX = x;
        nEnergizerY = y;

        ArrayList<Point> pntCs = new ArrayList<Point>();

        pntCs.add(new Point(2, 4));
        pntCs.add(new Point(4, 2));
        pntCs.add(new Point(4, -2));
        pntCs.add(new Point(2, -4));
        pntCs.add(new Point(-2, -4));
        pntCs.add(new Point(-4, -2));
        pntCs.add(new Point(-4, 2));
        pntCs.add(new Point(-2, 4));

        assignPolarPoints(pntCs);

        setColor(new Color(200,200,200));

        int nHeight = TargetSpace.TS_HEIGHT;
        int nWidth = TargetSpace.TS_WIDTH;

        setCenter(new Point(nHeight * (x - 1) + nHeight/2, nWidth * (y - 1) + nWidth/2));

        setRadius(8);

    }

    public void draw(Graphics g) {
        super.draw(g);
        g.fillPolygon(getXcoords(), getYcoords(), dDegrees.length);
    }

}
