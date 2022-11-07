package edu.uchicago.gerber.labjava.lec06.glab.abstract_me;

import java.util.Date;

/**
 * Created by ag on 11/3/2014.
 */
public class AbstractDriver {

    public static void main(String[] args) {



        System.out.println(new MyAbstractDate() {
            @Override
            public String getMayanArmegeddon() {
                return "May 3, 2012. Hello from myAbstractDate, my type is: " + this.getClass().getName();
            }
        }.getMayanArmegeddon());

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
