package edu.uchicago.gerber.labjava.lec05.exceptions;

import java.util.Scanner;

public class DealingWithUserInput {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int num = -999;
        String input = "";

        while (true){
            System.out.println("Enter your integer or exit to quit:");
            try {
                input = in.nextLine();
                num =  Integer.parseInt(input);
                break;
            } catch (NumberFormatException e) {
                if (input.equalsIgnoreCase("exit")) break;
                System.out.println("Sorry, try again. " + e.getMessage());
            }
        }

        if (num == -999) return;
        System.out.println("Well done, " + num + " is an integer." );



    }
}
