package edu.uchicago.gerber.labjava.lec04._more_interfaces;

// Define the Drawable interface
interface Drawable {
   void draw();



}

// Implement the Drawable interface in a Circle class
class Circle implements Drawable {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a circle with radius " + radius);
    }
}

// Implement the Drawable interface in a Rectangle class
class Rectangle implements Drawable {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a rectangle with width " + width + " and height " + height);
    }
}

public class InterfaceDemo {
    public static void main(String[] args) {
        Drawable circle = new Circle(5);
        Drawable rectangle = new Rectangle(4, 6);

        circle.draw();
        rectangle.draw();
    }
}
