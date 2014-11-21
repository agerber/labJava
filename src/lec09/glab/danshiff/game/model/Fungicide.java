package lec09.glab.danshiff.game.model;

import lec09.glab.danshiff.controller.Game;
import lec09.glab.danshiff.sounds.Sound;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: danshiff
 * Date: 11/27/13
 * Time: 5:52 PM
 * To change this template use File | Settings | File Templates.
 */

/**
 * Removes a third of the mushrooms from the game board.
 */
public class Fungicide extends Floater{

    public static final Color CIDE = new Color(253, 255, 29);

    public Fungicide(int x, int y){
        super(CIDE, x, y);

    }

    public void performEffect(Game game){
        game.mushpocolypse();
        Sound.playSound("boom.wav");
    }

}

