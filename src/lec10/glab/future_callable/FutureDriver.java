package lec10.glab.future_callable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 * User: ag
 * Date: 11/30/13
 * Time: 9:12 PM
 * To change this template use File | Settings | File Templates.
 */
//https://blogs.oracle.com/CoreJavaTechTips/entry/get_netbeans_6
public class FutureDriver {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(3);

        Callable<String> callableJavaClass = new WebsiteCallable("http://gerber.cs.uchicago.edu/java/");
        Callable<String> callableAndroidClass = new WebsiteCallable("http://gerber.cs.uchicago.edu/android/");
        //notice that the future object's generic maps directly to the Callable's generic.
        Future<String> futureJava = pool.submit(callableJavaClass);
        Future<String> futureAndroid = pool.submit(callableAndroidClass);


        try {
            //when this Callable task finishes, you can call the get() method on it's future
            System.out.println(futureJava.get());
            printSeperator(20);
            System.out.println(futureAndroid.get());

        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (ExecutionException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        System.exit(0);
    }

    private static void printSeperator(int nSep) {
        for (int nC = 0; nC <nSep ; nC++) {
            System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&-SEPERATOR-&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        }
    }


    public static class WebsiteCallable
            implements Callable<String> {
        private String strUrl;

        public WebsiteCallable(String strUrl) {
            this.strUrl = strUrl;
        }

        //the Callable interface is genericized and it requires that the call method return the generic type
        public String call() {
            String strRet = "";
            try {

                URL urlObject = new URL(strUrl);

                URLConnection con = urlObject.openConnection();
                InputStream is =con.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String strLine = null;

                while ((strLine = br.readLine()) != null) {
                    strRet += strLine + "\n";
                }
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }

            return strRet;

        }
    }
}
