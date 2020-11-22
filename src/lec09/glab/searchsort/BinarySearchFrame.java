package lec09.glab.searchsort;



import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

//import _ssort.quicksort.*;
//import _ssort.util.draw.*;

public class BinarySearchFrame extends JFrame
{

  private Random r = new Random();
  private int nR = 0;
  private int nB = 0;
  private int nY = -1;
  private boolean bD = false;
  private boolean bFound = false;
  private int nPR = 0;
  private int nPB = 0;
  private boolean bDone = false;

  boolean bWait = true;
  private Color colG = new Color( 1, 42, 42 );
  private boolean bGuess = false;

  private Timer timT;

  private Comparable[] cA = new Integer[100];
  private boolean bEmpty = true;

  private final int nMAX = 1000;

  private JPanel contentPane;
  private BorderLayout borderLayout1 = new BorderLayout();
  private JPanel panC = new JPanel();
  private JPanel panN = new JPanel();
  private GridLayout gridLayout1 = new GridLayout();

  //private JComboBox cboAlg = new JComboBox( sA );
  private JToggleButton bttGo = new JToggleButton();
  private JButton btnReset = new JButton();
  private JLabel lblMe = new JLabel();
  private JPanel panS = new JPanel();
  private JSlider sldSpeed = new JSlider( 0, nMAX, nMAX / 2 );
  private Comparable cTemp;
  private GridLayout gridLayout2 = new GridLayout();
  private JLabel lblPick = new JLabel();
  private JSlider sldVal = new JSlider();
  
  

  
  public BinarySearchFrame ()
  {
    try
    {
      setDefaultCloseOperation( DISPOSE_ON_CLOSE );
      jbInit();
    }
    catch ( Exception exception )
    {
      exception.printStackTrace();
    }
  }


  /**
   * Component initialization.
   *
   * @throws Exception
   */
  private void jbInit () throws Exception
  {
    contentPane = ( JPanel )getContentPane();
    contentPane.setLayout( borderLayout1 );
    setSize( new Dimension( 800, 600 ) );
    setTitle( "Binary Search O(log n)" );
    this.addWindowListener( new WindowAdapter()
    {
      public void windowClosing ( WindowEvent e )
      {
        this_windowClosing( e );
      }
    } );
    panC.setBackground( Color.black );

    panN.setLayout( gridLayout1 );
    bttGo.setText( "go" );
    bttGo.addActionListener( new ActionListener()
    {
      public void actionPerformed ( ActionEvent e )
      {
        bttGo_actionPerformed( e );
      }
    } );
    btnReset.setText( "begin here / reset" );
    btnReset.addActionListener( new ActionListener()
    {
      public void actionPerformed ( ActionEvent e )
      {
        btnReset_actionPerformed( e );
      }
    } );
    lblMe.setHorizontalAlignment( SwingConstants.CENTER );
    lblMe.setText( "Binary Search" );
    panS.setLayout( gridLayout2 );
    sldSpeed.addChangeListener( new ChangeListener()
    {
      public void stateChanged ( ChangeEvent e )
      {
        sldSpeed_stateChanged( e );
      }
    } );
    lblPick.setHorizontalAlignment( SwingConstants.CENTER );
    lblPick.setHorizontalTextPosition( SwingConstants.CENTER );
    lblPick.setText( "" );
    sldVal.addChangeListener( new ChangeListener()
    {
      public void stateChanged ( ChangeEvent e )
      {
        sldVal_stateChanged( e );
      }
    } );
    contentPane.add( panC, BorderLayout.CENTER );
    panN.add( btnReset );
    panN.add( lblMe );
    panN.add( bttGo );
    contentPane.add( panN, BorderLayout.NORTH );
    contentPane.add( panS, BorderLayout.SOUTH );
    panS.add( sldVal, null );
    panS.add( lblPick, null );
    panS.add( sldSpeed, null );
    ActionListener timerListener = new ActionListener()
    {
      public void actionPerformed ( ActionEvent e )
      {

        if ( !bFound )
        {
          doWork();
          //clearPanC();
          display();

        }
        else
        {
          //timT.stop();
          bttGo.setSelected( false );
          bttGo.setText( "go" );
          //clearPanC();
          clearGreen();
          //display();
        }

      }
    };

    //the first parameter controls the delay
    timT = new Timer( invertSliderValue( sldSpeed.getValue() ),
                                  timerListener );

    // createUnsortedArray();

  } //end jbInit()


  public void bttGo_actionPerformed ( ActionEvent e )
  {
    if ( !bDone )
    {

      if ( bttGo.isSelected() )
      {

        bttGo.setText( "stop" );
        timT.start();

        //implement this
      }
      else
      {
        bttGo.setText( "go" );
        timT.stop();

      }
    }
    else
    {
      bttGo.setSelected( false );
      bttGo.setText( "go" );
    }
  } //end bttGo_action


  private void createUnsortedArray ()
  {
    for ( int nC = 0; nC < cA.length; nC++ )
    {
      cA[nC] = new Integer( r.nextInt( panC.getHeight() ) );
    }
    bEmpty = false;

    //cTemp = cA[nR];
  } //end createUnsortedArray()


//if guessing then leave




  private void display ()
  {
    Graphics g = panC.getGraphics();

    int nW = panC.getWidth() / 100;
    int nS = getSearch();
    int nLeft;
    int nRight;
    Color colArrow;

    for ( int nC = 0; nC < cA.length; nC++ )
    {
      //I'm guessing and it's not found
      if ( bGuess && !bFound )
      {
        //set the appropriate parameters
        nLeft = nPR;
        nRight = nPB;
        colArrow = Color.yellow;

        if ( bDone )
        {
          nLeft = Math.max( nR, nPR );
          nRight = Math.min( nB, nPB );
          colArrow = Color.yellow;

        }

      }
      //I"m guessing and it's found!
      else if ( bGuess && bFound )
      {
        nLeft = Math.max( nR, nPR );
        nRight = Math.min( nB, nPB );
        colArrow = Color.yellow;
      }
      //I"m not guessing and it's not found
      else if ( !bGuess && !bFound )
      {
        nLeft = Math.max( nR, nPR );
        nRight = Math.min( nB, nPB );
        colArrow = Color.black;

      }
      else if ( !bGuess && bFound )
      {
        nLeft = Math.max( nR, nPR );
        nRight = Math.min( nB, nPB );
        colArrow = Color.black;
      }
      else
      {
        nLeft = Math.max( nR, nPR );
        nRight = Math.min( nB, nPB );
        colArrow = Color.yellow;

      }

      //found
      if ( nC == nY && ( ( Integer )cA[nC] ).intValue() == nS )
      {

        g.setColor( Color.yellow );
        g.fill3DRect( nW * nC,
                      panC.getHeight() - ( ( Integer )cA[nC] ).intValue(),
                      nW, ( ( Integer )cA[nC] ).intValue(), true );

        g.setColor( Color.yellow );
        g.fill3DRect( nW * nC + nW / 3, 0,
                      nW / 3,
                      panC.getHeight() - ( ( Integer )cA[nC] ).intValue(), true );

        //draw the pointer of the arrow triangle
        int nP = 3; //triangle
        int[] nX = new int[nP];
        int[] nY = new int[nP];

        nX[0] = nW * nC + nW / 3;
        nX[1] = nW * nC;
        nX[2] = nW * nC + nW;

        nY[0] = panC.getHeight() - ( ( Integer )cA[nC] ).intValue();
        nY[1] = panC.getHeight() - ( ( Integer )cA[nC] ).intValue() - 15;
        nY[2] = panC.getHeight() - ( ( Integer )cA[nC] ).intValue() - 15;

        g.fillPolygon( nX, nY, nP );
      } //end first if
      //it's yellow but its not found
      else if ( nC == nY && ( ( Integer )cA[nC] ).intValue() != nS )
      {
        if ( !bDone )
        {

          g.setColor( Color.cyan );
          g.fill3DRect( nW * nC,
                        panC.getHeight() - ( ( Integer )cA[nC] ).intValue(),
                        nW, ( ( Integer )cA[nC] ).intValue(), true );

          g.setColor( colArrow );
          g.fill3DRect( nW * nC + nW / 3, 0,
                        nW / 3,
                        panC.getHeight() - ( ( Integer )cA[nC] ).intValue(), true );

//draw the pointer of the arrow triangle
          int nP = 3; //triangle
          int[] nX = new int[nP];
          int[] nY = new int[nP];

          nX[0] = nW * nC + nW / 3;
          nX[1] = nW * nC;
          nX[2] = nW * nC + nW;

          nY[0] = panC.getHeight() - ( ( Integer )cA[nC] ).intValue();
          nY[1] = panC.getHeight() - ( ( Integer )cA[nC] ).intValue() - 15;
          nY[2] = panC.getHeight() - ( ( Integer )cA[nC] ).intValue() - 15;

          g.fillPolygon( nX, nY, nP );
        }
        //done
        else
        {

          g.setColor( colG );
          g.fill3DRect( nW * nC,
                        panC.getHeight() - ( ( Integer )cA[nC] ).intValue(),
                        nW, ( ( Integer )cA[nC] ).intValue(), true );

        }
      }
      else if ( nC < nLeft )
      {
        g.setColor( colG );
        g.fill3DRect( nW * nC,
                      panC.getHeight() - ( ( Integer )cA[nC] ).intValue(),
                      nW, ( ( Integer )cA[nC] ).intValue(), true );

      }
      else if ( nC > nRight )
      {
        g.setColor( colG );
        g.fill3DRect( nW * nC,
                      panC.getHeight() - ( ( Integer )cA[nC] ).intValue(),
                      nW, ( ( Integer )cA[nC] ).intValue(), true );

      }
      else if ( nC >= nLeft && nC <= nRight )
      {
        g.setColor( Color.cyan );
        g.fill3DRect( nW * nC,
                      panC.getHeight() - ( ( Integer )cA[nC] ).intValue(),
                      nW, ( ( Integer )cA[nC] ).intValue(), true );

      }
    }

    //expand the thing to nPR and nPB red and blue on the right
  }


  private void clearPanC ()
  {
    Graphics g = panC.getGraphics();

    g.setColor( Color.black );
    g.fillRect( 0, 0, panC.getWidth(), panC.getHeight() );

  }


  public void btnReset_actionPerformed ( ActionEvent e )
  {

    sldVal.setMaximum( panC.getHeight() );
    sldVal.setMinimum( 0 );
    sldVal.setValue(panC.getHeight()/ 2);
    nR = 0;
    nB = cA.length - 1;
    nPR = nR;
    nPB = nB;
    nY = -1;
    bD = false;
    bFound = false;
    clearPanC();
    createUnsortedArray();
    Quick.sort( cA );
    display();
    bDone = false;
    //lblPick.setText( "Search value from 0 to " + panC.getHeight() );

  } //btnReset


  public void sldSpeed_stateChanged ( ChangeEvent e )
  {
    timT.setDelay( invertSliderValue( sldSpeed.getValue() ) );

  }


  private int invertSliderValue ( int nVal )
  {
    return nMAX - nVal;
  }


  private int getSearch ()
  {
    return sldVal.getValue();
  }


  private void finish ()
  {

    bDone = true;
    clearPanC();
    clearGreen();
    timT.stop();
    bttGo.setSelected( false );
    bttGo.setText( "go" );
    //bGuess = true;
    //bD = true;
    // if (nB < n


  }


  private void clearGreen ()
  {
    Graphics g = panC.getGraphics();
    // clearPanC();
    g.setColor( colG );

    int nW = panC.getWidth() / 100;
    for ( int nC = 0; nC < cA.length; nC++ )
    {

      g.fill3DRect( nW * nC,
                    panC.getHeight() - ( ( Integer )cA[nC] ).intValue(),
                    nW, ( ( Integer )cA[nC] ).intValue(), true );

    }
    // g.setColor(Color.red);
    // g.fillOval(50,50, 50, 50);
    //System.out.println( "afdadf" );

  }


  private void doWork ()
  {

    //flip it
    bGuess = !bGuess;

    if ( bGuess )
    {

      int nS = getSearch();

      if ( nR <= nB )
      {
        nY = ( nR + nB ) / 2;
        if ( ( ( Integer )cA[nY] ).intValue() == nS )
        {
          // System.out.println(nKey);
          // return nMid;
          bFound = true;
          nPR = Math.max( nPR, nR );
          nR = Math.max( nPR, nR );
          nPB = Math.min( nPB, nB );
          nB = Math.min( nPB, nB );
          finish();

        }
        else if ( ( ( Integer )cA[nY] ).intValue() < nS )
        {
          //System.out.println(nNums[nMid]);
          nPR = nR;
          nPB = nB;
          nR = nY + 1;

        }
        else
        {
          //System.out.println(nNums[nMid]);
          nPB = nB;
          nPR = nR;
          nB = nY - 1;
        }
      }
      else
      {
        finish();
      }
    }
  } //end dowork


  public static void main ( String[] args )
  {
    boolean packFrame = false;

    /**
     * Construct and show the application.
     */

    BinarySearchFrame frame = new BinarySearchFrame();
    // Validate frames that have preset sizes
    // Pack frames that have useful preferred size info, e.g. from their layout
    if ( packFrame )
    {
      frame.pack();
    }
    else
    {
      frame.validate();
    }

    // Center the window
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = frame.getSize();
    if ( frameSize.height > screenSize.height )
    {
      frameSize.height = screenSize.height;
    }
    if ( frameSize.width > screenSize.width )
    {
      frameSize.width = screenSize.width;
    }
    frame.setLocation( ( screenSize.width - frameSize.width ) / 2,
                       ( screenSize.height - frameSize.height ) / 2 );
    frame.setVisible( true );

  }


  void sldVal_stateChanged ( ChangeEvent e )
  {
    lblPick.setText( "Search for: " + sldVal.getValue() );

  } /////end main


  public void this_windowClosing ( WindowEvent e )
  {


     createUnsortedArray();
     finish();
//Quick.sort( cA );
//display();
//bDone = false;

  }
} //end class
