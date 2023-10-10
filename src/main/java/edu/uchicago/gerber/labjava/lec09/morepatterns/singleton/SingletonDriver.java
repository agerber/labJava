package edu.uchicago.gerber.labjava.lec09.morepatterns.singleton;

public class SingletonDriver {
    public static void main(String[] args) {
        //there is only ever one of these on the heap
        MySingleton.getInstance().setReport("Hello");
        MySingleton.getInstance().setReport("Hello2");
        MySingleton.getInstance().setReport("Hello3");

        System.out.println(MySingleton.getInstance().getReport());

    }
}
