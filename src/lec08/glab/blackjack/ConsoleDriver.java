package lec08.glab.blackjack;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: ag
 * Date: 11/16/13
 * Time: 1:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class ConsoleDriver {
    public static void main(String[] args) {
        BlackJack blackJack = new BlackJack();
        Scanner scan = new Scanner(System.in);

        outer:
        while (true){
            System.out.println(blackJack.status());
            System.out.println("hit (h) stick (s) or double down (d) or (x) to exit:");
            String strResponse = scan.nextLine();
            switch (strResponse){
                case "h":
                    blackJack.getDealer().hitPlayer();
                    System.out.println(blackJack.showPlayersTurn());
                    break;
                case "s":
                    blackJack.getDealer().hitDealer();
                    System.out.println(blackJack.showPlayersTurn());

                    break;
                case "d":

                    break;
                case "x":
                    break outer;
            }

        }
        System.out.println("Thank you for playing.");

    }






}
