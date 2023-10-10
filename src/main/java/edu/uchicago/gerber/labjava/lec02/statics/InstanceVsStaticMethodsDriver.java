package edu.uchicago.gerber.labjava.lec02.statics;




public class InstanceVsStaticMethodsDriver {

    /*
    Both instance-method-definitions and static-method-definitions are stored in the
    class-object and loaded by the class-loader before runtime. However, all
    instances (objects) are created at runtime.
     */


    //my instance field
    private int value;

    //this method can be either instance or static as it does not reference any
    //instance fields
    public static int canBeInstanceOrStatic(int n){
        return n + 10;
    }

    //this method MUST be an instance method because it references a field.
    //if you try to make it static, the compiler will complain.
    public int mustBeInstance(){
        return value;

    }
}
