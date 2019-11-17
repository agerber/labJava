package lec02.glab;

public class InterDriver {

    public static void main(String[] args) {

        //the new keyword/cosntrutor returns the memory address (on the heap) to the newly constructed object

        Intern firstIntern = new Intern("Alice");

        new Intern("David");

        System.out.println(firstIntern);
        System.out.println(new Intern());



    }
}
