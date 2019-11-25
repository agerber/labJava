package lec09.glab.generics.basics;

import java.awt.*;
import java.util.Date;

class GenericClass<T> {
    T ob;

    GenericClass(T o) {
        ob = o;
    }



      T getOb() {
       // T t = new T();  //can not instantiate directly.
         //T.getClass() doesn't work either

        return ob;
    }

     void setOb(T ob) {
        this.ob = ob;
    }

    void showType() {
        System.out.println("Type of T is " + ob.getClass().getName());
    }
}

class GenClass<U> {
    private U obj;

    public GenClass(U obj) {
        this.obj = obj;
    }

    public U getObj() {
        return obj;
    }

    public void setObj(U obj) {
        this.obj = obj;
    }
}

public class BasicDriver {
    public static void main(String args[]) {
        // Create a Gen reference for Integers.
        GenericClass<Integer> iOb = new GenericClass<>(88);
        iOb.showType();



        // no cast is needed.
        int v = iOb.getOb();
        System.out.println("value: " + v);

        // Create a Gen object for Strings.
        GenericClass<String> strOb = new GenericClass<>("Generics Test");
        strOb.showType();

        String str = strOb.getOb();
        System.out.println("value: " + str);
    }
}