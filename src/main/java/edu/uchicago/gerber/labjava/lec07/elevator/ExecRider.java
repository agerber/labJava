package edu.uchicago.gerber.labjava.lec07.elevator;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: ag
 * Date: 11/2/13
 * Time: 3:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class ExecRider extends Rider  {
    private boolean mSuiteAccess;


    public ExecRider(Dimension dimension) {
       super(dimension);
        mSuiteAccess = (Math.random() * 10 < 5 ? true : false);
    }

    public boolean isSuiteAccess() {
        return mSuiteAccess;
    }

    public void setSuiteAccess(boolean suiteAccess) {
        mSuiteAccess = suiteAccess;
    }


}
