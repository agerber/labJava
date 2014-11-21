package lec09.glab.danshiff.controller;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.sound.sampled.Clip;

import lec09.glab.danshiff.game.model.*;
import lec09.glab.danshiff.game.view.*;
import lec09.glab.danshiff.sounds.Sound;

// ===============================================
// == This Game class is the CONTROLLER
// ===============================================

public class Game implements Runnable, KeyListener {

	// ===============================================
	// FIELDS
	// ===============================================

    public static final int ROW = 35, COL = 30, STANDARD_RADIUS = 10;   //Sets how big the game is.
	public static final Dimension DIM = new Dimension(COL * 2 * STANDARD_RADIUS, ROW * 2 * STANDARD_RADIUS);
    public static final int BOTTOM = 670;
	private GamePanel gmpPanel;
	public static Random R = new Random();
	public final static int ANI_DELAY = 45; // milliseconds between screen
											// updates (animation)
	private Thread thrAnim;
	private int nLevel = 1;
	private int nTick = 0;
	private ArrayList<Tuple> tupMarkForRemovals;
	private ArrayList<Tuple> tupMarkForAdds;
	private boolean bMuted = true;
	

	private final int PAUSE = 80, // p key
			QUIT = 81, // q key
			LEFTKEY = 37, // rotate left; left arrow
			RIGHTKEY = 39, // rotate right; right arrow
			UPKEY = 38, // thrust; up arrow
            DOWNKEY = 40,
			START = 83, // s key
			FIRE = 32, // space key
			MUTE = 77; // m-key mute

	// for possible future use
	// HYPER = 68, 					// d key
	// SHIELD = 65, 				// a key arrow
	// NUM_ENTER = 10, 				// hyp
	// SPECIAL = 70; 					// fire special weapon;  F key

	private Clip clpThrust;
	private Clip clpMusicBackground;

	private static final int SPAWN_NEW_SHIP_FLOATER = 1200;



	// ===============================================
	// ==CONSTRUCTOR
	// ===============================================

	public Game() {

		gmpPanel = new GamePanel(DIM);
		gmpPanel.addKeyListener(this);

		clpThrust = Sound.clipForLoopFactory("whitenoise.wav");
		clpMusicBackground = Sound.clipForLoopFactory("flight_of_the_bumblebee_2.wav");
	

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
	@Override
    public void run() {

		// lower this thread's priority; let the "main" aka 'Event Dispatch'
		// thread do what it needs to do first
		thrAnim.setPriority(Thread.MIN_PRIORITY);

		// and get the current time
		long lStartTime = System.currentTimeMillis();

		// this thread animates the scene
		while (Thread.currentThread() == thrAnim) {
			tick();
			//spawnNewShipFloater();
			gmpPanel.update(gmpPanel.getGraphics()); // update takes the graphics context we must 
														// surround the sleep() in a try/catch block
														// this simply controls delay time between 
														// the frames of the animation

			//this might be a good place to check for collisions
			checkCollisions();
			//this might be a god place to check if the level is clear (no more foes)
			//if the level is clear then spawn some big asteroids -- the number of asteroids 
			//should increase with the level.
			checkNewLevel();


            if(!CommandCenter.isPaused() && CommandCenter.isPlaying()){
                //Maybe add some bugs or floaters if the game is in progress. Also, lower the chill.
                //Don't do these things when paused.
                lowerChill();
                spawnRandomFly(CommandCenter.getLevel());
                spawnRandomSpider();
                spawnRandomScorp(CommandCenter.getLevel() - 3); //No scorp's before level 4.
                spawnRandomFloater(CommandCenter.getLevel());

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

    /**
     * Decreases the chill count by one. While the game is chilled, bugs move slowly.
     */
    private void lowerChill(){
        if(CommandCenter.getChilled() > 0){
            CommandCenter.setChilled(CommandCenter.getChilled() - 1);
        }
    }

    /**
     * This now has to check collisions between friends and fungus, foes and fungus, friends and foes, friends and
     * floaters, foes and foes, and clear out anything that's off screen.
     */
	private void checkCollisions() {

		
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

        //These are long methods based on the initial code. They add things to the appropriate arraylists.
        friendFoeCollision();
        friendFloatCollision();
        friendFunguCollision();
        foeFunguCollision();

        //Get rid of off-screen foes,
        for(Movable movFoe : CommandCenter.movFoes){
            if(((Sprite)movFoe).isOffScreen()){
                tupMarkForRemovals.add(new Tuple(CommandCenter.movFoes, movFoe));
            }
        }

        //This keeps ant pieces from piling up on each other.
        for(Movable movFoe : CommandCenter.movFoes){
            for(Movable movFoe2 : CommandCenter.movFoes){
                if(movFoe != movFoe2 && movFoe instanceof Ant && movFoe2 instanceof Ant){
                    if(movFoe.getCenter().x - movFoe2.getCenter().x >=0 &&
                            movFoe.getCenter().x - movFoe2.getCenter().x <= (2 * STANDARD_RADIUS) &&
                            movFoe.getCenter().y == movFoe2.getCenter().y){
                        ((Ant) movFoe).setCenter(
                                new Point(movFoe2.getCenter().x + (2 * STANDARD_RADIUS), movFoe.getCenter().y));
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

    //Many of the below methods are specific collision detectors
    private void friendFoeCollision(){
        for (Movable movFriend : CommandCenter.movFriends) {
            for (Movable movFoe : CommandCenter.movFoes) {

                Point pntFriendCenter, pntFoeCenter;
                int nFriendRadiux, nFoeRadiux;
                pntFriendCenter = movFriend.getCenter();
                pntFoeCenter = movFoe.getCenter();
                nFriendRadiux = movFriend.getRadius();
                nFoeRadiux = movFoe.getRadius();

                //detect collision
                if (pntFriendCenter.distance(pntFoeCenter) < (nFriendRadiux + nFoeRadiux)) {

                    //falcon
                    //Kill falcon, restart ant swarm, other bugs die, as do floaters
                    if ((movFriend instanceof BugHunter) ){

                        tupMarkForRemovals.add(new Tuple(CommandCenter.movFriends, movFriend));
                        CommandCenter.spawnHunter(false);
                        CommandCenter.movFoes.clear();
                        CommandCenter.movFloaters.clear();
                        spawnAntArmy();

                    }
                    //not the falcon--remove it, kill the foe
                    else {
                        CommandCenter.movFriends.remove(movFriend);
                        killFoe((Foe)movFoe);

                        break;
                    }//end else

                    //explode/remove foe



                }//end if
            }//end inner for
        }//end outer for
    }

    private void friendFloatCollision(){
        for (Movable movFriend : CommandCenter.movFriends) {
            for (Movable movFloat : CommandCenter.movFloaters) {
                Point pntFriendCenter, pntFloatCenter;
                int nFriendRadiux, nFloatRadiux;

                pntFriendCenter = movFriend.getCenter();
                pntFloatCenter = movFloat.getCenter();
                nFriendRadiux = movFriend.getRadius();
                nFloatRadiux = movFloat.getRadius();

                //detect collision
                if (pntFriendCenter.distance(pntFloatCenter) < (nFriendRadiux + nFloatRadiux)) {

                    //falcon--only thing that matters for colliding w/ floater.
                    if ((movFriend instanceof BugHunter) ){
                        tupMarkForRemovals.add(new Tuple(CommandCenter.movFloaters, movFloat));
                        ((Floater)movFloat).performEffect(this);
                    }

                }//end if
            }//end inner for
        }
    }

    private void friendFunguCollision(){
        for (Movable movFriend : CommandCenter.movFriends) {
            for (Movable movFungu : CommandCenter.movFungus) {
                Point pntFriendCenter, pntFunguCenter;
                int nFriendRadiux, nFunguRadiux;
                pntFriendCenter = movFriend.getCenter();
                pntFunguCenter = movFungu.getCenter();
                nFriendRadiux = movFriend.getRadius();
                nFunguRadiux = movFungu.getRadius();

                //detect collision
                if (pntFriendCenter.distance(pntFunguCenter) < (nFriendRadiux + nFunguRadiux)) {


                    //bullet--destroy shroom, make a weaker shroom in its place
                    if (movFriend instanceof Bullet){

                    tupMarkForRemovals.add(new Tuple(CommandCenter.movFriends, movFriend));

                        Mushroom mus = (Mushroom)movFungu;
                        tupMarkForRemovals.add(new Tuple(CommandCenter.movFungus, mus));
                        if(mus.getHits() < 3){
                            tupMarkForAdds.add(new Tuple(CommandCenter.movFungus, new Mushroom(mus)));
                        }

                        break; //Just breaks the inner loop since this bullet shouldn't hit anything else.


                    }

                    //Hunter--don't let it move through the shroom
                    else if (movFriend instanceof BugHunter){
                        BugHunter bhn = (BugHunter)movFriend;
                        if(bhn.getDeltaX() < 0 && pntFunguCenter.x < pntFriendCenter.x){
                            bhn.setCenter(new Point(pntFunguCenter.x + 2 + (2 * STANDARD_RADIUS), pntFriendCenter.y));
                        }
                        if(bhn.getDeltaX() > 0 && pntFunguCenter.x > pntFriendCenter.x){
                            bhn.setCenter(new Point(pntFunguCenter.x - 2 - (2 * STANDARD_RADIUS), pntFriendCenter.y));
                        }
                        if(bhn.getDeltaY() < 0 && pntFunguCenter.y < pntFriendCenter.y){
                            bhn.setCenter(new Point(pntFriendCenter.x, pntFunguCenter.y + 2 + (2 * STANDARD_RADIUS)));
                        }
                        if(bhn.getDeltaY() > 0 && pntFunguCenter.y > pntFriendCenter.y){
                            bhn.setCenter(new Point(pntFriendCenter.x , pntFunguCenter.y - 2 - (2 * STANDARD_RADIUS)));
                        }

                    }


                }//end if
            }//end inner for
        }//end outer for
    }

    private void foeFunguCollision(){
        for (Movable movFoe : CommandCenter.movFoes) {
            for (Movable movFungu : CommandCenter.movFungus) {
                Point pntFoeCenter, pntFunguCenter;
                int nFoeRadiux, nFunguRadiux;
                pntFoeCenter = movFoe.getCenter();
                pntFunguCenter = movFungu.getCenter();
                nFoeRadiux = movFoe.getRadius();
                nFunguRadiux = movFungu.getRadius();

                //detect collision
                if (pntFoeCenter.distance(pntFunguCenter) < (nFoeRadiux + nFunguRadiux)) {
                    Foe foe = (Foe)movFoe;
                    foe.interactWithMushroom((Mushroom)movFungu);


                }//end if
            }//end inner for
        }//end outer for

    }

	private void killFoe(Foe foe) {
        //Only remove foe if the kill returns true. Add the foe's value to the score
        if(foe.kill()){
            tupMarkForRemovals.add(new Tuple(CommandCenter.movFoes, foe));
            CommandCenter.setScore(CommandCenter.getScore() + (foe).getValue());
        }
		
	}

    /**
     * Remove 1/3 of the mushrooms (on average)
     */
    public void mushpocolypse(){
        final int nRemoved = 3;
        for(Movable movFungu : CommandCenter.movFungus){
            if(R.nextInt(nRemoved) == 0){
                tupMarkForRemovals.add(new Tuple(CommandCenter.movFungus, movFungu));
            }
        }
    }

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

	/*
    private void spawnNewShipFloater() {
		//make the appearance of power-up dependent upon ticks and levels
		//the higher the level the more frequent the appearance
		if (nTick % (SPAWN_NEW_SHIP_FLOATER - nLevel * 7) == 0) {
			CommandCenter.movFungus.add(new NewShipFloater());
		}
	}
	*/

	// Called when user presses 's'
	private void startGame() {
		CommandCenter.clearAll();
		CommandCenter.initGame();
		CommandCenter.setLevel(0);
		CommandCenter.setPlaying(true);
		CommandCenter.setPaused(false);
		//if (!bMuted)
		   // clpMusicBackground.loop(Clip.LOOP_CONTINUOUSLY);
	}

    /**
     * Make a spider. Happens level-many times per 500 frames (on average)
     */
    private void spawnRandomSpider(){
        final int nMiddle = 550, nRange = 100;  //Where the spider starts (y-wise)
        final int nSpiRate = 500;
        boolean side = R.nextBoolean();
        int location = nMiddle+R.nextInt(nRange);
        if(R.nextInt(nSpiRate) < CommandCenter.getLevel()){
            CommandCenter.movFoes.add(new Spider(side, location));
        }
    }


	private void spawnAntArmy() {
        final int nAntNum = 10; //Start w/ 10 that must be killed.
        int nHead = R.nextInt((int)DIM.getWidth() - (nAntNum * STANDARD_RADIUS)) + (nAntNum * STANDARD_RADIUS);
        for(int i=0; i<nAntNum; i++){
        Ant cent = new Ant();
        cent.setOrientation(Sprite.RIGHT);  //Starts facing right. Each ant goes just behind the last
        cent.setCenter(new Point( nHead - (STANDARD_RADIUS * 2 * i), (3 * STANDARD_RADIUS)));

            for(Movable movMush : CommandCenter.movFungus){
                if (Math.abs(cent.getCenter().getX() - movMush.getCenter().getX()) <= (2 * STANDARD_RADIUS)
                        && cent.getCenter().getY() == movMush.getCenter().getY()){
                    CommandCenter.removeMushroom((Mushroom)movMush);
                }
            }
        CommandCenter.movFoes.add(cent);

        }




    }

    /**
     * Makes a scorpion in a random row. High param makes chance higher
     * @param nRate
     */
    private void spawnRandomScorp(int nRate){
        final int nLowBuffer = 5, nHighBuffer = 2;  //How many rows from the bottom and top the scorpion must be.
        final int nScoChance = 2000;    //The higher this is, the less often scorpions happen
        if(R.nextInt(nScoChance) < nRate){
            int nRow = R.nextInt(ROW- (nLowBuffer + nHighBuffer)) - nHighBuffer;
            CommandCenter.movFoes.add(new Scorpion(R.nextBoolean(), nRow));
        }
    }

    /**
     * Makes a fly. High param makes chance higher. X-position of fly is random.
     * @param nRate
     */
    private void spawnRandomFly(int nRate){
        final int nFlChance = 500;
        if(R.nextInt(nFlChance) <= 1 + nRate){
            CommandCenter.movFoes.add(new Fly());
        }
    }

    /**
     * Makes a floater. High param makes chance higher. All floater types are equally likely.
     * @param nRate
     */
    private void spawnRandomFloater(int nRate){
        final int nFloChance = 2000;
        final int nTopRow = 530;    //Highest place it can start.
        if(R.nextInt(nFloChance) < nRate){
            int nRow = R.nextInt(BOTTOM - nTopRow)+nTopRow;
            int nCol = R.nextInt((int)DIM.getWidth() - (2 * STANDARD_RADIUS)) + STANDARD_RADIUS;
            Sprite floater;
            switch(R.nextInt(4)){
                case 0:
                    floater = new TripleShot(nCol, nRow);
                    break;
                case 1:
                    floater = new Fungicide(nCol, nRow);
                    break;
                case 2:
                    floater = new ChillPill(nCol, nRow);
                    break;
                case 3:
                    floater = new LaserFloat(nCol, nRow);
                    break;
                default:
                    floater = null;
                    break;
            }
            CommandCenter.movFloaters.add(floater);
        }
    }

    /**
     * Make the initial shrooms on the game board. Some may be poisonous.
     */
    private void spawnMushrooms(){
        final double dMushPerRow = 2.5;
        final int nPoisonRate = 30;
        final int nRoundNum = 100;
        int nChance = ((int)(dMushPerRow * nRoundNum)/COL);
        for(int iR = 1; iR<ROW-7; iR++){
            for(int iC = 0; iC<COL; iC++){
                if(R.nextInt(nRoundNum) <= nChance){
                    CommandCenter.addMushroom(
                            new Mushroom(iC * (2 * STANDARD_RADIUS) + STANDARD_RADIUS,
                                    iR * (2 * STANDARD_RADIUS) + STANDARD_RADIUS));;
                }
            }
        }

        for(Movable movMush :CommandCenter.movFungus){
            if(R.nextInt(nPoisonRate) == 0){
                ((Mushroom)movMush).setPoisonous(true);
            }
        }
    }

    /**
     * Clear level means no ants.
     * @return
     */
	private boolean isLevelClear(){
	    boolean bCentipedeFree = true;
        for(Movable movFoe : CommandCenter.movFoes){
            if (movFoe instanceof Ant){
                bCentipedeFree = false;
                break;
            }
        }
        return bCentipedeFree;

		
	}

    /**
     * Start of the game, level requires making shroom. Otherwise, new level requires making new ants (rest of the bugs
     * stay on the board).
     */
	private void checkNewLevel(){
		if(CommandCenter.getLevel() == 0){
            spawnMushrooms();
        }

		if (isLevelClear()){
            CommandCenter.setLevel(CommandCenter.getLevel() + 1);
            Ant.setSpeed(Ant.LOWEST_SPEED + (CommandCenter.getLevel() * .5));
            spawnAntArmy();
		}
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
		BugHunter fal = CommandCenter.getHunter();
		int nKey = e.getKeyCode();
		// System.out.println(nKey);

		if (nKey == START && !CommandCenter.isPlaying())
			startGame();

		if (fal != null) {

			switch (nKey) {
			case PAUSE:
				CommandCenter.setPaused(!CommandCenter.isPaused());
				if (CommandCenter.isPaused())
					stopLoopingSounds(clpMusicBackground, clpThrust);
				else
					clpMusicBackground.loop(Clip.LOOP_CONTINUOUSLY);
				break;
			case QUIT:
				System.exit(0);
				break;

            //Direction keys no longer cause thrust or turns. Instead they cause the hunter to have non-zero speed.
			case UPKEY:
				fal.move(Sprite.UP);
				break;
			case LEFTKEY:
				fal.move(Sprite.LEFT);
				break;
			case RIGHTKEY:
				fal.move(Sprite.RIGHT);
				break;
            case DOWNKEY:
                fal.move(Sprite.DOWN);
                break;

			// possible future use
			// case KILL:
			// case SHIELD:
			// case NUM_ENTER:

			default:
				break;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		BugHunter fal = CommandCenter.getHunter();
		int nKey = e.getKeyCode();
		 System.out.println(nKey);

		if (fal != null) {
			switch (nKey) {
			case FIRE:
                //Triple shot gives a bullet going to the left and right. Decrease TS count.
                if(CommandCenter.getHunter().getTripleShot() > 0){
                    Bullet bulLeft = new Bullet(fal);
                    bulLeft.setDeltaX(bulLeft.getDeltaX() - 4);
                    Bullet bulRight = new Bullet(fal);
                    bulRight.setDeltaX(bulRight.getDeltaX() + 4);
                    CommandCenter.movFriends.add(bulLeft);
                    CommandCenter.movFriends.add(bulRight);
                    CommandCenter.getHunter().setTripleShot(CommandCenter.getHunter().getTripleShot() - 1);
                }
                //Laser makes a column of bullets above the hunter
                else if(CommandCenter.getHunter().isLaser()){
                    for(int iRow = 0; iRow < CommandCenter.getHunter().getCenter().y - Game.STANDARD_RADIUS; iRow++){
                        LaserBullet laserBul = new LaserBullet(CommandCenter.getHunter());
                        laserBul.setCenter(new Point(laserBul.getCenter().x, iRow));
                        CommandCenter.movFriends.add(laserBul);

                    }
                    CommandCenter.getHunter().setLaser(false);
                    Sound.playSound("big_laser.wav");
                    return;
                }
				CommandCenter.movFriends.add(new Bullet(fal));
				Sound.playSound("laser.wav");
				break;
				
			//special is a special weapon, current it just fires the cruise missile. 
			//case SPECIAL:
			//	CommandCenter.movFriends.add(new Cruise(fal));
				//Sound.playSound("laser.wav");
			//	break;

            //Release a direction key stops the hunter in that direction immediately.
			case LEFTKEY:
				fal.stopMove(Sprite.LEFT);
				break;
			case RIGHTKEY:
				fal.stopMove(Sprite.RIGHT);
				break;
			case UPKEY:
				fal.stopMove(Sprite.UP);
				break;
            case DOWNKEY:
                fal.stopMove(Sprite.DOWN);
                break;

				
			case MUTE:
				if (!bMuted){
					stopLoopingSounds(clpMusicBackground);
					bMuted = !bMuted;
				} 
				else {
					clpMusicBackground.loop(Clip.LOOP_CONTINUOUSLY);
					bMuted = !bMuted;
				}
				break;
				
				
			default:
				break;
			}
		}
	}

	@Override
	// Just need it b/c of KeyListener implementation
	public void keyTyped(KeyEvent e) {
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
        if(movMovs == CommandCenter.movFungus && movTarget instanceof Mushroom){
            CommandCenter.removeMushroom((Mushroom)movTarget);
            return;
        }
		movMovs.remove(movTarget);
	}
	
	public void addMovable(){
        if(movMovs == CommandCenter.movFungus && movTarget instanceof Mushroom){
            CommandCenter.addMushroom((Mushroom)movTarget);
            return;
        }
        movMovs.add(movTarget);
	}

}
