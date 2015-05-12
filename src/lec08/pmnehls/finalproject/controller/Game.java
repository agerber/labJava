
/*
                                     ,2Ah5si3BMr             .3HA
                         r::       ,H@G:     .;&M;           s@#@@.        .3As
           .:rS22r.     ;@@@B     .#@,    ...    @i          s#. @@:     .3@#@@       :A&r
     :sXB#@@#Hh22XX#@:  h# :@@    X@   .....  .S@@2 S5XX2A:  iB   #@r  .2@#: @9      i@MM@:     ,:
     i@A;:,         2@r:#s  .@@:  @2 ..,,,.,iB@@S.  @@SS52@2 SH    G@2s@@;  .@r    ,A@i  @M     h@@A    2i:.
      @S      ri   ,sX@XA     A@i #2 ..,,,.r@@2     s@..,.A@i5G     s@@r    ;@,   r@M,   2@.   .#h3@S  ;@##@@#
      X#  ....@@.  ;Xr@@: .    r@5.M ......:ii29Xi;  .@@@@#Ai92 ..   .   .. i@  .9@5      @G   r@, M@: A#  .;2@
      ;@r .,.   ,:s5:M@A ..@@. rs#A5S  ....    s#;@;        :Bs ...    .. G,X@ ,##:  ,s.  h@   &A   @@;#;    ;@:
       #A ... 2hS23h@9M  . sS   3;9@AS:       ;5S@@.        i@,      .... @.HB;@X  . &@2 ..@S ;#r   .@@M  .. @@
       5@. .. 9X;@2::Xi ..    .:,#:;@Xr22srrriM##i           #3irr;:,.:XSsG @#9,  ..  .  3;3@ SM  .  ,@r .. ;@S
       ,@i .   #.@  iA     .,:sAG3hS@@5 .:sX9S;               X@@@@@@@@@@#hX@@: ..     ,..A.@93i ...  ;. ., M@
        M# :;;;& #9 M@SH@@@@@@BXir;,                                   .,;riS&M@@@@@AXsXXr& 2@H  ...     rH,@i
        r@i9HHBAH@@  2hi;,                                                       .:s3B@@@#HXh@A      ,.  @:9@
          sMH2r:.                                                                         :r5G@@@@AS;2Xsi& @S
                                                                                                :SH@@@@#H:9@
                                                                                                      ,;s5hr
*/

package lec08.pmnehls.finalproject.controller;

import sun.audio.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.sound.sampled.Clip;

import lec08.pmnehls.finalproject.game.model.*;
import lec08.pmnehls.finalproject.game.view.*;
import lec08.pmnehls.finalproject.sounds.Sound;

// ===============================================
// == This Game class is the CONTROLLER
// ===============================================

public class Game implements Runnable, KeyListener {

	// ===============================================
	// FIELDS
	// ===============================================

	public static final Dimension DIM = new Dimension(TargetSpace.TS_WIDTH* 28, TargetSpace.TS_HEIGHT * 37); //the dimension of the game
    //to change dimensions of the game (not recommended), change TargetSpace.TS_HEIGHT or TS_WIDTH, not the above dimensions
	private GamePanel gmpPanel;
	public static Random R = new Random();
	public final static int ANI_DELAY = 45; // milliseconds between screen
											// updates (animation)
	private Thread thrAnim;


    private static int nLives = 4; //set number of initial lives
    private static int nProtonPacks = 3; //set number of initial proton packs
    private static int nScatterSeconds = 7; //set second length of scatter intervals
    private static int nChaseSeconds = 20; //set second length of chase intervals


    //variables to keep track of scores and level progress
	private static int nTick = 0;
    private static int nTickStore;
    private static int nDotCounter;
    private static int nEnergizerCounter;
    private static int nGhostsEaten;

    private int nSirenTimer; //makes siren sound loop when no other sound is active

	private ArrayList<Tuple> tupMarkForRemovals;
	private ArrayList<Tuple> tupMarkForAdds;

    //booleans to control timing, fruit spawn, and initial music
    private static boolean bInitial = true;
    private boolean bNewLevel;
    private static boolean bRespawnAfterDeath;
    private static boolean bFruit = false;
    private boolean bBonusLife;
    private static boolean bStarted;

    //energizer booleans and variables
    private static boolean isInvincible;
    private static int nScaredSeconds;

	private final int PAUSE = 80, // p key
			QUIT = 81, // q key
			LEFT = 37, // turn left; left arrow
			RIGHT = 39, // turn right; right arrow
			UP = 38, // turn up; up arrow
            DOWN = 40, // turn down; down arrow
			START = 83, // s key
            OUIJA = 79, // o key
            PROTON = 71; // g key



    private static Clip clpSiren; //background siren sound


	// ===============================================
	// ==CONSTRUCTOR
	// ===============================================

	public Game() {

		gmpPanel = new GamePanel(DIM);
		gmpPanel.addKeyListener(this);

        //initialize siren background sound
        clpSiren = Sound.clipForLoopFactory("siren.wav");

	}

	// ===============================================
	// ==METHODS
	// ===============================================

	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() { // uses the Event dispatch thread from Java 5 (refactored)
					public void run() {
						try {
							Game game = new Game(); // construct itself
							game.fireUpAnimThread();

						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
	}

	private void fireUpAnimThread() { // called initially
		if (thrAnim == null) {
			thrAnim = new Thread(this); // pass the thread a runnable object (this)
			thrAnim.start();
		}
	}

	// implements runnable - must have run method
	public void run() {

		// lower this thread's priority; let the "main" aka 'Event Dispatch'
		// thread do what it needs to do first
		thrAnim.setPriority(Thread.MIN_PRIORITY);

		// and get the current time
		long lStartTime = System.currentTimeMillis();

        //set nTick to zero when starting the program
        nTick = 0;

		// this thread animates the scene
		while (Thread.currentThread() == thrAnim) {
			tick();

            //spawn initial stuff after music finishes
            if (nTick == 100 && bInitial && bStarted)
            {
                bInitial = false;
                CommandCenter.initialSpawn();
                nTick = 0;
            }

			//spawnNewShipFloater();
			gmpPanel.update(gmpPanel.getGraphics()); // update takes the graphics context we must 
														// surround the sleep() in a try/catch block
														// this simply controls delay time between 
														// the frames of the animation

			checkCollisions();


            //spawn pacman and ghosts after a pause after new level or death
            if(bNewLevel || bRespawnAfterDeath)
            {
                if (nTick > 100 && bStarted)
                {
                    CommandCenter.spawnAllAfterPause();
                    bNewLevel = false;
                    bRespawnAfterDeath = false;
                    nTick = 0;
                }
            }
			//this might be a god place to check if the level is clear (no more foes)
			//if the level is clear then spawn some big asteroids -- the number of asteroids 
			//should increase with the level. 

			checkNewLevel();

            // award a bonus life if player reaches 10,000 points
            if (CommandCenter.getScore() >= 10000 && !bBonusLife)
            {
                Sound.playSound("pacman_extrapac.wav");
                nLives += 1;
                CommandCenter.movLives.clear();
                CommandCenter.initPacmanLives();
                bBonusLife = true;
            }

			try {
				// The total amount of time is guaranteed to be at least ANI_DELAY long.  If processing (update) 
				// between frames takes longer than ANI_DELAY, then the difference between lStartTime - 
				// System.currentTimeMillis() will be negative, then zero will be the sleep time
				lStartTime += ANI_DELAY;
				Thread.sleep(Math.max(0,
						lStartTime - System.currentTimeMillis()));
			} catch (InterruptedException e) {
				// just skip this frame -- no big deal
				continue;
			}
		} // end while
	} // end run

	private void checkCollisions() {

        if (nDotCounter == 70 && !bFruit)
        {

                CommandCenter.spawnCherry();
                bFruit = true;
        }

        //@formatter:off
		//for each friend in movFriends
			//for each foe in movFoes
				//if the distance between the two centers is less than the sum of their radii
					//mark it for removal
		
		//for each mark-for-removal
			//remove it
		//for each mark-for-add
			//add it
		//@formatter:on
		
		//we use this ArrayList to keep pairs of movMovables/movTarget for either
		//removal or insertion into our arrayLists later on
		tupMarkForRemovals = new ArrayList<Tuple>();
		tupMarkForAdds = new ArrayList<Tuple>();


        if (CommandCenter.movPacman.size() != 0)
        {
            for (Movable dot : CommandCenter.movDots)
            {
                Point pntPacman = CommandCenter.movPacman.get(0).getCenter();
                Point pntDot = dot.getCenter();

                if (Math.abs(pntPacman.x - pntDot.x) < 6)
                {
                    if (Math.abs(pntPacman.y - pntDot.y) < 6)
                    {
                        if (dot instanceof Cherry)
                        {
                            CommandCenter.setScore(CommandCenter.getScore() + 100);
                            Sound.playSound("pacman_eatfruit.wav");
                            tupMarkForRemovals.add(new Tuple(CommandCenter.movDots, dot));
                        }
                        else
                        {
                            stopLoopingSounds(clpSiren);
                            CommandCenter.setScore(CommandCenter.getScore() + 10);
                            tupMarkForRemovals.add(new Tuple(CommandCenter.movDots, dot));
                            nDotCounter = nDotCounter + 1; // this needs to be after so last dot is removed when level is clear
                            nSirenTimer = nTick;
                        }

                    }
                }

            }


            //play siren sound if dot sound is done
            if (nSirenTimer + 40 < nTick && bStarted)
            {
                clpSiren.loop(Clip.LOOP_CONTINUOUSLY);
            }
        }
        //}

        //eat energizers and set invincible booleans
        for (Movable pacman : CommandCenter.movPacman)
        {
            for (Movable energizer : CommandCenter.movEnergizers)
            {
                Point pntPacman = pacman.getCenter();
                Point pntEnergizer = energizer.getCenter();

                if (Math.abs(pntPacman.x - pntEnergizer.x) < 10)
                {
                    if (Math.abs(pntPacman.y - pntEnergizer.y) < 10)
                    {
                        tupMarkForRemovals.add(new Tuple(CommandCenter.movEnergizers, energizer));
                        nEnergizerCounter += 1;
                        isInvincible = true;
                        nTickStore = nTick;
                        CommandCenter.setScore(CommandCenter.getScore() + 50);

                        for (int nC = 0; nC < CommandCenter.movFoes.size(); nC++)
                        {
                            if (CommandCenter.movFoes.get(nC) instanceof Blinky)
                            {
                                CommandCenter.movFoes.get(nC).setRespawn(false);
                            }
                            else if (CommandCenter.movFoes.get(nC) instanceof Inky)
                            {
                                CommandCenter.movFoes.get(nC).setRespawn(false);
                            }
                            else if (CommandCenter.movFoes.get(nC) instanceof Pinky)
                            {
                                CommandCenter.movFoes.get(nC).setRespawn(false);
                            }
                            else if (CommandCenter.movFoes.get(nC) instanceof Clyde)
                            {
                                CommandCenter.movFoes.get(nC).setRespawn(false);
                            }
                        }
                    }
                }

            }
        }


        //handle proton pack
        if (CommandCenter.getProton())
        {
            if(CommandCenter.getProtonTick() > nTick)
            {
                CommandCenter.setProton(false);
            }
            else if(CommandCenter.getProtonTick() + 88 < nTick)
            {
                CommandCenter.setProton(false);
            }

            boolean bZapped = false;
            for (Movable pacman: CommandCenter.movPacman)
            {
                for (Movable ghost : CommandCenter.movFoes)
                {
                    Point pntPacman = pacman.getCenter();
                    Point pntGhost = ghost.getCenter();
                    int nPacDirection = pacman.getOrientation();
                    if (nPacDirection == 0)
                    {
                        if((pntPacman.x == pntGhost.x) && pntPacman.y - pntGhost.y < 30 && pntPacman.y - pntGhost.y > 0)
                        {
                            bZapped = true;
                        }
                        else
                        {
                            bZapped = false;
                        }
                    }
                    else if (nPacDirection == 90)
                    {
                        if((Math.abs(pntPacman.y - pntGhost.y) < 2 )&& (pntGhost.x - pntPacman.x < 30) && (pntGhost.x - pntPacman.x > 0))
                        {
                            bZapped = true;
                        }
                        else
                        {
                            bZapped = false;
                        }
                    }
                    else if (nPacDirection == 180)
                    {
                        if((pntPacman.x == pntGhost.x) && (pntGhost.y - pntPacman.y < 30) && (pntGhost.y - pntPacman.y > 0))
                        {
                            bZapped = true;
                        }
                        else
                        {
                            bZapped = false;
                        }
                    }
                    else if (nPacDirection == 270)
                    {
                        if((pntPacman.y == pntGhost.y) && (pntPacman.x - pntGhost.x < 30) && (pntPacman.x - pntGhost.x > 0))
                        {
                            bZapped = true;
                        }
                        else
                        {
                            bZapped = false;
                        }
                    }

                    //remove and respawn ghost if zapped
                    if(bZapped)
                    {
                        Sound.playSound("floop2_x.wav");
                        if (ghost instanceof Blinky)
                        {
                            tupMarkForRemovals.add(new Tuple(CommandCenter.movFoes, ghost));
                            CommandCenter.spawnBlinky(false);

                        }
                        else if (ghost instanceof Pinky)
                        {
                            tupMarkForRemovals.add(new Tuple(CommandCenter.movFoes, ghost));
                            CommandCenter.spawnPinky(false);
                        }
                        else if (ghost instanceof Inky)
                        {
                            tupMarkForRemovals.add(new Tuple(CommandCenter.movFoes, ghost));
                            CommandCenter.spawnInky(false);
                        }
                        else if (ghost instanceof Clyde)
                        {
                            tupMarkForRemovals.add(new Tuple(CommandCenter.movFoes, ghost));
                            CommandCenter.spawnClyde(false);
                        }
                    }

                    if(!CommandCenter.getProton())
                    {
                        if(CommandCenter.movProton.size() != 0)
                        tupMarkForRemovals.add(new Tuple(CommandCenter.movProton, CommandCenter.movProton.get(0)));

                    }

                }
            }
        }



        //handle pac-man and ghost collision
        for (Movable pacman : CommandCenter.movPacman)
        {
            for (Movable ghost : CommandCenter.movFoes)
            {
                Point pntPacman = pacman.getCenter();
                Point pacManSquare = new Point((pntPacman.x/TargetSpace.TS_WIDTH)+1, (pntPacman.y/TargetSpace.TS_HEIGHT)+1);
                Point pntGhost = ghost.getCenter();
                Point ghostSquare = new Point((pntGhost.x/TargetSpace.TS_WIDTH)+1, (pntGhost.y/TargetSpace.TS_HEIGHT)+1);

                //resets ghost eaten counter for proper bonus points
                if (!isInvincible)
                {
                    nGhostsEaten = 0;
                }

                if ((pacManSquare.x == ghostSquare.x) || Math.abs(pntPacman.x - pntGhost.x) < 4)
                {
                    if ((pacManSquare.y == ghostSquare.y) || Math.abs(pntPacman.y - pntGhost.y) < 4)
                    {
                        if (isInvincible && !ghost.getRespawn())
                        {
                            Sound.playSound("pacman_eatghost.wav");
                            nGhostsEaten += 1;
                            if (ghost instanceof Blinky)
                            {
                                tupMarkForRemovals.add(new Tuple(CommandCenter.movFoes, ghost));
                                CommandCenter.spawnBlinky(false);

                            }
                            else if (ghost instanceof Pinky)
                            {
                                tupMarkForRemovals.add(new Tuple(CommandCenter.movFoes, ghost));
                                CommandCenter.spawnPinky(false);
                            }
                            else if (ghost instanceof Inky)
                            {
                                tupMarkForRemovals.add(new Tuple(CommandCenter.movFoes, ghost));
                                CommandCenter.spawnInky(false);
                            }
                            else if (ghost instanceof Clyde)
                            {
                                tupMarkForRemovals.add(new Tuple(CommandCenter.movFoes, ghost));
                                CommandCenter.spawnClyde(false);
                            }

                            switch (nGhostsEaten)
                            {
                                case 1:
                                    CommandCenter.setScore(CommandCenter.getScore() + 200);
                                    break;
                                case 2:
                                    CommandCenter.setScore(CommandCenter.getScore() + 400);
                                    break;
                                case 3:
                                    CommandCenter.setScore(CommandCenter.getScore() + 800);
                                    break;
                                case 4:
                                    CommandCenter.setScore(CommandCenter.getScore() + 1600);
                                    break;
                            }
                        }
                        else
                        {
                            tupMarkForRemovals.add(new Tuple(CommandCenter.movPacman, pacman));
                            for (int nC = 0; nC < CommandCenter.movFoes.size(); nC ++)
                            {
                                tupMarkForRemovals.add(new Tuple(CommandCenter.movFoes,
                                        CommandCenter.movFoes.get(nC)));
                            }

                            stopLoopingSounds(clpSiren, Pacman.getWaka());
                            try
                            {
                                Thread.sleep(150);
                            } catch (InterruptedException e)
                            {
                                e.printStackTrace();
                            }
                            Sound.playSound("pacman_death.wav");
                            nLives -= 1;
                            nTick = 0;
                            bRespawnAfterDeath = true;
                            CommandCenter.resetLevel();

                        }

                    }
                }

            }
        }


		
		//remove these objects from their appropriate ArrayLists
		//this happens after the above iterations are done
		for (Tuple tup : tupMarkForRemovals) 
			tup.removeMovable();
		
		//add these objects to their appropriate ArrayLists
		//this happens after the above iterations are done
		for (Tuple tup : tupMarkForAdds) 
			tup.addMovable();

		//call garbage collection
		System.gc();
		
	}//end meth


	//some methods for timing events in the game,
	//such as the appearance of UFOs, floaters (power-ups), etc. 
	public void tick() {
		if (nTick == Integer.MAX_VALUE)
			nTick = 0;
		else
			nTick++;
	}

	public int getTick() {
		return nTick;
	}



	// Called when user presses 's'
	private void startGame() {
		CommandCenter.clearAll();
        CommandCenter.playIntro();
		CommandCenter.initGame();
		CommandCenter.setPlaying(true);
		CommandCenter.setPaused(false);
        CommandCenter.setScore(0);
        bStarted = true;
        bInitial = true;
        bNewLevel = false;

	}



	
	private void checkNewLevel()
    {
        if (Game.getDotCounter() >= 240)
        {
            if(Game.getEnergizerCounter() >= 4)
            {
                CommandCenter.setLevel(CommandCenter.getLevel() + 1);
                CommandCenter.clearAll();
                stopLoopingSounds(clpSiren, Pacman.getWaka());
                CommandCenter.startNextLevel(CommandCenter.getLevel());
                nTick = 0;
                bNewLevel = true;

            }
        }

	}
	
	
	public static int getnTick()
    {
        return nTick;
    }

    public static void setnTick(int nTick)
    {
        Game.nTick = nTick;
    }

    public static int getEnergizerCounter()
    {
        return nEnergizerCounter;
    }

    public static void setEnergizerCounter(int nEnergizerCounter)
    {
        Game.nEnergizerCounter = nEnergizerCounter;
    }

    public static int getDotCounter()
    {
        return nDotCounter;
    }

    public static void setDotCounter(int nDotCounter)
    {
        Game.nDotCounter = nDotCounter;
    }


    public static int getnScatterSeconds()
    {
        return nScatterSeconds;
    }

    public static void setScatterSeconds(int nSeconds)
    {
        Game.nScatterSeconds = nSeconds;
    }

    public static int getScaredSeconds()
    {
        return nScaredSeconds;
    }

    public static void setScaredSeconds(int nScaredSeconds)
    {
        Game.nScaredSeconds = nScaredSeconds;
    }

    public static int getChaseSeconds()
    {
        return nChaseSeconds;
    }

    public static void setChaseSeconds(int nChaseSeconds)
    {
        Game.nChaseSeconds = nChaseSeconds;
    }

    public static boolean getIsInvincible()
    {
        return isInvincible;
    }

    public static void setIsInvincible(boolean isInvincible)
    {
        Game.isInvincible = isInvincible;
    }

    public static int getTickStore()
    {
        return nTickStore;
    }

    public static void setTickStore(int nTickStore)
    {
        Game.nTickStore = nTickStore;
    }

    public static int getProtonsLeft()
    {
        return Game.nProtonPacks;
    }

    public static void setProtonsLeft(int nProtons)
    {
        Game.nProtonPacks = nProtons;
    }
    public static int getLives()
    {
        return  Game.nLives;
    }

    public static void setInitial(boolean initial)
    {
        Game.bInitial = initial;
    }

    public static void setRespawnAfterDeath(boolean bRespawn)
    {
        Game.bRespawnAfterDeath = bRespawn;
    }
    public static void setLives(int nLives)
    {
        Game.nLives = nLives;
    }

    public static void setFruitBool(boolean bFruit)
    {
        Game.bFruit = bFruit;
    }

    public static Clip getSiren()
    {
        return Game.clpSiren;
    }

    public static void setStarted(boolean bStarted)
    {
        Game.bStarted = bStarted;
    }

    // Varargs for stopping looping-music-clips
	private static void stopLoopingSounds(Clip... clpClips) {
		for (Clip clp : clpClips) {
			clp.stop();
		}
	}

	// ===============================================
	// KEYLISTENER METHODS
	// ===============================================

	@Override
	public void keyPressed(KeyEvent e) {
		Pacman pacman = CommandCenter.getPacman();
		int nKey = e.getKeyCode();
		// System.out.println(nKey);

		if (nKey == START && !CommandCenter.isPlaying())
        {
            startGame();
            nTick = 0;
        }

		if (pacman != null) {

			switch (nKey) {
			case PAUSE:
				CommandCenter.setPaused(!CommandCenter.isPaused());
				if (CommandCenter.isPaused())
                {
                    stopLoopingSounds(clpSiren, Pacman.getWaka());
                }
				break;
			case QUIT:
				System.exit(0);
				break;
			case UP:
				pacman.turnUp();
				break;
			case LEFT:
				pacman.turnLeft();
				break;
			case RIGHT:
				pacman.turnRight();
				break;
            case DOWN:
                pacman.turnDown();
                break;
            case OUIJA:
                CommandCenter.ouija(nTick);
                break;
            case PROTON:
                if (!CommandCenter.getProton() && nProtonPacks > 0)
                {
                    nProtonPacks -= 1;
                    CommandCenter.protonPack();
                }
                break;

			default:
				break;
			}
		}
	}

    public void keyReleased(KeyEvent e) {}


	@Override
	// Just need it b/c of KeyListener implementation
	public void keyTyped(KeyEvent e)
    {

	}

}

// ===============================================
// ==A tuple takes a reference to an ArrayList and a reference to a Movable
//This class is used in the collision detection method, to avoid mutating the array list while we are iterating
// it has two public methods that either remove or add the movable from the appropriate ArrayList 
// ===============================================

class Tuple{
	//this can be any one of several CopyOnWriteArrayList<Movable>
	private CopyOnWriteArrayList<Movable> movMovs;
	//this is the target movable object to remove
	private Movable movTarget;
	
	public Tuple(CopyOnWriteArrayList<Movable> movMovs, Movable movTarget) {
		this.movMovs = movMovs;
		this.movTarget = movTarget;
	}
	
	public void removeMovable(){
		movMovs.remove(movTarget);
	}
	
	public void addMovable(){
		movMovs.add(movTarget);
	}

}
 // this is a different class down here, chief!