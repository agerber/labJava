package edu.uchicago.gerber.labjava.lec10.glab.multi_core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 * User: ag
 * Date: 11/30/13
 * Time: 10:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class JoinWebDriverCallable {

      public static void main(String[] args) {

          ExecutorService executor = Executors.newFixedThreadPool(3);

          String[] strUrls = {"http://gerber.cs.uchicago.edu/java",
                  "http://gerber.cs.uchicago.edu/advjava",
                  "http://gerber.cs.uchicago.edu/android"};

          List<Future<String>> list = new ArrayList<Future<String>>();

          for (String strUrl : strUrls) {


                  Future<String> future = executor.submit(new WebCallable(strUrl));
                  //add Future to the list, we can get return value using Future
                  list.add(future);

          }

          for(Future<String> fut : list){
              try {
                  //print the return value of Future, notice the output delay in console
                  // because Future.get() waits for task to get completed
                  System.out.println(new Date()+ "::"+fut.get());
              } catch (InterruptedException | ExecutionException e) {
                  e.printStackTrace();
              }
          }
          //shut down the executor service now
          executor.shutdown();
          System.out.println("done");





    }


    private static class WebCallable implements Callable<String> {

        private String strUrl;


        private WebCallable(String strUrl) {
            this.strUrl = strUrl;
        }






        @Override
        public String call() throws Exception {
            String strRet = "";
            try {

                URL urlObject = new URL(strUrl);
                URLConnection con = urlObject.openConnection();
                InputStream is = con.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String strLine = "";

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



