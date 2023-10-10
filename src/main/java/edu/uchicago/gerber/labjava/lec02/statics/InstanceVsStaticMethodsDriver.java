package edu.uchicago.gerber.labjava.lec02.statics;

public class InstanceVsStaticMethodsDriver {

    private int value;

    public static int canBeInstanceOrStatic(int n){
        return n + 10;
    }

    public int mustBeInstance(){
        return value;

    }
}
