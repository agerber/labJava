package edu.uchicago.gerber.labjava.lec02.glab._2023.statics;

public class TempDriver {

    public static void main(String[] args) {
        // Convert 25°C to Fahrenheit
        double fahrenheit = TempUtil.celsiusToFahrenheit(25);
        System.out.println("25°C is equivalent to " + fahrenheit + "°F.");

        // Convert 77°F to Celsius
        double celsius = TempUtil.fahrenheitToCelsius(77);
        System.out.println("77°F is equivalent to " + celsius + "°C.");
    }
}

class TempUtil {

    private TempUtil() {
        // Private constructor to prevent instantiation of the utility class
    }

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9.0/5.0) + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5.0/9.0;
    }

}
