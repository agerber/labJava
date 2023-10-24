package edu.uchicago.gerber.labjava.lec10._03_util_concurrent.future_callable;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _01_HtmlFetchCallable implements Callable<String> {

    private final String url;

    public _01_HtmlFetchCallable(String url) {
        this.url = url;
    }

    @Override
    public String call() throws Exception {
        StringBuilder result = new StringBuilder();
        HttpURLConnection conn = null;
        BufferedReader reader = null;
        try {
            URL urlObj = new URL(url);
            conn = (HttpURLConnection) urlObj.openConnection();
            conn.setRequestMethod("GET");
            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (conn != null) {
                conn.disconnect();
            }
        }
        return result.toString();
    }

    public static void main(String[] args) throws Exception {
        String url = "http://gerber.cs.uchicago.edu/java"; // old java course url

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> future = executor.submit(new _01_HtmlFetchCallable(url));

        try {
            //this call will block until future.get() has a value!
            String htmlContent = future.get();
            System.out.println(htmlContent);
        } finally {
            executor.shutdown();
        }
    }
}
