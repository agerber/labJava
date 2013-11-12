package lec08.timpone.finalproject.game.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Point;
import java.util.concurrent.CopyOnWriteArrayList;

import lec08.timpone.finalproject.controller.Game;
import lec08.timpone.finalproject.game.model.ASCIITitle;
import lec08.timpone.finalproject.game.model.CommandCenter;
import lec08.timpone.finalproject.game.model.Falcon;
import lec08.timpone.finalproject.game.model.Movable;
import lec08.timpone.finalproject.game.model.Powerup;

/**
 *  This is a custom JPanel that has been modified from the original game base code.   
 */
public class GamePanel extends Panel {
	
	// ==============================================================
	// FIELDS 
	// ============================================================== 
	 
	private GameFrame gmf;					// the game frame object
	
	private Dimension dimOff;				// The following "off" vars are used for the off-screen double-bufferred image		
	private Image imgOff;
	private Graphics grpOff;
	
	private Font fnt = new Font("Monospaced", Font.PLAIN, 14);					// the general font that is used
	private Font fntScore = new Font("SansSerif", Font.BOLD, 12);				// font used for displaying score, kills, and level
	private Font fntTitle = new Font("Monospaced", Font.PLAIN, 12);				// font used for the ASCII art title
	private Font fntBig = new Font("SansSerif", Font.BOLD + Font.ITALIC, 36);	// big font
	
	private FontMetrics fmt;		// holds information about the font 
	private int nFontWidth;			// font width
	private int nFontHeight;		// font height
	
	private String strDisplay = "";	// initializes strDisplay
	

	// ==============================================================
	// CONSTRUCTOR 
	// ==============================================================
	
	public GamePanel(Dimension dim){
	    gmf = new GameFrame();
		gmf.getContentPane().add(this);
		gmf.pack();
		initView();
		
		gmf.setSize(dim);
		gmf.setTitle("Missile Command");
		gmf.setResizable(false);
		gmf.setVisible(true);
		this.setFocusable(true);
	}
	
	
	// ==============================================================
	// METHODS 
	// ==============================================================
	
	private void drawScore(Graphics g) {
		g.setColor(Color.white);
		g.setFont(fntScore);
		
		g.drawString("SCORE : " + CommandCenter.getScore(), nFontWidth, nFontHeight);
		g.drawString("KILLS: "+CommandCenter.getKillCount(),nFontWidth, nFontHeight+15);
		g.drawString("LEVEL: "+CommandCenter.getLevel(),nFontWidth, nFontHeight+30);
		g.drawString("HIGH SCORE : " + CommandCenter.getHighScore(), nFontWidth, nFontHeight+45);
		
		g.setFont(new Font(Font.MONOSPACED,Font.PLAIN,15));
		if(CommandCenter.isTurretsOn()){
			int nTurretAmmo = Powerup.TURRET_AMMO - CommandCenter.getTurretShots();
			g.drawString("Turret Ammo: "+nTurretAmmo, (int) 15, (int) Game.DIM.getHeight()-80);
		}
		if(CommandCenter.isSpreadGunOn()){
			int nSpreadAmmo = Powerup.SPREAD_AMMO - CommandCenter.getSpreadShots();
			g.drawString("Spread Ammo: "+nSpreadAmmo, (int) 15, (int) Game.DIM.getHeight()-60);
		}
		if(CommandCenter.isFlameCloudOn()){
			int nFlameAmmo = Powerup.FLAME_AMMO - CommandCenter.getFlameShots();
			g.drawString("Flame Ammo: "+nFlameAmmo, (int) 15, (int) Game.DIM.getHeight()-40);
		}
		
		g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
	}
	
	@SuppressWarnings("unchecked")
	public void update(Graphics g) {
		if (grpOff == null || Game.DIM.width != dimOff.width || Game.DIM.height != dimOff.height) {
			dimOff = Game.DIM;
			imgOff = createImage(Game.DIM.width, Game.DIM.height);
			grpOff = imgOff.getGraphics();
		}
		grpOff.setColor(Color.black);								// Fill in background with black.
		grpOff.fillRect(0, 0, Game.DIM.width, Game.DIM.height);
		
		grpOff.setColor(new Color(0,150,0));								// draw the grass
		grpOff.fillRect(0, Game.DIM.height-Game.GROUND_LEVEL, Game.DIM.width, Game.GROUND_LEVEL);

		drawScore(grpOff);
		
		if (!CommandCenter.isPlaying()) {
			displayTextOnScreen();
		}
		else if (CommandCenter.isPaused()) {
			strDisplay = "Game Paused";
			grpOff.drawString(strDisplay, (Game.DIM.width - fmt.stringWidth(strDisplay)) / 2, Game.DIM.height / 4);
		}
		
		else {			//playing and not paused!
			
			//draw them in decreasing level of importance - friends will be on top layer and debris on the bottom
			iterateMovables(grpOff,CommandCenter.movDebris,CommandCenter.movFloaters,CommandCenter.movFoes,CommandCenter.movFriends);
			drawNumberShipsLeft(grpOff);
			if (CommandCenter.isGameOver()) {
				CommandCenter.setPlaying(false);
			}
		}
		g.drawImage(imgOff, 0, 0, this);	//draw the double-Buffered Image to the graphics context of the panel
	} 

	// For each movable array, process it.
	private void iterateMovables(Graphics g, CopyOnWriteArrayList<Movable>...movMovz){
		for (CopyOnWriteArrayList<Movable> movMovs : movMovz) {
			for (Movable mov : movMovs) {
				mov.move();
				mov.draw(g);
				mov.fadeInOut();
				mov.expire();
			}
		}
	}
	
	// Draw the number of falcons left on the bottom-right of the screen. 
	private void drawNumberShipsLeft(Graphics g) {
		
		Falcon fal = CommandCenter.getFalcon();
		double[] dLens = fal.getLengths();
		int nLen = fal.getDegrees().length;

		Point[] pntMs = new Point[nLen];
		int[] nXs = new int[nLen];
		int[] nYs = new int[nLen];
	
		for (int nC = 0; nC < nLen; nC++) {										// convert to cartesean points
			pntMs[nC] = new Point((int) (10 * dLens[nC] * Math.sin(Math.toRadians(90) + fal.getDegrees()[nC])),
								  (int) (10 * dLens[nC] * Math.cos(Math.toRadians(90) + fal.getDegrees()[nC])));
		}
		
		g.setColor(Color.white);

		
		for (int nD = 1; nD < CommandCenter.getNumFalcons(); nD++) {		//for each falcon left (not including current falcon)
			
			//create x and y values for the objects to the bottom right using cartesean points again
			for (int nC = 0; nC < fal.getDegrees().length; nC++) {
				nXs[nC] = pntMs[nC].x + Game.DIM.width - (20 * nD);
				nYs[nC] = pntMs[nC].y + Game.DIM.height - 40;
			}
			g.drawPolygon(nXs, nYs, nLen);
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
		
		String[] strTitleLines = ASCIITitle.makeASCIITitle();

		int nTitleXCoord = 160;
		int nTitleYCoord = 100;
		int nTitleSpacing = 15;
		
		grpOff.setFont(fntTitle);
		
		grpOff.drawString(strTitleLines[0],nTitleXCoord,nTitleYCoord);
		grpOff.drawString(strTitleLines[1],nTitleXCoord,nTitleYCoord+nTitleSpacing*1);
		grpOff.drawString(strTitleLines[2],nTitleXCoord,nTitleYCoord+nTitleSpacing*2);
		grpOff.drawString(strTitleLines[3],nTitleXCoord,nTitleYCoord+nTitleSpacing*3);
		grpOff.drawString(strTitleLines[4],nTitleXCoord,nTitleYCoord+nTitleSpacing*4);
		grpOff.drawString(strTitleLines[5],nTitleXCoord,nTitleYCoord+nTitleSpacing*5);
		
		grpOff.setFont(fnt);
		
		if(CommandCenter.isFirstGame()){
			strDisplay = "WELCOME COMMANDER";
			grpOff.drawString(strDisplay,
					(Game.DIM.width - fmt.stringWidth(strDisplay)) / 2, Game.DIM.height / 4 + + nFontHeight + 40);
		}
		else{	
			strDisplay = "GAME OVER";
			grpOff.drawString(strDisplay,
					(Game.DIM.width - fmt.stringWidth(strDisplay)) / 2, Game.DIM.height / 4 + + nFontHeight + 40);
		}

		strDisplay = "Click the mouse to fire a missile - shoot at enemy missiles, bombers, and bombs";
		grpOff.drawString(strDisplay,
				(Game.DIM.width - fmt.stringWidth(strDisplay)) / 2, Game.DIM.height / 4 + nFontHeight + 80);
		
		strDisplay = "Shoot powerups for special abilities - your powerup ammo is displayed in the bottom left of the screen";
		grpOff.drawString(strDisplay,
				(Game.DIM.width - fmt.stringWidth(strDisplay)) / 2, Game.DIM.height / 4 + nFontHeight + 120);		

		strDisplay = "The game is over when your cities and missile silo are destroyed";
		grpOff.drawString(strDisplay,
				(Game.DIM.width - fmt.stringWidth(strDisplay)) / 2, Game.DIM.height / 4+ nFontHeight + 160);

		strDisplay = "Press the 'S' key to start";
		grpOff.drawString(strDisplay,
				(Game.DIM.width - fmt.stringWidth(strDisplay)) / 2, Game.DIM.height / 4 + nFontHeight + 200);

		strDisplay = "Press the 'P' key to pause";
		grpOff.drawString(strDisplay,
				(Game.DIM.width - fmt.stringWidth(strDisplay)) / 2, Game.DIM.height / 4 + nFontHeight + 240);

		strDisplay = "Press the 'Q' key to quit";
		grpOff.drawString(strDisplay,
				(Game.DIM.width - fmt.stringWidth(strDisplay)) / 2, Game.DIM.height / 4 + nFontHeight + 280);
		
		grpOff.setColor(Color.blue);
		strDisplay = "'T' Powerup = Missile turrets fire from your cities";
		grpOff.drawString(strDisplay,
				(Game.DIM.width - fmt.stringWidth(strDisplay)) / 2, Game.DIM.height / 4 + nFontHeight + 320);

		grpOff.setColor(Color.green);
		strDisplay = "'S' Powerup = Your missiles get a spread effect";
		grpOff.drawString(strDisplay,
				(Game.DIM.width - fmt.stringWidth(strDisplay)) / 2, Game.DIM.height / 4 + nFontHeight + 360);

		grpOff.setColor(Color.orange);
		strDisplay = "'F' Powerup = Move the mouse to fire continuously";
		grpOff.drawString(strDisplay,
				(Game.DIM.width - fmt.stringWidth(strDisplay)) / 2, Game.DIM.height / 4 + nFontHeight + 400);
		
		grpOff.setColor(Color.red);
		strDisplay = "'N' Powerup = Launch a super nuke";
		grpOff.drawString(strDisplay,
				(Game.DIM.width - fmt.stringWidth(strDisplay)) / 2, Game.DIM.height / 4 + nFontHeight + 440);
	}
	
	
	// ==============================================================
	// GETTERS & SETTERS 
	// ==============================================================
	
	public GameFrame getFrm() {return this.gmf;}
	public void setFrm(GameFrame frm) {this.gmf = frm;}	
}