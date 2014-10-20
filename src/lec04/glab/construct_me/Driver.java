package lec04.glab.construct_me;



import java.util.ArrayList;

/**
 * Created by ag on 10/20/2014.
 */
public class Driver {


    public static void main(String[] args) {

        ArrayList<Person> perPeeps = new ArrayList<>();
        perPeeps.add(new Person());
        perPeeps.add(new Person());
        perPeeps.add(new Person());
        perPeeps.add(new Person("Charlie"));

        for (Person perPeep : perPeeps) {
            System.out.println(perPeep.toString());
        }

        System.out.println(perPeeps.get(0).equals(perPeeps.get(2)));
        System.out.println(perPeeps.get(0).equals(perPeeps.get(3)));





    }


}
