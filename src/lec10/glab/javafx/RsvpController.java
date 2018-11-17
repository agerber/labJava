package lec10.glab.javafx;

import javafx.animation.Interpolator;
import javafx.animation.ScaleTransition;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

//some web services
//http://www.programmableweb.com/category/all/apis?data_format=21190

//http://www.programmableweb.com/category/all/apis?data_format=21190
//
//http://www.programmableweb.com/api/new-york-times-movie-reviews
//
//http://blog.musicplayr.com/api


public class RsvpController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private Button button;
    @FXML
    private Rectangle recBox;

    Task task;
    
    public static final int DELAY = 300;

    @FXML
    private void handleButtonAction(ActionEvent event) {
     

        button.setDisable(true);
        label.setText("");


        recBox.setVisible(true);

        //this will do the scale transition
        ScaleTransition st = new ScaleTransition(Duration.seconds(1.0), recBox);
        st.setInterpolator(Interpolator.EASE_IN);
        st.setFromX(3);
        st.setToX(0);

        //once we finish, we fire off the task
        st.setOnFinished(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                    //do something 
                // System.out.println("finished");
                initRsvp();
                new Thread(task).start();

            }
        });

        st.play();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        recBox.setVisible(false);
        label.setText("");

       
    }
    
    
     private int addDelay(String strWord, int nDelay) {
        switch (strWord.substring(strWord.length() - 1)) {
            case ":":
                return nDelay / 2;
            case ";":
                return nDelay / 2;
            case ",":
                return nDelay / 2;
            case ".":
                return nDelay;
            case "!":
                return nDelay;
            case "?":
                return nDelay;
            default:
                return 0;
        }
    }
    
    
    private void initRsvp(){
     
        String strWhole = "Humans might be the one problem Google can't solve. "
            
                + "For the past four years, Google has been working on self-driving cars with a mechanism to return control of the steering wheel to the driver in case of emergency. But Google's brightest minds now say they can't make that handoff work anytime soon. "
           
                + "Their answer? Take the driver completely out of the driving. "
             
                + "The company has begun building a fleet of 100 experimental electric-powered vehicles that will dispense with all the standard controls found in modern automobiles. The two-seat vehicle looks a bit like the ultracompact Fiat 500 or the Mercedes-Benz Smart car if you take out the steering wheel, gas pedal, brake and gear shift. The only things the driver controls is a red \"e-stop\" button for panic stops and a separate start button. "
          
                + "The car would be summoned with a smartphone application. It would pick up a passenger and automatically drive to a destination selected on a smartphone app without any human intervention.";

        final String[] strVals = strWhole.split(" ");
   

        task = new Task<Void>() {

            @Override
            protected Void call() throws Exception {

                for (final String str : strVals) {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            label.setText(str);
                        }
                    });
                    //DELAY words per minute
                    Thread.sleep((60 * 1000 / DELAY )  );
                }

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        button.setDisable(false);
                    }
                });

                return null;
            }
        };
    }
}
