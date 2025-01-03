package edu.uchicago.gerber.labjava.lec06.generics.basics;


public class BasicDriver {
    public static void main(String args[]) {
        // Create a Gen reference for Integers.
        GenericClass<Integer> iOb = new GenericClass<>(88);
        iOb.showType();

//        // Create a Gen object for Strings.
        GenericClass<String> strOb = new GenericClass<>("Generics Test");
        strOb.showType();

    }
}

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



