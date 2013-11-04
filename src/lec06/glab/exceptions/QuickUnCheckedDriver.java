package lec06.glab.exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: ag
 * Date: 11/4/13
 * Time: 12:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class QuickUnCheckedDriver {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        while(true){
            System.out.println("Please type a valid integer or exit to quit:");
            String strValue = scan.next();
            if(strValue.equalsIgnoreCase("exit")){
                break;
            }
            try {
                System.out.println("Echo: "  + Integer.parseInt(strValue));
            } catch (Exception e) {
                System.out.println("That's not valid input, try again");
                continue;
            }
            System.out.println("Thank you, let's try again.");

        }
        System.out.println("game over");


    }



}
