package lec09.glab.danshiff.game.model;

import lec09.glab.danshiff.controller.Game;
import lec09.glab.danshiff.sounds.Sound;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: danshiff
 * Date: 11/27/13
 * Time: 5:39 PM
 * To change this template use File | Settings | File Templates.
 */

/**
 * Slows the bugs for a bit.
 */
public class ChillPill extends Floater{

    public static final Color CHILL = new Color(83, 180, 211);

    public ChillPill(int x, int y){
        super(CHILL, x, y);

    }

    public void performEffect(Game game){
        CommandCenter.setChilled(CommandCenter.getChilled() + 450);
        Sound.playSound("chill.wav");
    }

}

