package edu.uchicago.gerber.labjava.lec10.patterns.visitor.example.visitor;

import edu.uchicago.gerber.labjava.lec10.patterns.visitor.example.shapes.Circle;
import edu.uchicago.gerber.labjava.lec10.patterns.visitor.example.shapes.CompoundShape;
import edu.uchicago.gerber.labjava.lec10.patterns.visitor.example.shapes.Dot;
import edu.uchicago.gerber.labjava.lec10.patterns.visitor.example.shapes.Rectangle;

public interface Visitor {
    String visitDot(Dot dot);

    String visitCircle(Circle circle);

    String visitRectangle(Rectangle rectangle);

    String visitCompoundGraphic(CompoundShape cg);
}
