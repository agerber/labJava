/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lec08.glab.javafx.concurrency;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class ThreadsMain extends Application implements Initializable{

    @Override
    public void start(Stage primaryStage) throws IOException {
        //the order is reversed from hierarchy
       // Parent root = FXMLLoader.load(getClass().getResource("/fxml/Threads.fxml"));
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Threads.fxml"));
        Parent root = (Parent) loader.load();
       // ThreadsController controller =  loader.getController();
        setStage(primaryStage);
        
        
        Scene scene = new Scene(root, 800, 600, Color.WHITE);
        //scene.getStylesheets().add("/styles/yelp.css");
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    //controller

    @FXML
    private Button btnThCancel;
    @FXML
    private Button btnSvStart;
    @FXML
    private ProgressBar prgThread;
    @FXML
    private ProgressBar prgService;
    @FXML
    private Button btnThStart;
    @FXML
    private Button btnSvCancel;

    private Stage primaryStage;




    public void setStage(Stage stage) {
        this.primaryStage = stage;
    }




    private FirstLineService service = new FirstLineService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {


        prgThread.progressProperty().bind(task.progressProperty());
        prgService.progressProperty().bind(service.progressProperty());


        service.stateProperty().addListener(new ChangeListener<Worker.State>() {
            @Override
            public void changed(ObservableValue<? extends Worker.State> observableValue, Worker.State oldState, Worker.State newState) {
                switch (newState) {
                    case SCHEDULED:
                        System.out.println("S:SCHEDULED");
                        //roperty().bind(friendFinder.progressProperty());  // workaround, we should be able to permanently bind to the progress, but unless we do this sometimes the progress does not always reach the end.
                        break;
                    case READY:
                        System.out.println("S:READY");
                        break;
                    case RUNNING:
                        System.out.println("S:RUNNING");
                        break;
                    case SUCCEEDED:
                        // we should be able to permanently bind to the progress, but unless we do this sometimes the progress does not always reach the end. (even this workaround didn't work, so I have no idea about this...)
                        System.out.println("S:SUCCEEDED");

                        btnSvStart.setText("success");

                        try {
                            System.out.println("S: The time is now: " + service.getValue());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        break;
                    case CANCELLED:
                        System.out.println("S:CANCELLED");
                        break;
                    case FAILED:
                        System.out.println("S:FAILED");
                        break;
                }
            }
        });

        task.stateProperty().addListener(new ChangeListener<Worker.State>() {
            @Override
            public void changed(ObservableValue<? extends Worker.State> observableValue, Worker.State oldState, Worker.State newState) {
                switch (newState) {
                    case SCHEDULED:
                        System.out.println("T:SCHEDULED");

                        break;
                    case READY:
                        System.out.println("T:READY");
                        break;
                    case RUNNING:
                        System.out.println("T:RUNNING");
                        break;
                    case SUCCEEDED:
                        // we should be able to permanently bind to the progress, but unless we do this sometimes the progress does not always reach the end. (even this workaround didn't work, so I have no idea about this...)
                        System.out.println("T:SUCCEEDED");
                        try {
                            System.out.println("T:" + task.get());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case CANCELLED:
                        System.out.println("T:CANCELLED");
                        break;
                    case FAILED:
                        System.out.println("T:FAILED");
                        break;
                }
            }
        });


    }

    @FXML
    private void btnSvStart_start(ActionEvent event) {

        service.restart();

        btnSvStart.setText("started");


    }

    @FXML
    private void btnSvCancel_cancel(ActionEvent event) {
        service.cancel();

        btnSvStart.setText("restart");

    }

    @FXML
    private void btnThStart_start(ActionEvent event) {
        new Thread(task).start();
    }

    @FXML
    private void btnThCancel_cancel(ActionEvent event) {

        task.cancel(true);
    }

    class FirstLineService extends Service<Date> {

        private IntegerProperty counter = new SimpleIntegerProperty();

        //must be set as final
        public final void setCounter(int n) {
            counter.set(n);
        }

        //must be set as final
        public final int getCounter() {
            return counter.get();
        }

        //return the property itself so that others can observe it
        public IntegerProperty getCounterProperty() {
            return counter;
        }

        @Override
        protected Task<Date> createTask() {
            return new Task<Date>() {

                @Override
                protected Date call() throws Exception {

                    while (getCounter() < 100) {
                        if (isCancelled()) {
                            break;
                        }
                        Thread.sleep(100);
                        setCounter(getCounter() + 1);
                        updateProgress(getCounter(), 100);
                    }
                    //return a date object initialized to right now.
                    return new Date();
                }

            };
        }



    }


    //the parameterized value is the return which can be accessed using .get(). This is why this is future/callable.
    private Task task = new Task<String>() {
        @Override
        protected String call() throws Exception {
            int nC = 0;
            while (nC < 100) {
                if (isCancelled()) {
                    break;
                }
                Thread.sleep(50);
                updateProgress(nC++, 100);
            }
            //complete
            updateProgress(100,100);
            return "The Task is done!";

        }

    };


}
