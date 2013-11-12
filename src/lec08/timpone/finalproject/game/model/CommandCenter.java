package lec08.timpone.finalproject.game.model;

import java.util.concurrent.CopyOnWriteArrayList;
import lec08.timpone.finalproject.sounds.Sound;

/**
 *  This is a utility class with static methods and no constructor.  It helps maintain the state of the game.  The CommandCenter 
 *  class has been altered slightly from the game base.  Several powerup boolean methods have been added, and some game-related 
 *  fields have been moved here.  For the most part though, the functinoality is the same as the generic game base.  
 */
public class CommandCenter {

	// ==============================================================
	// FIELDS 
	// ==============================================================
	
	private static Falcon falShip;					// the Falcon Missile Silo object
	private static int nNumFalcon;					// number of lives the player has

	private static int nLevel;						// the level that the player is currently on
	private static long lScore;						// the player's current score
	private static long lHighScore;					// the player's highest score
	private static int nKillCount;					// how many kills the player has accumulated in the current game

	private static boolean bPlaying;				// true if the player is currently playing the game
	private static boolean bPaused;					// true if the game is paused
	private static boolean bFirstGame;				// true if this is the player's first game
	
	private static int nTurretShots;				// number of times the turrets have fired since the T powerup was picked up
	private static int nSpreadShots;				// number of times the spread gun has been fired since the S powerup was picked up
	private static int nFlameShots;					// number of times the flame gun has been fired since the F powerup was picked up
	
	private static boolean bTurretsActive;			// true if the player has the turrets powerup active
	private static boolean bSpreadGunActive;		// true if the player has the spread gun powerup active
	private static boolean bFlameGunActive;			// true if the player has the flame gun powerup active
	
	private static boolean bFlameIsOn;				// true if the flame gun is currently firing
	
	// These ArrayLists are thread-safe and hold the game objects
	public static CopyOnWriteArrayList<Movable> movDebris = new CopyOnWriteArrayList<Movable>();
	public static CopyOnWriteArrayList<Movable> movFriends = new CopyOnWriteArrayList<Movable>();
	public static CopyOnWriteArrayList<Movable> movFoes = new CopyOnWriteArrayList<Movable>();
	public static CopyOnWriteArrayList<Movable> movFloaters = new CopyOnWriteArrayList<Movable>();
	
	
	// ==============================================================
	// METHODS 
	// ==============================================================
	
	// Initializes the state of the game
	public static void initGame(){
		setLevel(1);
		setScore(0);
		setKillCount(0);
		setNumFalcons(3);
		spawnFalcon(true);						// spawns a falcon - the 'true' indicates it is the player's first falcon
		Sound.playSound("terrannuke.wav");		// plays the "nuclear launch detected" sound at the beginning of the game
		bPaused = false;
		
		bFirstGame = false;		// changes first game to false so the home screen will read 'game over' instead of 'welcome commander'
		
		bTurretsActive = false;					// disables any powerups that are enabled
		bSpreadGunActive = false;
		bFlameGunActive = false;
		
		nTurretShots = 0;						// resets all powerup ammo to 0
		nSpreadShots = 0;
		nFlameShots = 0;
	}

	// Replaces the high score with the current score if it is higher than the previous high score
	public static void checkForHighScore(){
		if(lScore > lHighScore){
			lHighScore = lScore;
		}
	}
	
	// Spawns a new Falcon if the player still has lives remaining.  The parameter indicates whether this is the player's 
	// first falcon.  
	public static void spawnFalcon(boolean bFirst) {
		if (getNumFalcons() != 0) {
			falShip = new Falcon();
			movFriends.add(falShip);
			if (!bFirst)
			    setNumFalcons(getNumFalcons() - 1);
			}
		Sound.playSound("shipspawn.wav");
	}
	
	public static void clearAll(){
		movDebris.clear();
		movFriends.clear();
		movFoes.clear();
		movFloaters.clear();
	}
	
	// If the number of lives remaining is zero, then game over
	public static boolean isGameOver() {		
		if (getNumFalcons() == 0) {
			checkForHighScore();
			CommandCenter.setPaused(true);
			bTurretsActive = false;				// disables any active powerups
			bSpreadGunActive = false;
			bFlameGunActive = false;
			return true;
		}
		return false;
	}
	
	public static void incrementTurretShots(){
		nTurretShots++;
	}

	public static void incrementSpreadShots(){
		nSpreadShots++;
	}
	
	public static void incrementFlameShots(){
		nFlameShots++;
	}
	
	// ==============================================================
	// GETTERS & SETTERS 
	// ==============================================================
	
	public static boolean isPlaying() {return bPlaying;}
	public static void setPlaying(boolean bPlaying) {CommandCenter.bPlaying = bPlaying;}

	public static boolean isPaused() {return bPaused;}
	public static void setPaused(boolean bPaused) {CommandCenter.bPaused = bPaused;}
	
	public  static long getScore() {return lScore;}
	public static void setScore(long lParam) {lScore = lParam;}

	public static int getLevel() {return nLevel;}
	public static void setLevel(int n) {nLevel = n;}

	public static int getNumFalcons() {return nNumFalcon;}
	public static void setNumFalcons(int nParam) {nNumFalcon = nParam;}
	
	public static Falcon getFalcon(){return falShip;}
	public static void setFalcon(Falcon falParam){falShip = falParam;}

	public static CopyOnWriteArrayList<Movable> getMovDebris() {return movDebris;}
	public static CopyOnWriteArrayList<Movable> getMovFriends() {return movFriends;}
	public static CopyOnWriteArrayList<Movable> getMovFoes() {return movFoes;}
	public static CopyOnWriteArrayList<Movable> getMovFloaters() {return movFloaters;}

	public static int getKillCount() {return nKillCount;}
	public static void setKillCount(int nKillCount) {CommandCenter.nKillCount = nKillCount;}

	public static boolean isTurretsOn() {return bTurretsActive;}
	public static void setTurretsOn(boolean bTurretsOn) {CommandCenter.bTurretsActive = bTurretsOn;}

	public static boolean isSpreadGunOn() {return bSpreadGunActive;}
	public static void setSpreadGunOn(boolean bSpreadGunOn) {CommandCenter.bSpreadGunActive = bSpreadGunOn;}

	public static boolean isFlameCloudOn() {return bFlameGunActive;}
	public static void setFlameCloudOn(boolean bFlameCloudOn) {CommandCenter.bFlameGunActive = bFlameCloudOn;}

	public static int getTurretShots() {return nTurretShots;}
	public static void setTurretShots(int nTurretShots) {CommandCenter.nTurretShots = nTurretShots;}
	
	public static int getSpreadShots() {return nSpreadShots;}
	public static void setSpreadShots(int nSpreadShots) {CommandCenter.nSpreadShots = nSpreadShots;}

	public static int getFlameShots() {return nFlameShots;}
	public static void setFlameShots(int nFlameShots) {CommandCenter.nFlameShots = nFlameShots;}
	
	public static boolean isbFlameOn() {return bFlameIsOn;}
	public static void setbFlameOn(boolean bFlameOn) {CommandCenter.bFlameIsOn = bFlameOn;}

	public static boolean isFirstGame() {return bFirstGame;}
	public static void setFirstGame(boolean bFirstGame) {CommandCenter.bFirstGame = bFirstGame;}

	public static long getHighScore() {return lHighScore;}
	public static void setHighScore(long lHighScore) {CommandCenter.lHighScore = lHighScore;}
	
}