package edu.uchicago.gerber.labjava.lec03._simplepoly;

public class _1_DubToObjectExample {
    public static void main(String[] args) {

        //I'm creating a new object here
        Double dub = new Double(34.56);

        //up-cast (narrowing aperture)
        Number num = (Number) dub;


        //up-cast (narrowing aperture)
        Object obj =  (Object) num;


        //down-casting (widening aperture) Be careful!
        Double anotherDub = (Double) obj;


        //up-cast (narrowing aperture)
        Number anotherNum =  (Number) anotherDub;

        //how many objects are instantiated in this example?


        //what is the underlying object type of each of these references?
        System.out.println("what is the underlying object type of each of these references?");
        System.out.println(dub.getClass());
        System.out.println(num.getClass());
        System.out.println(obj.getClass());
        System.out.println(anotherDub.getClass());
        System.out.println(anotherNum.getClass());

        //do these references point to the same object?
        System.out.println("do these references point to the same object?");
        System.out.println(dub == num);
        System.out.println(num == obj);
        System.out.println(obj == anotherDub);
        System.out.println(anotherNum == anotherDub);
        System.out.println(dub == anotherNum);
        //etc. etc. etc.






    }



}
