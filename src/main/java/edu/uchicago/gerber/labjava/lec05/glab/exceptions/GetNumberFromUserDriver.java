package edu.uchicago.gerber.labjava.lec05.glab.exceptions;

import java.util.Scanner;

public class GetNumberFromUserDriver {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int number;

        while (true){
            System.out.println("what is your integer");
            String response = scanner.nextLine();
            try {
                number = Integer.parseInt(response);
                break;
            } catch (NumberFormatException e) {
                System.out.print("try again, ");
            }

        }
        System.out.println("congrats, your number is " + number);

    }
}
