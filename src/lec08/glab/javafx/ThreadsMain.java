/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lec08.glab.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class ThreadsMain extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        //the order is reversed from hierarchy
       // Parent root = FXMLLoader.load(getClass().getResource("/fxml/Threads.fxml"));
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Threads.fxml"));
        Parent root = (Parent) loader.load();
        ThreadsController controller =  loader.getController();
        controller.setStage(primaryStage);
        
        
        Scene scene = new Scene(root, 800, 600, Color.WHITE);
        //scene.getStylesheets().add("/styles/yelp.css");
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
