package edu.uchicago.gerber.labjava.lec05.exceptions;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class FunnelDriver {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        byte[] arrayOfBytes;
        String password, filePath;
        boolean passwordVerified = false; //false is the default value, so we could leave the assignment off


        while (true) {

            try {
                if (!passwordVerified)    {
                    System.out.println("What is the password?");
                    password = scanner.nextLine();
                    passwordVerified = checkPass(password);
                }
                System.out.println("What is the absolute path to your file?");
                filePath = scanner.nextLine();
                arrayOfBytes = getBytes(filePath);
                break;

            //Exception Funnel
            } catch (Exception exception) {

                if (exception instanceof BadPasswordException){
                    System.out.println("Try again, you must have fat-fingered your password: " + exception.getMessage());
                } else if (exception instanceof IOException){
                    System.out.println("Try again, you path is invalid: " + exception.getMessage());
                } else {

                    System.out.println("Something bad happened: " + exception.getMessage());
                }


            }
        }
        System.out.println(new String(arrayOfBytes, Charset.defaultCharset()));

    }


    private static byte[] getBytes(String filePath) throws IOException {
        byte[] arrayOfBytes;
        arrayOfBytes = Files.readAllBytes(Paths.get(filePath));
        return arrayOfBytes;
    }


    private static boolean checkPass(String pass) throws BadPasswordException {

        if (!pass.equals("P@ssword")){
            throw new BadPasswordException(pass);
        }
        return true;

    }




}
