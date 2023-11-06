package edu.uchicago.gerber.labjava.lec05.exceptions;

import java.util.Scanner;

public class DealingWithUserInput {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int num;

        while (true){
            System.out.println("Enter your integer:");
            try {
                num =  Integer.parseInt(in.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.print("Sorry, try again. ");
            }
        }

        System.out.println("Well done, " + num + " is an integer." );



    }
}
