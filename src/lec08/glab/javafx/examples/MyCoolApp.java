package lec08.glab.javafx.examples;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class MyCoolApp extends Application implements Initializable {

    //the main method is optional and used for backwards compatability
//    public static void main(String[] args) {
//        launch(args);
//    }

    @Override
    public void start(Stage stage) throws IOException {

        //javaFX applications are composed of a stage, a scene and a root component.
        //stage
        //scene
        //root


        //create them in reverse order of above diagram 

        //make sure you create an file called MyCoolApp.fmxl using scenebuilder.

        //the path to the controller will look something like this
        //lec08.glab.javafx.examples.Tester where lec08 is the subdir of src and Tester is the Tester.java controller file

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/MyCoolApp.fxml"));

        Scene scene = new Scene(root);

        //you may also uncomment this for css styles
        //scene.getStylesheets().add("/styles/MyCoolApp.css");

        stage.setTitle("MyCoolApp");
        stage.setScene(scene);


        stage.show();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //set up any controls behavior here

    }
}
