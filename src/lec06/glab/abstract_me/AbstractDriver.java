package lec06.glab.abstract_me;

import java.util.Date;

/**
 * Created by ag on 11/3/2014.
 */
public class AbstractDriver {

    public static void main(String[] args) {

        MyAbstractDate myAbstractDate = new MyAbstractDate() {
            @Override
            public String getMayanArmegeddon() {
                return "May 3, 2012 : " + this.getClass().getName();
            }
        };

        System.out.println(myAbstractDate.getMayanArmegeddon());

    }
}

abstract class MyAbstractDate extends Date {

    public abstract String getMayanArmegeddon();

}
