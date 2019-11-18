package lec10.glab.serialize_xml;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: ag
 * Date: 12/2/13
 * Time: 10:56 AM
 * To change this template use File | Settings | File Templates.
 */
public class HighScores extends ArrayList<HighScore> {

    //make this ArrayList behave like a Set with regards to getName()
    @Override
    public boolean add(HighScore highScore) {
        if (!contains(highScore)){
            return super.add(highScore);
        } else {
            remove(highScore);
            return super.add(highScore);
        }

    }
}
