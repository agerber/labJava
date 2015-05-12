package lec08.pmnehls.finalproject.game.view;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JFrame;


import lec08.pmnehls.finalproject.controller.Game;
import lec08.pmnehls.finalproject.game.model.CommandCenter;
import lec08.pmnehls.finalproject.game.model.Movable;
import lec08.pmnehls.finalproject.game.model.TargetSpace;
import lec08.pmnehls.finalproject.sounds.Sound;


public class GamePanel extends Panel {
	
	// ==============================================================
	// FIELDS 
	// ============================================================== 
	 
	// The following "off" vars are used for the off-screen double-bufferred image. 
	private Dimension dimOff;
	private Image imgOff;
	private Graphics grpOff;
	
	private GameFrame gmf;
	private Font fnt = new Font("Joystix", Font.PLAIN, 18);
	private Font fntBig = new Font("Joystix", Font.BOLD, 64);
    private Font fntlogo = new Font("SansSerif", Font.PLAIN, 4);

	private FontMetrics fmt; 
	private int nFontWidth;
	private int nFontHeight;
	private String strDisplay = "";

    private static final String strFile = System.getProperty("user.dir") + "/src/lec08/pmnehls/finalproject/game/model/Joystix.TTF";

    public Font joystix = initJoystixFont();



	// ==============================================================
	// CONSTRUCTOR 
	// ==============================================================
	
	public GamePanel(Dimension dim){
        initJoystixFont();
	    gmf = new GameFrame();
		gmf.getContentPane().add(this);
		gmf.pack();
		initView();
		
		gmf.setSize(dim);
		gmf.setTitle("PAC-MAN");
		gmf.setResizable(false);
		gmf.setVisible(true);
		this.setFocusable(true);


	}
	
	
	// ==============================================================
	// METHODS 
	// ==============================================================
	
	private void drawScore(Graphics g) {
		g.setColor(Color.white);
		g.setFont(fnt);
		if (CommandCenter.getScore() != 0) {
			g.drawString("" + CommandCenter.getScore(), nFontWidth, nFontHeight);
		} else {
			g.drawString("00", nFontWidth, nFontHeight);
		}
	}

    private void drawLevel(Graphics g)
    {
        g.setColor(Color.WHITE);
        g.setFont(fnt);
        if(CommandCenter.getLevel() != 0)
        {
            g.drawString("Level " + CommandCenter.getLevel(), TargetSpace.TS_WIDTH * 22, TargetSpace.TS_HEIGHT * 35);
        }
    }

    public void drawLogo(Graphics g)
    {
        g.setColor(Color.YELLOW);
        g.setFont(fntBig);
        if(!CommandCenter.isPlaying())
        {
            g.drawString("PAC-MAN", 62, 180);
        }
    }


	@SuppressWarnings("unchecked")
	public void update(Graphics g) {
		if (grpOff == null || Game.DIM.width != dimOff.width
				|| Game.DIM.height != dimOff.height) {
			dimOff = Game.DIM;
			imgOff = createImage(Game.DIM.width, Game.DIM.height);
			grpOff = imgOff.getGraphics();
		}
		// Fill in background with black.
		grpOff.setColor(Color.black);
		grpOff.fillRect(0, 0, Game.DIM.width, Game.DIM.height);

        drawLogo(grpOff);
		drawScore(grpOff);
        drawLevel(grpOff);

		if (!CommandCenter.isPlaying()) {
			displayTextOnScreen();
		} else if (CommandCenter.isPaused()) {
			strDisplay = "Game Paused";
			grpOff.drawString(strDisplay,
					(Game.DIM.width - fmt.stringWidth(strDisplay)) / 2, Game.DIM.height / 4);
		}
		
		//playing and not paused!
		else {
			
			//draw them in decreasing level of importance
			//friends will be on top layer and debris on the bottom
			iterateMovables(grpOff,
                       CommandCenter.movLives,
                       CommandCenter.movDots,
                       CommandCenter.movEnergizers,
			           CommandCenter.movFoes,
                       CommandCenter.movDebris,
                       CommandCenter.movProton,
                       CommandCenter.movPacman,
			           CommandCenter.movFriends);
			
			
			//drawNumberShipsLeft(grpOff);
			if (CommandCenter.isGameOver()) {
				CommandCenter.setPlaying(false);
				//bPlaying = false;
			}
		}
		//draw the double-Buffered Image to the graphics context of the panel
		g.drawImage(imgOff, 0, 0, this);
	} 


	
	//for each movable array, process it.
	private void iterateMovables(Graphics g, CopyOnWriteArrayList<Movable>...movMovz)
    {

        for (CopyOnWriteArrayList<Movable> movMovs : movMovz)
        {
            for (Movable mov : movMovs)
            {

                mov.move();
                mov.draw(g);
                mov.fadeInOut();
                mov.expire();
            }
        }

    }
	
	private void initView() {
		Graphics g = getGraphics();			// get the graphics context for the panel
		g.setFont(fnt);						// take care of some simple font stuff
		fmt = g.getFontMetrics();
		nFontWidth = fmt.getMaxAdvance();
		nFontHeight = fmt.getHeight();
		g.setFont(fntBig);					// set font info
	}
	
	// This method draws some text to the middle of the screen before/after a game
	private void displayTextOnScreen() {

		strDisplay = "use the arrow keys to turn Pac-Man";
		grpOff.drawString(strDisplay,
				(Game.DIM.width - fmt.stringWidth(strDisplay)) / 2, Game.DIM.height / 4
						+ nFontHeight + 100);


		strDisplay = "'S' to Start";
		grpOff.drawString(strDisplay,
				(Game.DIM.width - fmt.stringWidth(strDisplay)) / 2, Game.DIM.height / 4
						+ nFontHeight + 160);

		strDisplay = "'P' to Pause";
		grpOff.drawString(strDisplay,
				(Game.DIM.width - fmt.stringWidth(strDisplay)) / 2, Game.DIM.height / 4
						+ nFontHeight + 200);

		strDisplay = "'Q' to Quit";
		grpOff.drawString(strDisplay,
				(Game.DIM.width - fmt.stringWidth(strDisplay)) / 2, Game.DIM.height / 4
						+ nFontHeight + 240);


        strDisplay = "------BONUS FEATURES------";
        grpOff.drawString(strDisplay,
                (Game.DIM.width - fmt.stringWidth(strDisplay)) / 2, Game.DIM.height / 4
                        + nFontHeight + 280);

        strDisplay = "Add more ghosts: 'O' for Ouija";
        grpOff.drawString(strDisplay,
                (Game.DIM.width - fmt.stringWidth(strDisplay)) / 2, Game.DIM.height / 4
                        + nFontHeight + 320);

        strDisplay = "GhostBuster Mode: press 'G'";
        grpOff.drawString(strDisplay,
                (Game.DIM.width - fmt.stringWidth(strDisplay)) / 2, Game.DIM.height / 4
                        + nFontHeight + 360);


	}
	
	public GameFrame getFrm() {return this.gmf;}
	public void setFrm(GameFrame frm) {this.gmf = frm;}

    public Font initJoystixFont()
    {
        try
        {
            Font fntTemp = Font.createFont(Font.TRUETYPE_FONT,new File(strFile));
            return fntTemp.deriveFont(18f);

        } catch (FontFormatException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        return null;
    }


}