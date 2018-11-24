package lec08.glab.javafx.imageshop;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;
import java.util.function.UnaryOperator;

/**
 * Created by daniel on 08/05/14.
 */
@FunctionalInterface
interface ColorTransformer {
    Color apply(int x, int y, Color colorAtXY);
}

//Exercise 12
class LatentImage {
    private Image in;
    private List<ColorTransformer> pendingOperations;

    public static LatentImage from(Image in) {
        LatentImage result = new LatentImage();
        result.in = in;
        result.pendingOperations = new ArrayList<>();
        return result;
    }

    LatentImage transform(UnaryOperator<Color> f) {
        pendingOperations.add((x,y,c) -> f.apply(c));
        return this;
    }

    LatentImage transform(ColorTransformer f) {
        pendingOperations.add(f);
        return this;
    }

    public Image toImage() {
        int width = (int) in.getWidth();
        int height = (int) in.getHeight();
        WritableImage out = new WritableImage(width, height);
        for (int x = 0; x < width; x++)
            for (int y = 0; y < height; y++) {
                Color c = in.getPixelReader().getColor(x, y);
                for (ColorTransformer f : pendingOperations) {
                    c = f.apply(x, y, c);
                }
                out.getPixelWriter().setColor(x, y, c);
            }
        return out;
    }

    //Exercise 15
    public Image toImageParallel() {
        int n = Runtime.getRuntime().availableProcessors();
        int width = (int) in.getWidth();
        int height = (int) in.getHeight();
        WritableImage out = new WritableImage(width, height);
        try {
            ExecutorService pool = Executors.newCachedThreadPool();
            for (int i = 0; i < n; i++) {
                int fromY = i * height / n;
                int toY = (i + 1) * height / n;
                pool.submit( () -> {
                    for (int x = 0; x < width; x++)
                        for (int y = fromY; y < toY; y++) {
                            Color c = in.getPixelReader().getColor(x, y);
                            for (ColorTransformer f : pendingOperations) {
                                c = f.apply(x, y, c);
                            }
                            out.getPixelWriter().setColor(x, y, c);
                        }
                });
                pool.shutdown();
                pool.awaitTermination(1, TimeUnit.HOURS);
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        return out;
    }
}

//Exercise 5
//Ctrl-c Ctrl-v from source code of book
//The solution is in from source code of Chapter 3 section 3 on the website of the author
public class ImageTransform extends Application {

    public static Image transform(Image in, UnaryOperator<Color> f) {
        int width = (int) in.getWidth();
        int height = (int) in.getHeight();
        WritableImage out = new WritableImage(
                width, height);
        for (int x = 0; x < width; x++)
            for (int y = 0; y < height; y++)
                out.getPixelWriter().setColor(x, y,
                        f.apply(in.getPixelReader().getColor(x, y)));
        return out;
    }

    public static Image transform(Image in, ColorTransformer f) {
        int width = (int) in.getWidth();
        int height = (int) in.getHeight();
        WritableImage out = new WritableImage(
                width, height);
        for (int x = 0; x < width; x++)
            for (int y = 0; y < height; y++)
                out.getPixelWriter().setColor(x, y,
                        f.apply(x, y, in.getPixelReader().getColor(x, y)));
        return out;
    }

    //Exercise 6
    public static <T> Image transform(Image in, BiFunction<Color, T, Color> f, T arg) {
        int width = (int) in.getWidth();
        int height = (int) in.getHeight();
        WritableImage out = new WritableImage(
                width, height);
        for (int x = 0; x < width; x++)
            for (int y = 0; y < height; y++)
                out.getPixelWriter().setColor(x, y,
                        f.apply(in.getPixelReader().getColor(x, y), arg));
        return out;
    }

    //Exercise 8
    public static ColorTransformer frameBorder(Image image, int thickness, Color color) {
        return (x, y, c) -> x < thickness || x > image.getWidth() - thickness
                || y < thickness || y > image.getHeight() - thickness ? color : c;
    }

    //Exercise 10 : not really code

    //Exercise 11
    public static ColorTransformer compose(ColorTransformer transformerAfter, ColorTransformer transformerBefore) {
        return (x, y, c) -> transformerAfter.apply(x, y, transformerBefore.apply(x, y, c));
    }

    public static ColorTransformer convert(UnaryOperator<Color> f) {
        return (x, y, c) -> f.apply(c);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Image image = new Image(this.getClass().getClassLoader().getResourceAsStream("queen-mary.png"));


        Image brightenedImage = transform(transform(image, Color::brighter), Color::grayscale);


        Image image2 = transform(image,
                (x, y, c) -> x < 10 || x > image.getWidth() - 10
                        || y < 10 || y > image.getHeight() - 10 ? Color.GRAY : c
        );

        Image image2bis = transform(image, frameBorder(image, 15, Color.BLUE));

        Image image3 = transform(image, (Color c, Double d) -> c.deriveColor(0, 1, d, 1), 1.2);

        //the
        Image image55 = transform(image, (Color c, Double d) -> c.deriveColor(0, 1.0/ d, 1.0, 1.0), .1);

        //return deriveColor(0, 1.0 / SATURATE_DESATURATE_FACTOR, 1.0, 1.0);

        Image imageExercise11 = transform(image, compose(frameBorder(image, 10, Color.GRAY), convert(Color::brighter)));



        Rectangle2D rec = new Rectangle2D(0, 0,image.getWidth(), image.getHeight());

        ImageView imageView1 = new ImageView(image);
        imageView1.setViewport(rec);

        ImageView imageView2 = new ImageView(brightenedImage);
        imageView2.setViewport(rec);

        ImageView imageView3 = new ImageView(image2);
        imageView3.setViewport(rec);


        ImageView imageView4 = new ImageView(image2bis);
        imageView4.setViewport(rec);

        ImageView imageView5 = new ImageView(image55);
        imageView5.setViewport(rec);

        ImageView imageView6 = new ImageView(imageExercise11);
        imageView6.setViewport(rec);


        stage.setScene(new Scene(new HBox(

                imageView1,
                imageView2,
                imageView3,
                imageView4,
                imageView5,
                imageView6
        )));
        stage.show();
    }
}
