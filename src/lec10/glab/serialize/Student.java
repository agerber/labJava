package lec10.glab.serialize;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 * User: ag
 * Date: 11/28/13
 * Time: 4:34 PM
 * To change this template use File | Settings | File Templates.
 */

//needs to implement the serializeale interface
public class Student implements Serializable {


    //https://stackoverflow.com/questions/285793/what-is-a-serialversionuid-and-why-should-i-use-it
    private static final long serialVersionUID = 456780L;

    private String mName;
    private int mYear;


    public Student(String name, int year) {
        mYear = year;
        mName = name;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getYear() {
        return mYear;
    }

    public void setYear(int year) {
        mYear = year;
    }

    @Override
    public String toString() {
        return "Student{" +
                "mName='" + mName + '\'' +
                ", mYear=" + mYear +
                '}';
    }
}
