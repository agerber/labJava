package edu.uchicago.gerber.labjava.lec09.glab.generics.basics;


public class BasicDriver {
    public static void main(String args[]) {
        // Create a Gen reference for Integers.
        GenericClass<Integer> iOb = new GenericClass<>(88);
        iOb.showType();

//        List<Pair<Integer, String>> list = new ArrayList<>();
//        list.add(new Pair<>(60101, "Chicago"));
//        list.add(new Pair<>(94562, "San Francisco"));
//        list.add(new Pair<>(12183, "Boston"));
//
//        for (Pair<Integer, String> integerStringPair : list) {
//            System.out.println(integerStringPair);
//        }

//
//        // no cast is needed.
//        int v = iOb.getOb();
//        System.out.println("value: " + v);
//
//        // Create a Gen object for Strings.
        GenericClass<String> strOb = new GenericClass<>("Generics Test");
        strOb.showType();
//
//        String str = strOb.getOb();
//        System.out.println("value: " + str);
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



