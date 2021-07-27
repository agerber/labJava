package edu.uchicago.gerber.labjava.lec08.glab.javafx.examples;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BouncingBall extends Application{

    @Override
    public void start(Stage stage) {

        Pane canvas = new Pane();
        Scene scene = new Scene(canvas, 300, 300, Color.ALICEBLUE);
        Circle ball = new Circle(10, Color.CADETBLUE);
        ball.relocate(5, 5);

        canvas.getChildren().add(ball);

        stage.setTitle("Animated Ball");
        stage.setScene(scene);
        stage.show();

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(20),
                new EventHandler<ActionEvent>() {

                    double dx = 7; //Step on x or velocity
                    double dy = 3; //Step on y

                    @Override
                    public void handle(ActionEvent t) {
                        //move the ball
                        ball.setLayoutX(ball.getLayoutX() + dx);
                        ball.setLayoutY(ball.getLayoutY() + dy);

                        Bounds bounds = canvas.getBoundsInLocal();

                        //If the ball reaches the left or right border make the step negative
                        if(ball.getLayoutX() <= (bounds.getMinX() + ball.getRadius()) ||
                                ball.getLayoutX() >= (bounds.getMaxX() - ball.getRadius()) ){

                            dx = -dx;

                        }

                        //If the ball reaches the bottom or top border make the step negative
                        if((ball.getLayoutY() >= (bounds.getMaxY() - ball.getRadius())) ||
                                (ball.getLayoutY() <= (bounds.getMinY() + ball.getRadius()))){

                            dy = -dy;

                        }
                    }
                }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public static void main(String[] args) {
        launch();
    }
}