package edu.uchicago.gerber.labjava.lec04._simplepoly;

public class _1_DubToObjectExample {
    public static void main(String[] args) {

        //I'm creating a new object here
        Double dub =34.56;

        //up-cast (automatic casting)
        Number num =  dub;


        //up-cast (automatic casting)
        Object obj =  num;


        //down-casting (widening)
        Double anotherDub = (Double) obj;


        //up-cast (automatic casting)
        Number anotherNum =  anotherDub;

        //how many objects are instantiated in this example?





    }



}
