package lec08.pmnehls.finalproject.game.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by pmnehls on 12/3/14.
 */
public class Proton extends Sprite
{

    private Pacman pacman;

    public Proton(Pacman pacman)
    {
        super();

        ArrayList<Point> pntCs = new ArrayList<Point>();

        pntCs.add(new Point(0, 0));
        pntCs.add(new Point(0, 1));
        pntCs.add(new Point(6, 1));
        pntCs.add(new Point(6, 2));
        pntCs.add(new Point(13, 2));
        pntCs.add(new Point(13, 3));
        pntCs.add(new Point(17, 3));
        pntCs.add(new Point(17, -3));
        pntCs.add(new Point(13, -3));
        pntCs.add(new Point(13, -2));
        pntCs.add(new Point(6, -2));
        pntCs.add(new Point(6, -1));
        pntCs.add(new Point(0, -1));



        assignPolarPoints(pntCs);

        setColor(Color.WHITE);

        setCenter(pacman.getCenter());

        //facing left
        setOrientation(270);

        //this is the size of Eyes
        setRadius(30);

        this.pacman = pacman;



    }

    public void draw(Graphics g)
    {
        super.draw(g);
        g.fillPolygon(getXcoords(), getYcoords(), dDegrees.length);
    }

    public void move()
    {
        super.move();

        if (pacman.getOrientation() == 0)
        {
            setCenter(new Point(pacman.getCenter().x, pacman.getCenter().y - 12));
        }
        else if (pacman.getOrientation() == 90)
        {
            setCenter(new Point(pacman.getCenter().x + 12, pacman.getCenter().y));
        }
        else if (pacman.getOrientation() == 180)
        {
            setCenter(new Point(pacman.getCenter().x, pacman.getCenter().y + 12));
        }
        else if (pacman.getOrientation() == 270)
        {
            setCenter(new Point(pacman.getCenter().x - 12, pacman.getCenter().y));
        }

        Random ran = new Random();

        setColor(new Color(ran.nextInt(255), ran.nextInt(255), ran.nextInt(255)));

        setOrientation(pacman.getOrientation());
    }
}
