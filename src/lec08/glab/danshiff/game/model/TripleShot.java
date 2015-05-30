package lec08.glab.danshiff.game.model;

import lec08.glab.danshiff.controller.Game;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: danshiff
 * Date: 11/25/13
 * Time: 5:51 PM
 * To change this template use File | Settings | File Templates.
 */

/**
 * Makes the next 20 shots triple shots (this can accumulate). Takes away laser.
 */
public class TripleShot extends Floater{

    public static final Color TRIPLE = new Color(145, 89, 148);

    public TripleShot(int x, int y){
        super(TRIPLE, x, y);

    }

    public void performEffect(Game game){
        CommandCenter.getHunter().setLaser(false);
        CommandCenter.getHunter().setTripleShot(CommandCenter.getHunter().getTripleShot() + 20);
        CommandCenter.getHunter().setColor(new Color(135, 12, 148));
    }

}

