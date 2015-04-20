package lec04.glab.tetris;

import java.awt.*;
import java.awt.Frame;
import java.awt.event.*;
import java.util.*;

public class Game extends Panel implements Runnable
{
  //these are the threads that control game play and animation
  Thread thLoad;
  Thread thAnimate;
  Thread thAutoDown;

  //these are references to the current widget && the ondeck Widget
  Widget wdCurr;
  Widget wdOnDeck;

  //constants
  final static int NUM_POSSIBLE = 70; //used for generating widget probabilities
  final static int PRESS_DELAY = 40; //this is to ensure no doubling of press
  final static int PNT = 2400; //threashold for increasing speed (difficulty)
  final static int ANI_DELAY = 50; // Milliseconds between screen updates (animation)

  //the variable speed of drops
  static protected int nAutoDelay = 300; // Milliseconds between widget coming down automatically

  //some utility vars
  Dimension d = this.getSize(); //the size of the panel
  private long lTime; //time stamp for events, to keep keyPressed from doubling
  private long lTimeStep; //used in conjunction with above

  // Values for the offscreen doubleBuffer image.
  Dimension offDimension;
  Image offImage;
  Graphics offGraphics;

  //here's the grid
  Grid grid = new Grid();

  //and the frame
  static java.awt.Frame frame;

  // Font data.
  Font font = new Font( "Helvetica", Font.BOLD, 12 );
  FontMetrics fm; //this will be initialized in jbInit
  int fontWidth;
  int fontHeight;

  //this utility var is used by several functions throughout the game
  final static Random r = new Random();

  //boolean flags
  boolean bLoaded = true;
  boolean bPaused = false;
  static boolean bPlaying = false;

  //here's the executable main method
  public static void main ( String args[] )
  {

    frame = new Frame();

    Game game = new Game(); //the panel constructs itself
    game.setSize( 500, 700 );
    frame.add( game );
    frame.pack();
    game.init();
    frame.setSize( 500, 700 );
    frame.setTitle( "Tetris" );
    frame.setResizable( false );
    frame.show();

  }


  //this class implements runnable and therefore must have a run method
  public void run ()
  {

    // lower the thread's priority and get the current time.
    Thread.currentThread().setPriority( Thread.MIN_PRIORITY );
    long startTime = System.currentTimeMillis();

    if ( !bLoaded && Thread.currentThread() == thLoad )
    {

      bLoaded = true;

    }

    // This thread moves the widget down automatically.
    while ( Thread.currentThread() == thAutoDown )
    {
      //check these flags first
      if ( !bPaused && bPlaying )
      {
        tryMoveDown();
      }
      //ok, now repaint
      repaint();
      //we must surround the sleep() in a try/catch block
      //this simply controls delay time between auto-moveDown()
      try
      {
        startTime += nAutoDelay;
        Thread.sleep( Math.max( 0, startTime - System.currentTimeMillis() ) );
      }
      catch ( InterruptedException e )
      {
        break;
      } //end try/catch

    } //end while

    //this thread animates the scene
    while ( Thread.currentThread() == thAnimate )
    {

      //check these flags
      if ( !bPaused && bPlaying )
      {
        updateGrid();
      }
      //go ahead and repaint
      repaint();
      //we must surround the sleep() in a try/catch block
      //this simply controls delay time between the frames of the animation
      try
      {
        startTime += ANI_DELAY;
        Thread.sleep( Math.max( 0, startTime - System.currentTimeMillis() ) );
      }
      catch ( InterruptedException e )
      {
        break;
      } //end try/catch

    } //end while

  } //end run


  //Initialize the panel...init calls jbInit()
  public void init ()
  {
    try
    {
      jbInit();
    }
    catch ( Exception e )
    {
      e.printStackTrace();
    }

  }


  //in this case, jbInit is the indirect initialization
  //we use jbInit (JBuilder) to allow for automatic registration of GUI events
  private void jbInit () throws Exception
  {
    //this is to handle the x closing of window
    frame.addWindowListener( new WindowAdapter()
    {
      public void windowClosing ( WindowEvent e )
      {
        frame_windowClosing( e );
      }
    } );

    //autoRegister of events using adapters
    this.addKeyListener( new KeyAdapter()
    {
      public void keyPressed ( KeyEvent e )
      {
        this_keyPressed( e );
      }
    } );
    //register the keyEvent
    this.addKeyListener( new KeyAdapter()
    {

      public void keyPressed ( KeyEvent e )
      {
        this_keyPressed( e );
      }
    } );

    //get the graphics context for the panel
    Graphics g = getGraphics();

    //set font info
    g.setFont( font );
    fm = g.getFontMetrics();
    fontWidth = fm.getMaxAdvance();
    fontHeight = fm.getHeight();

    //start up the threads
    fireUpThreads();

  } //end jbInit


  //this is called when the user presses 's'
  private void startGame ()
  {
    bPlaying = true;
    bPaused = false;
    wdCurr = genNewWidget();
    wdOnDeck = genNewWidget();
    grid.score.setThresh( 2400 );
    nAutoDelay = 300;
    grid.score.setScore( 0 );

  } //end init


  private void fireUpThreads ()
  {

    if ( thAnimate == null )
    {
      thAnimate = new Thread( this );
      thAnimate.start();
    }
    if ( thAutoDown == null )
    {
      thAutoDown = new Thread( this );
      thAutoDown.start();
    }

    if ( !bLoaded && thLoad == null )
    {
      thLoad = new Thread( this );
      thLoad.start();
    }

  }


  //generate a new Widget randomly
  private Widget genNewWidget ()
  {

    int nKey = r.nextInt( NUM_POSSIBLE ); //returns # between 0-69

    //12/70
    if ( nKey >= 0 && nKey < 12 )
    {
      return new Peanut();

    }

    //8/70
    else if ( nKey >= 12 && nKey < 20 )
    {
      return new Squared();
    }
    //12/70
    else if ( nKey >= 20 && nKey < 32 )
    {
      return new Sancho();
    }
    //10/70
    else if ( nKey >= 32 && nKey < 42 )
    {
      return new Luigi();
    }
    //8/70
    else if ( nKey >= 42 && nKey < 50 )
    {
      return new Slim();
    }
    //10/70

    else if ( nKey >= 50 && nKey < 60 )
    {
      return new CitizenSnips();
    }
    //10/70
    //between 60 and 69
    else
    {
      return new Zorro();
    }

  }


  private void updateGrid ()
  {

    grid.setBlocks( wdCurr );

  }


  public void paint ( Graphics g )
  {
    update( g );
  }


//this method used extensively by thAutoDown and by user moving down
  private void tryMoveDown ()
  {
    Widget wdTest = wdCurr.duplicateWidget();
    wdTest.moveDown();

    if ( grid.requestDown( wdTest ) )
    {

      wdCurr.moveDown();
      wdTest = null; //marks this object for garbage collection

    }
    else if (bPlaying == true)
    {

      grid.addOccupied( wdCurr ); //add the current widget to the occupied blocks
      grid.topRow(); //check for game over
      grid.checkFullRow(); //check if any of the rows are full
      wdCurr = wdOnDeck; //assign onDeck to current widget
      wdOnDeck = genNewWidget(); //gen a new widget for onDeck
      wdTest = null; //marks this object for garbage collection

    }
    else
    {
      wdTest = null; //marks this object for garbage collection
    }

  }


  //this draws the on the screen
  public void update ( Graphics g )
  {

    String sDisplay;

    Dimension d = this.getSize();

    // Create the offscreen graphics context, if no good one exists.
    if ( offGraphics == null || d.width != offDimension.width ||
         d.height != offDimension.height )
    {
      offDimension = d;
      offImage = createImage( d.width, d.height );
      offGraphics = offImage.getGraphics();
    }

    // Fill in background with black.
    offGraphics.setColor( Color.black );
    offGraphics.fillRect( 0, 0, d.width, d.height );

    offGraphics.setColor( Color.white );
    offGraphics.setFont( font );

    offGraphics.drawString( "Score: " + grid.score.getScore(), fontWidth,
                            fontHeight );

    sDisplay = "High Score: " + grid.score.getHighScore();
    offGraphics.drawString( sDisplay, d.width - ( fontWidth + 350 ),
                            fontHeight );

    if ( !bPlaying )
    {
      sDisplay = "TETRIS";
      offGraphics.drawString( sDisplay, ( d.width - fm.stringWidth( sDisplay ) ) / 2,
                              d.height / 2 );

      if ( !bLoaded )
      {
        sDisplay = "Loading sounds...";
        offGraphics.drawString( sDisplay, ( d.width - fm.stringWidth( sDisplay ) ) / 2,
                                d.height / 4 );
      }
      else
      {
        sDisplay = "Game Over";
        offGraphics.drawString( sDisplay, ( d.width - fm.stringWidth( sDisplay ) ) / 2,
                                d.height / 4 );
        sDisplay = "'S' to Start";
        offGraphics.drawString( sDisplay, ( d.width - fm.stringWidth( sDisplay ) ) / 2,
                                d.height / 4 + fontHeight + 14 );

        sDisplay = "'P' to Pause";
        offGraphics.drawString( sDisplay, ( d.width - fm.stringWidth( sDisplay ) ) / 2,
                                d.height / 4 + fontHeight + 30 );

        sDisplay = "'Q' to Quit";
        offGraphics.drawString( sDisplay, ( d.width - fm.stringWidth( sDisplay ) ) / 2,
                                d.height / 4 + fontHeight + 46 );

      }
    }
    else if ( bPaused )
    {
      sDisplay = "Game Paused";
      offGraphics.drawString( sDisplay, ( d.width - fm.stringWidth( sDisplay ) ) / 2,
                              d.height / 4 );
    }
    else
    {

      //I'll need to draw individual boxes
      int nBy = ( d.height - 150 ) / Grid.ROWS;
      int nBx = ( d.width - 150 ) / Grid.COLS;

      //I'd like to have a gutter on the right...so that I can display my game data.
      Block[][] b = grid.getBlocks();

      for ( int h = 0; h < b.length; h++ )
      {
        for ( int k = 0; k < b[0].length; k++ )
        {

          offGraphics.setColor( b[h][k].color );
          offGraphics.fill3DRect( k * nBx, h * nBy + 150, nBx, nBy, true );

        }
      }

      //draw the onDeckWidget and its bounding box
      offGraphics.setColor( Color.white );
      offGraphics.draw3DRect( d.width - 150, 0, 150, d.height, true );
      offGraphics.draw3DRect( d.width - 140, 10, 130, 130, true );

      boolean[][] lts = wdOnDeck.getLights( wdOnDeck.or );
      Color c = wdOnDeck.color;
      for ( int k = 0; k < Grid.DIM; k++ )
      {
        for ( int m = 0; m < Grid.DIM; m++ )
        {
          if ( lts[m][k] )
          //draw my lights
          {
            offGraphics.setColor( c );
            offGraphics.fill3DRect( k * nBx + 360, m * nBy + 20, nBx, nBy, true );
          }

        }
      }

    }

    //draw the doubleBuffered Image to the graphics context of the panel
    g.drawImage( offImage, 0, 0, this );

  } //end update


  void this_keyPressed ( KeyEvent e )
  {
    lTime = System.currentTimeMillis();
    int key = e.getKeyCode();

    //pressed the s key
    if ( key == 83 && bLoaded && !bPlaying )
    {
      startGame();

    }

    //pressed the p key
    if ( key == 80 && lTime > lTimeStep + PRESS_DELAY )
    {
      bPaused = !bPaused;
      lTimeStep = System.currentTimeMillis();
    }

    //pressed the q key
    if ( key == 81 && lTime > lTimeStep + PRESS_DELAY )
    {
      System.exit( 0 );
    }

//down
    if ( key == 40 && lTime > lTimeStep + PRESS_DELAY - 35 )
    {
      tryMoveDown();
      lTimeStep = System.currentTimeMillis();
    }
//left
    if ( key == 37 && lTime > lTimeStep + PRESS_DELAY )
    {

      Widget wdTest = wdCurr.duplicateWidget();
      wdTest.moveLeft();

      if ( grid.requestLateral( wdTest ) )
      {
        wdCurr.moveLeft();
        wdTest = null;
        lTimeStep = System.currentTimeMillis();
      }
      else
      {
        wdTest = null;
      }

    }
//right
    if ( key == 39 && lTime > lTimeStep + PRESS_DELAY )
    {

      Widget wdTest = wdCurr.duplicateWidget();
      wdTest.moveRight();

      if ( grid.requestLateral( wdTest ) )
      {
        wdCurr.moveRight();
        wdTest = null;
        lTimeStep = System.currentTimeMillis();
      }
      else
      {
        wdTest = null;
      }

    }
    //pressed the space bar (rotate)
    if ( key == 32 && lTime > lTimeStep + PRESS_DELAY )
    {

      Widget wdTest = wdCurr.duplicateWidget();
      wdTest.rotateMe();

      if ( grid.requestLateral( wdTest ) )
      {
        wdCurr.rotateMe();
        wdTest = null;
        lTimeStep = System.currentTimeMillis();
      }
      else
      {
        wdTest = null;
      }

    }

  } //end keyPressed


  //this meth to handle the x (closing) button on window event
  void frame_windowClosing ( WindowEvent e )
  {
    System.exit( 0 );

  }

} //end class
