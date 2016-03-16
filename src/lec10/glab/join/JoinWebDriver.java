package lec10.glab.join;

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


        WebRunner webRunner = new WebRunner("http://java-class.cs.uchicago.edu/");
        Thread thrWeb = new Thread(webRunner);

        thrWeb.start();


        //comment-out the following try-catch to see the difference in results.

        //this joins thread thrWeb to the main thread.
        try {
            thrWeb.join();

        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        System.out.println(webRunner.getReturnValue());

    }


    private static class WebRunner implements Runnable {

        private String strUrl;
        private String strReturnValue;

        private WebRunner(String strUrl) {
            this.strUrl = strUrl;
        }

        @Override
        public void run() {
            try {
                String strRet = "";
                URL urlObject = new URL(strUrl);
                URLConnection con = urlObject.openConnection();
                InputStream is = con.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String strLine = "";

                while ((strLine = br.readLine()) != null) {
                    strRet += strLine + "\n";
                }
                strReturnValue = strRet;

            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }


        }

        private String getReturnValue() {
            return strReturnValue;
        }


    }
}



