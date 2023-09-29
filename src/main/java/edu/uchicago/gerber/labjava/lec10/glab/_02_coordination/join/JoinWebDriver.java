package edu.uchicago.gerber.labjava.lec10.glab._02_coordination.join;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created with IntelliJ IDEA.
 * User: ag
 * Date: 11/30/13
 * Time: 10:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class JoinWebDriver {

      public static void main(String[] args) {

      System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getState());

      WebRunner webRunner = new WebRunner("http://gerber.cs.uchicago.edu/java");
      webRunner.setName("webRunner");
      System.out.println(webRunner.getName() + ":" + webRunner.getState().toString().toUpperCase()); // NEW



        webRunner.start();
        //comment-out the following try-catch to see the difference in results.

       //join does the following things. 1/ sets the main into a wait() state. 2/ adds itself to the waitSet of
          // webRunner

        try {
            webRunner.join();
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        System.out.println(webRunner.getReturnValue());
        System.out.println(Thread.currentThread().getName() + ":TERMINATED");

    }


    private static class WebRunner extends Thread {



        private String strUrl;
        private String strReturnValue;

        private WebRunner(String strUrl) {
            this.strUrl = strUrl;
        }


        @Override
        public void start() {
            super.start();
            System.out.println(this.getName() + ":" + this.getState().toString().toUpperCase());

        }

        @Override
        public void run() {
            try {

                System.out.println(this.getName() + ": go fetch html from website");

                URL urlObject = new URL(strUrl);
                URLConnection con = urlObject.openConnection();
                InputStream is = con.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                StringBuilder stringBuilder  = new StringBuilder();
                String strLine;

                while ((strLine = br.readLine()) != null) {
                   stringBuilder.append(strLine).append("\n");
                }
                strReturnValue = stringBuilder.toString();

            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            finally {
                System.out.println(this.getName() + ":TERMINATED");
            }


        }

        private String getReturnValue() {
            return strReturnValue;
        }


    }
}



