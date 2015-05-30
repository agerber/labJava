package lec08.timpone.finalproject.controller;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import lec08.timpone.finalproject.game.model.*;
import lec08.timpone.finalproject.game.view.*;
import lec08.timpone.finalproject.sounds.Sound;

// ===================================================
// == This Game class is the CONTROLLER
// ===================================================


/**
 *  ___  ________ _____ _____ _____ _      _____    _____ ________  ______  ___  ___   _   _______ 
 *  |  \/  |_   _/  ___/  ___|_   _| |    |  ___|  /  __ \  _  |  \/  ||  \/  | / _ \ | \ | |  _  \
 *  | .  . | | | \ `--.\ `--.  | | | |    | |__    | /  \/ | | | .  . || .  . |/ /_\ \|  \| | | | |
 *  | |\/| | | |  `--. \`--. \ | | | |    |  __|   | |   | | | | |\/| || |\/| ||  _  || . ` | | | |
 *  | |  | |_| |_/\__/ /\__/ /_| |_| |____| |___   | \__/\ \_/ / |  | || |  | || | | || |\  | |/ / 
 *  \_|  |_/\___/\____/\____/ \___/\_____/\____/    \____/\___/\_|  |_/\_|  |_/\_| |_/\_| \_/___/  
 * 
 *  @author Rob Timpone
 *  @version 1.00
 *
 *
 *  =============
 *  Instructions:
 *  ============= 
 *  
 *  Missile Command is a game where a player tries to survive as long as possible against an increasingly difficult attack of enemy 
 *  missiles and bomber planes.  The player clicks the mouse to fire counter missiles from their Falcon Missile Silo, which has
 *  unlimited ammo.  A player can destroy an enemy or pick up a powerup by firing a missile at it.  As the player kills enemy 
 *  missiles, planes, and bombs, the level will eventually increase and missiles will appear more frequently.  Players earn points
 *  for destroying enemies and for advancing levels.  
 *  
 *  When the player shoots a powerup, they will temporarily gain a special ability or trigger a special weapon to be fired.  The
 *  Turrets (T), Spread Gun (S), and Flame Gun (F) all have limited ammo.  The Super Nuke (N) powerup automatically fires a super
 *  nuke from the Falcon Missile Silo when it is picked up. 
 *  
 *  If a missile hits one of the player's four cities, it will be destroyed and will not respawn.  If a missile hits the player's
 *  Falcon Missile Silo,  it will be destroyed and will use one of the player's lives.  If the player has extra lives left, the 
 *  Falcon will respawn and will be invincible for a few seconds (the silo is invincible when it is colored blue.)  The player can 
 *  see how many lives are remaining in the bottom right corner of the screen.  The game continues until all 4 of the player's 
 *  cities have been destroyed and the player is out of lives.  
 *  
 *  
 *  =======
 *  Points:
 *  =======
 *  
 *  Destroy an enemy missile:  100 points
 *  Destroy an enemy bomb:  100 points
 *  Destroy an enemy bomber plane:  400 points
 *  Make it to the next level:  (level number) * 1000 points
 *  
 *  
 *  ==================
 *  Powerup abilities:
 *  ==================
 *  
 *  Turrets - 'T' powerup
 *  Your cities will begin randomly firing a limited number of turret missiles at enemies
 *  
 *  Spread Gun - 'S' powerup
 *  Your counter missiles will fire with a spread effect for a limited number of shots
 *  
 *  Flame Gun - 'F' powerup
 *  You will continually fire missiles as you move the mouse for a limited number of shots
 *  
 *  Super Nuke - 'N' pouwerup
 *  Launches a super nuke from the missile silo that explodes in the middle of the screen, killing almost all enemies on the screen
 *  
 *  
 */

public class Game implements Runnable, KeyListener, MouseListener, MouseMotionListener {

	// ===============================================
	// FIELDS
	// ===============================================

	public static final Dimension DIM = new Dimension(990, 810); 	// the dimensions of the game window
	private GamePanel gmpPanel;										// the GamePanel that the game is played in
	
	private Thread thrAnim;											// animation thread
	private static int nTick = 0;									// tick used for timing events
	public final static int ANI_DELAY = 45; 						// milliseconds between screen updates (animation)
	
	public static Random R = new Random();

	private ArrayList<Tuple> tupMarkForRemovals;
	private ArrayList<Tuple> tupMarkForAdds;
	
	
	// Adjustable game setting
	
	private static final long MISSILE_KILL_POINTS = 100;			// points awarded for shooting down an enemy missile
	private static final long PLANE_KILL_BONUS_POINTS = 400;		// points awarded for shooting down an enemy bomber plane

	public final static int INITIAL_MISSILE_FREQ = 11;				// how often enemy missiles appear - lower number = higher freq
	public final static int KILLS_TO_LEVEL_UP = 50;					// number of kills necessary to advance to the next level
	
	public final static int GROUND_LEVEL = 100;						// height of the ground in pixels
	public final static int NUM_TREES = 25;							// number of trees spawned
	public final static int NUM_STARS = 200;						// number of stars spawned in the background
	
	
	// Keyboard constants
	
	private final int PAUSE = 80, 			// p key - pause the game
					  QUIT = 81, 			// q key - quit
					  START = 83, 			// s key - start the game
					  
					  // keys for debugging purposes (not intended to be used by the player):
					  
					  TURRET = 84, 			// t key - spawn the 'T' powerup
					  SPREAD = 82, 			// r key - spawn the 'S' powerup
					  FLAME = 70, 			// f key - spawn the 'F' powerup
					  SUPERNUKE = 78,		// n key - spawn the 'N' powerup
					  BOMBER = 66, 			// b key - spawn an enemy bomber plane
					  KILLALL = 67;			// c key - clear all enemies from the screen
	

	// ===============================================
	// ==CONSTRUCTOR
	// ===============================================

	// Sets up the game panel and tells the CommandCenter that this is the first game being played
	public Game() {
		gmpPanel = new GamePanel(DIM);
		gmpPanel.addKeyListener(this);
		gmpPanel.addMouseListener(this);
		gmpPanel.addMouseMotionListener(this);
		CommandCenter.setFirstGame(true);
		CommandCenter.setPaused(true);			// prevents missiles and powerups from being spawned before game starts
	}

	
	// ===============================================
	// ==METHODS
	// ===============================================

	// Instantiates a Game object and starts the animation
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() { 		// uses the Event dispatch thread from Java 5 (refactored)
					public void run() {
						try {
							Game game = new Game(); 	// construct itself
							game.fireUpAnimThread();

						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
	}

	// Starts the thread
	private void fireUpAnimThread() { 			// called initially
		if (thrAnim == null) {
			thrAnim = new Thread(this); 		// pass the thread a runnable object (this)
			thrAnim.start();
		}
	}

	// This method is constantly being called while the thread is active.  The game will always be checking to see if objects are
	// colliding, if the level needs to be increased, if turrets need to fire from cities, and if objects need to be spawned.  
	public void run() {
		
		thrAnim.setPriority(Thread.MIN_PRIORITY);		// lower this thread's priority
		long lStartTime = System.currentTimeMillis();	// gets the current time
		while (Thread.currentThread() == thrAnim) {		// this thread animates the scene
			tick();
			gmpPanel.update(gmpPanel.getGraphics()); 	// update takes the graphics context we must surround the sleep() in a 
														// try/catch block this simply controls delay time between the frames of 
														// the animation
			
			checkCollisions();			// checks for collisions between objects
			checkLevel();				// checks to see if the level needs to advance
			fireTurretsIfEnabled();		// fires missiles from the player's cities if the turret powerup is active	
			spawnObjects();				// spawns missiles and powerups if appropriate

			try {
				// The total amount of time is guaranteed to be at least ANI_DELAY long.  If processing (update) 
				// between frames takes longer than ANI_DELAY, then the difference between lStartTime - 
				// System.currentTimeMillis() will be negative, then zero will be the sleep time
				lStartTime += ANI_DELAY;
				Thread.sleep(Math.max(0,lStartTime - System.currentTimeMillis()));
			} catch (InterruptedException e) {
				continue;							// just skip this frame -- no big deal
			}
		}
	}
	

	// Checks for various collisions between objects
	private void checkCollisions() {
		
		tupMarkForRemovals = new ArrayList<Tuple>();
		tupMarkForAdds = new ArrayList<Tuple>();

		Point pntFriendCenter, pntFoeCenter, pntFloaterCenter;
		int nFriendRadiux, nFoeRadiux, nFloaterRadiux;

		for (Movable movFriend : CommandCenter.movFriends) {				// Checks each pair of friend and floater Movable objects
			for (Movable movFloater : CommandCenter.movFloaters) {
				
				pntFriendCenter = movFriend.getCenter();					// gets the center point and radius of each object
				pntFloaterCenter = movFloater.getCenter();
				nFriendRadiux = movFriend.getRadius();
				nFloaterRadiux = movFloater.getRadius();
				
				// Checks to see if a friend object is touching a floater object (in this case, the only floaters are Powerups)
				if (pntFriendCenter.distance(pntFloaterCenter) < (nFriendRadiux + nFloaterRadiux)) {	
					tupMarkForRemovals.add(new Tuple(CommandCenter.movFloaters, movFloater));			// removes the floater 
					Powerup pow = (Powerup) movFloater;	
					activatePowerup(pow);																// activates the powerup
					Sound.playSound("LTTP_Sword_Magic.wav");
				}
			}
		}
		
		for (Movable movFriend : CommandCenter.movFriends) {				// Checks each pair of friend and floater Movable objects
			for (Movable movFoe : CommandCenter.movFoes) {

				pntFriendCenter = movFriend.getCenter();					// gets the center points and radius of each object
				pntFoeCenter = movFoe.getCenter();
				nFriendRadiux = movFriend.getRadius();
				nFoeRadiux = movFoe.getRadius();

				// Removes a turret missile if it hits the top, left, or right sides of the screen
				if (movFriend instanceof TurretMissile && movFriend.getCenter().getY() < 10 ||
					movFriend instanceof TurretMissile && movFriend.getCenter().getX() < 10 ||
					movFriend instanceof TurretMissile && movFriend.getCenter().getX() > DIM.getWidth()-10){
						tupMarkForRemovals.add(new Tuple(CommandCenter.movFriends, movFriend));
				}
				
				// Kills a Missile if it hits the ground
				if (movFoe instanceof Missile && movFoe.getCenter().getY() > DIM.getHeight()-GROUND_LEVEL-movFoe.getRadius()){
					killFoe(movFoe);
				}
				
				// Kills and detonates a bomd if it hits the ground
				if (movFoe instanceof Bomb && movFoe.getCenter().getY() > DIM.getHeight()-GROUND_LEVEL-movFoe.getRadius()){
					Bomb bomb = (Bomb)movFoe;
					
					// Bombs temporarily have a large radius to give them an explosion that kills anything in the blast radius
					bomb.setRadius(GiantExplosion.MAX_EXPLOSION_RADIUS/2);
					if(movFriend instanceof Falcon && pntFriendCenter.distance(bomb.getCenter()) 
						    < (nFriendRadiux+GiantExplosion.MAX_EXPLOSION_RADIUS)){
						
						if (!CommandCenter.getFalcon().getProtected()){				// kills the falcon if it is not protected
							tupMarkForRemovals.add(new Tuple(CommandCenter.movFriends, movFriend));
							CommandCenter.spawnFalcon(false);
							killFoe(movFoe);
							Sound.playSound("baseunderattack.wav");
						}
					}
					killFoe(movFoe);	// kills the bomb after the collision
				}
				
				// detects collisions between friend and foe objects
				if (pntFriendCenter.distance(pntFoeCenter) < (nFriendRadiux + nFoeRadiux)) {	
					
					if ((movFriend instanceof Falcon) ){		
						if (!CommandCenter.getFalcon().getProtected()){				// kills the falcon if it is not protected
							tupMarkForRemovals.add(new Tuple(CommandCenter.movFriends, movFriend));
							CommandCenter.spawnFalcon(false);
							killFoe(movFoe);
							Sound.playSound("baseunderattack.wav");
						}
					}
					
					else if(movFriend instanceof TurretMissile ){
						
						// removes turret missile upon collision with a foe object
						CommandCenter.getMovDebris().add((Movable) new SmallExplosion(movFriend.getCenter()));	// adds turret missile explosion
						tupMarkForRemovals.add(new Tuple(CommandCenter.movFriends, movFriend));
						killFoe(movFoe);																// kills enemy missile
						awardPoints(movFoe);
					}
					
					else {	
						
						// If the friend object is a counter missile or a supernuke, the friend object does not get removed 
						if(movFriend instanceof CounterMissile || movFriend instanceof SuperNukeExplosion){
							awardPoints(movFoe);
							CommandCenter.setKillCount(CommandCenter.getKillCount()+1);
							killFoe(movFoe);
						}
						
						else{
							tupMarkForRemovals.add(new Tuple(CommandCenter.movFriends, movFriend));
							if(movFriend instanceof City){
								Sound.playSound("LA_Bomb_Explode.wav");
							}
							killFoe(movFoe);	
						}
					}
				} 
			}
		}
		
		//remove these objects from their appropriate ArrayLists; this happens after the above iterations are done
		for (Tuple tup : tupMarkForRemovals) {
			tup.removeMovable();
		}
		
		//put these objects to their appropriate ArrayLists; this happens after the above iterations are done
		for (Tuple tup : tupMarkForAdds) 
			tup.addMovable();

		System.gc();	// call garbage collection
	}

	// Updates the player's score when a missile or bomber plane are killed
	public void awardPoints(Movable movFoe) {
		CommandCenter.setScore(CommandCenter.getScore()+MISSILE_KILL_POINTS);				// awards points for missile kill
		if(movFoe instanceof BomberPlane){
			CommandCenter.setScore(CommandCenter.getScore()+PLANE_KILL_BONUS_POINTS);		// awards bonus points for bomber kill
		}
	}
	
	// Checks to see if the player has enough kills to advance the level.  If the level advances, points are awarded and a bomber
	// is spawned
	private void checkLevel(){
		if(CommandCenter.getKillCount()>CommandCenter.getLevel()*KILLS_TO_LEVEL_UP){
			CommandCenter.setLevel(CommandCenter.getLevel()+1);
			CommandCenter.setScore(CommandCenter.getScore()+(CommandCenter.getLevel()*1000));
			spawnPlane();
		}
	}
	
	// If the player has the 'turrets' powerup enabled, this method randomly target (missile, bomber, or bomb) and creates a turret
	// missile.  The turret missile constructor determines where the missile is fired from.   
	public void fireTurretsIfEnabled(){
		if(CommandCenter.isTurretsOn()){
			if(nTick % Powerup.TURRET_FIRE_FREQUENCY == 0 && !CommandCenter.isPaused()){			// firing frequency depends on the a constant
				int nFoeTarget;
				Point nFoeTargetPoint;
				try {
					nFoeTarget = R.nextInt(CommandCenter.getMovFoes().size());					       // randomly selects a target
					nFoeTargetPoint = CommandCenter.getMovFoes().get(nFoeTarget).getCenter();
				} catch (Exception e) {
					nFoeTargetPoint = new Point((int) DIM.getWidth()/2, 100);	  // if it can't find a target, shoots at the middle
				}
				CommandCenter.getMovFriends().add(new TurretMissile(nFoeTargetPoint));
				CommandCenter.incrementTurretShots();
			}
			if(CommandCenter.getTurretShots() > Powerup.TURRET_AMMO){
				CommandCenter.setTurretsOn(false);					  // turns off the turrets powerup if the player is out of ammo
				CommandCenter.setTurretShots(0);
			}
		}
	}
	
	// Spawns new enemy missiles and powerups depending on frequencies determined in the constants
	public void spawnObjects() {
		int nFreq = Math.max(INITIAL_MISSILE_FREQ-CommandCenter.getLevel(),1);
		if(nTick > 40 && nTick % nFreq == 0 && !CommandCenter.isPaused()){			// missile frequency increases with level
			spawnMissile();
		}
		if (nTick % Powerup.POWERUP_FREQUENCY == 0 && !CommandCenter.isPaused()){	// powerup frequency determined by constant
			spawnPowerup();
		}
	}

	// Spawns a missile at the top of the screen.  The missile randomly targets one of the player's cities or the falcon.
	// The missile will not target cities that have already been destroyed.  
	private void spawnMissile(){
		ArrayList<Movable> movTargets = new ArrayList<Movable>();
		for (int nC = 0; nC < CommandCenter.getMovFriends().size(); nC++) {
			if(CommandCenter.getMovFriends().get(nC) instanceof City || CommandCenter.getMovFriends().get(nC) instanceof Falcon){
				movTargets.add(CommandCenter.getMovFriends().get(nC));
			}
		}
		try {
			int nTgtNum = R.nextInt(movTargets.size());			// randomly assigns the missile's target
			CommandCenter.movFoes.add(new Missile(movTargets.get(nTgtNum).getCenter()));
		} catch (Exception e) {
			try {
				CommandCenter.movFoes.add(new Missile(CommandCenter.getFalcon().getCenter()));
			} catch (Exception e1) {
				System.out.println("Cannot find falcon");
			}
		}
	}
	
	// Spawns a randomly selected powerup.  Each powerup has an equal chance of appearing.  The powerups's initial position is
	// randomly determined in the Powerup constructor.  
	public void spawnPowerup(){
		int nPowerupID = R.nextInt(4);
		if(nPowerupID == 0){
			CommandCenter.getMovFloaters().add((Movable) new Powerup("CityTurrets","T", Color.blue));
		}
		else if(nPowerupID == 1){
			CommandCenter.getMovFloaters().add((Movable) new Powerup("SpreadGun","S", Color.green));
		}
		else if(nPowerupID == 2){
			CommandCenter.getMovFloaters().add((Movable) new Powerup("SuperNuke","N", Color.red));
		}
		else{
			CommandCenter.getMovFloaters().add((Movable) new Powerup("FlameCloud","F", Color.orange));
		}
	}
	
	// Activates a power in CommandCenter once the player has picked up a powerup by shooting it
	public void activatePowerup(Powerup pow){
		if(pow instanceof Powerup){
			if(pow.getPower().equals("CityTurrets")){
				CommandCenter.setTurretShots(0);
				CommandCenter.setTurretsOn(true);
			}
			else if(pow.getPower().equals("SpreadGun")){
				CommandCenter.setSpreadShots(0);
				CommandCenter.setSpreadGunOn(true);
			}
			else if(pow.getPower().equals("SuperNuke")){
				CommandCenter.movDebris.add(new SuperNuke(new Point((int) DIM.getWidth()/2,(int) DIM.getHeight()/2)));
			}
			else{
				CommandCenter.setFlameShots(0);
				CommandCenter.setFlameCloudOn(true);
			}
		}
	}
	
	// Marks a given foe for removal from the game and creates a corresponding explosion
	private void killFoe(Movable movFoe) {
		tupMarkForRemovals.add(new Tuple(CommandCenter.movFoes, movFoe));
		if(movFoe instanceof Missile){
			CommandCenter.getMovDebris().add(new ExplodingMissile(movFoe.getCenter()));		// missiles create ExplodingMissiles
		}
		if(movFoe instanceof Bomb || movFoe instanceof BomberPlane){
			CommandCenter.getMovDebris().add(new GiantExplosion(movFoe.getCenter()));		// bombers and bombs create GiantExplosions
		}
	}

	// Increments nTick (unless it is already at the max value, in which case it resets)
	public void tick() {
		if (nTick == Integer.MAX_VALUE){
			nTick = 0;
		}
		else{
			nTick++;
		}
	}

	// Called when user presses 's' - initializes a new game and sets up the game's objects (stars, trees, cities, etc.)
	private void startGame() {
		CommandCenter.clearAll();
		CommandCenter.initGame();
		CommandCenter.setPlaying(true);
		CommandCenter.setPaused(false);
		addStars(NUM_STARS);
		spawnTrees();
		spawnTargets();
	}
	
	// Spawns stars in random positions
	public void addStars(int nNum){
		for (int nC = 0; nC < nNum; nC++) {
			int nStarX = R.nextInt((int) DIM.getWidth());
			int nStarY = R.nextInt((int) DIM.getHeight() - GROUND_LEVEL);
			
			CommandCenter.getMovDebris().add(new Star(new Point(nStarX,nStarY)));
		}
	}
	
	// Spawns tress at the beginning of the game - the number of trees is determined by the constant NUM_TREES
	public void spawnTrees() {
		int nSpacing = (int) (DIM.getWidth()/NUM_TREES);			// helps minimize tree overlap
		for (int i = 0; i < NUM_TREES; i++) {
			int nXCoord = (int) ((nSpacing*i)+R.nextInt(nSpacing));
			CommandCenter.movFriends.add(new Tree(new Point(nXCoord, (int) DIM.getHeight()-GROUND_LEVEL)));
		}
	}

	// Spawns 4 cities, 2 on either side of the falcon missile silo
	private void spawnTargets(){
		
		int nTgtYCoord = (int)(DIM.getHeight()-GROUND_LEVEL-(City.BUILDING_RADIUS/2.0));
		int nSpacingXCoord = (int) DIM.getWidth()/6;										// helps space the cities apart
		
		City tgt1 = new City(new Point(nSpacingXCoord,nTgtYCoord));
		City tgt2 = new City(new Point(nSpacingXCoord*2,nTgtYCoord));
		City tgt3 = new City(new Point(nSpacingXCoord*4,nTgtYCoord));
		City tgt4 = new City(new Point(nSpacingXCoord*5,nTgtYCoord));
		
		CommandCenter.movFriends.add(tgt1);													// adds to the movFriends array list
		CommandCenter.movFriends.add(tgt2);
		CommandCenter.movFriends.add(tgt3);
		CommandCenter.movFriends.add(tgt4);
	}

	// Spawns an enemy bomber plane
	public void spawnPlane() {
		int nRandNum = R.nextInt(2);
		if(nRandNum == 0){
			CommandCenter.movFoes.add(new BomberPlane("right"));   // side of the screen the bomber enters from is determined randomly
		}
		else{
			CommandCenter.movFoes.add(new BomberPlane("left"));
		}
	}


	// ===============================================
	// KEYLISTENER METHODS
	// ===============================================

	@Override
	public void keyPressed(KeyEvent e) {
		
		Falcon fal = CommandCenter.getFalcon();
		int nKey = e.getKeyCode();

		if (nKey == START && !CommandCenter.isPlaying())					// S key - starts the game
			startGame();

		if (nKey == QUIT){													// Q key - quits the game at any time
			System.exit(0);
		}
		
		if (fal != null) {
			switch (nKey) {
				
				case PAUSE:													// P key - pauses the game
					CommandCenter.setPaused(!CommandCenter.isPaused());
					break;
					
					
				// DEBUGGING KEYS (NOT INTENDED TO BE USED IN NORMAL GAMEPLAY):
				
				case BOMBER:												// B key - spawns an enemy bomber plane
					spawnPlane();
					break;
					
				case TURRET:												// T key - spawns the turrets powerup
					CommandCenter.getMovFloaters().add((Movable) new Powerup("CityTurrets","T", Color.blue));
					break;
				
				case SPREAD:												// R key - spawns the spread gun powerup
					CommandCenter.getMovFloaters().add((Movable) new Powerup("SpreadGun","S", Color.green));
					break;
				
				case FLAME:													// F key - spawns the flame gun powerup
					CommandCenter.getMovFloaters().add((Movable) new Powerup("FlameCloud","F", Color.orange));
					break;
					
				case SUPERNUKE:												// N key - spawns the supernuke powerup
					CommandCenter.getMovFloaters().add((Movable) new Powerup("SuperNuke","N", Color.red));
					break;
					
				case KILLALL:												// C key - clears all enemies from the playing field
					CopyOnWriteArrayList<Movable> movMovables = CommandCenter.getMovFoes();
					for (Movable movFoe : movMovables) {
						CommandCenter.getMovFoes().remove(movFoe);
					}
					break;
	
				default:
					break;
			}
		}
	}

	// Just need these because of KeyListener implementation
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}	
	
	
	// ==============================================================
	// MOUSELISTENER METHODS
	// ==============================================================

	// When the mouse is clicked, a new CounterMissile is spawned in the point where the player clicked
	@Override
	public void mouseClicked(MouseEvent e) {
		if (CommandCenter.isPlaying()) {
			CommandCenter.movFriends.add(new CounterMissile(new Point(e.getX(),e.getY())));
		}
		
		// If the player has the spread gun powerup activated, other CounterMissiles will also spawn next to where the player clicked
		if(CommandCenter.isSpreadGunOn()){
			if (e.getX()-120 > 0) {
				CommandCenter.movFriends.add(new CounterMissile(new Point(e.getX() - 120, e.getY() + 20)));
			}
			if (e.getX()-80 > 0) {
				CommandCenter.movFriends.add(new CounterMissile(new Point(e.getX() - 80, e.getY() + 10)));
			}
			if (e.getX()-40 > 0) {
				CommandCenter.movFriends.add(new CounterMissile(new Point(e.getX() - 40, e.getY() + 5)));
			}
			if (e.getX()+40 < DIM.getWidth()) {
				CommandCenter.movFriends.add(new CounterMissile(new Point(e.getX() + 40, e.getY() + 5)));
			}
			if (e.getX()+80 < DIM.getWidth()) {
				CommandCenter.movFriends.add(new CounterMissile(new Point(e.getX() + 80, e.getY() + 10)));
			}
			if (e.getX()+120 < DIM.getWidth()) {
				CommandCenter.movFriends.add(new CounterMissile(new Point(e.getX() + 120, e.getY() + 20)));
			}
			CommandCenter.incrementSpreadShots();
			if(CommandCenter.getSpreadShots()>Powerup.SPREAD_AMMO){		// deactivates the spread powerup if the player is out of ammo
				CommandCenter.setSpreadGunOn(false);
				CommandCenter.setSpreadShots(0);
			}
		}
		
		// Turns on the player's flame gun if the flame gun powerup is activated
		if(CommandCenter.isFlameCloudOn()){
			CommandCenter.setbFlameOn(true);
		}
	}

	// Just need these because of MouseListener implementation
	public void mouseReleased(MouseEvent arg0) {}
	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {}
	
	
	// ==============================================================
	// MOUSEMOTIONLISTENER METHODS
	// ==============================================================
	
	// Repositions the falcon missile silo toward the mouse whenever the cursor is moved
	// http://stackoverflow.com/questions/6208833/java-game-development-look-and-shoot-at-mouse-coordinates
	@Override
	public void mouseMoved(MouseEvent e) {
		if(CommandCenter.getFalcon() != null){
			Falcon fal = CommandCenter.getFalcon();
		
			double xDistance = e.getX()-fal.getCenter().getX();
			double yDistance = e.getY()-fal.getCenter().getY();
		
			int nAngle = -1 * (int) Math.toDegrees(Math.atan2(xDistance,yDistance)) + 90;		// trig function to find angle 
			fal.setOrientation(nAngle);
		}
		
		// If the player has the flame powerup activated, CounterMissiles will continually be created whenever the mouse is moved
		// until the player is out of ammo
		if(CommandCenter.isbFlameOn()){
			CommandCenter.getMovFriends().add(new CounterMissile(e.getPoint()));
			Sound.playSound("LOZ_Bomb_Blow.wav");
			
			// If the spread gun is activated at the same time as the flame powerup, spread shots will continually show up next
			// to the flame shots
			if(CommandCenter.isSpreadGunOn()){
				if (e.getX()-120 > 0) {
					CommandCenter.movFriends.add(new CounterMissile(new Point(e.getX() - 120, e.getY() + 20)));
				}
				if (e.getX()-80 > 0) {
					CommandCenter.movFriends.add(new CounterMissile(new Point(e.getX() - 80, e.getY() + 10)));
				}
				if (e.getX()-40 > 0) {
					CommandCenter.movFriends.add(new CounterMissile(new Point(e.getX() - 40, e.getY() + 5)));
				}
				if (e.getX()+40 < DIM.getWidth()) {
					CommandCenter.movFriends.add(new CounterMissile(new Point(e.getX() + 40, e.getY() + 5)));
				}
				if (e.getX()+80 < DIM.getWidth()) {
					CommandCenter.movFriends.add(new CounterMissile(new Point(e.getX() + 80, e.getY() + 10)));
				}
				if (e.getX()+120 < DIM.getWidth()) {
					CommandCenter.movFriends.add(new CounterMissile(new Point(e.getX() + 120, e.getY() + 20)));
				}
			}
		
			CommandCenter.incrementFlameShots();
			if(CommandCenter.getFlameShots()>Powerup.FLAME_AMMO){	// deactivates flame powerup if the player runs out of ammo
				CommandCenter.setbFlameOn(false);
				CommandCenter.setFlameCloudOn(false);
				CommandCenter.setFlameShots(0);
			}
		}
	}
	
	
	public void mouseDragged(MouseEvent e) {}				// Just need this because of MouseMotionListener implementation

	// ==============================================================
	// GETTERS & SETTERS 
	// ==============================================================

	public static int getTick() {return nTick;}



// ==============================================================
// INNER CLASS
// ==============================================================

/**
 *  This inner class remains unchanged from the original game base
 *  
 *  A tuple takes a reference to an ArrayList and a reference to a Movable.  This class is used in the collision detection 
 *  method, to avoid mutating the array list while we are iterating.  It has two public methods that either remove or put the
 *  movable from the appropriate ArrayList  
 */

	class Tuple{
		
		private CopyOnWriteArrayList<Movable> movMovs;		// this can be any one of several CopyOnWriteArrayList<Movable>
		private Movable movTarget;							// this is the target movable object to remove
		
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

}
