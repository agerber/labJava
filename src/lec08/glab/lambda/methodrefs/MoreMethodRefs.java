package lec08.glab.lambda.methodrefs;

import lec10.glab.lambdas.Circle;
import sun.plugin.dom.css.Rect;

import java.awt.*;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Supplier;

public class MoreMethodRefs {

    public static void main(String[] args) {

        //very clear about what is going on
        Function<Double, String> stringFunction1 = dub -> String.valueOf(dub);

        //this is rather confusing, as we don't see any parameters!
        Function<Double, String> stringFunction2 = String::valueOf;

        //this is a supplier of ArrayList
        Supplier<ArrayList<String>> circleSupplier1 = () -> new ArrayList<>();

        //this is confusing, as we don't see what's happening
        Supplier<ArrayList<String>> circleSupplier2 = ArrayList::new;




        Rectangle rectangle = new Rectangle(1,2,3,4);

        //this is very clear
        Function<Rectangle, Double> rectangleIntegerFunction1 = (rec) -> rec.getHeight();

        //not so clear
        Function<Rectangle, Double> rectangleIntegerFunction2 = Rectangle::getHeight;


    }
}
