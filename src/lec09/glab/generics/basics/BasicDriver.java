package lec09.glab.generics.basics;

class GenericClass<T> {
    T ob;

    GenericClass(T o) {
        ob = o;
    }

    T getob() {
        return ob;
    }

    void showType() {
        System.out.println("Type of T is " + ob.getClass().getName());
    }
}

public class BasicDriver {
    public static void main(String args[]) {
        // Create a Gen reference for Integers.
        GenericClass<Integer> iOb = new GenericClass<Integer>(88);
        iOb.showType();

        // no cast is needed.
        int v = iOb.getob();
        System.out.println("value: " + v);

        // Create a Gen object for Strings.
        GenericClass<String> strOb = new GenericClass<String>("Generics Test");
        strOb.showType();

        String str = strOb.getob();
        System.out.println("value: " + str);
    }
}