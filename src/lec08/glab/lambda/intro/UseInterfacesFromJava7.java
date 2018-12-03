package lec08.glab.lambda.intro;

import javax.swing.Timer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class UseInterfacesFromJava7 {


    //In this example, we are going to use Functional Interfaces that were defined in Java7 and before.
    //We will ignore those Functional Interfaces in the java.util.function Package which were introduced in Java8

    public static void main(String[] args) {

      //Any Interface that has exactly one stub method, can be used
      Timer timer = new Timer(500, e -> System.out.println("fired at " + e.getWhen()));
      timer.start();

      //you can try to code this manually as well and roll-out the lambda using IntelliJ code complete.
      Thread thread = new Thread(() -> System.out.println("Hello there"));
      thread.start();


      //this is the functionalInterface. Replace with lamda using IntelliJ
      Comparator<String> myStringComparatorReverse = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
               return -1 * o1.compareTo(o2);
            }
        };


        List<String> myList = Arrays.asList("Charlie", "Robby", "Betsie", "Danny", "Becky", "Sammy");
        myList.sort(myStringComparatorReverse);

        for (String s : myList) {
            System.out.println(s);
        }
        System.out.println("########################################");

//        myList.sort(Comparator.naturalOrder());
//
//        for (String s : myList) {
//            System.out.println(s);
//        }
//        System.out.println("########################################");


        myList.sort((s1, s2) -> {
            if (s1.length() > s2.length())
                return 1;
            else if (s1.length() < s2.length())
                return  -1;
            else
                return 0;
        });

        for (String s : myList) {
            System.out.println(s);
        }



    }
}
