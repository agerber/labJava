package edu.uchicago.gerber.labjava.lec05.exceptions;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class _CheckedDriver {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        byte[] arrayOfBytes;
        System.out.println("What is the absolute path to your file?");
        String filePath = scanner.nextLine();
       // arrayOfBytes = Files.readAllBytes(Paths.get(filePath));
      //  System.out.println(new String(arrayOfBytes, Charset.defaultCharset()));


    }


}
