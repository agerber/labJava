package lec05.glab.debug;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by ag on 10/27/2014.
 */
public class CheckedDriver {

    public static void main(String[] args) {


       // boolean bSuccessOrCancelled = false;
        String strPath = "";
        Scanner scanner = new Scanner(System.in);


      //  FileInputStream  fis = new FileInputStream("B:/myfile.txt");

       String strReturn = excutePost("http://java-class.cs.uchicago.edu/index.html");
        System.out.println(strReturn);


        do {

            System.out.println("What is your path? or 'q' to exit");
            strPath = scanner.nextLine();
            if (strPath.equalsIgnoreCase("q")){
                break;
            }

            try {
                File file = getFile(strPath);
                System.out.println("Well done, you found a file at: " + file.getPath());


                break;

            } catch (YourLocalFileNotFoundException e) {
               // e.printStackTrace();
                System.out.println(e.getMessage());
                continue;
            }


        } while (true);




    }

    private static File getFile(String str) throws  YourLocalFileNotFoundException {



        File file = new File(str);
        if (file.isFile()){
            return file;
        } else {
            throw new YourLocalFileNotFoundException("you need to supply another path.");
        }

//        if (!str.equalsIgnoreCase("c:/file.txt")){
//                throw new YourLocalFileNotFoundException("you need to supply another path.");
//        }
//
//        return true;

    }



    public static String excutePost(String targetURL) {
        StringBuilder stringBuilder = new StringBuilder();
        InputStreamReader inputStreamReader = null;


        try {
            URL url = new URL(targetURL);
            inputStreamReader = new InputStreamReader(url.openStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String strTemp = "";

            while (null != (strTemp = bufferedReader.readLine())){
                stringBuilder.append(strTemp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return stringBuilder.toString();



    }
}
