package lec08.glab.danshiff.sounds;



import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound {




    // For individual wav sounds (not looped)
    // http://stackoverflow.com/questions/26305/how-can-i-play-sound-in-java
    public static synchronized void playSound(final String strPath) {

        //this method commented-out becuase it was throwing exceptions

//        new Thread(new Runnable() {
//
//            public void run() {
//                try {
//                    Clip clp = AudioSystem.getClip();
//
//                    InputStream audioSrc = Sound.class.getResourceAsStream(strPath);
//                    InputStream bufferedIn = new BufferedInputStream(audioSrc);
//                    AudioInputStream aisStream = AudioSystem.getAudioInputStream(bufferedIn);
//
//                    clp.open(aisStream);
//                    clp.start();
//
//                } catch (Exception e) {
//                    System.err.println(e.getMessage());
//                }
//            }
//
//        }).start();
    }


    // For looping wav clips
    // http://stackoverflow.com/questions/4875080/music-loop-in-java
    public static Clip clipForLoopFactory(String strPath){
        Clip clp = null;
        try {
            AudioInputStream aisStream = AudioSystem.getAudioInputStream(Sound.class.getResourceAsStream(strPath));
            clp = AudioSystem.getClip();
            clp.open( aisStream );
        } catch (UnsupportedAudioFileException exp) {
            exp.printStackTrace();
        } catch (IOException exp) {
            exp.printStackTrace();
        } catch (LineUnavailableException exp) {
            exp.printStackTrace();
        }catch(Exception exp){
            System.out.println("error");
        }
        return clp;
    }




}
