package lec04.glab.construct_me;



import java.util.ArrayList;

/**
 * Created by ag on 10/20/2014.
 */
public class Driver {


    public static void main(String[] args) {

        ArrayList<Person> perPeeps = new ArrayList<>();
        perPeeps.add(new Person("Dan"));
        perPeeps.add(new Person("Jason"));
        perPeeps.add(new Person("Liz"));
        perPeeps.add(new Person("Charlie"));
        perPeeps.add(new Person("Charlie", 150));
        perPeeps.add(new Person("Charlie", 160));
        perPeeps.add(new Person("Charlie", 160));

        for (Person perPeep : perPeeps) {
            System.out.println(perPeep.toString());
        }

        System.out.println(perPeeps.get(6).equals(perPeeps.get(5)));
        System.out.println(perPeeps.get(0).equals(perPeeps.get(3)));

        Person perDan = perPeeps.get(0);
        System.out.println(perDan.getName() + "'s wieght in kilos is " + Metric.lbsToKilos(perDan.getWeight()));





    }


}
