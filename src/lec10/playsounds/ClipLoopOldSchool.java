package lec10.playsounds;



//good source for sound samples
//http://www.therecordist.com/video-game-audio/game-audio-samples

//http://introcs.cs.princeton.edu/java/faq/mp3/MP3.java.html
//grossly simplified  and re-factored to the following
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;




public class ClipLoopOldSchool implements Runnable {
    private String strFileName;


    // constructor that takes the name of an MP3 file
    public ClipLoopOldSchool(String str) {
        this.strFileName = str;
    }

    public void run() {

        try {

            //you need an au file format to use this method 
            URL url = new URL(
            		strFileName);
           // "file://" +   System.getProperty("user.dir") +   "/src/edu/uchicago/cs/java/lec10/playsounds/snds/samisen.au");
            AudioClip clip = Applet.newAudioClip(url);
            clip.loop();
     
            //clip.play();

           
            //Thread.sleep(Long.MAX_VALUE);  //this is ugly, but it works without throwing an exception
            wait();
          
          } catch (Exception e) {
        	  //wait works but it will throw an exception
          	//e.printStackTrace();
          }
        }

    	
 

    }

