package lec10.playsounds;


//good source for sound samples
//http://www.therecordist.com/video-game-audio/game-audio-samples

//http://introcs.cs.princeton.edu/java/faq/mp3/MP3.java.html
//grossly simplified  and re-factored to the following
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import javazoom.jl.player.Player;

public class Mp3 implements Runnable {
    private String strFileName;
    private Player ply;
	private FileInputStream fis;
	private BufferedInputStream bis; 

    // constructor that takes the name of an MP3 file
    public Mp3(String str) {
        this.strFileName = str;
    }

    public void run() {

            try { 
                fis = new FileInputStream(strFileName);
                bis = new BufferedInputStream(fis);
                ply = new Player(bis);
            	ply.play(); 
            	
            	
            }
            catch (Exception e) {
            	System.out.println(e); 
            }

    }

}