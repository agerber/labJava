package lec02.glab;

import java.util.Date;

public class InterDriver {

    public static void main(String[] args) {

        Intern intern = new Intern();

       // the new keyword/cosntrutor returns the memory address (on the heap) to the newly constructed object

        Intern firstIntern = new Intern("Alice");

       // firstIntern.setName("Bob");

        new Intern("David");

        System.out.println(firstIntern.getName());
        System.out.println(new Intern());
        System.out.println(new Date());




        String strAdam = new String("Adam");


        char cChar = 'a';

        strAdam = strAdam.toLowerCase().replace(cChar, 'o');
        System.out.println(strAdam);

        double dPow = Math.pow(2,3);
        System.out.println(dPow);






    }
}
