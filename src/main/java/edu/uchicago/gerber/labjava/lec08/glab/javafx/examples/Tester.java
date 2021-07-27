package edu.uchicago.gerber.labjava.lec08.glab.javafx.examples;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;




public class Tester extends Application implements Initializable {


    @FXML
    private TextArea txaArea;

    @FXML
    private Button btnGo;


    //this is optional and used for backwards compatability
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {

        //javaFX applications are composede of a stage, a scene and a root component.
        //stage
        //scene
        //root


        //create them in reverse order of above diagram 
        //make sure you create an file called Tester.fmxl using scenebuilder.
        //the controller will be this file
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Tester.fxml"));

        Scene scene = new Scene(root);

        //you may also uncomment this for css styles
        //scene.getStylesheets().add("/styles/Tester.css");

        stage.setTitle("Tester");
        stage.setScene(scene);

        stage.show();




    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //set up any controls behavior here

    }
}
