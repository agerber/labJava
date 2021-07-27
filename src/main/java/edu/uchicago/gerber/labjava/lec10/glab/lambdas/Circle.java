package edu.uchicago.gerber.labjava.lec10.glab.lambdas;

public class Circle implements Cloneable{

    private int radius;
    private int x;
    private int y;
    private String name;
    private double area;

    public Circle(int x, int y, int radius){
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.area = 2 * Math.PI * radius;
    }

    public Circle(int x, int y, int radius, String name){
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.name = name;
        this.area = Math.PI * Math.pow(radius, 2);
    }


    public String getName() {
        return this.name;
    }

    public int getRadius(){
        return this.radius;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public double getArea(){
        return this.area;
    }

    @Override
    public String toString(){
        return "I am " + this.name + ", area:" + this.area;
    }

    @Override
    protected Circle clone() throws CloneNotSupportedException {
        return (Circle)super.clone();
    }
}
