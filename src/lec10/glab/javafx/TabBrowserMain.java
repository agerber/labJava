/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lec10.glab.javafx;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;



/**
 * An implementation of tabs using the TabPane class.
 *
 * @see TabPane
 * @see Tab
 * @see TabPane
 */
public class TabBrowserMain extends Application {
    
     final TabPane tabPane = new TabPane();
     private int nTabCount = 0;
    
    private void init(Stage primaryStage) {
        
        //Stage
            //Scene
                //Root
        
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root);
        
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
       // BorderPane borderPane = new BorderPane();
        primaryStage.setTitle("Tabs Sample");

        final Button btn = new Button();
        //btn.setPrefSize(500, 30);
        btn.setPrefHeight(30);
        btn.setText("Click to add tab");
        
       // tabPane.setPrefSize(500, 600);
        tabPane.setSide(Side.TOP);
       
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.ALL_TABS);
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
           
                    final Tab tabNew = new Tab();
                    tabNew.setText("Tab " + ++nTabCount);
                    tabNew.setContent(getBroswer());

                    tabPane.getTabs().addAll(tabNew);
        
                
            }
            
        });
        
      //  borderPane.prefWidthProperty().bind(scene.widthProperty());
        btn.prefWidthProperty().bind(scene.widthProperty());
        
        final Tab tab1 = new Tab();
        tab1.setText("Tab " + ++nTabCount);
        tab1.setContent(getBroswer());


        //this is var-args
        tabPane.getTabs().addAll(tab1);
        
        root.setCenter(tabPane);
        root.setTop(btn);
        // borderPane.setTop(hBox);
      //  root.getChildren().addAll(borderPane);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        init(primaryStage);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
    //this is now our web-browser embebbed in a VBox
    private VBox getBroswer() {
        //this is our webview which is embeedd in a vBox
        WebView webView = new WebView();
        
        final WebEngine webEngine = webView.getEngine();
        webEngine.load("http://www.google.com");
        
        final TextField locationField = new TextField("http://www.google.com");
        webEngine.locationProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                locationField.setText(newValue);
            }
        });
        EventHandler<ActionEvent> goAction = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                webEngine.load(locationField.getText().startsWith("http://")
                        ? locationField.getText()
                        : "http://" + locationField.getText());
            }
        };
        locationField.setOnAction(goAction);
        
        Button goButton = new Button("Go");
        goButton.setDefaultButton(true);
        goButton.setOnAction(goAction);

        // Layout logic
        HBox hBox = new HBox(5);
        hBox.getChildren().setAll(locationField, goButton);
        HBox.setHgrow(locationField, Priority.ALWAYS);
        
        VBox vBox = new VBox(5);
        vBox.getChildren().setAll(hBox, webView);
        VBox.setVgrow(webView, Priority.ALWAYS);
        return vBox;
    }
}
