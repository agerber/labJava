package lec04.glab.phone2;

/**
 * Created by Adam on 10/17/2016.
 */
public class MyNumber extends Number {

    long lValue;

    public MyNumber(long lValue) {
        this.lValue = lValue;
    }

    public long getlValue() {
        return lValue;
    }

    public void setlValue(long lValue) {
        this.lValue = lValue;
    }

    @Override
    public int intValue() {
        return 0;
    }

    @Override
    public long longValue() {
        return 0;
    }

    @Override
    public float floatValue() {
        return 0;
    }

    @Override
    public double doubleValue() {
        return 0;
    }

}
