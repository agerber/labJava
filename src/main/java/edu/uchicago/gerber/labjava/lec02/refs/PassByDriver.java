package edu.uchicago.gerber.labjava.lec02.refs;

public class PassByDriver {

    public static void main(String[] args) {
        // Primitive
        //when we pass a primitive, we pass a copy of the value. The original value outside
        //the scope of this method will be unaffected
        int primitiveValue = 10;
        System.out.println("Before passing primitive: " + primitiveValue);
        modifyPrimitive(primitiveValue);
        System.out.println("After passing primitive: " + primitiveValue);

        // Object
        //when we pass an object, we pass a copy of the value of the memory address.
        //once the method has the address, it CAN mutate the object.
        IntegerWrapper objectValue = new IntegerWrapper(10);
        System.out.println("\nBefore passing object: " + objectValue.getValue());
        modifyObject(objectValue);
        System.out.println("After passing object: " + objectValue.getValue());
    }

    public static void modifyPrimitive(int value) {
        value = value + 10;
        System.out.println("Inside modifyPrimitive method: " + value);
    }

    public static void modifyObject(IntegerWrapper wrapper) {
        wrapper.setValue(wrapper.getValue() + 10);
        System.out.println("Inside modifyObject method: " + wrapper.getValue());
    }

    // Inner class for demonstration purposes
    static class IntegerWrapper {
        private int value;

        public IntegerWrapper(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
