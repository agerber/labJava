package lec08.pmnehls.finalproject.game.model;

import java.awt.*;

/**
 * Created by pmnehls on 11/19/14.
 *
 * Target Spaces play a key role in this game. The grid is composed of 28x36 target spaces. The long equations below determine
 * which square is a wall, which is a dot, and which is empty. passing in an x,y value can tell a ghost or pacman what is in any
 * given square, telling them if they need to stop, turn, or if they are eating a dot
 */
public class TargetSpace extends Sprite
{
    private boolean isWall;
    private boolean isDot;
    private boolean isEmpty;
    private boolean isEnergizer;
    private boolean isGhostBox;
    private boolean isReachable;
    public static final int TS_HEIGHT= 16;
    public static final int TS_WIDTH = 16;
    private Sprite inside;
    private Point pCenter;
    private int nX;
    private int nY;

    public TargetSpace(int x, int y)
    {
        nX = x;
        nY = y;

        if((x == 2 && y == 7) || (x == 2 && y == 27) || (x == 27 && y == 7) || (x == 27 && y == 27))
        {
            isEnergizer = true;
            isReachable = true;
            this.inside = new Energizer(x, y);
        }
        else if (((y == 5 || y == 24) && (x != 1 && x != 14 && x!= 15 && x != 28)) || ((y == 9 || y == 33) && (x != 1 && x != 28))
            || ((y == 12 || y == 30) && ((x != 1 && x != 8 && x != 9 && x != 14 && x != 15 && x != 20 && x != 21 && x != 28)))
            || (y == 27 && ((x != 1 && x != 5 && x != 6 && x != 14 && x != 15 && x != 23 && x != 24 && x != 28)))
            || ((y == 6 || y == 8 || y == 25 || y == 26) && (x == 2 || x == 7 || x == 13 || x == 16 || x == 22 || x == 27 ))
            || (y == 7 && (x == 7 || x == 13 || x == 16 || x == 22))
            || ((y == 10 || y == 11) && (x == 2 || x == 7 || x == 10 || x == 19 || x == 22 || x == 27 ))
            || (y > 12 && y < 24) && (x == 7 || x == 22)
            || (y == 28 || y == 29) && (x == 4 || x == 7 || x == 10 || x == 19 || x == 22 || x == 25)
            || (y == 31 || y == 32) && (x == 2 || x == 13 || x == 16 || x == 27))
        {
            this.isDot = true;
            this.isReachable = true;
            this.inside = new Dot(x, y);
        }
        else if (((y == 13 || y == 14) && (x == 13 || x == 16)) || ((y == 15 || y == 21) && ( x > 9 && x < 20))
            || ((y == 16 || y == 17 || y == 18 || y == 19 || y == 20 || y == 21 || y == 23 || y == 24) && (x == 10 || x == 19))
            || (y == 18 && (x != 7 && x != 22 && (x < 11 || x > 18))) || (y == 27 && (x == 14 || x == 15))
            || (y == 22 && (x == 10 || x == 19)))
        {
            isEmpty = true;
            isReachable = true;
        }
        else if(y == 1 || y == 2 || y == 3 || y == 35 || y == 36 || (y == 7 && ( x == 4 || x == 5 || x == 9 || x == 10 || x == 11
            || x == 18 || x == 19 || x == 20 || x == 24 || x == 25 )) || ((y == 14 || y == 15 || y == 16 || y == 20
            || y == 21 || y == 22) && ( x < 6 || x > 23)))
        {
            isEmpty = true;
        }
        else if ((y > 15 && y < 21 ) && (x > 10 && x < 19 ))
        {
            if (y == 16 || y == 20)
            {
                isGhostBox = true;
                isWall = true;
            }
            else if (x == 11 || x == 18)
            {
                isGhostBox = true;
                isWall = true;
            }

        }
        else
        {
            isWall = true;
            this.inside = new Wall(x ,y );
        }

        pCenter = new Point(TS_HEIGHT * (x-1) + TS_HEIGHT/2, TS_WIDTH * (y-1) + TS_WIDTH/2);
        setCenter(new Point(pCenter));

    }

    public boolean getIsWall()
    {
        return isWall;
    }

    public boolean getIsDot()
    {
        return isDot;
    }

    public void setIsDot(boolean isDot)
    {
        this.isDot = isDot;
    }

    public boolean getIsEmpty()
    {
        return isEmpty;
    }

    public boolean getIsEnergizer()
    {
        return isEnergizer;
    }

    public void setIsEnergizer(boolean isEnergizer)
    {
        this.isEnergizer = isEnergizer;
    }


    public boolean getIsGhostBox()
    {
        return isGhostBox;
    }
    public boolean getIsReachable()
    {
        return isReachable;
    }

    public Movable getInside()
    {
        return inside;
    }

    public Point getTargetCenter()
    {
        return pCenter;
    }

    public int getSpaceX()
    {
        return nX;
    }

    public void setSpaceX(int x)
    {
        this.nX = x;
    }

    public int getSpaceY()
    {
        return nY;
    }

    public void setSpaceY(int y)
    {
        this.nY = y;
    }

    public Point getSpacePoint()
    {
        return new Point(nX, nY);
    }

    public Point getSpaceCenterCoord()
    {
        return pCenter;
    }

    @Override
    public void setRespawn(boolean bRespawn)
    {

    }
}
