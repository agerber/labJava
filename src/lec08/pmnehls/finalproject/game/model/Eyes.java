package lec08.pmnehls.finalproject.game.model;

import lec08.pmnehls.finalproject.sounds.Sound;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by pmnehls on 12/3/14.
 */
public class Eyes extends Sprite
{
    private Movable ghost;

    public Eyes(Movable ghost) {
        super();

        ArrayList<Point> pntCs = new ArrayList<Point>();

        pntCs.add(new Point(-5, -1));
        pntCs.add(new Point(-5, 2));
        pntCs.add(new Point(-4, 2));
        pntCs.add(new Point(-4, 3));
        pntCs.add(new Point(-2, 3));
        pntCs.add(new Point(-2, 2));
        pntCs.add(new Point(-1, 2));
        pntCs.add(new Point(-1, 0));
        pntCs.add(new Point(1, 0));
        pntCs.add(new Point(1, 2));
        pntCs.add(new Point(2, 2));
        pntCs.add(new Point(2, 3));
        pntCs.add(new Point(4, 3));
        pntCs.add(new Point(4, 2));
        pntCs.add(new Point(5, 2));
        pntCs.add(new Point(5, -1));
        pntCs.add(new Point(4, -1));
        pntCs.add(new Point(4, -2));
        pntCs.add(new Point(2, -2));
        pntCs.add(new Point(2, -1));
        pntCs.add(new Point(1, -1));
        pntCs.add(new Point(1, 0));
        pntCs.add(new Point(-1, 0));
        pntCs.add(new Point(-1, -1));
        pntCs.add(new Point(-2, -1));
        pntCs.add(new Point(-2, -2));
        pntCs.add(new Point(-4, -2));
        pntCs.add(new Point(-4, -1));

        assignPolarPoints(pntCs);

        setColor(Color.WHITE);

        this.ghost = ghost;
        setCenter(ghost.getCenter());

        //facing left
        setOrientation(270);

        //this is the size of Eyes
        setRadius(6);

    }

    public void draw(Graphics g)
    {
        super.draw(g);
        g.fillPolygon(getXcoords(), getYcoords(), dDegrees.length);
    }

    public void move()
    {
        super.move();

        setCenter(ghost.getCenter());
    }

    public Movable getGhost()
    {
        return ghost;
    }
}

