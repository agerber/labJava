package edu.uchicago.gerber.labjava.lec01.hlab;

/**
 8) The program in Lab 3.7 was heavily nested with if statements, and it can be difficult to follow the logic of any
 program that is heavily nested in this way. By constructing complex conditions with the && operator, it is possible to
 simplify the code and remove some of the else alternatives. Rewrite the program in Lab 3.7 using complex conditions and
 omitting the else construct.
 */
import java.util.Scanner;
public class RockPaperScissors2
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Player 1: Choose rock, scissors, or paper:");
        String player1 = scan.next().toLowerCase();
        System.out.println("Player 2: Choose rock, scissors, or paper:");
        String player2 = scan.next().toLowerCase();
        if (player1.equals("rock") && player2.equals("rock"))
        {
            System.out.println("It is a tie.");
        }
        if (player1.equals("rock") && player2.equals("scissors"))
        {
            System.out.println("Player 1 wins.");
        }
        if (player1.equals("rock") && player2.equals("paper"))
        {
            System.out.println("Player 2 wins.");
        }
        if (player1.equals("scissors") && player2.equals("rock"))
        {
            System.out.println("Player 2 wins.");
        }
        if (player1.equals("scissors") && player2.equals("scissors"))
        {
            System.out.println("It is a tie.");
        }
        if (player1.equals("scissors") && player2.equals("paper"))
        {
            System.out.println("Player 1 wins.");
        }
        if (player1.equals("paper") && player2.equals("rock"))
        {
            System.out.println("Player 1 wins.");
        }
        if (player1.equals("paper") && player2.equals("scissors"))
        {
            System.out.println("Player 2 wins.");
        }
        if (player1.equals("paper") && player2.equals("paper"))
        {
            System.out.println("It is a tie.");
        }
    }
}
