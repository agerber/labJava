package edu.uchicago.gerber.labjava.lec10.glab.serialize_xml;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: ag
 * Date: 11/28/13
 * Time: 4:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class HighScore implements Serializable, Comparable<HighScore> {

    private String mName;
    private long mScore;

    private static final long serialVersionUID = 78965434233L;

    //you must include a no-arg consturctor
    public HighScore() {
    }

    public HighScore(String name, String score) {


        long lScore =0;
        try {
            lScore=   Long.parseLong(score);
        } catch (NumberFormatException e) {
          //  e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        mName = name;
        mScore = lScore;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public long getScore() {
        return mScore;
    }

    public void setScore(long score) {
        mScore = score;
    }

    @Override
    public String toString() {
        return  mName + " : "+ mScore;
    }

    @Override
    public int compareTo(HighScore highScore) {
        int nRet = 0;
        //sort descending
        if (this.getScore() > highScore.getScore()) {
            nRet =  -1;
        } else if (this.getScore() < highScore.getScore()) {
            nRet =  1;
        }

        return nRet;

    }

    @Override
    public boolean equals(Object obj) {
        if (((HighScore)obj).getName().equalsIgnoreCase(this.getName())){
                return true;
        } else {
            return false;
        }

    }
}
