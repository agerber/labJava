/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lec08.glab.javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TabPaneWithAddButton extends Application {

  @Override
  public void start(Stage primaryStage) {
      
      //Stage
        //Scene
            //Root
      
    AnchorPane root = new AnchorPane();
    final TabPane tabs = new TabPane();
    Button addButton = new Button("+");

    AnchorPane.setTopAnchor(tabs, 5.0);
    AnchorPane.setLeftAnchor(tabs, 5.0);
    AnchorPane.setRightAnchor(tabs, 5.0);
    AnchorPane.setTopAnchor(addButton, 10.0);
    AnchorPane.setLeftAnchor(addButton, 10.0);

    addButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        final Tab tab = new Tab("Tab " + (tabs.getTabs().size() + 1));
        tabs.getTabs().add(tab);
        tabs.getSelectionModel().select(tab);
      }
    });

    root.getChildren().addAll(tabs, addButton);

     Scene scene = new Scene(root, 600, 400);
    
    //bind the tabs and button to the width of the scene
   // tabs.prefHeightProperty().bind(scene.heightProperty());
//    tabs.prefWidthProperty().bind(scene.widthProperty());
//    addButton.prefWidthProperty().bind(scene.widthProperty());
    
    scene.getStylesheets().add("/src/main/resources/styles/tabs.css");
    primaryStage.setScene(scene);
    primaryStage.show();

  }

  public static void main(String[] args) {
    launch(args);
  }
}
