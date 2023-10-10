package edu.uchicago.gerber.labjava.lec02.statics;




public class InstanceVsStaticMethodsDriver {

    /*
    Both instance-method-definitions and static-method-definitions are stored in the
    class-object and loaded by the class-loader before runtime. However, all
    instances (objects) are created at runtime.
     */

    public static void main(String[] args) {
        MyObject myObject = new MyObject(25);

        //instance call
        int localValue = myObject.mustBeInstance();

        //static call
        int someOtherValue = MyObject.canBeInstanceOrStatic(50);

    }


}

class MyObject {
    //my instance field
    private int value;

    public MyObject(int value) {
        this.value = value;
    }

    //this method MUST be an instance method because it references a field.
    //if you try to make it static, the compiler will complain.
    public int mustBeInstance(){
        return value;

    }

    //this method can be either instance or static as it does not reference any
    //instance fields. If you make it an instance method, you must call it from the
    // implicit parameter above (and not the class).
    public static int canBeInstanceOrStatic(int n){
        return n + 10;
    }


}
