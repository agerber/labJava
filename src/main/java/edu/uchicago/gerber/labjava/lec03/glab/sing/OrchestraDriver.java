package edu.uchicago.gerber.labjava.lec03.glab.sing;

public class OrchestraDriver {

    public static void main(String[] args) {

     //https://www.asciiart.eu/animals/

//        Singable sing1 = new Bear();
//        Singable sing2 = new Frog();



        Singable[] singables = {new Bear(), new Frog(), new Chipmunk()};



        for (int nC = 0; nC < 100; nC++) {
            Singable singable = singables[(int) (Math.random() * 3)];
            System.out.println(singable.dance() + "\n" + singable.sing());
        }


    }
}
