package edu.uchicago.gerber.labjava.lec01.hlab;

/**
 7) Remember the childhood game “Rock, Paper, Scissors”? It is a two-player game in which each person simultaneously
 chooses either rock, paper, or scissors. Rock beats scissors but loses to paper, paper beats rock but loses to scissors,
 and scissors beats paper but loses to rock. The following code prompts player 1 and player 2 to each enter a
 string: rock, paper, or scissors. Finish the code by adding nested if statements to appropriately report “Player 1
 wins”, “Player 2 wins”, or “It is a tie.”
 */
import java.util.Scanner;
public class RockPaperScissors
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Player 1: Choose rock, scissors, or paper:");
        String player1 = scan.next().toLowerCase();
        System.out.println("Player 2: Choose rock, scissors, or paper:");
        String player2 = scan.next().toLowerCase();
        if (player1.equals("rock"))
        {
            if (player2.equals("rock"))
            {
                System.out.println("It is a tie.");
            }
            if (player2.equals("scissors"))
            {
                System.out.println("Player 1 wins.");
            }
            if (player2.equals("paper"))
            {
                System.out.println("Player 2 wins.");
            }
        }
        else if (player1.equals("scissors"))
        {
            if (player2.equals("rock"))
            {
                System.out.println("Player 2 wins.");
            }
            if (player2.equals("scissors"))
            {
                System.out.println("It is a tie.");
            }
            if (player2.equals("paper"))
            {
                System.out.println("Player 1 wins.");
            }
        }
        else if (player1.equals("paper"))
        {
            if (player2.equals("rock"))
            {
                System.out.println("Player 1 wins.");
            }
            if (player2.equals("scissors"))
            {
                System.out.println("Player 2 wins.");
            }
            if (player2.equals("paper"))
            {
                System.out.println("It is a tie.");
            }
        }
    }
}