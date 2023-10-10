package edu.uchicago.gerber.labjava.lec02.refs;

public class PassByDriver {

    public static void main(String[] args) {
        // Primitive
        int primitiveValue = 10;
        System.out.println("Before passing primitive: " + primitiveValue);
        modifyPrimitive(primitiveValue);
        System.out.println("After passing primitive: " + primitiveValue);

        // Object
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
