package lec06.glab.mortalkombat;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;






public abstract class Mortal  {
	

	public static final URL URLMORTAL = Mortal.class.getResource("./"); //get the current director of card
	

	
	// #################################################
	// ##### INSTANCE FIELDS
	// #################################################

	
	//private char[][] cAsciis;
	
	private BufferedImage bimMortal;
	private String strSoundPath;

	
	
	// #################################################
	// ##### CONSTRUCTORS
	// #################################################


	
	public BufferedImage getBimMortal() {
		return this.bimMortal;
	}




	public String getSoundPath() {
		return this.strSoundPath;
	}




	public void setSoundPath(String strSoundPath) {
		this.strSoundPath = strSoundPath;
	}




	public void setBimMortal(BufferedImage bimMortal) {
		this.bimMortal = bimMortal;
	}




	public Mortal(String strImage, String strSound) {
		

		
		try {
			//image
			String strPathImg = URLMORTAL.getPath().substring(1, URLMORTAL.getPath().length())  + "imgs/" + strImage;
			File filImg = new File(strPathImg);
			
			//sound
			//strSoundPath = URLMORTAL.getPath().substring(1, URLMORTAL.getPath().length())  + "sounds/" + strSound;
            strSoundPath= strSound;
			
			
			bimMortal = ImageIO.read(filImg);
			bimMortal = scaleImage(bimMortal, MortalKombat.WIDTH, MortalKombat.HEIGHT);
			
		} catch (Exception e) {
		
			bimMortal = null;
		}
		
		//cAsciis = Asciify.getAsciiChars(strUrlAscii, nDim, nDim);
		//the distanced is automatically set to zero
		
	}

	
	
	
	
	//method found on stackoverflow.com, re-implemented here
	private BufferedImage scaleImage(BufferedImage img, int nWidth, int nHeight) {

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
	
	
   //sounds from http://www.partnersinrhyme.com/soundfx/fight.shtml
	//from stack overflow -re-implemented here
	//http://stackoverflow.com/questions/26305/how-can-i-play-sound-in-java
	 public  synchronized void playSound( final String strURL) {
		    new Thread(new Runnable() { // the wrapper thread is unnecessary, unless it blocks on the Clip finishing, see comments
		      public void run() {
		        try {
		          Clip clp = AudioSystem.getClip();
		          AudioInputStream inputStream = AudioSystem.getAudioInputStream(new FileInputStream(strURL));
		          clp.open(inputStream);
		          clp.start(); 
		        } catch (Exception e) {
		          System.err.println(e.getMessage());
		        }
		      }
		    }).start();
		  }




	
}