package edu.uchicago.gerber.labjava.lec03.simplepoly;

public class DubToObjectExample {
    public static void main(String[] args) {

        //I'm creating a new object here
        Double dub =34.56;

        //up-cast (automatic casting)
        Number num = (Number) dub;


        //up-cast (automatic casting)
        Object obj = (Object) num;


        //down-casting (widening)
        Double anotherDub = (Double) obj;


        //up-cast (automatic casting)
        Number anotherNum = (Number) anotherDub;

        //how many objects are instantiated in this example?





    }



}
