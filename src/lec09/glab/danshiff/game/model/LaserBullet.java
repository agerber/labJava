package lec09.glab.danshiff.game.model;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: danshiff
 * Date: 11/27/13
 * Time: 6:20 PM
 * To change this template use File | Settings | File Templates.
 */

/**
 * Use this to create a laser (column of red bullets). They don't move, but they expire quickly.
 */
public class LaserBullet extends Bullet{

    public LaserBullet(BugHunter fal){
        super(fal);
        setDeltaY(0);
        setDeltaX(0);
        setColor(Color.RED);
        setExpire(4);
    }

}
