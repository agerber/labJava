package lec08.glab.javafx_group;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import javax.swing.*;

/**

 1/ create a class
 2/ extend javafx_group.application.Applicaiton
 3/ override the start() method

 //stage
    //scene
        //root

 4/ You need to create these things in reverse order

 */
public class App extends Application {


    private boolean bFlip = false;


    @Override
    public void start(Stage primaryStage) throws Exception {




        Group root = new Group();

        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(5));
        gridpane.setHgap(10);
        gridpane.setVgap(10);


        Button button = new Button("click");
        ImageView imageView = new ImageView();
        Image img = new Image(App.class.getResourceAsStream("elcapitan.jpg"));
        imageView.setImage(img);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Image img = null;
                if (bFlip){
                     img = new Image(App.class.getResourceAsStream("elcapitan.jpg"));

                    imageView.setImage(img);

                }
                else {
                     img = new Image(App.class.getResourceAsStream("diablo.jpg"));
                    imageView.setImage(img);
                }

                bFlip = !bFlip;

              //  JOptionPane.showConfirmDialog(null, "you cliecked me");
            }
        });



        imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println(event.getSceneX() + ":"+ event.getScreenY());
            }
        });

        final HBox pictureRegion = new HBox();

        pictureRegion.getChildren().add(imageView);
        pictureRegion.getChildren().add(button);

        gridpane.add(pictureRegion, 1, 1);


        root.getChildren().add(gridpane);




        Scene scene = new Scene(root, 800, 800); //put some dims
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hello World");
        primaryStage.show();


    }
}
