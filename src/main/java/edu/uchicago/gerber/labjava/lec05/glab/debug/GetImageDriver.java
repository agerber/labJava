package edu.uchicago.gerber.labjava.lec05.glab.debug;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class GetImageDriver {

    public static void main(String[] args) {


        //dealing with checked excpetions.
        //Not a good idea to throw an exception off the main method as this is adjascent to the JVM.

        Scanner scanner = new Scanner(System.in);


        while (true){


            System.out.println("What is the full path to your file or type \"quit\" to exit:");
            String strInput = scanner.nextLine();
            if (strInput.equalsIgnoreCase("quit"))
                break;

            try {
                printFile(strInput);
            } catch (YourLocalFileNotFoundException e) {

                System.out.println(e.getMessage());
                continue;

                //e.printStackTrace();
            }
        }


    }

    private static void printFile(String str) throws YourLocalFileNotFoundException {
        try {
            FileReader file = new FileReader(str);
            BufferedReader fileInput = new BufferedReader(file);

            // Print first 3 lines of file "C:\test\a.txt"
            for (int counter = 0; counter < 3; counter++)
                System.out.println(fileInput.readLine());

            fileInput.close();
        } catch (IOException e) {
            throw new YourLocalFileNotFoundException(str);
        }
    }
}
