package edu.uchicago.gerber.labjava.lec03.glab.boxing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: ag
 * Date: 9/26/13
 * Time: 3:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class FileOps {

    //pass in a path to a file that is relative to the root such as "//src//P0_3//godzilla.txt"
    public static String convertFileToString(String strFileName){
        String strR = "";
        String strPath =  System.getProperty("user.dir") + strFileName ;
        Scanner in;
        File fileInput = new File(strPath);
        try {
            in = new Scanner(fileInput);
        } catch (FileNotFoundException e) {
            return "There's been an error: " + e.getMessage();

        }
        while(in.hasNextLine()){
            strR += in.nextLine() + "\n";
        }
        return strR;
    }


}
