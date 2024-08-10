package edu.uchicago.gerber.labjava.lec06.patterns.visitor.example.shapes;

import edu.uchicago.gerber.labjava.lec06.patterns.visitor.example.visitor.Visitor;

public interface Shape {
    void move(int x, int y);
    void draw();
    String accept(Visitor visitor);
}
