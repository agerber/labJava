package lec03.glab2;

import lec10.glab.lambdas.Circle;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

public class MySimplePolyDriver {

    public static void main(String[] args) {

        ArrayList arrayList = new ArrayList();
        arrayList.add(new Rectangle(1,2,3,4));
        arrayList.add(new Circle(2,3,4));
        arrayList.add(new Date());
        arrayList.add(new Integer(3));
        arrayList.add(new MyCool());


        for (Object obj : arrayList) {
            System.out.println(obj.toString());
        }

    }
}
