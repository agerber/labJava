package lec06.glab.exceptions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class CheckedDriver {

    public static void main(String[] args)  {

        Scanner scanner = new Scanner(System.in);
        byte[] array = null;

        while (true){
            try {
                System.out.println("What is the absolute path to your file?");

                String filePath = scanner.nextLine();

                array = getBytes(filePath);
                break;
            } catch (IOException e) {
                System.out.println("You got an error " + e.getMessage());
                continue;
            }
        }



        System.out.println(array);


    }

    private static byte[] getBytes(String filePath) throws IOException {
        byte[] array;
        array = Files.readAllBytes(Paths.get(filePath));
        return array;
    }
}
