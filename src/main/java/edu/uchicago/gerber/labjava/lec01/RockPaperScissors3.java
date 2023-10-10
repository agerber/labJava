package edu.uchicago.gerber.labjava.lec01;

/**
Implement Rock, Paper, Scissors using switch(String) - with Java7 only.
 */
import java.util.Scanner;

public class RockPaperScissors3
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Player 1: Choose rock, scissors, or paper:");
        String strPlayer1 = scan.next().toLowerCase();
        System.out.println("Player 2: Choose rock, scissors, or paper:");
        String strPlayer2 = scan.next().toLowerCase();







        switch (strPlayer1){
            case "rock":
                switch (strPlayer2){
                    case "rock":
                        System.out.println("Tie");
                        break;
                    case "paper":
                        System.out.println("Player two wins: " + strPlayer2 + " beats " + strPlayer1);
                        break;
                    case "scissors":
                        System.out.println("Player one wins: " + strPlayer1 + " beats " + strPlayer2);
                        break;
                    default:
                        System.out.println("can't play "+ strPlayer2);
                }
                break;
            case "paper":
                switch (strPlayer2){
                    case "rock":
                        System.out.println("Player one wins: " + strPlayer1 + " beats " + strPlayer2);
                        break;
                    case "paper":
                        System.out.println("Tie");
                        break;
                    case "scissors":
                        System.out.println("Player two wins: " + strPlayer2 + " beats " + strPlayer1);
                        break;
                    default:
                        System.out.println("can't play "+ strPlayer2);
                }
                break;
            case "scissors":
                switch (strPlayer2){
                    case "rock":
                        System.out.println("Player two wins: " + strPlayer2 + " beats " + strPlayer1);
                        break;
                    case "paper":
                        System.out.println("Player one wins: " + strPlayer1 + " beats " + strPlayer2);
                        break;
                    case "scissors":
                        System.out.println("Tie");
                        break;
                    default:
                        System.out.println("can't play "+ strPlayer2);
                }
                break;
            default:
                System.out.println("can't play "+ strPlayer1);
        }

    }
}
