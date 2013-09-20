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

public class SeqSearchFrame extends JFrame
{

  private Random r = new Random();
  private int nR = 0;
  private int nB = 0;
  private int nY = 0;
  boolean bWait = true;
  private Color colG = new Color( 1, 42, 42 );

  private javax.swing.Timer timT;

  private Comparable[] cA = new Integer[100];
  private boolean bEmpty = true;

  private final int nMAX = 20;

  private JPanel contentPane;
  private BorderLayout borderLayout1 = new BorderLayout();
  private JPanelDB panC = new JPanelDB();
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
  public SeqSearchFrame ()
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
    setSize( new Dimension( 800, 250 ) );
    setTitle( "Sequential Search O(n)" );
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
    lblMe.setText( "Sequential Search" );
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

        if ( nR < cA.length )
        {
          doWork();
          // clearPanC();
          display();

        }
        else
        {
          timT.stop();
          bttGo.setSelected( false );
          bttGo.setText( "go" );
          clearPanC();
          display();
        }

      }
    };

    //the first parameter controls the delay
    timT = new javax.swing.Timer( invertSliderValue( sldSpeed.getValue() ),
                                  timerListener );

    // createUnsortedArray();

  } //end jbInit()


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

    //cTemp = cA[nR];
  } //end createUnsortedArray()


  private void display ()
  {
    panC.clearDB();
    Graphics g = panC.getGraphicsDB();

    int nW = panC.getWidth() / 100;
    int nS = getSearch();

    for ( int nC = 0; nC < cA.length; nC++ )
    {

      if ( nC == nR )
      {
        if ( ( ( Integer )cA[nC] ).intValue() == nS )
        {

          g.setColor( Color.yellow );
          g.fill3DRect( nW * nC,
                        panC.getHeight() - ( ( Integer )cA[nC] ).intValue(),
                        nW, ( ( Integer )cA[nC] ).intValue(), true );

          g.setColor( Color.red );
          g.fill3DRect( nW * nC + nW / 3, 0,
                        nW / 3, panC.getHeight(), true );

        }
        else
        {

          g.setColor( Color.cyan );
          g.fill3DRect( nW * nC,
                        panC.getHeight() - ( ( Integer )cA[nC] ).intValue(),
                        nW, ( ( Integer )cA[nC] ).intValue(), true );

          g.setColor( Color.red );
          g.fill3DRect( nW * nC + nW / 3, 0,
                        nW / 3, panC.getHeight(), true );

        }

      }

      else if ( nC < nR )
      {

        //g.setColor( Color.cyan );
        g.setColor( colG );
        g.fill3DRect( nW * nC,
                      panC.getHeight() - ( ( Integer )cA[nC] ).intValue(),
                      nW, ( ( Integer )cA[nC] ).intValue(), true );

      }

      else if ( nC > nR )
      {
        //
        g.setColor( Color.cyan );
        //g.setColor(colG);
        g.fill3DRect( nW * nC,
                      panC.getHeight() - ( ( Integer )cA[nC] ).intValue(),
                      nW, ( ( Integer )cA[nC] ).intValue(), true );

      }

    }

    panC.repaintDB();

  } //end display()


  private void clearPanC ()
  {

    panC.clearDB();
    panC.repaintDB();

  }


  public void btnReset_actionPerformed ( ActionEvent e )
  {

    sldVal.setMaximum( panC.getHeight() );
    sldVal.setMinimum( 0 );
    //sldVal.setValue(panC.getHeight()/ 2);
    nR = 0;
    nB = 0;
    nY = 0;
    clearPanC();
    createUnsortedArray();
    display();
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
    timT.stop();
    bttGo.setSelected( false );
    bttGo.setText( "go" );

  }


  private void doWork ()
  {
    int nS = getSearch();

    if ( nR <= cA.length - 1 )
    {

      if ( ( ( Integer )cA[nR] ).intValue() == nS )
      {
        finish();
      }
      else
      {
        nR++;
      }

    }

  }


  public static void main ( String[] args )
  {
    boolean packFrame = false;

    /**
     * Construct and show the application.
     */

    SeqSearchFrame frame = new SeqSearchFrame();
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
    timT.stop();
    bttGo.setSelected( false );
    bttGo.setText( "go" );

  }
} //end class
