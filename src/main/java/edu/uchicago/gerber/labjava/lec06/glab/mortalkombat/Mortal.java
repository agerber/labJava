package edu.uchicago.gerber.labjava.lec06.glab.mortalkombat;

import java.awt.image.BufferedImage;
import java.util.Random;


public abstract class Mortal  {


	private String mSoundPath;
    private BufferedImage mBufferedImage;

    public static final String[] SOUNDS = {

            "BaAAm!",
            "bIfff!@#",
            "cRACk#%*!",
            "smAAAAck^",
            "pop"

    };

    public static final Random RAN = new Random(); //a random to use


    public Mortal(String strImage, String strSound) {

        mSoundPath = strSound;
        mBufferedImage = SoundImageUtils.genBuffImage(strImage);

    }

    public String getRandomSound(){
       return  SOUNDS[RAN.nextInt(SOUNDS.length)];
    }

	public String getSoundPath() {
		return this.mSoundPath;
	}

	public void setSoundPath(String strSoundPath) {
		this.mSoundPath = strSoundPath;
	}

    public BufferedImage getBufferedImage() {
        return mBufferedImage;
    }

    public void setBufferedImage(BufferedImage bufferedImage) {
        mBufferedImage = bufferedImage;
    }
}