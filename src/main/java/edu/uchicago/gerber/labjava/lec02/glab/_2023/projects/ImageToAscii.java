package edu.uchicago.gerber.labjava.lec02.glab._2023.projects;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.image.BufferedImage;
import java.net.URL;

public class ImageToAscii {

    public static void main(String[] args) {
        try {
            // Capture the clipboard content
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            String imageUrl = (String) clipboard.getData(DataFlavor.stringFlavor);

            // Fetch the image from the URL
            BufferedImage originalImage = ImageIO.read(new URL(imageUrl));

            // Scale the image to 300x300
            final int SCALE = 150;
            BufferedImage scaledImage = new BufferedImage(SCALE, SCALE, originalImage.getType());
            Graphics2D graphics = scaledImage.createGraphics();
            graphics.drawImage(originalImage, 0, 0, SCALE, SCALE, null);
            graphics.dispose();

            // Convert the image to ASCII representation
            char[][] asciiArt = imageToAscii(scaledImage);

            // Print the ASCII representation
            for (char[] row : asciiArt) {
                for (char ch : row) {
                    System.out.print(ch);
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static char[][] imageToAscii(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        char[][] asciiArr = new char[height][width];

        // List of characters to be used in the representation
        char[] chars = {'@', '#', 'S', '%', '?', '*', '+', ';', ':', ',', '.'};

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int pixel = image.getRGB(x, y);
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = (pixel) & 0xff;
                float luminance = 0.299f * red + 0.587f * green + 0.114f * blue;
                int index = Math.round((chars.length - 1) * luminance / 255);
                asciiArr[y][x] = chars[index];
            }
        }
        return asciiArr;
    }
}
