package edu.uchicago.gerber.labjava.lec01.glab;

public class CardDriver {
    public static void main(String[] args) {

        byte aceValue = 11;
        System.out.println(aceValue);


        Card cardKS = new Card('K', 'S', (byte)10);
        System.out.println(cardKS.getFace());



       // Card cardQS = new Card('Q', 'S', (byte)10);
        //Card cardAS = new Card('A', 'S', (byte)1);
      //  System.out.println(cardKS.toString());
      //  Player player1 = new Player("Adam", 50_000.09);
      //  System.out.println(player1.toString());


    }
}
