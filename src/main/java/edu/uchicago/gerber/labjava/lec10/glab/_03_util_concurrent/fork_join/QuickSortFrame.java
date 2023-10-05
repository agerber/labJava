package edu.uchicago.gerber.labjava.lec10.glab._03_util_concurrent.fork_join;


//import _ssort.quicksort.*;

import edu.uchicago.gerber.labjava.lec09.glab.searchsort.JPanelDB;
import edu.uchicago.gerber.labjava.lec09.glab.searchsort.Quick;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Random;

//import _ssort.util.draw.*;

public class QuickSortFrame extends JFrame
{

  private ArrayList a = new ArrayList();

  private Random r = new Random();
  private int[] nP = new int[99];
  // private int nB = 0;
  private int[] nR = new int[99];
  private int[] nL = new int[99];
  private int nFull = 0;

  boolean bWait = true;
  boolean bDone = false;

  private Timer timT;

  private Comparable[] cA = new Integer[100];

  private boolean bEmpty = true;

  private final int nMAX = 900;

  private JPanel contentPane;
  private BorderLayout borderLayout1 = new BorderLayout();
  //private JPanel panC = new JPanel();
  private JPanelDB panC = new JPanelDB();

  private JPanel panN = new JPanel();
  private GridLayout gridLayout1 = new GridLayout();
  //private JComboBox cboAlg = new JComboBox( sA );
  private JToggleButton bttGo = new JToggleButton();
  private JButton btnReset = new JButton();
  private JLabel lblMe = new JLabel();
  private JPanel panS = new JPanel();
  private JSlider sldSpeed = new JSlider( 0, nMAX, nMAX / 2 );
  private JCheckBox chkSort = new JCheckBox();
  private GridLayout gridLayout2 = new GridLayout();
  public QuickSortFrame()
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
    setTitle( "Quck Sort O(n log n)" );
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
    lblMe.setText( "Quick Sort" );
    panS.setLayout( gridLayout2 );
    sldSpeed.addChangeListener( new ChangeListener()
    {
      public void stateChanged ( ChangeEvent e )
      {
        sldSpeed_stateChanged( e );
      }
    } );
    chkSort.setFont( new Font( "Dialog", Font.PLAIN, 9 ) );
    chkSort.setMnemonic( '0' );
    chkSort.setText(
        "checking this box will pre-sort, thus changing growth " +
        "from O(n log n) to O(n^2)!" );
    chkSort.addActionListener( new ActionListener()
    {
      public void actionPerformed ( ActionEvent e )
      {
        chkSort_actionPerformed( e );
      }
    } );
    contentPane.add( panC, BorderLayout.CENTER );
    panN.add( btnReset );
    panN.add( lblMe );
    panN.add( bttGo );
    contentPane.add( panN, BorderLayout.NORTH );
    contentPane.add( panS, BorderLayout.SOUTH );
    panS.add( chkSort, null );
    panS.add( sldSpeed, null );
    ActionListener timerListener = new ActionListener()
    {
      public void actionPerformed ( ActionEvent e )
      {

        if ( checkDone() )
        {
          doWork();
          //clearPanC();
          display();

        }
        else
        {
          timT.stop();
          bttGo.setSelected( false );
          bttGo.setText( "go" );
          clearPanC();
          displayDone();
        }

      }
    };

    //the first parameter controls the delay
    timT = new Timer( invertSliderValue( sldSpeed.getValue() ),
                                  timerListener );

    // createUnsortedArray();



  } //end jbInit()


  private void doWork ()
  {
    for ( int nC = 0; nC < a.size(); nC++ )
    {
      Sorter s = ( Sorter )a.get( nC );
      if ( s.alive() )
      {

        if ( s.getR() != s.getL() &&
             cA[s.getL()].compareTo( cA[s.getP()] ) <= 0 )
        {
          s.setL( s.getL() + 1 );
        }

        if ( s.getR() != s.getL() &&
             cA[s.getR()].compareTo( cA[s.getP()] ) >= 0 )
        {
          s.setR( s.getR() - 1 );

        }

        //swap
        if ( s.getR() != s.getL() &&
             cA[s.getR()].compareTo( cA[s.getP()] ) <= 0 &&
             cA[s.getL()].compareTo( cA[s.getP()] ) >= 0 )
        {

          Comparable cTemp = cA[s.getR()];
          cA[s.getR()] = cA[s.getL()];
          cA[s.getL()] = cTemp;
        }

        else if ( s.getR() == s.getL() &&
                  cA[s.getL()].compareTo( cA[s.getP()] ) < 0 )
        {
          //swap the columns
          Comparable cTemp = cA[s.getL()];

          cA[s.getL()] = cA[s.getP()];
          cA[s.getP()] = cTemp;

          a.remove( s );
          spawn( s.getB(), s.getL(), s.getE() );

        }
        else if ( s.getR() == s.getL() &&
                  cA[s.getL()].compareTo( cA[s.getP()] ) >= 0 )
        {
          a.remove( s );
          spawn( s.getB(), s.getL(), s.getE() );

        }

      }
      //if it's dead, remove its dead corpse from the arrayList
      else
      {
        a.remove( s );
      }
    }

  } //end doWork


  private boolean checkDone ()
  {
    //if the arrayList contains no more sorters
    return!a.isEmpty();
  }


  private void spawn ( int nB, int nL, int nE )
  {

    a.add( new Sorter( nB, nL - 1 ) );
    a.add( new Sorter( nL, nE ) );
  }


  //btt is button toggle
  public void bttGo_actionPerformed ( ActionEvent e )
  {
    if ( !bEmpty )
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
  } //end bttGo_action


  private void createUnsortedArray ()
  {
    for ( int nC = 0; nC < cA.length; nC++ )
    {
      cA[nC] = new Integer( r.nextInt( panC.getHeight() ) );
    }
    bEmpty = false;
  } //end createUnsortedArray()


  private void display ()
  {

    panC.clearDB();
    Graphics g = panC.getGraphicsDB();

    for ( int nQ = 0; nQ < a.size(); nQ++ )
    {
      Sorter s = ( Sorter )a.get( nQ );
      if ( s.alive() )
      {

        //Graphics g = panC.getGraphics();

        int nW = panC.getWidth() / 100;

        for ( int nC = 0; nC < cA.length; nC++ )
        {

          if ( nC == s.getP() )
          {

            g.setColor( Color.cyan );
            g.fill3DRect( nW * nC,
                          panC.getHeight() - ( ( Integer )cA[nC] ).intValue(),
                          nW, ( ( Integer )cA[nC] ).intValue(), true );

            g.setColor( Color.yellow );
            g.fill3DRect( nW * nC + nW / 3, 0,
                          nW / 3,
                          panC.getHeight() - ( ( Integer )cA[nC] ).intValue(), true );

            //draw the pointer of the arrow triangle
            int nPoints = 3; //triangle
            int[] nX = new int[nPoints];
            int[] nY = new int[nPoints];

            nX[0] = nW * nC + nW / 3;
            nX[1] = nW * nC;
            nX[2] = nW * nC + nW;

            nY[0] = panC.getHeight() - ( ( Integer )cA[nC] ).intValue();
            nY[1] = panC.getHeight() - ( ( Integer )cA[nC] ).intValue() - 15;
            nY[2] = panC.getHeight() - ( ( Integer )cA[nC] ).intValue() - 15;

            g.fillPolygon( nX, nY, nPoints );

          }

          else if ( nC == s.getR() )
          {

            g.setColor( Color.cyan );
            g.fill3DRect( nW * nC,
                          panC.getHeight() - ( ( Integer )cA[nC] ).intValue(),
                          nW, ( ( Integer )cA[nC] ).intValue(), true );

            g.setColor( Color.red );
            g.fill3DRect( nW * nC + nW / 3, 0,
                          nW / 3,
                          panC.getHeight() - ( ( Integer )cA[nC] ).intValue(), true );

            //draw the pointer of the arrow triangle
            int nPoints = 3; //triangle
            int[] nX = new int[nPoints];
            int[] nY = new int[nPoints];

            nX[0] = nW * nC + nW / 3;
            nX[1] = nW * nC;
            nX[2] = nW * nC + nW;

            nY[0] = panC.getHeight() - ( ( Integer )cA[nC] ).intValue();
            nY[1] = panC.getHeight() - ( ( Integer )cA[nC] ).intValue() - 15;
            nY[2] = panC.getHeight() - ( ( Integer )cA[nC] ).intValue() - 15;

            g.fillPolygon( nX, nY, nPoints );

          }

          else if ( nC == s.getL() )
          {

            g.setColor( Color.cyan );
            g.fill3DRect( nW * nC,
                          panC.getHeight() - ( ( Integer )cA[nC] ).intValue(),
                          nW, ( ( Integer )cA[nC] ).intValue(), true );

            g.setColor( Color.blue );
            g.fill3DRect( nW * nC + nW / 3, 0,
                          nW / 3,
                          panC.getHeight() - ( ( Integer )cA[nC] ).intValue(), true );

            //draw the pointer of the arrow triangle
            int nPoints = 3; //triangle
            int[] nX = new int[nPoints];
            int[] nY = new int[nPoints];

            nX[0] = nW * nC + nW / 3;
            nX[1] = nW * nC;
            nX[2] = nW * nC + nW;

            nY[0] = panC.getHeight() - ( ( Integer )cA[nC] ).intValue();
            nY[1] = panC.getHeight() - ( ( Integer )cA[nC] ).intValue() - 15;
            nY[2] = panC.getHeight() - ( ( Integer )cA[nC] ).intValue() - 15;

            g.fillPolygon( nX, nY, nPoints );

          }

          else
          {
            g.setColor( Color.cyan );
            g.fill3DRect( nW * nC,
                          panC.getHeight() - ( ( Integer )cA[nC] ).intValue(),
                          nW, ( ( Integer )cA[nC] ).intValue(), true );

          }

        }

      }
    }
    panC.repaintDB();
  } //end display()


  private void displayDone ()
  {

    Graphics g = panC.getGraphics();

    int nW = panC.getWidth() / 100;

    for ( int nC = 0; nC < cA.length; nC++ )
    {
      g.setColor( Color.cyan );
      g.fill3DRect( nW * nC,
                    panC.getHeight() - ( ( Integer )cA[nC] ).intValue(),
                    nW, ( ( Integer )cA[nC] ).intValue(), true );

    }

  } //end display()


  private void clearPanC ()
  {
    Graphics g = panC.getGraphics();

    g.setColor( Color.black );
    g.fillRect( 0, 0, panC.getWidth(), panC.getHeight() );

  }


  public void chkSort_actionPerformed ( ActionEvent e )
  {

    a.clear();
    a.add( new Sorter( 0, cA.length - 1 ) );

    clearPanC();
    createUnsortedArray();

    if ( chkSort.isSelected() )
    {

      Quick.sort( cA );

    }

    display();

  } //end chkSortAction


  public void btnReset_actionPerformed ( ActionEvent e )
  {

    a.clear();
    a.add( new Sorter( 0, cA.length - 1 ) );

    clearPanC();
    createUnsortedArray();

    //optional to unomment in order to see how bad the performance can get.
    //if you sort the set first, performance drops from O(n log n) to O (n^2)
    if ( chkSort.isSelected() )
    {
      Quick.sort( cA );
    }
    //

    display();

  } //btnReset


  public void sldSpeed_stateChanged ( ChangeEvent e )
  {
    timT.setDelay( invertSliderValue( sldSpeed.getValue() ) );

  }


  private int invertSliderValue ( int nVal )
  {
    return nMAX - nVal;
  }


  public static void main ( String[] args )
  {
    boolean packFrame = false;

    /**
     * Construct and show the application.
     */

    QuickSortFrame frame = new QuickSortFrame();
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

  } //end main


  private void finish ()
  {
    timT.stop();
    bttGo.setSelected( false );
    bttGo.setText( "go" );

  }


  public void this_windowClosing ( WindowEvent e )
  {
    createUnsortedArray();
    finish();
  }


  private class Sorter
  {
    private int nP;
    private int nR;
    private int nL;

    private int nBegin;
    private int nEnd;

    private boolean bAlive;

    //constructor
    public Sorter ( int nStart, int nEnd )
    {
      nP = nBegin = nStart;
      nR = this.nEnd = nEnd;

      if ( nP == nR )
      {
        bAlive = false;
      }
      else
      {
        nL = nP + 1;
        bAlive = true;
      }

    } //end constr


    public int getB ()
    {
      return nBegin;
    }


    public int getE ()
    {
      return nEnd;
    }


    public int getP ()
    {
      return nP;
    }


    public int getR ()
    {
      return nR;
    }


    public int getL ()
    {
      return nL;
    }


    public boolean alive ()
    {
      return bAlive;
    }


    public void setP ( int n )
    {
      nP = n;
    }


    public void setR ( int n )
    {
      nR = n;
    }


    public void setL ( int n )
    {
      nL = n;
    }


    public void die ()
    {
      bAlive = false;
    }

  } //end private inner class.

} //end class
