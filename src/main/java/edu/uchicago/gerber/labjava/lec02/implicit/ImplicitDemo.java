package edu.uchicago.gerber.labjava.lec02.implicit;

public class ImplicitDemo {

    public static void main(String[] args) {
        String strName = new String("John Doe");

        // For the method indexOf, the implicit parameter is strName
        int spaceIndex = strName.indexOf(' ');
        System.out.println("The index of space in '" + strName + "' is: " + spaceIndex);

        // For the static method pow of the Math class, there's no implicit parameter as it's a class (static) method and not an instance method.
        double result = Math.pow(2, 3);
        System.out.println("2 raised to the power of 3 is: " + result);
    }
}
