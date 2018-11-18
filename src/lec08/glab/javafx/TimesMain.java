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
import javafx.stage.Stage;

import java.io.IOException;

/**
 *
 * @author ag
 */
public class TimesMain extends Application {
  
    @Override
    public void start(Stage stage) throws IOException {
          Parent root = FXMLLoader.load(getClass().getResource("/fxml/Times.fxml"));
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/yelp.css");
        
        stage.setTitle("Times");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
    
}
