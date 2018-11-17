package lec03.glab.singagain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class OchrestraSinging {

    public static void main(String[] args) {

        List<Singable> singers = new LinkedList<>();

        singers.add(new Bear());
        singers.add(new Frog());
        singers.add(new Chipmunk());


        for (Singable singer : singers) {
            System.out.println( singer.dance() + "\n" + singer.sing());
        }

    }
}