package lec06.glab.elevator;

/**
 * Created with IntelliJ IDEA.
 * User: ag
 * Date: 11/2/13
 * Time: 3:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class ExecRider extends Rider {
    private boolean mSuiteAccess;

    public boolean isSuiteAccess() {
        return mSuiteAccess;
    }

    public void setSuiteAccess(boolean suiteAccess) {
        mSuiteAccess = suiteAccess;
    }
}
