package lec10.glab.playsounds;



//good source for sound samples
//http://www.therecordist.com/video-game-audio/game-audio-samples

//http://introcs.cs.princeton.edu/java/faq/mp3/MP3.java.html
//grossly simplified  and re-factored to the following
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import javazoom.jl.player.Player;
//import java.applet.AudioClip;

//import javax.sound.sampled.AudioInputStream;
//import javax.sound.sampled.AudioSystem;
//import javax.sound.sampled.Clip;

public class Mp3Loop implements Runnable {
    private String strFileName;
    private Player ply;
	private FileInputStream fis;
	private BufferedInputStream bis; 

    // constructor that takes the name of an MP3 file
    public Mp3Loop(String str) {
        this.strFileName = str;
    }

    public void run() {

    	

    	
            try { 
      	
        
                fis = new FileInputStream(strFileName);
                bis = new BufferedInputStream(fis);
                ply = new Player(bis);
            	ply.play(); 
            	bis.close();
          
            	while(true){

            		if (ply.isComplete()){
            			
            	          fis     = new FileInputStream(strFileName);
                          bis = new BufferedInputStream(fis);
                          ply = new Player(bis);
                     	  ply.play(); 
                     	  bis.close();
            		}
            	}

            	
            	
            }
            catch (Exception e) {
            	System.out.println(e); 
            }

    }

}