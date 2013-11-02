package lec06.glab.elevator;

/**
 * Created with IntelliJ IDEA.
 * User: ag
 * Date: 11/2/13
 * Time: 2:51 PM
 * To change this template use File | Settings | File Templates.
 */

public class Rider {

    //Rider can be waiting, riding, or indisposed  (must we make this static?)
    public static enum State {RIDING, WAITING, IN_BUILDING, AWAY}
    private State mState;
    private int mFloor; //0-4


}
