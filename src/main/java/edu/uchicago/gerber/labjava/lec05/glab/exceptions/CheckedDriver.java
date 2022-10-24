package edu.uchicago.gerber.labjava.lec05.glab.exceptions;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class CheckedDriver {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        byte[] arrayOfBytes;


        while (true) {

            System.out.println("What is the absolute path to your file?");
            String filePath = scanner.nextLine();
            try {
                arrayOfBytes = getBytes(filePath);
                break;
            } catch (IOException exception) {
                System.out.println("Try again, this path is invalid: " + exception.getMessage());
            }
        }
        System.out.println(new String(arrayOfBytes, Charset.defaultCharset()));

    }


    private static byte[] getBytes(String filePath) throws IOException {
        byte[] arrayOfBytes;
        arrayOfBytes = Files.readAllBytes(Paths.get(filePath));
        return arrayOfBytes;
    }






}
