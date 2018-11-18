/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lec08.glab.javafx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PbarsMain extends Application {

    final Float[] values = new Float[]{-1.0f, 0f, 0.6f, 1.0f};
    final Label[] labels = new Label[values.length];
    final ProgressBar[] pbs = new ProgressBar[values.length];
    final ProgressIndicator[] pins = new ProgressIndicator[values.length];
    final HBox hbs[] = new HBox[values.length];

    private Task task;

    @Override
    public void start(Stage stage) {

        //stage
            //scene
                 //root

        Group root = new Group();
        Scene scene = new Scene(root, 300, 150);
        // scene.getStylesheets().add("progresssample/Style.css");
        stage.setScene(scene);
        stage.setTitle("Progress Controls");


        //Task implements the Woker interface. Service also implments the Worker interface.  Worker in turn implements the future/callable Interface.
        task = new Task<Void>() {

            @Override
            protected Void call() throws Exception {

                //wait 3 seconds so we can see the orig state
                Thread.sleep(1000 * 3);
                //bind all the bars on the UI Thread
                Platform.runLater(new Runnable() {

                    @Override
                    public void run() {
                        //bind all progres bars
                        for (ProgressBar pb : pbs) {
                            pb.progressProperty().bind(task.progressProperty());

                        }

                        //bind all pins
                        for (ProgressIndicator pin : pins) {
                            pin.progressProperty().bind(task.progressProperty());

                        }
                    }
                });

                //simulate some work
                int nC = 0;
                while (nC++ < 100) {
                    Thread.sleep(60);
                    updateProgress(nC, 100);
                }

                return null;
            }
        };

        //this lays out the bars
        for (int i = 0; i < values.length; i++) {
            final Label label = labels[i] = new Label();
            label.setText("progress:" + values[i]);

            final ProgressBar pb = pbs[i] = new ProgressBar();
            pb.setProgress(values[i]);

            final ProgressIndicator pin = pins[i] = new ProgressIndicator();
            pin.setProgress(values[i]);
            final HBox hb = hbs[i] = new HBox();
            hb.setSpacing(5);
            hb.setAlignment(Pos.CENTER);
            hb.getChildren().addAll(label, pb, pin);
        }

        final VBox vb = new VBox();
        vb.setSpacing(5);
        vb.getChildren().addAll(hbs);
        scene.setRoot(vb);
        stage.show();
        new Thread(task).start();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
