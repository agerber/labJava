package lec06.glab.mortalkombat;

import java.awt.image.BufferedImage;


public abstract class Mortal  {


    //private String strMortal;
	private String mSoundPath;
    private BufferedImage mBufferedImage;



    public Mortal(String strImage, String strSound) {

        mSoundPath = strSound;
        mBufferedImage = SoundImageUtils.genBuffImage(strImage);

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