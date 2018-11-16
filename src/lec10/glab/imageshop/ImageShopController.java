package lec10.glab.imageshop;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Sample Skeleton for 'imageshop.fxml' Controller Class
 */


public class ImageShopController implements Initializable {

    //private Desktop desktop = Desktop.getDesktop();
    private ToggleGroup mToggleGroup = new ToggleGroup();

    public enum Pen {
        CIR, SQR, FIL, OTHER;
    }

    public enum FilterStyle {
        SAT, DRK, OTHER;
    }



    private int penSize = 50;
    private Pen penStyle = Pen.CIR;
    private FilterStyle mFilterStyle = FilterStyle.DRK;

    @FXML // fx:id="imgView"
    private ImageView imgView; // Value injected by FXMLLoader

//    @FXML // ResourceBundle that was given to the FXMLLoader
//    private ResourceBundle resources;

    // for mouse clicks
    private double xPos, yPos, hPos, wPos;

    private Color mColor = Color.WHITE;

    ArrayList<Shape> removeShapes = new ArrayList<>(1000);


    //http://java-buddy.blogspot.com/2013/01/use-javafx-filechooser-to-open-image.html
    @FXML
    void mnuOpenAction(ActionEvent event) {

        Cc.getInstance().setImgView(this.imgView);


        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

        //Show open file dialog
        File file = fileChooser.showOpenDialog(null);
        //openFile(file);


        try {
            BufferedImage bufferedImage = ImageIO.read(file);


            // imgView.setImage(Cc.getInstance().getImg());

            Cc.getInstance().setImageAndRefreshView(SwingFXUtils.toFXImage(bufferedImage, null));

        } catch (IOException ex) {
            Logger.getLogger(ImageShopController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    @FXML
    private ComboBox<String> cboSome;

    @FXML
    private ToggleButton tgbSquare;


    @FXML
    private ToggleButton tgbCircle;


    @FXML
    private ColorPicker cpkColor;



    @FXML
    private Slider sldSize;

    @FXML
    private ToggleButton tgbFilter;

    @FXML
    void mnuReOpenLast(ActionEvent event) {

      //  Cc.getInstance().reOpenLast();
    }

    @FXML
    private AnchorPane ancRoot;


    @FXML
    void mnuSaveAction(ActionEvent event) {

    }



    @FXML
    void mnuSaveAsAction(ActionEvent event) {

    }

    @FXML
    void mnuQuitAction(ActionEvent event) {


        System.exit(0);


    }

    @FXML
    void mnuCloseAction(ActionEvent event) {
        Cc.getInstance().close();
    }

    @FXML
    void mnuGrayscale(ActionEvent event) {


        if (Cc.getInstance().getImg() == null)
            return;

        //make sure that we set the image view first, so we can roll back and do other operations to it.
        Cc.getInstance().setImgView(this.imgView);

        Image greyImage = Cc.getInstance().transform(Cc.getInstance().getImg(), Color::grayscale);
        Cc.getInstance().setImageAndRefreshView(greyImage);


    }

    @FXML
    void mnuSaturate(ActionEvent event) {


        Cc.getInstance().setImgView(this.imgView);


        Stage dialogStage = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/saturation.fxml"));
            Scene scene = new Scene(root);
            dialogStage.setTitle("Saturation");
            dialogStage.setScene(scene);
            //set the stage so that I can close it later.
            Cc.getInstance().setSaturationStage(dialogStage);
            dialogStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    @FXML
    void mnuUndo(ActionEvent event) {

        Cc.getInstance().undo();

    }


    @FXML
    void mnuRedo(ActionEvent event) {
        Cc.getInstance().redo();
    }


    //##################################################################
    //INITIALIZE METHOD
    //see: http://docs.oracle.com/javafx/2/ui_controls/jfxpub-ui_controls.htm
    //##################################################################
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //mColor = Color.WHITE;
        tgbCircle.setToggleGroup(mToggleGroup);
        tgbSquare.setToggleGroup(mToggleGroup);
        tgbFilter.setToggleGroup(mToggleGroup);
        tgbCircle.setSelected(true);
        cboSome.setValue("Darker");

        mToggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                if (newValue == tgbCircle) {
                    penStyle = Pen.CIR;
                    System.out.println("Initialize: resources = "+resources );
                } else if (newValue == tgbSquare) {
                    penStyle = Pen.SQR;
                } else if (newValue == tgbFilter) {
                    penStyle = Pen.FIL;
                } else {
                    penStyle = Pen.CIR;
                }
            }
        });


        imgView.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent me) {
                if (penStyle == Pen.FIL){
                    xPos = (int) me.getX();
                    yPos = (int) me.getY();
                }

                me.consume();
            }
        });


        imgView.addEventFilter(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent me) {

                if (penStyle == Pen.CIR || penStyle == Pen.SQR) {

                    System.out.println("mouse pressed! " + me.getSource());
                    SnapshotParameters snapshotParameters = new SnapshotParameters();
                    snapshotParameters.setViewport(new Rectangle2D(0, 0, imgView.getFitWidth(), imgView.getFitHeight()));
                    Image snapshot = ancRoot.snapshot(snapshotParameters, null);
                    Cc.getInstance().setImageAndRefreshView(snapshot);
                    ancRoot.getChildren().removeAll(removeShapes);
                    removeShapes.clear();

                } else if (penStyle == Pen.FIL){


                    wPos =  (int) me.getX() ;
                    hPos = (int) me.getY() ;

                    //default value
                   Image transformImage;

                    switch (mFilterStyle){
                        case DRK:
                            //make darker
                            transformImage = Cc.getInstance().transform(Cc.getInstance().getImg(),
                                    (x, y, c) -> (x > xPos && x < wPos)
                                            && (y > yPos && y < hPos) ?  c.deriveColor(0, 1, .5, 1): c
                            );
                            break;

                        case SAT:

                            //saturate
                            transformImage = Cc.getInstance().transform(Cc.getInstance().getImg(),
                                    (x, y, c) -> (x > xPos && x < wPos)
                                            && (y > yPos && y < hPos) ?  c.deriveColor(0, 1.0 / .1, 1.0, 1.0): c


                            );


                            break;

                        default:
                            //make darker
                            //make darker
                            transformImage = Cc.getInstance().transform(Cc.getInstance().getImg(),
                                    (x, y, c) -> (x > xPos && x < wPos)
                                            && (y > yPos && y < hPos) ?  c.deriveColor(0, 1, .5, 1): c
                            );
                            break;

                    }



                    Cc.getInstance().setImageAndRefreshView(transformImage);
                } else {
                    //do nothing right now

                }
                me.consume();
            }
        });


        imgView.addEventFilter(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent me) {

                if (penStyle == Pen.FIL){
                    me.consume();
                    return;
                }

                // Line line = new Line(xPos, yPos, me.getX(), me.getY());

                xPos = me.getX();
                yPos = me.getY();

                int nShape = 0;
                //default value
                Shape shape = new Circle(xPos, yPos, 10);
                switch (penStyle) {
                    case CIR:
                        shape = new Circle(xPos, yPos, penSize);
                        break;
                    case SQR:
                        shape = new Rectangle(xPos, yPos, penSize, penSize);
                        break;


                    default:
                        shape = new Circle(xPos, yPos, penSize);
                        break;

                }

               // shape.setStroke(mColor);
                shape.setFill(mColor);

                ancRoot.getChildren().add(shape);
                removeShapes.add(shape);
                me.consume();

                //   Node shapeRemove =  ancRoot.getScene().lookup("789");
                //  ancRoot.getChildren().remove(shapeRemove);


            }
        });


        cpkColor.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mColor = cpkColor.getValue();
            }
        });

        sldSize.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                double temp  = (Double) newValue; //automatic unboxing
                penSize = (int) Math.round(temp);
            }
        });


        cboSome.getItems().addAll(
                "Darker",
                "Saturate"

        );


        cboSome.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                switch (newValue){
                    case "Saturate":
                        mFilterStyle = FilterStyle.SAT;
                        break;

                    case "Darker":
                        mFilterStyle = FilterStyle.DRK;
                        break;

                    default:
                        mFilterStyle = FilterStyle.DRK;
                        break;

                }
            }
        });










    }//END INIT


    //invert

//    Cc.getInstance().setSaturationLevel((int)sldSaturation.getValue());
//
//
//    int nLevel = Cc.getInstance().getSaturationLevel();
//    double dLevel = (100-nLevel)/100;
//
//    //saturation value
//    Image image = Cc.transform(Cc.getInstance().getImg(), (Color c, Double d) -> c.deriveColor(0, 1.0/ d, 1.0, 1.0), dLevel);
//    Cc.getInstance().getImgView().setImage(image);
//
//    Cc.getInstance().getSaturationStage().close();


}
