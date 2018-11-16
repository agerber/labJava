package lec08.glab.lambda.behaviorParam;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Adam on 6/21/2016.
 */
public class _01TheProblemDefined {

    public static void main(String[] args) {


        //in Java7, we want to pass in behavior, but we can't because functions are 2nd class citizens in Java. Only
        //objects are 1st class citizens in Java.


        new javax.swing.Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getClass().toString());
            }
        }).start();


        List<String> names = Arrays.asList("Bob", "James", "Brian", "Cindy", "Barbara", "Kathy", "John", "Depak", "Alex");

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };

        Collections.sort(names, comparator);


        Collections.sort(names, (String o1, String o2) -> o1.compareTo(o2));



        for (String name : names) {
            System.out.println(name);
        }






    }
}
