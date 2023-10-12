package edu.uchicago.gerber.labjava.lec03.simplepoly;

public class DubToObjectGodView {

    public static void main(String[] args) {
        //I'm creating a new object here
        Double dub =34.56;
        //System.out.println(dub.getClass().getName());
        GodView.print(Double.class, GodView.Size.LARGE, false);
        GodView.print(dub.getClass(), GodView.Size.LARGE, true);


        //up-cast (automatic casting)
        Number num = (Number) dub;
        GodView.print(Number.class, GodView.Size.MEDIUM, false);
        GodView.print(num.getClass(), GodView.Size.LARGE, true);


        //up-cast (automatic casting)
        Object obj = (Object) num;
        GodView.print(Object.class, GodView.Size.SMALL, false);
        GodView.print(obj.getClass(), GodView.Size.LARGE, true);


        //down-casting (widening)
        Double anotherDub = (Double) obj;
        GodView.print(Double.class, GodView.Size.LARGE, false);
        GodView.print(anotherDub.getClass(), GodView.Size.LARGE, true);


        //up-cast (automatic casting)
        Number anotherNum = (Number) anotherDub;
        GodView.print(Number.class, GodView.Size.MEDIUM, false);
        GodView.print(anotherNum.getClass(), GodView.Size.LARGE, true);

        //how many objects are instantiated in this example?

    }
}
