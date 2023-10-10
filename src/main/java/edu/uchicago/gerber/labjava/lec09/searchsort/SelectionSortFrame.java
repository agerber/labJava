package edu.uchicago.gerber.labjava.lec09.searchsort;


import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

//import _ssort.util.draw.*;

public class SelectionSortFrame extends JFrame
{

  private Random r = new Random();
  private int nR = 0;
  private int nB = 0;
  private int nY = 0;
  boolean bWait = true;

  private Timer timT;

  private Comparable[] cA = new Integer[100];
  private boolean bEmpty = true;

  private final int nMAX = 200;

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
  private BorderLayout borderLayout2 = new BorderLayout();
  public SelectionSortFrame ()
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
    setTitle( "Selection Sort O(n^2)" );
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
    lblMe.setText( "Selection Sort" );
    panS.setLayout( borderLayout2 );
    sldSpeed.addChangeListener( new ChangeListener()
    {
      public void stateChanged ( ChangeEvent e )
      {
        sldSpeed_stateChanged( e );
      }
    } );
    contentPane.add( panC, BorderLayout.CENTER );
    panN.add( btnReset );
    panN.add( lblMe );
    panN.add( bttGo );
    contentPane.add( panN, BorderLayout.NORTH );
    contentPane.add( panS, BorderLayout.SOUTH );
    panS.add( sldSpeed, BorderLayout.CENTER );
    ActionListener timerListener = new ActionListener()
    {
      public void actionPerformed ( ActionEvent e )
      {

        if ( nR < cA.length - 1 )
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

    //functions as outer loop
    //nR is red line
    if ( nR < cA.length - 1 )
    {
      //functions as inner loop
      //nB is blue line
      if ( nB < cA.length )
      {
        //do the comparison
        if ( cA[nB].compareTo( cA[nY] ) < 0 )
        {
          nY = nB;
        }
        //inner counter increment
        nB++;

      }
      else
      {
        //swap
        //nY is yellow line
        Comparable cTemp = cA[nR];
        cA[nR] = cA[nY];
        cA[nY] = cTemp;
        //outer counter increment
        nR++;
        //reset the blue and yellow to red
        nB = nR;
        nY = nR;

      }

    } //end outer if

  } //end doWork


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




    int nW = panC.getWidth() / 100;

    for ( int nC = 0; nC < cA.length; nC++ )
    {

      if ( nC == nR )
      {

        g.setColor( Color.cyan );
        g.fill3DRect( nW * nC,
                      panC.getHeight() - ( ( Integer )cA[nC] ).intValue(),
                      nW, ( ( Integer )cA[nC] ).intValue(), true );

        g.setColor( Color.red );
        g.fill3DRect( nW * nC + nW / 3, 0,
                      nW / 3, panC.getHeight(), true );

      }

      else if ( nC == nB  )
      {

        g.setColor( Color.cyan );
        g.fill3DRect( nW * nC,
                      panC.getHeight() - ( ( Integer )cA[nC] ).intValue(),
                      nW, ( ( Integer )cA[nC] ).intValue(), true );

        g.setColor( Color.blue );
        g.fill3DRect( nW * nC + nW / 3, 0,
                      nW / 3, panC.getHeight(), true );

      }


      else if ( nC == nY )
      {

        g.setColor( Color.cyan );
        g.fill3DRect( nW * nC,
                      panC.getHeight() - ( ( Integer )cA[nC] ).intValue(),
                      nW, ( ( Integer )cA[nC] ).intValue(), true );

        g.setColor( Color.yellow );
        g.fill3DRect( nW * nC + nW / 3, 0,
                      nW / 3, panC.getHeight() - ( ( Integer )cA[nC] ).intValue(), true );

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

      else
      {
        g.setColor( Color.cyan );
        g.fill3DRect( nW * nC,
                      panC.getHeight() - ( ( Integer )cA[nC] ).intValue(),
                      nW, ( ( Integer )cA[nC] ).intValue(), true );

      }

    }



panC.repaintDB();


  } //end display()


  private void clearPanC ()
  {
    Graphics g = panC.getGraphics();

    g.setColor( Color.black );
    g.fillRect( 0, 0, panC.getWidth(), panC.getHeight() );

  }


  public void btnReset_actionPerformed ( ActionEvent e )
  {
    nR = 0;
    nB = 0;
    nY = 0;
    clearPanC();
    createUnsortedArray();
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

  SelectionSortFrame frame = new SelectionSortFrame();
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

}//end main


  public void this_windowClosing ( WindowEvent e )
  {
    createUnsortedArray();

      timT.stop();
      bttGo.setSelected( false );
      bttGo.setText( "go" );



  }

} //end class
