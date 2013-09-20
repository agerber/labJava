package lec09.glab.searchsort;


import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class JPanelDB extends JPanel
{

  private BufferedImage image_off;
  private Graphics graph;

  public JPanelDB ( int nW, int nH )
  {

    super();
    setOpaque( true );
    setLayout( null );

    image_off = new BufferedImage( nW, nH, BufferedImage.TYPE_INT_RGB );

  }


  public JPanelDB ()
  {

    super();
    setOpaque( true );
    setLayout( null );

    image_off = new BufferedImage( 1200, 1200, BufferedImage.TYPE_INT_RGB );

  }


  //overridden
  protected void paintComponent ( Graphics g )
  {

    g.drawImage( image_off, 0, 0, this );

  }


  public void repaintDB ()
  {
    image_off.flush();
    //get the graphics context of this JPanel
    //pass it into paintComponent
    graph = getGraphics();
    paintComponent( graph );

  }


  public Graphics getGraphicsDB ()
  {
    return image_off.getGraphics();
  }


  public void clearDB ( Color colParam )
  {
    Graphics gr = getGraphicsDB();
    gr.setColor( colParam );
    gr.fillRect( 0, 0, getWidth(), getHeight() );

  }


  public void clearDB ()
  {
    Graphics gr = getGraphicsDB();
    gr.setColor( Color.black );
    gr.fillRect( 0, 0, getWidth(), getHeight() );
  }

}
