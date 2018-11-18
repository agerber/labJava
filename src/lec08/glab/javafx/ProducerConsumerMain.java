/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lec08.glab.javafx;


import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 *
 * @author ag
 */
public class ProducerConsumerMain extends Application {

    //this is the
    // private ConcurrentLinkedQueue<String> broker = new ConcurrentLinkedQueue<>();
    //this simulates a list of web sites or web services
    private ArrayList<String> sites = new ArrayList<>();

    private Random random = new Random();
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 800, 600, Color.BLACK);
        primaryStage.setScene(scene);

        //search engine sites and web services
        sites.add("faroo");
        sites.add("yahoo");
        sites.add("google");
        sites.add("someweb");
        sites.add("anotherweb");
        sites.add("thisweb");
        sites.add("thatweb");
        sites.add("restweb");

        Button btnGo = new Button("Producer-Consumer");
        Label lbl = new Label("This is a simulation: see console output");
        //ThreadFactory is a functional interface and we may therefore use a lambda: see the intelliJ hint for this
        final ExecutorService producer = Executors.newFixedThreadPool(3, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setDaemon(true);
                return t;
            }
        });
        //ThreadFactory is a functional interface and we may therefore use a lambda: see the intelliJ hint for this
        final ExecutorService consumer = Executors.newFixedThreadPool(15, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setDaemon(true);
                return t;
            }
        });

        //this handles a successful ConsumerTask
        //EventHandler is a functional interface and we may therefore use a lambda: see the intelliJ hint for this
        final EventHandler<WorkerStateEvent> consumerTaskHandler = new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                //report on successful download of file
                System.out.println(event.getSource().getValue());

            }
        };

        //this handles a successful ProducerTask
        //EventHandler is a functional interface and we may therefore use a lambda: see the intelliJ hint for this
        final EventHandler<WorkerStateEvent> producerTaskHandler = new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {

                ConsumerTask consumerTask;
                for (String url : (ArrayList<String>) event.getSource().getValue()) {
                    //this will queue up values on the consumer executor
                    consumerTask = new ConsumerTask(url, 5000);
                    //make sure we're calling back on success for each one
                    consumerTask.setOnSucceeded(consumerTaskHandler);
                    //this is a thread-pool with 15 threads
                    consumer.execute(consumerTask);
                }

            }
        };

        //EventHandler is a functional interface and we may therefore use a lambda: see the intelliJ hint for this
        btnGo.setOnAction(new EventHandler<ActionEvent>() {

                              @Override
                              public void handle(ActionEvent event) {
                                  System.out.println("BEGIN FETCHING URLS");
                                  //seed the producer with the list of restful web services and web search engines

                                  //we could also use a strea().forEach(). but there's no need.
                                  ProducerTask producerTask;
                                  for (String site : sites) {
                                      producerTask = new ProducerTask(site);
                                      //make sure we're calling back on success for each one
                                      producerTask.setOnSucceeded(producerTaskHandler);
                                      //this is a thread-pool with 3 threads
                                      producer.execute(producerTask);


                                  }
                              }
                          }
        );

        //just add button and label to root and display
        root.setCenter(btnGo);
        root.setBottom(lbl);
        primaryStage.setTitle("Producer-Consumer example");
        primaryStage.setHeight(200);
        primaryStage.setWidth(300);
        primaryStage.show();

    }

    //generates an arraylist with random number of strings
    public ArrayList<String> generateRandomUrls(String site, int numberOfWords) {
        ArrayList<String> strReturns = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < numberOfWords; i++) {
            char[] word = new char[random.nextInt(18) + 10];
            for (int j = 0; j < word.length; j++) {

              boolean  bForwardSlash = (new Random().nextInt(100) > 90);
                if (!bForwardSlash)
                    word[j] = (char) ('a' + random.nextInt(26));
                else
                    word[j] = '/';
            }
            strReturns.add(site + " : http://" + new String(word) + ".pdf");
        }
        return strReturns;
    }
//

    class ProducerTask extends Task<ArrayList<String>> {

        private String strSite;

        public ProducerTask(String strSite) {
            this.strSite = strSite;
        }

        @Override
        protected ArrayList<String> call() throws Exception {
            Thread.sleep(random.nextInt(5000));
            //simulate culling urls from web-services or websites
            return generateRandomUrls(strSite, random.nextInt(50) + 10);
        }

    }

    class ConsumerTask extends Task<String> {

        private String strUrl;
        private int nDownThreshold;

        public ConsumerTask(String strUrl, int downThresh) {
            this.strUrl = strUrl;
            this.nDownThreshold = downThresh;
        }

        //in a Task, the call() method is a proxy for run()
        @Override
        protected String call() throws Exception {

            Thread.sleep(random.nextInt(3500));

            return "finished downloading from " + strUrl;




        }

    }

}