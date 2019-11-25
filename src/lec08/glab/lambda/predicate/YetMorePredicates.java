package lec08.glab.lambda.predicate;

import javafx.util.Pair;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class YetMorePredicates {

    public static void main(String[] args) {

        BiPredicate<Circle, Circle> circleCircleBiPredicate =
                (cir1, cir2) ->
                      cir1.getCenter().distance(cir2.getCenter()) < cir1.getRadius() + cir2.getRadius();

        List<Pair<Circle, Circle>> list = new ArrayList<>();
        list.add(new Pair<>(new Circle(2, new Point(34, 56)),new Circle(2, new Point(34, 56)) ));
        list.add(new Pair<>(new Circle(5, new Point(334, 556)),new Circle(2, new Point(34, 56)) ));
        list.add(new Pair<>(new Circle(2, new Point(34, 56)),new Circle(2, new Point(34, 56)) ));
        list.add(new Pair<>(new Circle(2, new Point(34, 56)),new Circle(2, new Point(34, 56)) ));


        BiConsumer<Circle, Circle> circleCircleBiConsumer = (c1, c2) -> System.out.println(c1.toString() + c2.toString() + " collision");

        BiFunction<Circle, Circle, String> circleCircleStringBiFunction = (c1, c2) -> c1.toString() + c2.toString() + " collision";



        for (Pair<Circle, Circle> pair : list) {
            Circle c1 = pair.getKey();
            Circle c2 = pair.getValue();
            if (circleCircleBiPredicate.test(c1,c2)){
                circleCircleBiConsumer.accept(c1, c2);
                System.out.println(circleCircleStringBiFunction.apply(c1, c2).toUpperCase());

            }
        }

        list.forEach(p -> System.out.println(p.getValue().toString() + p.getKey().toString()));



    }
}

class Circle {
    private double radius;
    private Point center;

    public Circle(double radius, Point center) {
        this.radius = radius;
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", center=" + center +
                '}';
    }
}