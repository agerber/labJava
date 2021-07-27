package edu.uchicago.gerber.labjava.lec04.glab.tetris;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Frame extends JFrame
{
  private JPanel contentPane;
  private ImageIcon image1;
  private ImageIcon image2;
  private ImageIcon image3;
  private BorderLayout borderLayout1 = new BorderLayout();

  //Construct the frame
  public Frame()
  {
    enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    try
    {
      jbInit();
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
  }

  //Component initialization
  private void jbInit() throws Exception
  {
    image1 = new ImageIcon(Frame.class.getResource("openFile.png"));
    image2 = new ImageIcon(Frame.class.getResource("closeFile.png"));
    image3 = new ImageIcon(Frame.class.getResource("help.png"));
    contentPane = (JPanel) this.getContentPane();
    contentPane.setLayout(borderLayout1);
    this.setSize(new Dimension(400, 300));
    this.setTitle("rolling dice");
  }

  //File | Exit action performed
  public void jMenuFileExit_actionPerformed(ActionEvent e)
  {
    System.exit(0);
  }

  //Help | About action performed
  public void jMenuHelpAbout_actionPerformed(ActionEvent e)
  {
    Frame_AboutBox dlg = new Frame_AboutBox(this);
    Dimension dlgSize = dlg.getPreferredSize();
    Dimension frmSize = getSize();
    Point loc = getLocation();
    dlg.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x, (frmSize.height - dlgSize.height) / 2 + loc.y);
    dlg.setModal(true);
    dlg.pack();
    dlg.show();
  }

  //Overridden so we can exit when window is closed
  protected void processWindowEvent(WindowEvent e)
  {
    super.processWindowEvent(e);
    if (e.getID() == WindowEvent.WINDOW_CLOSING)
    {
      jMenuFileExit_actionPerformed(null);
    }
  }
}
