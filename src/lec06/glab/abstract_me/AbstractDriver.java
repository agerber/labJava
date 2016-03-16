package lec06.glab.abstract_me;

import java.util.Date;

/**
 * Created by ag on 11/3/2014.
 */
public class AbstractDriver {

    public static void main(String[] args) {



    }
}

abstract class MyAbstractDate extends Date {

    private int mNum;
    private String mMyString;

    public int getNum() {
        return mNum;
    }

    public void setNum(int num) {
        mNum = num;
    }

    public String getMyString() {
        return mMyString;
    }

    public void setMyString(String string) {
        mMyString = string;
    }

    public abstract String getMayanArmegeddon();

}
