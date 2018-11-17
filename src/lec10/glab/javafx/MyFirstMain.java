package lec10.glab.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MyFirstMain extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        
        //Stage
            //Scene
                //Root


        Parent root = FXMLLoader.load(getClass().getResource("/fxml/myfirst.fxml"));
        Scene scene = new Scene(root);
       // scene.getStylesheets().add("/styles/Styles.css");
        stage.setTitle("MyFirstFx");
        stage.setScene(scene);
        stage.show();
    }

//    public static void main(String[] args) {
//        launch(args);
//    }

}
