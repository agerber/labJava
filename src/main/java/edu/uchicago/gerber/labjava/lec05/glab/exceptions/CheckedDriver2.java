package edu.uchicago.gerber.labjava.lec05.glab.exceptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

// https://stackoverflow.com/questions/6159118/using-java-to-pull-data-from-a-webpage
public class CheckedDriver2 {


    public static void main(String[] args)  {
        String url = "http://gerber.cs.uchicago.edu/java/index.html";
        try {
            readFromWeb(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void readFromWeb(String webURL) throws IOException {

        try {
            URL url = new URL(webURL);
            InputStream is =  url.openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
            throw new MalformedURLException("URL is malformed!!");
        }
        catch (IOException e) {
            e.printStackTrace();
            throw new IOException();
        }

    }




}