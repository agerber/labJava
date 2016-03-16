package lec10.glab.playsounds;
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;

public class PlayClip {

public static void main(String args[]) {
    try {

      //you need an au file to do it. 
      URL url = new URL(
      "file://" +   System.getProperty("user.dir") +   "\\src\\lec10\\glab\\playsounds\\snds\\samisen.au");
      AudioClip clip = Applet.newAudioClip(url);

      clip.play();

      Thread.sleep(5000);
    
    } catch (InterruptedException e) {
    	e.printStackTrace();
    } catch (MalformedURLException e) {
    	e.printStackTrace();
    }
  }
}