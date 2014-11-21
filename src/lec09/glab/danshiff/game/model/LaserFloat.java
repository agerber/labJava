package lec09.glab.danshiff.game.model;

import lec09.glab.danshiff.controller.Game;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: danshiff
 * Date: 11/27/13
 * Time: 6:22 PM
 * To change this template use File | Settings | File Templates.
 */

/**
 * Makes the next shot a laser. Also takes away triple shot.
 */
public class LaserFloat extends Floater{

    public static final Color LASER = Color.RED;

    public LaserFloat(int x, int y){
        super(LASER, x, y);
    }

    public void performEffect(Game game){
        CommandCenter.getHunter().setTripleShot(0);
        CommandCenter.getHunter().setLaser(true);
    }

}

