package lec05.glab.exceptions;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class CheckedDriver {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        byte[] array = null;


        while (true) {

            System.out.println("What is the absolute path to your file?");
            String filePath = scanner.nextLine();
            try {
                array = getBytes(filePath);
                break;
            } catch (IOException e) {
                System.out.println("You got an excep[t here " + e.getMessage());
            }
        }
        System.out.println(new String(array, Charset.defaultCharset()));

    }


    private static byte[] getBytes(String filePath) throws IOException {
        byte[] array;
        array = Files.readAllBytes(Paths.get(filePath));
        return array;
    }






}
