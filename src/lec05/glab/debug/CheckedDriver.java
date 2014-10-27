package lec05.glab.debug;

import javax.swing.*;
import java.util.Scanner;

/**
 * Created by ag on 10/27/2014.
 */
public class CheckedDriver {

    public static void main(String[] args) {


        boolean bSuccessOrCancelled = false;
        String strPath = "";
        Scanner scanner = new Scanner(System.in);

        do {

            System.out.println("What is your path? or 'q' to exit");
            strPath = scanner.nextLine();
            if (strPath.equalsIgnoreCase("q")){
                break;
            }

            try {
                if( isGoodPath(strPath)){
                    System.out.println("Well done!");
                    break;
                }
            } catch (YourLocalFileNotFoundException e) {
               // e.printStackTrace();
                System.out.println(e.getMessage());
                continue;
            }


        } while (true);




    }

    private static boolean isGoodPath(String str) throws  YourLocalFileNotFoundException {

        if (!str.equalsIgnoreCase("c:/file.txt")){
                throw new YourLocalFileNotFoundException("you need to supply another path.");
        }

        return true;

    }
}
