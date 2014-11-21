package lec09.glab.danshiff.game.model;

/**
 * Created with IntelliJ IDEA.
 * User: danshiff
 * Date: 12/2/13
 * Time: 12:28 PM
 * To change this template use File | Settings | File Templates.
 */

/**
 * A Foe is any sort of bug.
 */
public abstract class Foe extends Sprite{

    private long mValue;    //How many points killing this is worth.

    public abstract void interactWithMushroom(Mushroom mus);    //Most bugs interact with mushrooms in some way.

    public abstract boolean kill(); //Some bugs do weird things when they die. Boolean because not all bugs die with one
                                    //hit.

    public void setValue(long value){
        mValue = value;
    }

    public long getValue(){
        return mValue;
    }

    /**
     * This override of the move method ensures that bugs will move at half their normal rate when slowed.
     * @param nXCode    Can Loop (like asteroids), Stick (can't leave frame), or Leave the world
     * @param nYCode    As above (except loop) but can also StrongStick (can't go above a certain location)
     */
    public void move(int nXCode, int nYCode){
        if(CommandCenter.getChilled() % 2 !=0){
            return;
        }
        super.move(nXCode, nYCode);
    }
}
