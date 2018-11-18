package lec08.glab.javafx;




import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Orientation;
import javafx.scene.control.ScrollBar;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 * Horizontal and vertical scroll bars.
 *
 * @see ScrollBar
 */

public class BindToBarSample extends Application {
    private Circle circle;
    private ScrollBar xscrollBar;
    private ScrollBar yscrollBar;
    private double xscrollValue=0;
    private double yscrollValue=15;
    private static final int xBarWidth = 393;
    private static final int xBarHeight = 15;
    private static final int yBarWidth = 15;
    private static final int yBarHeight = 393;
    private static final int circleRadius = 90;
    private void init(Stage primaryStage) {

        //stage
            //scene
                //root


        Group root = new Group();
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 408,408));
        Rectangle bg = new Rectangle(xBarWidth+yBarWidth,xBarHeight+yBarHeight,Color.rgb(90,90,90));
        Rectangle box = new Rectangle (100,100,Color.rgb(150,150,150));
        box.setTranslateX(147);
        box.setTranslateY(147);

        //create moveable circle
        circle = new Circle(45,45, circleRadius,  Color.rgb(90,210,210));
        circle.setOpacity(0.4);
        circle.relocate(0,15);

        //create horizontal scrollbar
        xscrollBar = horizontalScrollBar(-1,-1,xBarWidth,xBarHeight,xBarWidth,xBarHeight);
        xscrollBar.setUnitIncrement(20.0);
        //assign a listener to the scrollbar so that its events can be captured
        //you can changed ChangeListener to lamda as it is a functional interface - use IntelliJ hint to do this.
        xscrollBar.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                //changes the x position of the circle
                setScrollValueX(xscrollBar.getValue(), circle);
            }
        });

        //create vertical scrollbar
        yscrollBar = verticalScrollBar(-1,-1,yBarWidth,yBarHeight,yBarWidth,yBarHeight);
        yscrollBar.setUnitIncrement(20.0);
        //assign a listener to the scrollbar so that its events can be captured
        //you can changed ChangeListener to lamda as it is a functional interface - use IntelliJ hint to do this.
        yscrollBar.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                //changes the y position of the circle
                setScrollValueY(yscrollBar.getValue(), circle);
            }
        });

        //shift position of vertical scrollbar to right side of scene
        yscrollBar.setTranslateX(yBarHeight);
        yscrollBar.setTranslateY(yBarWidth);
        yscrollBar.setOrientation(Orientation.VERTICAL);

        root.getChildren().add(bg);
        root.getChildren().add(box);
        root.getChildren().add(circle);
        root.getChildren().add(xscrollBar);
        root.getChildren().add(yscrollBar);
    }
    //Create a ScrollBar with given parameters
    private ScrollBar horizontalScrollBar(double minw, double minh, double prefw, double prefh, double maxw, double maxh) {
        final ScrollBar scrollBar = new ScrollBar();
        scrollBar.setMinSize(minw, minh);
        scrollBar.setPrefSize(prefw, prefh);
        scrollBar.setMaxSize(maxw, maxh);
        scrollBar.setVisibleAmount(50);
        scrollBar.setMax(xBarWidth-(2*circleRadius));
        return scrollBar;
    }

    //Create a ScrollBar with given parameters
    private ScrollBar verticalScrollBar(double minw, double minh, double prefw, double prefh, double maxw, double maxh) {
        final ScrollBar scrollBar = new ScrollBar();
        scrollBar.setMinSize(minw, minh);
        scrollBar.setPrefSize(prefw, prefh);
        scrollBar.setMaxSize(maxw, maxh);
        scrollBar.setVisibleAmount(50);
        scrollBar.setMax(yBarHeight-(2*circleRadius));
        return scrollBar;
    }
    //Updates x values
    private void setScrollValueX(double v, Circle circle) {
        this.xscrollValue = v;
        circle.relocate(xscrollValue, yscrollValue);
    }
    //Updates x values
    private void setScrollValueY(double v, Circle circle) {
        this.yscrollValue = v+xBarHeight;
        circle.relocate(xscrollValue, yscrollValue);
    }

    public double getSampleWidth() { return 408; }

    public double getSampleHeight() { return 408; }

    @Override public void start(Stage primaryStage) throws Exception {
        init(primaryStage);
        primaryStage.show();
    }
    public static void main(String[] args) { launch(args); }
}

