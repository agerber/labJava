package lec08.glab.javafx;

/**
 * Created by Adam on 7/28/2015.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exclusions {

    public static void main(String[] args) {

        //use file i/o to read file into a stream of lines

        List<String> allMatches = new ArrayList<>();
        Matcher m = Pattern.compile("rel=(.*?)</a>")
                .matcher(getStringFromFile());
        while (m.find()) {
            allMatches.add(m.group());
        }



        allMatches.stream().map(s -> {
           s = s.replace("rel=\"nofollow\">", "");
           s=  s.replace("</a>", "");
            return s;

        }).forEach(System.out::println);

    }


    private static String getStringFromFile(){

        //Path file = Paths.get("c:\\dev\\exclusions.txt");
        File file = new File("c:\\dev\\exclusions.txt");
        InputStream in = null;
        StringBuffer cBuf = new StringBuffer();
        try {

             in = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line = null;

            while ((line = reader.readLine()) != null) {
               // System.out.println(line);
                cBuf.append("\n");
                cBuf.append(line);
            }
        } catch (IOException x) {
            System.err.println(x);
        } finally {
            if (in != null) try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
// cBuf.toString() will contain the entire file contents
        return cBuf.toString();
    }


}
