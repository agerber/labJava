package lec09.glab.danshiff.game.model;

import java.util.concurrent.CopyOnWriteArrayList;

import lec09.glab.danshiff.controller.Game;
import lec09.glab.danshiff.sounds.Sound;

import static lec09.glab.danshiff.controller.Game.*;

// I only want one Command Center and therefore this is a perfect candidate for static
// Able to get access to methods and my movMovables ArrayList from the static context.
public class CommandCenter {

	private static int nLives;
	private static int nLevel;
	private static long lScore;
	private static BugHunter bhAvatar;
	private static boolean bPlaying;
	private static boolean bPaused;
    private static int nChilled;
	
	// These ArrayLists are thread-safe
	public static CopyOnWriteArrayList<Movable> movDebris = new CopyOnWriteArrayList<>();
	public static CopyOnWriteArrayList<Movable> movFriends = new CopyOnWriteArrayList<>();
	public static CopyOnWriteArrayList<Movable> movFoes = new CopyOnWriteArrayList<>();
	public static CopyOnWriteArrayList<Movable> movFungus = new CopyOnWriteArrayList<>();   //I added this.
    public static CopyOnWriteArrayList<Movable> movFloaters = new CopyOnWriteArrayList<>();

    //Want to make sure mushrooms do not overlap. This grid that tracks whether there's a shroom in each "cell" of the
    //board does that. It gives parallel information, but the simplest alternatives do horrible things to running time
    //(have each mushroom being added make sure there isn't a mushroom in the location it wants to go).
    public static boolean[][] bMushrooms = new boolean[Game.ROW][Game.COL];
	

	// Constructor made private - static Utility class only
	private CommandCenter() {}
	
	public static void initGame(){
		setLevel(0);
		setScore(0);
		setLives(3);
        setChilled(0);
		spawnHunter(true);
	}
	
	// The parameter is true if this is for the beginning of the game, otherwise false
	// When you spawn a new falcon, you need to decrement its number
	public static void spawnHunter(boolean bFirst) {

		if (getLives() != 0) {
			bhAvatar = new BugHunter();
			movFriends.add(bhAvatar);
			if (!bFirst)
			    setLives(getLives() - 1);
		}
        //Bugs don't stay chilled upon dying.
        setChilled(0);
		
		Sound.playSound("shipspawn.wav");

	}

    /**
     * Special method for adding mushrooms. Checks grid array to make sure there isn't overlapping. Then lets the grid
     * know a shroom is there.
     * @param musAdd
     */
    public static void addMushroom(Mushroom musAdd){
        int row = musAdd.getCenter().y/(Game.STANDARD_RADIUS * 2);
        int col = musAdd.getCenter().x/(Game.STANDARD_RADIUS * 2);
        //Make sure edge cases don't screw me up.
        if(col >= Game.COL){
            col = Game.COL - 1;
        }
        if(col < 0){
            col = 0;
        }
        System.out.println("" + row + " " + col);
        if(!bMushrooms[row][col]){
            movFungus.add(musAdd);
        }
        bMushrooms[row][col] = true;
    }

    /**
     * Special method for removing a shroom. Lets the grid know the shroom is gone.
     * @param musRem
     */
    public static void removeMushroom(Mushroom musRem){
        int row = musRem.getCenter().y/(Game.STANDARD_RADIUS * 2);
        int col = musRem.getCenter().x/(Game.STANDARD_RADIUS * 2);
        if(col > Game.COL - 1 || col < 0){
            movFungus.remove(musRem);
            return;
        }
        movFungus.remove(musRem);
        System.out.println("" + row + " " + col);
        bMushrooms[row][col] = false;
    }
	
	public static void clearAll(){
		movDebris.clear();
		movFriends.clear();
		movFoes.clear();
		movFungus.clear();
        movFloaters.clear();
        bMushrooms = new boolean[Game.ROW][Game.COL];
	}

	public static boolean isPlaying() {
		return bPlaying;
	}

	public static void setPlaying(boolean bPlaying) {
		CommandCenter.bPlaying = bPlaying;
	}

	public static boolean isPaused() {
		return bPaused;
	}

	public static void setPaused(boolean bPaused) {
		CommandCenter.bPaused = bPaused;
	}
	
	public static boolean isGameOver() {		//if the number of hunters is zero, then game over
		if (getLives() == 0) {
			return true;
		}
		return false;
	}

	public static int getLevel() {
		return nLevel;
	}

	public  static long getScore() {
		return lScore;
	}

	public static void setScore(long lParam) {
        setLives(getLives() + (int)((lParam / 1000)-(lScore / 1000)));
		lScore = lParam;
	}

	public static void setLevel(int n) {
		nLevel = n;
	}

	public static int getLives() {
		return nLives;
	}

	public static void setLives(int nParam) {
		nLives = nParam;
	}

	public static BugHunter getHunter(){
		return bhAvatar;
	}
	
	public static void setHunter(BugHunter falParam){
		bhAvatar = falParam;
	}

    public static int getChilled(){
        return nChilled;
    }

    public static void setChilled(int nParam){
        nChilled = nParam;
    }

	public static CopyOnWriteArrayList<Movable> getMovDebris() {
		return movDebris;
	}



	public static CopyOnWriteArrayList<Movable> getMovFriends() {
		return movFriends;
	}



	public static CopyOnWriteArrayList<Movable> getMovFoes() {
		return movFoes;
	}


	public static CopyOnWriteArrayList<Movable> getMovFloaters() {
		return movFungus;
	}


	
	
}
