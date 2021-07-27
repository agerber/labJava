package edu.uchicago.gerber.labjava.lec04.glab.vetsagain;

public class VetDriver {

    public static void main(String[] args) {

        //create some Veterans
        Veteran vetJake = new Veteran("Jake", 32);
        Veteran vet2 = new Veteran("G-Money", 32);
        Veteran vetJJ = new Veteran("JJ", 32);


        Veteran vet4 = new Veteran("Lance", 32);

        Veteran vetMike = new Veteran("The Hammer", 32);
        vetMike.setJuniors(new Veteran("Carol", 30), new Veteran("Marcia", 17), new Veteran("Jan", 15),  new Veteran("Cindy", 15));



        printVets(vetJake, vet2, vetJJ, vet4, vetMike);




    }

    private static void printVets(Veteran... vets){

       Veteran[] vets2 = vets;

        for (Veteran vet : vets) {
            System.out.println(vet);
        }

    }
}
