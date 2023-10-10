package edu.uchicago.gerber.labjava.lec07.jpanel_gui;



import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

//http://stackoverflow.com/questions/2416935/how-to-play-wav-files-with-java/2417088#2417088
public class SoundImageUtils {

    private static final int BUFFER_SIZE = 128000;
    private static File soundFile;
    private static AudioInputStream audioStream;
    private static AudioFormat audioFormat;
    private static SourceDataLine sourceLine;

    /**
     * @param filename the name of the file that is going to be played
     */
    public static void playSound(String filename){


        String strPath =  System.getProperty("user.dir") + filename;

        //String strPath = filename ;

        try {
            soundFile = new File(strPath);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        try {
            audioStream = AudioSystem.getAudioInputStream(soundFile);
        } catch (Exception e){
            e.printStackTrace();
            System.exit(1);
        }

        audioFormat = audioStream.getFormat();

        DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
        try {
            sourceLine = (SourceDataLine) AudioSystem.getLine(info);
            sourceLine.open(audioFormat);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        sourceLine.start();

        int nBytesRead = 0;
        byte[] abData = new byte[BUFFER_SIZE];
        while (nBytesRead != -1) {
            try {
                nBytesRead = audioStream.read(abData, 0, abData.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (nBytesRead >= 0) {
                @SuppressWarnings("unused")
                int nBytesWritten = sourceLine.write(abData, 0, nBytesRead);
            }
        }

        sourceLine.drain();
        sourceLine.close();
    }


    public static BufferedImage genBuffImage(String strRelativeFilePath){
        String strPathImg= System.getProperty("user.dir")+ strRelativeFilePath;
        File filImg = new File(strPathImg);

        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(filImg);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return bufferedImage;

    }

    public static BufferedImage genBuffImage(String strRelativeFilePath, int nWidth, int nHeight){
        String strPathImg= System.getProperty("user.dir")+ strRelativeFilePath;
        File filImg = new File(strPathImg);

        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(filImg);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

         return scaleImage(bufferedImage, nWidth, nHeight);
    }


    //method found on stackoverflow.com, re-implemented here
    private static BufferedImage scaleImage(BufferedImage img, int nWidth, int nHeight) {

        BufferedImage newImage = new BufferedImage(nWidth, nHeight,
                BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = newImage.createGraphics();
        try {
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                    RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            g.setBackground(new Color(0,0,0));
            g.clearRect(0, 0, nWidth, nHeight);
            g.drawImage(img, 0, 0, nWidth, nHeight, null);
        } finally {
            g.dispose();
        }
        return newImage;
    }


}
