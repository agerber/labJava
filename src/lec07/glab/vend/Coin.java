package lec07.glab.vend;

/**
 * Created with IntelliJ IDEA.
 * User: ag
 * Date: 11/11/13
 * Time: 10:13 AM
 * To change this template use File | Settings | File Templates.
 */
public class Coin {
    private double mValue;

    public Coin(double value) {
        mValue = value;
    }

    public double getValue() {
        return mValue;
    }

    public void setValue(double value) {
        mValue = value;
    }
}
