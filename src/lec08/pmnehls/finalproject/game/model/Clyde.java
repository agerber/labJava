package lec08.pmnehls.finalproject.game.model;

import lec08.pmnehls.finalproject.controller.Game;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by pmnehls on 11/30/14.
 *
 *  * Ghost Logic is true to the original Pac-Man game. This logic is available on various sites online,
 * most references in this code come from http://home.comcast.net/~jpittman2/pacman/pacmandossier.html. All ghost logic
 * code is original.
 *
 * CLYDE- When Clyde is in Chase mode, he targets the square that Pac-Man is in. If, however, he gets within an eight
 * square radius of pac-man, he goes down to the bottom left corner
 */
public class Clyde extends Sprite
{
    private Point pGhostCenter;
    private int nDirection; // 0- left, 1- up, 2- right, 3-down
    private int nGhostSpeed = 3; //note to change this below in tunnel checker
    private Color ghostColor = new Color(255, 224, 97);


    //turn trigger booleans and variables
    private boolean bTurnsQueued;
    private boolean toTurnDown;
    private boolean toTurnLeft;
    private boolean toTurnUp;
    private boolean toTurnRight;
    private boolean bRecentTurn;
    private int nTurnTick;
    private int nXTurn;
    private int nYTurn;
    private int nDotLimit;

    //mode change booleans
    private boolean bFirstScatter;
    private boolean bFirstChase;
    private boolean bFirstScared;
    private boolean bModeSwitch;
    private static boolean bInsideBox;
    private boolean bRespawn;
    private boolean bTooClose; //this is a clyde only boolean which prevents him from reversing when a scatter is called
                               // due to him getting too close to pac-man

    //store nTick when mode switch is triggered
    private int nTickAtSwitch;




    //scatter target square information
    //private final Point scatterTargetPixel = new Point(TargetSpace.TS_HEIGHT*26 - TargetSpace.TS_HEIGHT/2,TargetSpace.TS_HEIGHT/2);
    private final Point scatterTargetSquare = new Point(1, 35);

    public Clyde()
    {
        super();

        ArrayList<Point> pntCs = new ArrayList<Point>();

        pntCs.add(new Point(-7, -7));
        pntCs.add(new Point(-6, -7));
        pntCs.add(new Point(-6, -6));
        pntCs.add(new Point(-5, -6));
        pntCs.add(new Point(-5, -5));
        pntCs.add(new Point(-4, -5));
        pntCs.add(new Point(-4, -6));
        pntCs.add(new Point(-3, -6));
        pntCs.add(new Point(-3, -7));
        pntCs.add(new Point(-1, -7));
        pntCs.add(new Point(-1, -5));
        pntCs.add(new Point(1, -5));
        pntCs.add(new Point(1, -7));
        pntCs.add(new Point(3, -7));
        pntCs.add(new Point(3, -6));
        pntCs.add(new Point(4, -6));
        pntCs.add(new Point(4, -5));
        pntCs.add(new Point(5, -5));
        pntCs.add(new Point(5, -6));
        pntCs.add(new Point(6, -6));
        pntCs.add(new Point(6, -7));
        pntCs.add(new Point(7, -7));
        pntCs.add(new Point(7, 2));
        pntCs.add(new Point(6, 2));
        pntCs.add(new Point(6, 4));
        pntCs.add(new Point(5, 4));
        pntCs.add(new Point(5, 5));
        pntCs.add(new Point(4, 5));
        pntCs.add(new Point(4, 6));
        pntCs.add(new Point(2, 6));
        pntCs.add(new Point(2, 7));
        pntCs.add(new Point(-2, 7));
        pntCs.add(new Point(-2, 6));
        pntCs.add(new Point(-4, 6));
        pntCs.add(new Point(-4, 5));
        pntCs.add(new Point(-5, 5));
        pntCs.add(new Point(-5, 4));
        pntCs.add(new Point(-6, 4));
        pntCs.add(new Point(-6, 2));
        pntCs.add(new Point(-7, 2));

        assignPolarPoints(pntCs);

        setColor(ghostColor);

        pGhostCenter = new Point(TargetSpace.TS_WIDTH*(16) - 1,
                TargetSpace.TS_HEIGHT*(17) + TargetSpace.TS_HEIGHT / 2  + 4);


        bInsideBox = true;
        setCenter(pGhostCenter);

        setOrientation(270);

        //set initial direction (left)
        nDirection = 0;

        setRadius(14);


    }

    public void move()
    {
        super.move();

        if(bInsideBox)
        {
            if (CommandCenter.getLevel() == 1)
            {
                nDotLimit = 90;
            }
            else if (CommandCenter.getLevel() == 2)
            {
                nDotLimit = 50;
            }
            else
            {
                nDotLimit = 0;
            }

            if(nDotLimit <= Game.getDotCounter())
            {
                Point pnt = getCenter();
                setCenter(new Point(pnt.x - 1, pnt.y));
                if (pnt.x <= TargetSpace.TS_WIDTH * (14))
                {
                    setCenter(new Point(TargetSpace.TS_WIDTH * 14, pnt.y - 2));
                    if (pnt.y <= TargetSpace.TS_HEIGHT * (14) + TargetSpace.TS_HEIGHT / 2)
                    {
                        nDirection = 0;
                        bInsideBox = false;
                    }
                }
            }
            else //waver up and down inside box
            {
                Point pnt = getCenter();
                if (Game.getnTick() % 16 < 8)
                {
                    setCenter(new Point(pnt.x, pnt.y - 2));
                }
                else
                {
                    setCenter(new Point(pnt.x, pnt.y + 2));
                }

            }
        }
        else
        {
            //change color for scared mode
            if (Game.getIsInvincible() && !bRespawn)
            {
                frightened();
                nGhostSpeed = 2;

                if (Game.getTickStore() + (23 * (Game.getScaredSeconds() - 3)) > Game.getnTick())
                {
                    setColor(Color.BLUE);
                } else if ((Game.getTickStore() + (23 * (Game.getScaredSeconds() - 1)) > Game.getnTick()))
                {
                    //flash slow with 3 seconds left
                    if (Game.getnTick() % 4 == 0 || Game.getnTick() % 4 == 1)
                    {
                        setColor(Color.WHITE);
                    } else
                    {
                        setColor(Color.BLUE);
                    }
                } else if ((Game.getTickStore() + (22 * (Game.getScaredSeconds())) > Game.getnTick()))
                {
                    //flash fast with two second left
                    if (Game.getnTick() % 2 == 0)
                    {
                        setColor(Color.WHITE);
                    } else
                    {
                        setColor(Color.BLUE);
                    }
                } else
                {
                    Game.setIsInvincible(false);
                    Game.setnTick(Game.getTickStore());
                    setColor(ghostColor);
                    bFirstScatter = false;
                    bFirstChase = false;
                    bFirstScared = false;
                    nGhostSpeed = 3;
                }
            }
            else if (Game.getIsInvincible())
            {
                chase();
            }

            //get Clyde's Center
            Point pnt = getCenter();

            //slow down if ghost is in tunnel
            if (getGhostSpaceCoord().y == 18 && (getGhostSpaceCoord().x < 5 ||
                    getGhostSpaceCoord().x > 24))
            {
                nGhostSpeed = 2;
            } else if (!Game.getIsInvincible())
            {
                nGhostSpeed = 3;
            }

            if (nDirection == 0) //moving left
            {
                setCenter(new Point(pnt.x - nGhostSpeed, pnt.y));
            }

            if (nDirection == 1) //moving up
            {
                setCenter(new Point(pnt.x, pnt.y - nGhostSpeed));
            }

            if (nDirection == 2) //moving right
            {
                setCenter(new Point(pnt.x + nGhostSpeed, pnt.y));
            }

            if (nDirection == 3) //moving down
            {
                setCenter(new Point(pnt.x, pnt.y + nGhostSpeed));
            }

            if (toTurnDown)
            {

                if (nDirection == 0)
                {
                    if (pGhostCenter.x <= nXTurn)
                    {
                        nDirection = 3;
                        setCenter(new Point(nXTurn, pGhostCenter.y));
                        toTurnDown = false;
                        bTurnsQueued = false;
                        bRecentTurn = true;
                        nTurnTick = Game.getnTick();
                    }
                } else if (nDirection == 2)
                {
                    if (pGhostCenter.x >= nXTurn)
                    {
                        nDirection = 3;
                        setCenter(new Point(nXTurn, pGhostCenter.y));
                        toTurnDown = false;
                        bTurnsQueued = false;
                        bRecentTurn = true;
                        nTurnTick = Game.getnTick();
                    }
                }
            }

            if (toTurnUp)
            {

                if (nDirection == 0)
                {
                    if (pGhostCenter.x <= nXTurn)
                    {
                        nDirection = 1;
                        setCenter(new Point(nXTurn, pGhostCenter.y));
                        toTurnUp = false;
                        bTurnsQueued = false;
                        bRecentTurn = true;
                        nTurnTick = Game.getnTick();
                    }
                } else if (nDirection == 2)
                {
                    if (pGhostCenter.x >= nXTurn)
                    {
                        nDirection = 1;
                        setCenter(new Point(nXTurn, pGhostCenter.y));
                        toTurnUp = false;
                        bTurnsQueued = false;
                        bRecentTurn = true;
                        nTurnTick = Game.getnTick();
                    }
                }
            }

            if (toTurnRight)
            {
                if (nDirection == 1)
                {
                    if (pGhostCenter.y <= nYTurn)
                    {
                        nDirection = 2;
                        setCenter(new Point(pGhostCenter.x, nYTurn));
                        toTurnRight = false;
                        bTurnsQueued = false;
                        bRecentTurn = true;
                        nTurnTick = Game.getnTick();
                    }
                } else if (nDirection == 3)
                {
                    if (pGhostCenter.y >= nYTurn)
                    {
                        nDirection = 2;
                        setCenter(new Point(pGhostCenter.x, nYTurn));
                        toTurnRight = false;
                        bTurnsQueued = false;
                        bRecentTurn = true;
                        nTurnTick = Game.getnTick();
                    }
                }
            }

            if (toTurnLeft)
            {
                if (nDirection == 1)
                {
                    if (pGhostCenter.y <= nYTurn)
                    {
                        nDirection = 0;
                        setCenter(new Point(pGhostCenter.x, nYTurn));
                        toTurnLeft = false;
                        bTurnsQueued = false;
                        bRecentTurn = true;
                        nTurnTick = Game.getnTick();
                    }
                }
                if (nDirection == 3)
                {
                    if (pGhostCenter.y >= nYTurn)
                    {
                        nDirection = 0;
                        setCenter(new Point(pGhostCenter.x, nYTurn));
                        toTurnLeft = false;
                        bTurnsQueued = false;
                        bRecentTurn = true;
                        nTurnTick = Game.getnTick();
                    }
                }
            }

            if (!Game.getIsInvincible())
            {
                //switch modes until perpetual chase cycle
                if (Game.getnTick() <= 154)
                {
                    scatter();
                }

                if (Game.getnTick() > 154 && Game.getnTick() <= 594)
                {
                    chase();
                }
                if (Game.getnTick() > 594 && Game.getnTick() <= 748)
                {
                    scatter();
                }
                if (Game.getnTick() > 748 && Game.getnTick() <= 1188)
                {
                    chase();
                }
                if (Game.getnTick() > 1188 && Game.getnTick() <= 1342)
                {
                    scatter();
                }
                if (Game.getnTick() > 1342 && Game.getnTick() <= 1782)
                {
                    chase();
                }
                if (Game.getnTick() > 1782 && Game.getnTick() <= 1936)
                {
                    scatter();
                }
                if (Game.getnTick() > 1936)
                {
                    chase();
                }
            }

            //handle case where reversal is triggered and ghost is still in same square after turn trigger
            if (bRecentTurn)
            {
                if (nTurnTick + 4 < Game.getnTick())
                {
                    bRecentTurn = false;
                }
            }
        }

        pGhostCenter = getCenter();

    }

    public void scatter()
    {
        nGhostSpeed = 3;
        setColor(ghostColor);

        //reverses ghost direction if the scatter call is not the initial scatter
        if (bFirstScatter)
        {
            if (!bTurnsQueued && !bRecentTurn && !bTooClose) //reverse direction if turn queue is not loaded
            {
                nDirection = (nDirection + 2) % 4;
            }

        }
        bFirstScatter = false;
        bFirstChase = true;
        bFirstScared = true;

        Point scatterTarget = scatterTargetSquare;
        TargetSpace targetSquare = new TargetSpace(scatterTarget.x, scatterTarget.y);
        Point currPnt = getGhostSpaceCoord();

        //target spaces for tests for next move
        TargetSpace L = new TargetSpace(currPnt.x - 2, currPnt.y);
        TargetSpace LU = new TargetSpace(currPnt.x - 1, currPnt.y - 1);
        TargetSpace U = new TargetSpace(currPnt.x, currPnt.y - 2);
        TargetSpace UR = new TargetSpace(currPnt.x + 1, currPnt.y - 1);
        TargetSpace R = new TargetSpace(currPnt.x + 2, currPnt.y);
        TargetSpace RD = new TargetSpace(currPnt.x + 1, currPnt.y + 1);
        TargetSpace D = new TargetSpace(currPnt.x, currPnt.y + 2);
        TargetSpace DL = new TargetSpace(currPnt.x - 1, currPnt.y + 1);

        //Adjacent target spaces
        TargetSpace AL = new TargetSpace(currPnt.x -1, currPnt.y);
        TargetSpace AU = new TargetSpace(currPnt.x, currPnt.y - 1);
        TargetSpace AR = new TargetSpace(currPnt.x + 1, currPnt.y);
        TargetSpace AD = new TargetSpace(currPnt.x, currPnt.y + 1);


        if (nDirection == 0 && !bTurnsQueued)
        {
            //first handle cases with no choice to be made

            if (LU.getIsWall() && L.getIsWall() && !DL.getIsWall()) // turn down at corner
            {
                toTurnDown = true;
                bTurnsQueued = true;
                Point turn = AL.getTargetCenter();
                nXTurn = turn.x;

            }
            if (DL.getIsWall() && L.getIsWall() && !LU.getIsWall()) // turn up at corner
            {
                toTurnUp = true;
                bTurnsQueued = true;
                Point turn = AL.getTargetCenter();
                nXTurn = turn.x;
            }
            if (L.getIsWall() && !LU.getIsWall() && !DL.getIsWall()) //handle two way intersection with wall in front
            {
                // get center point of both possible squares to go to
                Point option1 = LU.getTargetCenter();
                Point option2 = DL.getTargetCenter();
                Point target = targetSquare.getTargetCenter();
                double dist1 = getDistance(option1, target);
                double dist2 = getDistance(option2, target);

                if (dist1 < dist2)
                {
                    toTurnUp = true;
                    bTurnsQueued = true;
                    Point turn = AL.getTargetCenter();
                    nXTurn = turn.x;
                }
                else
                {
                    toTurnDown = true;
                    bTurnsQueued = true;
                    Point turn = AL.getTargetCenter();
                    nXTurn = turn.x;
                }

            }
            if (DL.getIsWall() && !L.getIsWall() && !LU.getIsWall()) //handle 3way junction up/left
            {
                // get center point of both possible squares to go to
                Point option1 = LU.getTargetCenter();
                Point option2 = L.getTargetCenter();
                Point target = targetSquare.getTargetCenter();
                double dist1 = getDistance(option1, target);
                double dist2 = getDistance(option2, target);

                if (dist1 < dist2)
                {
                    toTurnUp = true;
                    bTurnsQueued = true;
                    Point turn = AL.getTargetCenter();
                    nXTurn = turn.x;
                }
            }
            if (!DL.getIsWall() && !L.getIsWall() && LU.getIsWall()) //handle 3way junction down/left
            {
                // get center point of both possible squares to go to
                Point option1 = DL.getTargetCenter();
                Point option2 = L.getTargetCenter();
                Point target = targetSquare.getTargetCenter();
                double dist1 = getDistance(option1, target);
                double dist2 = getDistance(option2, target);

                if (dist1 < dist2)
                {
                    toTurnDown = true;
                    bTurnsQueued = true;
                    Point turn = AL.getTargetCenter();
                    nXTurn = turn.x;
                }
            }
            if (!L.getIsWall() && !LU.getIsWall() && !DL.getIsWall()) // 4 way intersection
            {
                Point option1 = LU.getTargetCenter();
                Point option2 = DL.getTargetCenter();
                Point option3 = L.getTargetCenter();
                Point target = targetSquare.getTargetCenter();
                double dist1 = getDistance(option1, target);
                double dist2 = getDistance(option2, target);
                double dist3 = getDistance(option3, target);

                if(dist1 < dist2 && dist1 < dist3)
                {
                    toTurnUp = true;
                    bTurnsQueued = true;
                    Point turn = AL.getTargetCenter();
                    nXTurn = turn.x;
                }
                else if (dist2 < dist1 && dist2 < dist3)
                {
                    toTurnDown = true;
                    bTurnsQueued = true;
                    Point turn = AL.getTargetCenter();
                    nXTurn = turn.x;
                }

            }

        }
        if (nDirection == 1 && !bTurnsQueued)
        {
            //first handle no choice turns
            if(LU.getIsWall() && U.getIsWall() && !UR.getIsWall()) // turn right at corner
            {
                toTurnRight = true;
                bTurnsQueued = true;
                Point turn = AU.getTargetCenter();
                nYTurn = turn.y;
            }
            if(U.getIsWall() && UR.getIsWall() && !LU.getIsWall()) // turn left at corner
            {
                toTurnLeft = true;
                bTurnsQueued = true;
                Point turn = AU.getTargetCenter();
                nYTurn = turn.y;
            }
            if(U.getIsWall() && !LU.getIsWall() && !UR.getIsWall())//T intersection
            {
                Point option1 = LU.getTargetCenter();
                Point option2 = UR.getTargetCenter();
                Point target = targetSquare.getTargetCenter();
                double dist1 = getDistance(option1, target);
                double dist2 = getDistance(option2, target);

                if (dist1 < dist2)
                {
                    toTurnLeft = true;
                    bTurnsQueued = true;
                    Point turn = AU.getTargetCenter();
                    nYTurn = turn.y;
                }
                else
                {
                    toTurnRight = true;
                    bTurnsQueued = true;
                    Point turn = AU.getTargetCenter();
                    nYTurn = turn.y;
                }
            }
            if(LU.getIsWall() && !U.getIsWall() && !UR.getIsWall())//3way intersection up, right
            {
                Point option1 = U.getTargetCenter();
                Point option2 = UR.getTargetCenter();
                Point target = targetSquare.getTargetCenter();
                double dist1 = getDistance(option1, target);
                double dist2 = getDistance(option2, target);

                if (dist1 > dist2)
                {
                    toTurnRight = true;
                    bTurnsQueued = true;
                    Point turn = AU.getTargetCenter();
                    nYTurn = turn.y;
                }
            }
            if(!LU.getIsWall() && !U.getIsWall() && UR.getIsWall())//3way intersection up, left
            {
                Point option1 = LU.getTargetCenter();
                Point option2 = U.getTargetCenter();
                Point target = targetSquare.getTargetCenter();
                double dist1 = getDistance(option1, target);
                double dist2 = getDistance(option2, target);

                if (dist1 < dist2)
                {
                    toTurnLeft = true;
                    bTurnsQueued = true;
                    Point turn = AU.getTargetCenter();
                    nYTurn = turn.y;
                }
            }
            if (!LU.getIsWall() && !U.getIsWall() && !UR.getIsWall()) //4way intersection
            {
                Point option1 = LU.getTargetCenter();
                Point option2 = UR.getTargetCenter();
                Point option3 = U.getTargetCenter();
                Point target = targetSquare.getTargetCenter();
                double dist1 = getDistance(option1, target);
                double dist2 = getDistance(option2, target);
                double dist3 = getDistance(option3, target);

                if (dist1 < dist2 && dist1 < dist3)
                {
                    toTurnLeft = true;
                    bTurnsQueued = true;
                    Point turn = AU.getTargetCenter();
                    nYTurn = turn.y;
                }
                else if (dist2 < dist1 && dist2 < dist3)
                {
                    toTurnRight = true;
                    bTurnsQueued = true;
                    Point turn = AU.getTargetCenter();
                    nYTurn = turn.y;
                }
            }

        }
        if (nDirection == 2 && !bTurnsQueued)
        {
            if(RD.getIsWall() && R.getIsWall() && !UR.getIsWall())//turn up at corner
            {
                toTurnUp = true;
                bTurnsQueued = true;
                Point turn = AR.getTargetCenter();
                nXTurn = turn.x;
            }
            if(UR.getIsWall() && R.getIsWall() && !RD.getIsWall())//turn down at corner
            {
                toTurnDown = true;
                bTurnsQueued = true;
                Point turn = AR.getTargetCenter();
                nXTurn = turn.x;
            }
            if(R.getIsWall() && !UR.getIsWall() && !RD.getIsWall()) //T intersection
            {
                Point option1 = UR.getTargetCenter();
                Point option2 = RD.getTargetCenter();
                Point target = targetSquare.getTargetCenter();
                double dist1 = getDistance(option1, target);
                double dist2 = getDistance(option2, target);

                if (dist1 < dist2)
                {
                    toTurnUp = true;
                    bTurnsQueued = true;
                    Point turn = AR.getTargetCenter();
                    nXTurn = turn.x;
                }
                else
                {
                    toTurnDown = true;
                    bTurnsQueued = true;
                    Point turn = AR.getTargetCenter();
                    nXTurn = turn.x;
                }
            }
            if (RD.getIsWall() && !R.getIsWall() && !UR.getIsWall())//3 way right up
            {
                Point option1 = UR.getTargetCenter();
                Point option2 = R.getTargetCenter();
                Point target = targetSquare.getTargetCenter();
                double dist1 = getDistance(option1, target);
                double dist2 = getDistance(option2, target);

                if (dist1 < dist2)
                {
                    toTurnUp = true;
                    bTurnsQueued = true;
                    Point turn = AR.getTargetCenter();
                    nXTurn = turn.x;
                }
            }
            if (UR.getIsWall() && !R.getIsWall() && !RD.getIsWall())//3 way right down
            {
                Point option1 = RD.getTargetCenter();
                Point option2 = R.getTargetCenter();
                Point target = targetSquare.getTargetCenter();
                double dist1 = getDistance(option1, target);
                double dist2 = getDistance(option2, target);

                if (dist1 < dist2)
                {
                    toTurnDown = true;
                    bTurnsQueued = true;
                    Point turn = AR.getTargetCenter();
                    nXTurn = turn.x;
                }
            }
            if (!UR.getIsWall() && !R.getIsWall() && !RD.getIsWall()) //4way intersection
            {
                Point option1 = UR.getTargetCenter();
                Point option2 = RD.getTargetCenter();
                Point option3 = R.getTargetCenter();
                Point target = targetSquare.getTargetCenter();
                double dist1 = getDistance(option1, target);
                double dist2 = getDistance(option2, target);
                double dist3 = getDistance(option3, target);

                if (dist1 < dist2 && dist1 < dist3)
                {
                    toTurnUp = true;
                    bTurnsQueued = true;
                    Point turn = AR.getTargetCenter();
                    nXTurn = turn.x;
                }
                else if (dist2 < dist1 && dist2 < dist3)
                {
                    toTurnDown = true;
                    bTurnsQueued = true;
                    Point turn = AR.getTargetCenter();
                    nXTurn = turn.x;
                }
            }
        }
        if (nDirection == 3 && !bTurnsQueued)
        {
            if(RD.getIsWall() && D.getIsWall() && !DL.getIsWall()) //turn left at corner
            {
                toTurnLeft = true;
                bTurnsQueued = true;
                Point turn = AD.getTargetCenter();
                nYTurn = turn.y;
            }
            if (DL.getIsWall() && D.getIsWall() && !RD.getIsWall()) //turn right at corner
            {
                toTurnRight = true;
                bTurnsQueued = true;
                Point turn = AD.getTargetCenter();
                nYTurn = turn.y;
            }
            if (D.getIsWall() && !RD.getIsWall() && !DL.getIsWall()) // T intersection
            {
                Point option1 = DL.getTargetCenter();
                Point option2 = RD.getTargetCenter();
                Point target = targetSquare.getTargetCenter();
                double dist1 = getDistance(option1, target);
                double dist2 = getDistance(option2, target);

                if (dist1 < dist2)
                {
                    toTurnLeft = true;
                    bTurnsQueued = true;
                    Point turn = AD.getTargetCenter();
                    nYTurn = turn.y;
                }
                else
                {
                    toTurnRight = true;
                    bTurnsQueued = true;
                    Point turn = AD.getTargetCenter();
                    nYTurn = turn.y;
                }
            }
            if (DL.getIsWall() && !D.getIsWall() && !RD.getIsWall()) //3 way intersection down right
            {
                Point option1 = RD.getTargetCenter();
                Point option2 = D.getTargetCenter();
                Point target = targetSquare.getTargetCenter();
                double dist1 = getDistance(option1, target);
                double dist2 = getDistance(option2, target);

                if (dist1 < dist2)
                {
                    toTurnRight = true;
                    bTurnsQueued = true;
                    Point turn = AD.getTargetCenter();
                    nYTurn = turn.y;
                }
            }
            if (!DL.getIsWall() && !D.getIsWall() && RD.getIsWall()) //3 way intersection down left
            {
                Point option1 = DL.getTargetCenter();
                Point option2 = D.getTargetCenter();
                Point target = targetSquare.getTargetCenter();
                double dist1 = getDistance(option1, target);
                double dist2 = getDistance(option2, target);

                if (dist1 < dist2)
                {
                    toTurnLeft = true;
                    bTurnsQueued = true;
                    Point turn = AD.getTargetCenter();
                    nYTurn = turn.y;
                }
            }
            if (!DL.getIsWall() && !D.getIsWall() && !RD.getIsWall()) //4 way intersection
            {
                Point option1 = DL.getTargetCenter();
                Point option2 = RD.getTargetCenter();
                Point option3 = D.getTargetCenter();
                Point target = targetSquare.getTargetCenter();
                double dist1 = getDistance(option1, target);
                double dist2 = getDistance(option2, target);
                double dist3 = getDistance(option3, target);

                if (dist1 < dist2 && dist1 < dist3)
                {
                    toTurnLeft = true;
                    bTurnsQueued = true;
                    Point turn = AD.getTargetCenter();
                    nYTurn = turn.y;
                }
                else if (dist2 < dist1 && dist2 < dist3)
                {
                    toTurnRight = true;
                    bTurnsQueued = true;
                    Point turn = AD.getTargetCenter();
                    nYTurn = turn.y;
                }
            }
        }


    }

    //CHASE MODE--------------------------------------------
    public void chase()
    {
        //set speed
        nGhostSpeed = 3;
        setColor(ghostColor);

        if (bFirstChase)
        {
            if (!bTurnsQueued && !bRecentTurn && !bTooClose) //reverse direction if turn queue is not loaded
            {
                nDirection = (nDirection + 2) % 4;
            }
        }
        bFirstChase = false;
        bFirstScatter = true;
        bFirstScared = true;

        if (CommandCenter.movPacman.size() !=0)
        {
            Point pacman = new Point(CommandCenter.movPacman.get(0).getCenter());
            int pacmanSpaceX = pacman.x / TargetSpace.TS_WIDTH;
            int pacmanSpaceY = pacman.y / TargetSpace.TS_HEIGHT;
            Point pacTarget = new Point(pacmanSpaceX + 1, pacmanSpaceY + 1);
            TargetSpace pacSquare = new TargetSpace(pacTarget.x, pacTarget.y);
            Point currPnt = getGhostSpaceCoord();

            //go to scatter mode if within an 8 space radius of pacman
            if(Math.abs(getDistance(pacman, getCenter())) < (TargetSpace.TS_HEIGHT * 8))
            {
                bTooClose = true;
                scatter();
            }

            //target spaces for tests for next move
            TargetSpace L = new TargetSpace(currPnt.x - 2, currPnt.y);
            TargetSpace LU = new TargetSpace(currPnt.x - 1, currPnt.y - 1);
            TargetSpace U = new TargetSpace(currPnt.x, currPnt.y - 2);
            TargetSpace UR = new TargetSpace(currPnt.x + 1, currPnt.y - 1);
            TargetSpace R = new TargetSpace(currPnt.x + 2, currPnt.y);
            TargetSpace RD = new TargetSpace(currPnt.x + 1, currPnt.y + 1);
            TargetSpace D = new TargetSpace(currPnt.x, currPnt.y + 2);
            TargetSpace DL = new TargetSpace(currPnt.x - 1, currPnt.y + 1);

            //Adjacent target spaces
            TargetSpace AL = new TargetSpace(currPnt.x - 1, currPnt.y);
            TargetSpace AU = new TargetSpace(currPnt.x, currPnt.y - 1);
            TargetSpace AR = new TargetSpace(currPnt.x + 1, currPnt.y);
            TargetSpace AD = new TargetSpace(currPnt.x, currPnt.y + 1);


            if (nDirection == 0 && !bTurnsQueued)
            {
                //first handle cases with no choice to be made

                if (LU.getIsWall() && L.getIsWall() && !DL.getIsWall()) // turn down at corner
                {
                    toTurnDown = true;
                    bTurnsQueued = true;
                    Point turn = AL.getTargetCenter();
                    nXTurn = turn.x;

                }
                if (DL.getIsWall() && L.getIsWall() && !LU.getIsWall()) // turn up at corner
                {
                    toTurnUp = true;
                    bTurnsQueued = true;
                    Point turn = AL.getTargetCenter();
                    nXTurn = turn.x;
                }
                if (L.getIsWall() && !LU.getIsWall() && !DL.getIsWall()) //handle two way intersection with wall in front
                {
                    // get center point of both possible squares to go to
                    Point option1 = LU.getTargetCenter();
                    Point option2 = DL.getTargetCenter();
                    Point target = pacSquare.getTargetCenter();
                    double dist1 = getDistance(option1, target);
                    double dist2 = getDistance(option2, target);

                    if (dist1 < dist2)
                    {
                        toTurnUp = true;
                        bTurnsQueued = true;
                        Point turn = AL.getTargetCenter();
                        nXTurn = turn.x;
                    } else
                    {
                        toTurnDown = true;
                        bTurnsQueued = true;
                        Point turn = AL.getTargetCenter();
                        nXTurn = turn.x;
                    }

                }
                if (DL.getIsWall() && !L.getIsWall() && !LU.getIsWall()) //handle 3way junction up/left
                {
                    // get center point of both possible squares to go to
                    Point option1 = LU.getTargetCenter();
                    Point option2 = L.getTargetCenter();
                    Point target = pacSquare.getTargetCenter();
                    double dist1 = getDistance(option1, target);
                    double dist2 = getDistance(option2, target);

                    if (dist1 < dist2)
                    {
                        toTurnUp = true;
                        bTurnsQueued = true;
                        Point turn = AL.getTargetCenter();
                        nXTurn = turn.x;
                    }
                }
                if (!DL.getIsWall() && !L.getIsWall() && LU.getIsWall()) //handle 3way junction down/left
                {
                    // get center point of both possible squares to go to
                    Point option1 = DL.getTargetCenter();
                    Point option2 = L.getTargetCenter();
                    Point target = pacSquare.getTargetCenter();
                    double dist1 = getDistance(option1, target);
                    double dist2 = getDistance(option2, target);

                    if (dist1 < dist2)
                    {
                        toTurnDown = true;
                        bTurnsQueued = true;
                        Point turn = AL.getTargetCenter();
                        nXTurn = turn.x;
                    }
                }
                if (!L.getIsWall() && !LU.getIsWall() && !DL.getIsWall()) // 4 way intersection
                {
                    Point option1 = LU.getTargetCenter();
                    Point option2 = DL.getTargetCenter();
                    Point option3 = L.getTargetCenter();
                    Point target = pacSquare.getTargetCenter();
                    double dist1 = getDistance(option1, target);
                    double dist2 = getDistance(option2, target);
                    double dist3 = getDistance(option3, target);

                    if (dist1 < dist2 && dist1 < dist3)
                    {
                        toTurnUp = true;
                        bTurnsQueued = true;
                        Point turn = AL.getTargetCenter();
                        nXTurn = turn.x;
                    } else if (dist2 < dist1 && dist2 < dist3)
                    {
                        toTurnDown = true;
                        bTurnsQueued = true;
                        Point turn = AL.getTargetCenter();
                        nXTurn = turn.x;
                    }

                }

            }
            if (nDirection == 1 && !bTurnsQueued)
            {
                //first handle no choice turns
                if (LU.getIsWall() && U.getIsWall() && !UR.getIsWall()) // turn right at corner
                {
                    toTurnRight = true;
                    bTurnsQueued = true;
                    Point turn = AU.getTargetCenter();
                    nYTurn = turn.y;
                }
                if (U.getIsWall() && UR.getIsWall() && !LU.getIsWall()) // turn left at corner
                {
                    toTurnLeft = true;
                    bTurnsQueued = true;
                    Point turn = AU.getTargetCenter();
                    nYTurn = turn.y;
                }
                if (U.getIsWall() && !LU.getIsWall() && !UR.getIsWall())//T intersection
                {
                    Point option1 = LU.getTargetCenter();
                    Point option2 = UR.getTargetCenter();
                    Point target = pacSquare.getTargetCenter();
                    double dist1 = getDistance(option1, target);
                    double dist2 = getDistance(option2, target);

                    if (dist1 < dist2)
                    {
                        toTurnLeft = true;
                        bTurnsQueued = true;
                        Point turn = AU.getTargetCenter();
                        nYTurn = turn.y;
                    } else
                    {
                        toTurnRight = true;
                        bTurnsQueued = true;
                        Point turn = AU.getTargetCenter();
                        nYTurn = turn.y;
                    }
                }
                if (LU.getIsWall() && !U.getIsWall() && !UR.getIsWall())//3way intersection up, right
                {
                    Point option1 = U.getTargetCenter();
                    Point option2 = UR.getTargetCenter();
                    Point target = pacSquare.getTargetCenter();
                    double dist1 = getDistance(option1, target);
                    double dist2 = getDistance(option2, target);

                    if (dist1 > dist2)
                    {
                        toTurnRight = true;
                        bTurnsQueued = true;
                        Point turn = AU.getTargetCenter();
                        nYTurn = turn.y;
                    }
                }
                if (!LU.getIsWall() && !U.getIsWall() && UR.getIsWall())//3way intersection up, left
                {
                    Point option1 = LU.getTargetCenter();
                    Point option2 = U.getTargetCenter();
                    Point target = pacSquare.getTargetCenter();
                    double dist1 = getDistance(option1, target);
                    double dist2 = getDistance(option2, target);

                    if (dist1 < dist2)
                    {
                        toTurnLeft = true;
                        bTurnsQueued = true;
                        Point turn = AU.getTargetCenter();
                        nYTurn = turn.y;
                    }
                }
                if (!LU.getIsWall() && !U.getIsWall() && !UR.getIsWall()) //4way intersection
                {
                    Point option1 = LU.getTargetCenter();
                    Point option2 = UR.getTargetCenter();
                    Point option3 = U.getTargetCenter();
                    Point target = pacSquare.getTargetCenter();
                    double dist1 = getDistance(option1, target);
                    double dist2 = getDistance(option2, target);
                    double dist3 = getDistance(option3, target);

                    if (dist1 < dist2 && dist1 < dist3)
                    {
                        toTurnLeft = true;
                        bTurnsQueued = true;
                        Point turn = AU.getTargetCenter();
                        nYTurn = turn.y;
                    } else if (dist2 < dist1 && dist2 < dist3)
                    {
                        toTurnRight = true;
                        bTurnsQueued = true;
                        Point turn = AU.getTargetCenter();
                        nYTurn = turn.y;
                    }
                }

            }
            if (nDirection == 2 && !bTurnsQueued)
            {
                if (RD.getIsWall() && R.getIsWall() && !UR.getIsWall())//turn up at corner
                {
                    toTurnUp = true;
                    bTurnsQueued = true;
                    Point turn = AR.getTargetCenter();
                    nXTurn = turn.x;
                }
                if (UR.getIsWall() && R.getIsWall() && !RD.getIsWall())//turn down at corner
                {
                    toTurnDown = true;
                    bTurnsQueued = true;
                    Point turn = AR.getTargetCenter();
                    nXTurn = turn.x;
                }
                if (R.getIsWall() && !UR.getIsWall() && !RD.getIsWall()) //T intersection
                {
                    Point option1 = UR.getTargetCenter();
                    Point option2 = RD.getTargetCenter();
                    Point target = pacSquare.getTargetCenter();
                    double dist1 = getDistance(option1, target);
                    double dist2 = getDistance(option2, target);

                    if (dist1 < dist2)
                    {
                        toTurnUp = true;
                        bTurnsQueued = true;
                        Point turn = AR.getTargetCenter();
                        nXTurn = turn.x;
                    } else
                    {
                        toTurnDown = true;
                        bTurnsQueued = true;
                        Point turn = AR.getTargetCenter();
                        nXTurn = turn.x;
                    }
                }
                if (RD.getIsWall() && !R.getIsWall() && !UR.getIsWall())//3 way right up
                {
                    Point option1 = UR.getTargetCenter();
                    Point option2 = R.getTargetCenter();
                    Point target = pacSquare.getTargetCenter();
                    double dist1 = getDistance(option1, target);
                    double dist2 = getDistance(option2, target);

                    if (dist1 < dist2)
                    {
                        toTurnUp = true;
                        bTurnsQueued = true;
                        Point turn = AR.getTargetCenter();
                        nXTurn = turn.x;
                    }
                }
                if (UR.getIsWall() && !R.getIsWall() && !RD.getIsWall())//3 way right down
                {
                    Point option1 = RD.getTargetCenter();
                    Point option2 = R.getTargetCenter();
                    Point target = pacSquare.getTargetCenter();
                    double dist1 = getDistance(option1, target);
                    double dist2 = getDistance(option2, target);

                    if (dist1 < dist2)
                    {
                        toTurnDown = true;
                        bTurnsQueued = true;
                        Point turn = AR.getTargetCenter();
                        nXTurn = turn.x;
                    }
                }
                if (!UR.getIsWall() && !R.getIsWall() && !RD.getIsWall()) //4way intersection
                {
                    Point option1 = UR.getTargetCenter();
                    Point option2 = RD.getTargetCenter();
                    Point option3 = R.getTargetCenter();
                    Point target = pacSquare.getTargetCenter();
                    double dist1 = getDistance(option1, target);
                    double dist2 = getDistance(option2, target);
                    double dist3 = getDistance(option3, target);

                    if (dist1 < dist2 && dist1 < dist3)
                    {
                        toTurnUp = true;
                        bTurnsQueued = true;
                        Point turn = AR.getTargetCenter();
                        nXTurn = turn.x;
                    } else if (dist2 < dist1 && dist2 < dist3)
                    {
                        toTurnDown = true;
                        bTurnsQueued = true;
                        Point turn = AR.getTargetCenter();
                        nXTurn = turn.x;
                    }
                }
            }
            if (nDirection == 3 && !bTurnsQueued)
            {
                if (RD.getIsWall() && D.getIsWall() && !DL.getIsWall()) //turn left at corner
                {
                    toTurnLeft = true;
                    bTurnsQueued = true;
                    Point turn = AD.getTargetCenter();
                    nYTurn = turn.y;
                }
                if (DL.getIsWall() && D.getIsWall() && !RD.getIsWall()) //turn right at corner
                {
                    toTurnRight = true;
                    bTurnsQueued = true;
                    Point turn = AD.getTargetCenter();
                    nYTurn = turn.y;
                }
                if (D.getIsWall() && !RD.getIsWall() && !DL.getIsWall()) // T intersection
                {
                    Point option1 = DL.getTargetCenter();
                    Point option2 = RD.getTargetCenter();
                    Point target = pacSquare.getTargetCenter();
                    double dist1 = getDistance(option1, target);
                    double dist2 = getDistance(option2, target);

                    if (dist1 < dist2)
                    {
                        toTurnLeft = true;
                        bTurnsQueued = true;
                        Point turn = AD.getTargetCenter();
                        nYTurn = turn.y;
                    } else
                    {
                        toTurnRight = true;
                        bTurnsQueued = true;
                        Point turn = AD.getTargetCenter();
                        nYTurn = turn.y;
                    }
                }
                if (DL.getIsWall() && !D.getIsWall() && !RD.getIsWall()) //3 way intersection down right
                {
                    Point option1 = RD.getTargetCenter();
                    Point option2 = D.getTargetCenter();
                    Point target = pacSquare.getTargetCenter();
                    double dist1 = getDistance(option1, target);
                    double dist2 = getDistance(option2, target);

                    if (dist1 < dist2)
                    {
                        toTurnRight = true;
                        bTurnsQueued = true;
                        Point turn = AD.getTargetCenter();
                        nYTurn = turn.y;
                    }
                }
                if (!DL.getIsWall() && !D.getIsWall() && RD.getIsWall()) //3 way intersection down left
                {
                    Point option1 = DL.getTargetCenter();
                    Point option2 = D.getTargetCenter();
                    Point target = pacSquare.getTargetCenter();
                    double dist1 = getDistance(option1, target);
                    double dist2 = getDistance(option2, target);

                    if (dist1 < dist2)
                    {
                        toTurnLeft = true;
                        bTurnsQueued = true;
                        Point turn = AD.getTargetCenter();
                        nYTurn = turn.y;
                    }
                }
                if (!DL.getIsWall() && !D.getIsWall() && !RD.getIsWall()) //4 way intersection
                {
                    Point option1 = DL.getTargetCenter();
                    Point option2 = RD.getTargetCenter();
                    Point option3 = D.getTargetCenter();
                    Point target = pacSquare.getTargetCenter();
                    double dist1 = getDistance(option1, target);
                    double dist2 = getDistance(option2, target);
                    double dist3 = getDistance(option3, target);

                    if (dist1 < dist2 && dist1 < dist3)
                    {
                        toTurnLeft = true;
                        bTurnsQueued = true;
                        Point turn = AD.getTargetCenter();
                        nYTurn = turn.y;
                    } else if (dist2 < dist1 && dist2 < dist3)
                    {
                        toTurnRight = true;
                        bTurnsQueued = true;
                        Point turn = AD.getTargetCenter();
                        nYTurn = turn.y;
                    }
                }
            }
        }
    }

    public void frightened()
    {
        nGhostSpeed = 2;

        //reverses ghost direction if the scatter call is not the initial scatter
        if (bFirstScared)
        {
            if (!bTurnsQueued && !bRecentTurn) //reverse direction if turn queue is not loaded
            {
                nDirection = (nDirection + 2) % 4;
            }

        }
        bFirstScared = false;
        bFirstChase = true;
        bFirstScatter = true;

        //store a random number for random turning
        Random ran = new Random();
        int nRandom = ran.nextInt(100) + 1;

        Point currPnt = getGhostSpaceCoord();

        //target spaces for tests for next move
        TargetSpace L = new TargetSpace(currPnt.x - 2, currPnt.y);
        TargetSpace LU = new TargetSpace(currPnt.x - 1, currPnt.y - 1);
        TargetSpace U = new TargetSpace(currPnt.x, currPnt.y - 2);
        TargetSpace UR = new TargetSpace(currPnt.x + 1, currPnt.y - 1);
        TargetSpace R = new TargetSpace(currPnt.x + 2, currPnt.y);
        TargetSpace RD = new TargetSpace(currPnt.x + 1, currPnt.y + 1);
        TargetSpace D = new TargetSpace(currPnt.x, currPnt.y + 2);
        TargetSpace DL = new TargetSpace(currPnt.x - 1, currPnt.y + 1);

        //Adjacent target spaces
        TargetSpace AL = new TargetSpace(currPnt.x -1, currPnt.y);
        TargetSpace AU = new TargetSpace(currPnt.x, currPnt.y - 1);
        TargetSpace AR = new TargetSpace(currPnt.x + 1, currPnt.y);
        TargetSpace AD = new TargetSpace(currPnt.x, currPnt.y + 1);


        if (nDirection == 0 && !bTurnsQueued)
        {

            //first handle cases with no choice to be made
            if (LU.getIsWall() && L.getIsWall() && !DL.getIsWall()) // turn down at corner
            {
                toTurnDown = true;
                bTurnsQueued = true;
                Point turn = AL.getTargetCenter();
                nXTurn = turn.x;

            }
            if (DL.getIsWall() && L.getIsWall() && !LU.getIsWall()) // turn up at corner
            {
                toTurnUp = true;
                bTurnsQueued = true;
                Point turn = AL.getTargetCenter();
                nXTurn = turn.x;
            }
            if (L.getIsWall() && !LU.getIsWall() && !DL.getIsWall()) //handle two way intersection with wall in front
            {

                if (nRandom % 2 == 0)
                {
                    toTurnUp = true;
                    bTurnsQueued = true;
                    Point turn = AL.getTargetCenter();
                    nXTurn = turn.x;
                }
                else
                {
                    toTurnDown = true;
                    bTurnsQueued = true;
                    Point turn = AL.getTargetCenter();
                    nXTurn = turn.x;
                }

            }
            if (DL.getIsWall() && !L.getIsWall() && !LU.getIsWall()) //handle 3way junction up/left
            {

                if (nRandom % 2 == 0)
                {
                    toTurnUp = true;
                    bTurnsQueued = true;
                    Point turn = AL.getTargetCenter();
                    nXTurn = turn.x;
                }
            }
            if (!DL.getIsWall() && !L.getIsWall() && LU.getIsWall()) //handle 3way junction down/left
            {

                if (nRandom % 2 == 0)
                {
                    toTurnDown = true;
                    bTurnsQueued = true;
                    Point turn = AL.getTargetCenter();
                    nXTurn = turn.x;
                }
            }
            if (!L.getIsWall() && !LU.getIsWall() && !DL.getIsWall()) // 4 way intersection
            {

                if(nRandom % 3 == 0)
                {
                    toTurnUp = true;
                    bTurnsQueued = true;
                    Point turn = AL.getTargetCenter();
                    nXTurn = turn.x;
                }
                else if (nRandom % 2 == 0)
                {
                    toTurnDown = true;
                    bTurnsQueued = true;
                    Point turn = AL.getTargetCenter();
                    nXTurn = turn.x;
                }

            }

        }
        if (nDirection == 1 && !bTurnsQueued)
        {
            //first handle no choice turns
            if(LU.getIsWall() && U.getIsWall() && !UR.getIsWall()) // turn right at corner
            {
                toTurnRight = true;
                bTurnsQueued = true;
                Point turn = AU.getTargetCenter();
                nYTurn = turn.y;
            }
            if(U.getIsWall() && UR.getIsWall() && !LU.getIsWall()) // turn left at corner
            {
                toTurnLeft = true;
                bTurnsQueued = true;
                Point turn = AU.getTargetCenter();
                nYTurn = turn.y;
            }
            if(U.getIsWall() && !LU.getIsWall() && !UR.getIsWall())//T intersection
            {

                if (nRandom % 2 == 0)
                {
                    toTurnLeft = true;
                    bTurnsQueued = true;
                    Point turn = AU.getTargetCenter();
                    nYTurn = turn.y;
                }
                else
                {
                    toTurnRight = true;
                    bTurnsQueued = true;
                    Point turn = AU.getTargetCenter();
                    nYTurn = turn.y;
                }
            }
            if(LU.getIsWall() && !U.getIsWall() && !UR.getIsWall())//3way intersection up, right
            {

                if (nRandom % 2 == 0)
                {
                    toTurnRight = true;
                    bTurnsQueued = true;
                    Point turn = AU.getTargetCenter();
                    nYTurn = turn.y;
                }
            }
            if(!LU.getIsWall() && !U.getIsWall() && UR.getIsWall())//3way intersection up, left
            {

                if (nRandom % 2 == 0)
                {
                    toTurnLeft = true;
                    bTurnsQueued = true;
                    Point turn = AU.getTargetCenter();
                    nYTurn = turn.y;
                }
            }
            if (!LU.getIsWall() && !U.getIsWall() && !UR.getIsWall()) //4way intersection
            {

                if (nRandom % 3 == 0)
                {
                    toTurnLeft = true;
                    bTurnsQueued = true;
                    Point turn = AU.getTargetCenter();
                    nYTurn = turn.y;
                }
                else if (nRandom % 2 == 0)
                {
                    toTurnRight = true;
                    bTurnsQueued = true;
                    Point turn = AU.getTargetCenter();
                    nYTurn = turn.y;
                }
            }

        }
        if (nDirection == 2 && !bTurnsQueued)
        {
            if(RD.getIsWall() && R.getIsWall() && !UR.getIsWall())//turn up at corner
            {
                toTurnUp = true;
                bTurnsQueued = true;
                Point turn = AR.getTargetCenter();
                nXTurn = turn.x;
            }
            if(UR.getIsWall() && R.getIsWall() && !RD.getIsWall())//turn down at corner
            {
                toTurnDown = true;
                bTurnsQueued = true;
                Point turn = AR.getTargetCenter();
                nXTurn = turn.x;
            }
            if(R.getIsWall() && !UR.getIsWall() && !RD.getIsWall()) //T intersection
            {

                if (nRandom % 2 == 0)
                {
                    toTurnUp = true;
                    bTurnsQueued = true;
                    Point turn = AR.getTargetCenter();
                    nXTurn = turn.x;
                }
                else
                {
                    toTurnDown = true;
                    bTurnsQueued = true;
                    Point turn = AR.getTargetCenter();
                    nXTurn = turn.x;
                }
            }
            if (RD.getIsWall() && !R.getIsWall() && !UR.getIsWall())//3 way right up
            {

                if (nRandom % 2 == 0)
                {
                    toTurnUp = true;
                    bTurnsQueued = true;
                    Point turn = AR.getTargetCenter();
                    nXTurn = turn.x;
                }
            }
            if (UR.getIsWall() && !R.getIsWall() && !RD.getIsWall())//3 way right down
            {

                if (nRandom % 2 == 0)
                {
                    toTurnDown = true;
                    bTurnsQueued = true;
                    Point turn = AR.getTargetCenter();
                    nXTurn = turn.x;
                }
            }
            if (!UR.getIsWall() && !R.getIsWall() && !RD.getIsWall()) //4way intersection
            {

                if (nRandom % 3 == 0)
                {
                    toTurnUp = true;
                    bTurnsQueued = true;
                    Point turn = AR.getTargetCenter();
                    nXTurn = turn.x;
                }
                else if (nRandom % 2 == 0)
                {
                    toTurnDown = true;
                    bTurnsQueued = true;
                    Point turn = AR.getTargetCenter();
                    nXTurn = turn.x;
                }
            }
        }
        if (nDirection == 3 && !bTurnsQueued)
        {
            if(RD.getIsWall() && D.getIsWall() && !DL.getIsWall()) //turn left at corner
            {
                toTurnLeft = true;
                bTurnsQueued = true;
                Point turn = AD.getTargetCenter();
                nYTurn = turn.y;
            }
            if (DL.getIsWall() && D.getIsWall() && !RD.getIsWall()) //turn right at corner
            {
                toTurnRight = true;
                bTurnsQueued = true;
                Point turn = AD.getTargetCenter();
                nYTurn = turn.y;
            }
            if (D.getIsWall() && !RD.getIsWall() && !DL.getIsWall()) // T intersection
            {

                if (nRandom % 2 == 0)
                {
                    toTurnLeft = true;
                    bTurnsQueued = true;
                    Point turn = AD.getTargetCenter();
                    nYTurn = turn.y;
                }
                else
                {
                    toTurnRight = true;
                    bTurnsQueued = true;
                    Point turn = AD.getTargetCenter();
                    nYTurn = turn.y;
                }
            }
            if (DL.getIsWall() && !D.getIsWall() && !RD.getIsWall()) //3 way intersection down right
            {

                if (nRandom % 2 == 0)
                {
                    toTurnRight = true;
                    bTurnsQueued = true;
                    Point turn = AD.getTargetCenter();
                    nYTurn = turn.y;
                }
            }
            if (!DL.getIsWall() && !D.getIsWall() && RD.getIsWall()) //3 way intersection down left
            {

                if (nRandom % 2 == 0)
                {
                    toTurnLeft = true;
                    bTurnsQueued = true;
                    Point turn = AD.getTargetCenter();
                    nYTurn = turn.y;
                }
            }
            if (!DL.getIsWall() && !D.getIsWall() && !RD.getIsWall()) //4 way intersection
            {

                if (nRandom % 3 == 0)
                {
                    toTurnLeft = true;
                    bTurnsQueued = true;
                    Point turn = AD.getTargetCenter();
                    nYTurn = turn.y;
                }
                else if (nRandom % 2 == 0)
                {
                    toTurnRight = true;
                    bTurnsQueued = true;
                    Point turn = AD.getTargetCenter();
                    nYTurn = turn.y;
                }
            }
        }


    }


    public void draw(Graphics g)
    {
        super.draw(g);
        g.fillPolygon(getXcoords(), getYcoords(), dDegrees.length);
    }


    public Point getGhostSpaceCoord()
    {
        Point pnt = getCenter();
        int x = (pnt.x / TargetSpace.TS_WIDTH) + 1;
        int y = (pnt.y / TargetSpace.TS_HEIGHT) + 1;
        return new Point(x, y);
    }

    public double getDistance(Point a, Point b)
    {
        double leg1 = Math.abs(a.x - b.x);
        double leg2 = Math.abs(a.y - b.y);
        return (Math.sqrt((leg1*leg1) + (leg2*leg2)));
    }

    public void setRespawn(boolean bRespawn)
    {
        this.bRespawn = bRespawn;
    }

    public boolean getRespawn()
    {
        return bRespawn;
    }

    public static void setInsideBox(boolean bInsideBox)
    {
        Clyde.bInsideBox = bInsideBox;
    }

}
